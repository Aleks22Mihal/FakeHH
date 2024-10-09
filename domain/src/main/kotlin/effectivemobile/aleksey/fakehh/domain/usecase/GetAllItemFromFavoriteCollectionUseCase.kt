package effectivemobile.aleksey.fakehh.domain.usecase

import effectivemobile.aleksey.fakehh.domain.models.Vacancy
import effectivemobile.aleksey.fakehh.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllItemFromFavoriteCollectionUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {
    operator fun invoke(): Flow<List<Vacancy>> {
        return databaseRepository.getAllItemFromFavoriteCollection()
    }
}