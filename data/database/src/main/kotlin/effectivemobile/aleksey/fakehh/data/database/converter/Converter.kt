package effectivemobile.aleksey.fakehh.data.database.converter

import androidx.room.TypeConverter
import java.util.stream.Collectors


class ConverterString {
    @TypeConverter
    fun fromString(hobbies: List<String?>): String {
        return hobbies.stream().collect(Collectors.joining(","))
    }

    @TypeConverter
    fun toString(data: String): List<String> {
        return listOf(*data.split(",".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray())
    }
}