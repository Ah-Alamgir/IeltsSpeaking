package com.ielts.speaking.data.model

data class Band9Vocabulary(
    val word: String,
    val type: String, // e.g., "C2 Lexis", "Idiomatic Collocation", "Formal Register"
    val meaning: String, // English definition and explanation
    val example: String // Contextual example sentence
)

data class SpeakingQuestionItem(
    val qNumber: Int, // 1 to 4
    val qNumberLabel: String, // "Question 1", "Question 2", "Question 3", "Question 4"
    val partLabel: String, // "Part 1: Introduction & Interview", "Part 2: Cue Card", "Part 3: In-Depth Discussion", "Part 3: Critical Analysis"
    val topicTitle: String,
    val prompt: String,
    val bulletPoints: List<String> = emptyList(),
    val band9Answer: String,
    val vocabularies: List<Band9Vocabulary>
)

data class SpeakingTestSet(
    val setNumber: Int, // 1, 2, 3, 4
    val setTitle: String, // e.g. "Question Set 1", "Question Set 2", etc.
    val topicTheme: String,
    val questions: List<SpeakingQuestionItem> // Exactly 4 questions per set
)

data class SpeakingYearPaper(
    val year: Int,
    val title: String,
    val description: String,
    val sets: List<SpeakingTestSet> // Exactly 4 sets: Set 1 to 4
)

// Legacy compatibility models
data class SpeakingQuestion(
    val id: String,
    val year: Int,
    val part: SpeakingPart,
    val topic: String,
    val title: String,
    val promptText: String,
    val followUpQuestions: List<String> = emptyList(),
    val rankedAnswers: List<RankedAnswer>
)

enum class SpeakingPart(val label: String) {
    PART_1("Part 1: Introduction & Interview"),
    PART_2("Part 2: Cue Card (Individual Long Turn)"),
    PART_3("Part 3: Two-Way Discussion")
}

data class RankedAnswer(
    val rank: Int, // 1 to 9
    val bandScore: Double, // 9.0 down to 5.0
    val title: String,
    val sampleText: String,
    val keyVocabulary: List<String>,
    val feedbackNotes: String
)
