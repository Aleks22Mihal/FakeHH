package effectivemobile.aleksey.fakehh.domain.repository

import effectivemobile.aleksey.fakehh.domain.models.Vacancy
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {

    fun getAllItemFromFavoriteCollection(): Flow<List<Vacancy>>

    fun getCountFromFavoriteCollection(): Flow<Int>

    suspend fun insertItemInFavoriteCollection(vacancy: Vacancy)

    suspend fun deleteItemFromFavoriteCollection(vacancy: Vacancy)
}