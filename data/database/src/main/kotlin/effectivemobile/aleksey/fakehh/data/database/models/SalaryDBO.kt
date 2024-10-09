package effectivemobile.aleksey.fakehh.data.database.models

import androidx.room.ColumnInfo

internal data class SalaryDBO(
    @ColumnInfo(name = "full")
    val full: String,
    @ColumnInfo(name = "short")
    val short: String?
)