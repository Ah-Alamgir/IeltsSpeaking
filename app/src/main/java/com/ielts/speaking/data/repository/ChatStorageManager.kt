package com.ielts.speaking.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.ielts.speaking.ui.chat.ChatContact
import com.ielts.speaking.ui.chat.DirectMessage
import org.json.JSONArray
import org.json.JSONObject
import java.util.Locale
import java.util.UUID

object ChatStorageManager {

    private const val PREFS_NAME = "ielts_chat_preferences"
    private const val KEY_PERMANENT_ID = "permanent_user_id"
    private const val KEY_CONTACTS = "contacts_list_json"
    private const val PREFIX_MESSAGES = "chat_messages_"

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    /**
     * Retrieves or creates a permanent, persistent IELTS Peer ID for this candidate.
     * Guaranteed to persist across app restarts, reboots, and updates.
     */
    fun getPermanentUserId(context: Context): String {
        val prefs = getPrefs(context)
        val existing = prefs.getString(KEY_PERMANENT_ID, null)
        if (!existing.isNullOrBlank()) {
            return existing
        }
        val newId = "ielts-" + UUID.randomUUID().toString().replace("-", "").take(6).uppercase(Locale.ROOT)
        prefs.edit().putString(KEY_PERMANENT_ID, newId).apply()
        return newId
    }

    fun setPermanentUserId(context: Context, newId: String) {
        val sanitized = newId.trim().lowercase(Locale.ROOT).replace(" ", "-")
        getPrefs(context).edit().putString(KEY_PERMANENT_ID, sanitized).apply()
    }

    /**
     * Gets all saved 1-on-1 practice contacts.
     * Zero dummy contacts: returns empty list if none added yet.
     */
    fun getContacts(context: Context): List<ChatContact> {
        val jsonStr = getPrefs(context).getString(KEY_CONTACTS, null) ?: return emptyList()
        val list = mutableListOf<ChatContact>()
        try {
            val array = JSONArray(jsonStr)
            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)
                list.add(
                    ChatContact(
                        id = obj.getString("id"),
                        name = obj.getString("name"),
                        country = obj.optString("country", "Global"),
                        targetBand = obj.optString("targetBand", "Band 7.5"),
                        isOnline = obj.optBoolean("isOnline", false),
                        lastMessage = obj.optString("lastMessage", ""),
                        lastTime = obj.optString("lastTime", "")
                    )
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return list
    }

    fun saveContact(context: Context, contact: ChatContact) {
        val current = getContacts(context).toMutableList()
        val index = current.indexOfFirst { it.id == contact.id }
        if (index >= 0) {
            current[index] = contact
        } else {
            current.add(0, contact)
        }
        persistContacts(context, current)
    }

    fun deleteContact(context: Context, contactId: String) {
        val current = getContacts(context).filter { it.id != contactId }
        persistContacts(context, current)
        getPrefs(context).edit().remove(PREFIX_MESSAGES + contactId).apply()
    }

    private fun persistContacts(context: Context, contacts: List<ChatContact>) {
        val array = JSONArray()
        contacts.forEach { c ->
            val obj = JSONObject().apply {
                put("id", c.id)
                put("name", c.name)
                put("country", c.country)
                put("targetBand", c.targetBand)
                put("isOnline", c.isOnline)
                put("lastMessage", c.lastMessage)
                put("lastTime", c.lastTime)
            }
            array.put(obj)
        }
        getPrefs(context).edit().putString(KEY_CONTACTS, array.toString()).apply()
    }

    /**
     * Gets persistent chat history for a specific partner ID.
     */
    fun getMessages(context: Context, contactId: String): List<DirectMessage> {
        val jsonStr = getPrefs(context).getString(PREFIX_MESSAGES + contactId, null) ?: return emptyList()
        val list = mutableListOf<DirectMessage>()
        try {
            val array = JSONArray(jsonStr)
            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)
                list.add(
                    DirectMessage(
                        sender = obj.getString("sender"),
                        text = obj.getString("text"),
                        timestamp = obj.getString("timestamp")
                    )
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return list
    }

    /**
     * Saves a message permanently and updates the contact's last activity snippet.
     */
    fun saveMessage(context: Context, contactId: String, message: DirectMessage) {
        val messages = getMessages(context, contactId).toMutableList()
        messages.add(message)
        val array = JSONArray()
        messages.forEach { m ->
            val obj = JSONObject().apply {
                put("sender", m.sender)
                put("text", m.text)
                put("timestamp", m.timestamp)
            }
            array.put(obj)
        }
        getPrefs(context).edit().putString(PREFIX_MESSAGES + contactId, array.toString()).apply()

        // Update contact last message
        val contacts = getContacts(context).toMutableList()
        val contactIndex = contacts.indexOfFirst { it.id == contactId }
        if (contactIndex >= 0) {
            val old = contacts[contactIndex]
            contacts[contactIndex] = old.copy(
                lastMessage = message.text,
                lastTime = message.timestamp
            )
            persistContacts(context, contacts)
        } else {
            val senderLabel = if (message.sender != "Me" && message.sender.isNotBlank()) message.sender else "Partner (${contactId.takeLast(4)})"
            val newContact = ChatContact(
                id = contactId,
                name = senderLabel,
                country = "Global",
                targetBand = "Band 7.5+",
                isOnline = true,
                lastMessage = message.text,
                lastTime = message.timestamp
            )
            contacts.add(0, newContact)
            persistContacts(context, contacts)
        }
    }
}
