package effectivemobile.aleksey.fakehh.domain.usecase

import effectivemobile.aleksey.fakehh.domain.models.Vacancy
import effectivemobile.aleksey.fakehh.domain.repository.DatabaseRepository
import javax.inject.Inject

class DeleteItemFromFavoriteUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {
    suspend operator fun invoke(vacancy: Vacancy) {
        databaseRepository.deleteItemFromFavoriteCollection(vacancy)
    }
}