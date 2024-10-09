package effectivemobile.aleksey.fakehh.domain.usecase

import effectivemobile.aleksey.fakehh.domain.repository.Repository
import javax.inject.Inject

class GetInfoScreenUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.getInfoScreen()
}