package effectivemobile.aleksey.fakehh.data.database.repository

import effectivemobile.aleksey.fakehh.data.database.AppDatabaseDao
import effectivemobile.aleksey.fakehh.data.database.mappers.mapToOffer
import effectivemobile.aleksey.fakehh.data.database.mappers.mapToVacancyDBO
import effectivemobile.aleksey.fakehh.domain.models.Vacancy
import effectivemobile.aleksey.fakehh.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class DatabaseRepositoryImpl @Inject constructor(
    private val appDatabaseDao: AppDatabaseDao
) : DatabaseRepository {

    override fun getAllItemFromFavoriteCollection(): Flow<List<Vacancy>> {
        return appDatabaseDao.getAllItemFromFavoriteCollection()
            .map { listVacancyDBO ->
                listVacancyDBO.map { vacancyDBO ->
                    vacancyDBO.mapToOffer()
                }
            }
    }

    override fun getCountFromFavoriteCollection(): Flow<Int> {
        return appDatabaseDao.getCountFromFavoriteCollection()
    }

    override suspend fun insertItemInFavoriteCollection(vacancy: Vacancy) {
        appDatabaseDao.insertItemInFavoriteCollection(
            vacancy = vacancy.mapToVacancyDBO()
        )
    }

    override suspend fun deleteItemFromFavoriteCollection(vacancy: Vacancy) {
        appDatabaseDao.deleteItemFromFavoriteCollection(vacancy.mapToVacancyDBO())
    }
}