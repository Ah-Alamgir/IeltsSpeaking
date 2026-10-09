package com.ielts.speaking.data.model

data class WritingQuestionItem(
    val qNumber: Int, // 1 to 4
    val qNumberLabel: String, // "Question 1", "Question 2", "Question 3", "Question 4"
    val taskTypeLabel: String, // "Task 1: Academic Data Report", "Task 2: Discursive Essay", "Task 1: Letter / Process", "Task 2: Problem-Solution Essay"
    val topicTitle: String,
    val prompt: String,
    val band9Answer: String,
    val vocabularies: List<Band9Vocabulary>
)

data class WritingTestSet(
    val setNumber: Int, // 1, 2, 3, 4
    val setTitle: String, // e.g. "Question Set 1", "Question Set 2", etc.
    val topicTheme: String,
    val questions: List<WritingQuestionItem> // Exactly 4 questions per set
)

data class WritingYearPaper(
    val year: Int,
    val title: String,
    val description: String,
    val sets: List<WritingTestSet> // Exactly 4 sets: Set 1 to 4
)

// Legacy compatibility models
data class WritingQuestion(
    val id: String,
    val year: Int,
    val taskType: WritingTaskType,
    val promptTitle: String,
    val promptBody: String,
    val category: String,
    val rankedAnswers: List<RankedWritingAnswer>
)

enum class WritingTaskType(val label: String) {
    TASK_1("Task 1: Academic / General Training Data & Diagram / Letter"),
    TASK_2("Task 2: Discursive Essay Prompt")
}

data class RankedWritingAnswer(
    val rank: Int, // 1 to 9
    val bandScore: Double, // 9.0 down to 5.0
    val essayTitle: String,
    val essayText: String,
    val taskResponseNotes: String,
    val coherenceNotes: String,
    val lexicalResourceNotes: String,
    val grammarNotes: String
)
