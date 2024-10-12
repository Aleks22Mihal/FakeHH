package effectivemobile.aleksey.fakehh.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import effectivemobile.aleksey.fakehh.data.database.converter.ConverterString
import effectivemobile.aleksey.fakehh.data.database.models.VacancyDBO

@TypeConverters(ConverterString::class)
@Database(
    entities = [
        VacancyDBO::class,
    ],
    exportSchema =  false,
    version = 1
)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): AppDatabaseDao
}