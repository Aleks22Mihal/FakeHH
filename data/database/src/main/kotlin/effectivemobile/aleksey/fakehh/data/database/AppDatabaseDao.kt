package effectivemobile.aleksey.fakehh.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import effectivemobile.aleksey.fakehh.data.database.models.VacancyDBO
import kotlinx.coroutines.flow.Flow

@Dao
internal interface AppDatabaseDao {

    @Transaction
    @Query(value = "SELECT * FROM favorite_vacancy")
    fun getAllItemFromFavoriteCollection(): Flow<List<VacancyDBO>>

    @Transaction
    @Query("SELECT COUNT(*) FROM favorite_vacancy")
    fun getCountFromFavoriteCollection(): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItemInFavoriteCollection(vacancy: VacancyDBO)

    @Delete
    suspend fun deleteItemFromFavoriteCollection(vacancy: VacancyDBO)


}