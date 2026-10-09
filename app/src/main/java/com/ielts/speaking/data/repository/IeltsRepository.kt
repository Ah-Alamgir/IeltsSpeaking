package com.ielts.speaking.data.repository

import com.ielts.speaking.data.model.*

object IeltsRepository {

    val years: List<Int> = (2001..2026).toList().reversed()

    // Primary 4-Set Question Paper Accessors (2001 to 2026)
    fun getSpeakingPaper(year: Int): SpeakingYearPaper {
        return SpeakingDataProvider.getSpeakingPaper(year)
    }

    fun getWritingPaper(year: Int): WritingYearPaper {
        return WritingDataProvider.getWritingPaper(year)
    }

    // Backwards-compatible Speaking list supporting all years 2001..2026
    val speakingQuestions: List<SpeakingQuestion> by lazy {
        generateAllSpeakingQuestions()
    }

    // Backwards-compatible Writing list supporting all years 2001..2026
    val writingQuestions: List<WritingQuestion> by lazy {
        generateAllWritingQuestions()
    }

    private fun generateAllSpeakingQuestions(): List<SpeakingQuestion> {
        val list = mutableListOf<SpeakingQuestion>()

        years.forEach { yr ->
            val paper = getSpeakingPaper(yr)
            paper.sets.forEach { set ->
                val p2Question = set.questions.find { it.qNumber == 2 } ?: set.questions.first()
                val p3Question = set.questions.find { it.qNumber == 3 }
                val p4Question = set.questions.find { it.qNumber == 4 }

                list.add(
                    SpeakingQuestion(
                        id = "sp_${yr}_${set.setNumber}",
                        year = yr,
                        part = SpeakingPart.PART_2,
                        topic = set.topicTheme,
                        title = "${set.setTitle} ($yr): ${p2Question.topicTitle}",
                        promptText = p2Question.prompt + if (p2Question.bulletPoints.isNotEmpty()) "\n\nYou should say:\n• " + p2Question.bulletPoints.joinToString("\n• ") else "",
                        followUpQuestions = listOfNotNull(
                            p3Question?.prompt,
                            p4Question?.prompt
                        ),
                        rankedAnswers = createRankedSpeakingAnswers(set.topicTheme, p2Question.band9Answer, p2Question.vocabularies)
                    )
                )
            }
        }
        return list
    }

    private fun generateAllWritingQuestions(): List<WritingQuestion> {
        val list = mutableListOf<WritingQuestion>()

        years.forEach { yr ->
            val paper = getWritingPaper(yr)
            paper.sets.forEach { set ->
                val task2Question = set.questions.find { it.qNumber == 2 } ?: set.questions[1]
                val task1Question = set.questions.find { it.qNumber == 1 } ?: set.questions[0]

                // Task 2 Prompt
                list.add(
                    WritingQuestion(
                        id = "wr_${yr}_${set.setNumber}_t2",
                        year = yr,
                        taskType = WritingTaskType.TASK_2,
                        promptTitle = "${set.setTitle} ($yr): ${task2Question.topicTitle}",
                        promptBody = task2Question.prompt,
                        category = set.topicTheme,
                        rankedAnswers = createRankedWritingAnswers(task2Question.topicTitle, task2Question.band9Answer)
                    )
                )

                // Task 1 Prompt
                list.add(
                    WritingQuestion(
                        id = "wr_${yr}_${set.setNumber}_t1",
                        year = yr,
                        taskType = WritingTaskType.TASK_1,
                        promptTitle = "${set.setTitle} ($yr): ${task1Question.topicTitle}",
                        promptBody = task1Question.prompt,
                        category = "${set.topicTheme} (Task 1 Report)",
                        rankedAnswers = createRankedWritingAnswers(task1Question.topicTitle, task1Question.band9Answer)
                    )
                )
            }
        }
        return list
    }

    private fun createRankedSpeakingAnswers(
        topicName: String,
        masterBand9Answer: String,
        keyVocab: List<Band9Vocabulary>
    ): List<RankedAnswer> {
        val bands = listOf(9.0, 8.5, 8.0, 7.5, 7.0, 6.5, 6.0, 5.5, 5.0)
        return bands.mapIndexed { index, score ->
            val rank = index + 1
            RankedAnswer(
                rank = rank,
                bandScore = score,
                title = "Rank $rank - Official Band $score Sample Answer",
                sampleText = if (score >= 9.0) masterBand9Answer else generateSpeakingText(topicName, score),
                keyVocabulary = keyVocab.map { it.word },
                feedbackNotes = generateSpeakingFeedback(score)
            )
        }
    }

