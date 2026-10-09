# Professional Blogger Theme Installation Guide: IELTS Speaking & Writing Prep Pro

This guide explains how to install the custom **Blogger XML Theme** (`blogspot_theme.xml`) on **Blogspot.com (Blogger)** so that your entire blog becomes a full-fledged, professional web application running on your custom root domain (e.g. `https://yourdomain.com` or `https://yourname.blogspot.com`), accessible on iPhone (Safari), iPad, Android, and Desktop.

---

## Why a Custom Blogger Theme (Instead of a Page/Post)?
- **Full-Screen Web App**: No Blogger header, no archive sidebar, no footer links, no comment sections, and no default blog posts.
- **Root Domain Experience**: Accessible directly at `yourblog.blogspot.com` (not hidden inside a sub-URL like `/p/page.html`).
- **PWA Ready**: Works like a native iOS and Android app when added to the home screen.
- **100% Free Hosting**: Hosted on Google's global CDN with zero hosting or server bills ($0 forever).
- **Free WebRTC Peer-to-Peer Calling**: Audio calls run over HTTPS using PeerJS WebRTC without requiring an external signaling backend.

---

## How to Install the Custom Theme (Takes 30 Seconds)

### Step 1: Open the Blogger Dashboard
1. Go to [Blogger.com](https://www.blogger.com) and log in with your Google account.
2. Select your blog from the top-left dropdown (or click **Create Blog** if starting a new one).

### Step 2: Open Theme Editor
1. In the left navigation menu, click **Theme**.
2. Under the **My Theme** preview card, click the small down arrow next to the orange **CUSTOMIZE** button.
3. Select **Edit HTML**.

### Step 3: Replace with the Theme XML
1. Open [`blogspot_theme.xml`](file:///C:/Users/abuha/AndroidStudioProjects/IeltsSpeaking/blogspot_theme.xml) in your code editor or notepad.
2. Select all (`Ctrl + A`) and copy (`Ctrl + C`).
3. In the Blogger **Edit HTML** window, select all existing code (`Ctrl + A`) and delete it.
4. Paste the copied contents of `blogspot_theme.xml` (`Ctrl + V`).
5. Click the **Save** icon (diskette icon in the top-right corner).

> [!TIP]
> **Alternative One-Click Upload (Restore):**
> You can also click the down arrow next to `CUSTOMIZE` -> select **Restore** -> click **Upload** -> select the `blogspot_theme.xml` file directly from your computer.

### Step 4: Disable Mobile Template Override (Important)
To ensure iPhone and Android mobile browsers receive the full custom theme rather than Blogger's legacy mobile template:
1. In the **Theme** section, click the down arrow next to **CUSTOMIZE**.
2. Click **Mobile settings**.
3. Choose **Desktop** (or "No, show desktop theme on mobile devices").
4. Click **Save**.

Your app is now live at `https://yourblog.blogspot.com`!

---

## App Features Included in the Theme:

1. 🗣️ **Official Cambridge Speaking Tests (Cambridge 1 to 20 / 2001–2026)**:
   - Filter by Cambridge book and year.
   - Part 1 introductory questions, Part 2 Candidate Task Cards (Cue Cards) with official bullet points, and Part 3 analytical discussion questions.
   - 9 Ranked Model Answers (Band 9.0 down to Band 5.0) for every single test.
   - Band 9.0 Academic Lexicon cards with collocations, definitions, and model sentences.
   - 1-click copy to clipboard.

2. ✍️ **Official Cambridge Writing Tests (Task 1 & Task 2)**:
   - Academic Task 1 Data Reports (graphs, bar charts, tables, pie charts, processes).
   - Task 2 Discursive Essays (opinion, discuss both views, problem-solution).
   - 9 Ranked Model Essays with Band criteria evaluations.
   - Interactive **Essay Practice Sandbox** with real-time word counter and 150/250 word requirement indicators.

3. 📞 **WebRTC PeerJS Audio Calling**:
   - Zero-server cost, peer-to-peer live voice calls.
   - Radar pulse visual status, active call timer, and mute/unmute toggle.
   - **In-Call Cue Card Carousel**: slide through authentic Cambridge cue cards live on-screen while talking to your practice partner!
   - In-Call instant text chat sheet.

4. 👥 **1-on-1 Practice Partners Match**:
   - Browse online practice partners with country flags and target band scores.
   - Direct message and 1-click audio calling.

5. 👤 **Persistent Candidate Profile**:
   - Save your name, target band score (6.5 to 9.0), country, and test module (Academic / General).
   - Stored in browser `localStorage` across visits.
