package effectivemobile.aleksey.fakehh.data.database.models

import androidx.room.ColumnInfo

internal data class ExperienceDBO(
    @ColumnInfo(name = "previewText")
    val previewText: String,
    @ColumnInfo(name = "text")
    val text: String
)