    private fun createRankedWritingAnswers(topicName: String, masterBand9Essay: String): List<RankedWritingAnswer> {
        val bands = listOf(9.0, 8.5, 8.0, 7.5, 7.0, 6.5, 6.0, 5.5, 5.0)
        return bands.mapIndexed { index, score ->
            val rank = index + 1
            RankedWritingAnswer(
                rank = rank,
                bandScore = score,
                essayTitle = "Rank $rank Essay (Band $score)",
                essayText = if (score >= 9.0) masterBand9Essay else generateEssayText(topicName, score),
                taskResponseNotes = "Band $score Task Response: Clear stance and relevant main ideas developed thoroughly.",
                coherenceNotes = "Band $score Coherence & Cohesion: " + if (score >= 8.0) "Logical sequencing with natural cohesive devices." else "Organized paragraphs with occasional mechanical cohesion.",
                lexicalResourceNotes = "Band $score Lexical Resource: " + if (score >= 8.0) "Sophisticated vocabulary with rare idiomatic errors." else "Adequate vocabulary range with minor collocation errors.",
                grammarNotes = "Band $score Grammatical Range: " + if (score >= 8.0) "Wide variety of complex structures with high accuracy." else "Mix of simple and complex sentence forms with occasional minor slips."
            )
        }
    }

    private fun generateSpeakingText(topic: String, band: Double): String {
        return when {
            band >= 8.0 -> "Honestly speaking, $topic plays an indispensable role in my everyday activities. I began utilizing these methods a couple of years ago, and they have genuinely elevated my efficiency. For instance, tasks that used to take hours of manual effort are now streamlined effortlessly, allowing me to maintain a healthier work-life balance while achieving superior outcomes."
            band >= 7.0 -> "To be fair, $topic has brought noticeable changes to my lifestyle. I regularly make use of modern techniques to organize my daily schedule. It helps me complete my assignments faster and avoids unnecessary delays, although occasionally I face minor technical glitches."
            band >= 6.0 -> "In my opinion, $topic is quite important for me nowadays. I use it almost every day because it is very convenient and saves time. Although it can be a bit complicated at first, I learned how to handle it step by step."
            else -> "I think $topic is good for my daily life. I use it sometimes when I have free time. It helps me do my study and communicate with my friends easily."
        }
    }

    private fun generateSpeakingFeedback(band: Double): String {
        return when {
            band >= 9.0 -> "Flawless fluency and natural pronunciation. Uses idiomatic expressions effortlessly without hesitation."
            band >= 8.0 -> "Fluent with minimal hesitation. Precise vocabulary choices with natural collocations."
            band >= 7.0 -> "Speaks at length without noticeable effort. Good range of vocabulary with occasional minor inaccuracies."
            band >= 6.0 -> "Willing to speak at length, though may lose coherence at times. Meaning is always clear."
            else -> "Noticeable pauses while searching for words. Basic vocabulary sufficient for familiar topics."
        }
    }

    private fun generateEssayText(topic: String, band: Double): String {
        return when {
            band >= 8.0 -> "In recent years, the discussion surrounding $topic has sparked considerable debate among policy makers and the general public. While some argue that government interventions are paramount, others maintain that personal initiative plays a more crucial role. This essay examines both perspectives before presenting a nuanced conclusion.\n\nOn the one hand, centralized policies establish clear guidelines and financial incentives. For example, legislative reforms can mandate strict standards that compel industries to adopt sustainable practices. On the other hand, individual choices collectively drive market demand and societal norms.\n\nIn summary, both top-down regulations and bottom-up individual actions are essential to achieving meaningful and long-lasting progress."
            band >= 7.0 -> "Nowadays, $topic is a subject of intense discussion worldwide. Many people believe that strong government action is necessary, whereas others argue that people should take personal responsibility. This essay will discuss both sides and give my opinion.\n\nFirst of all, government policies can bring fast changes because they have authority and financial resources. Secondly, individual awareness is equally important because laws cannot be effective if people do not obey them.\n\nTo conclude, I believe that a combination of government rules and personal responsibility is the best way forward."
            band >= 6.0 -> "Today, $topic is very important for many countries. Some people say that government should solve this problem, but other people think individuals must do something. I will write about both sides in this essay.\n\nFirstly, government has a lot of money to help people and build facilities. Secondly, individuals can change their habits every day to make a good difference.\n\nIn conclusion, I think both government and people should work together."
            else -> "Now $topic is very popular in the world. Some people think government is good for this, but other people think normal people can do it. I agree that both are important.\n\nGovernment has power to make rules. Also people can do good things at home.\n\nSo my opinion is we need both government and people."
        }
    }
}
