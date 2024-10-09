package effectivemobile.aleksey.fakehh.domain.usecase

import effectivemobile.aleksey.fakehh.common.utilities.NetworkError
import effectivemobile.aleksey.fakehh.common.utilities.Result
import effectivemobile.aleksey.fakehh.common.utilities.onError
import effectivemobile.aleksey.fakehh.common.utilities.onSuccess
import effectivemobile.aleksey.fakehh.domain.models.InfoScreen
import effectivemobile.aleksey.fakehh.domain.models.Vacancy
import effectivemobile.aleksey.fakehh.domain.repository.DatabaseRepository
import effectivemobile.aleksey.fakehh.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * 1) Получаем результат из сети
 * 2) Если запрос прошел успешно
 *  2.1) Если в результате есть флаг isFavorite = true добовляем в базу данных
 *  2.2) Получаем Flow базыданных
 *  2.3) Подпмсываемся на результаты базы данных
 *  2.4) Создаем изменяемый список для добавления в него наших изменненых вакансий
 *  2.5) Проходимся по результатам из сети
 *  2.6) Если наши id из сети сов падают с БД
 *  2.7) То добавляем в изменяемы спиписок вакансию с флагом isFavorite = true
 *  2.8) Иначе с флагом isFavorite = false
 *  2.9) Меняем результат из сети вакансий на наш изменный список
 *  2.10) Emite результат успешный с нашими обновленными данными
 * 3) Если прошел не успешно
 *  3.1) Emite результат с ошибкой
* */
class GetResultUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository,
    private val repository: Repository,
) {
    suspend operator fun invoke(): Flow<Result<InfoScreen, NetworkError>> {
        return flow {
            val result = repository.getInfoScreen()
            result.onSuccess { networkResult ->
                networkResult.vacancies.forEach { vacancy ->
                    if (vacancy.isFavorite) {
                        databaseRepository.insertItemInFavoriteCollection(vacancy)
                    }
                }
                val databaseFlow = databaseRepository.getAllItemFromFavoriteCollection()
                databaseFlow.collect { databaseResult ->
                    val mutableVacancyList = mutableListOf<Vacancy>()
                    networkResult.vacancies.forEach { vacancy: Vacancy ->
                        val boolean = databaseResult.any { it.id == vacancy.id }
                        if (boolean) {
                            val data = vacancy.copy(isFavorite = true)
                            mutableVacancyList.add(data)
                        } else {
                            val data = vacancy.copy(isFavorite = false)
                            mutableVacancyList.add(data)
                        }
                    }
                    val data = networkResult.copy(
                        vacancies = mutableVacancyList.toList()
                    )
                    this.emit(Result.Success(data))
                }
            }.onError { error ->
                emit(Result.Error(error))
            }
        }
    }
}