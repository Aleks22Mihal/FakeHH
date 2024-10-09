package effectivemobile.aleksey.fakehh.data.database.models

import androidx.room.ColumnInfo

internal data class AddressDBO(
    @ColumnInfo(name = "house")
    val house: String,
    @ColumnInfo(name = "street")
    val street: String,
    @ColumnInfo(name = "town")
    val town: String
)