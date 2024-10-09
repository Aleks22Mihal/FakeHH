package effectivemobile.aleksey.fakehh.domain.usecase

import effectivemobile.aleksey.fakehh.domain.repository.DatabaseRepository
import javax.inject.Inject

class GetCountFromFavoriteCollectionUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {
    operator fun invoke() = databaseRepository.getCountFromFavoriteCollection()
}