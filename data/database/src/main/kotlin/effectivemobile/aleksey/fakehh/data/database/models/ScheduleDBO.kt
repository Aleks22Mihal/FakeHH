package effectivemobile.aleksey.fakehh.data.database.models

import androidx.room.ColumnInfo

internal data class ScheduleDBO(
    @ColumnInfo(name = "schedules")
    val schedules: List<String>
)
