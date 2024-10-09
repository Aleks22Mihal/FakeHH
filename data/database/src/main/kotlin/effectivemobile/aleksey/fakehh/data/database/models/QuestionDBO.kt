package effectivemobile.aleksey.fakehh.data.database.models

import androidx.room.ColumnInfo

internal data class QuestionDBO(
    @ColumnInfo(name = "questions")
    val questions: List<String>
)