package effectivemobile.aleksey.fakehh.domain.usecase

import effectivemobile.aleksey.fakehh.domain.models.Vacancy
import effectivemobile.aleksey.fakehh.domain.repository.DatabaseRepository
import javax.inject.Inject

class InsertItemInFavoriteCollectionUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {
    suspend operator fun invoke(vacancy: Vacancy){
        val data = vacancy.copy(isFavorite = true)
        databaseRepository.insertItemInFavoriteCollection(data)
    }
}