package effectivemobile.aleksey.fakehh.data.network.model

import kotlinx.serialization.Serializable

@Serializable
internal data class VacancyDTO(
    val address: AddressDTO,
    val appliedNumber: Int?,
    val company: String,
    val description: String?,
    val experience: ExperienceDTO,
    val id: String,
    val isFavorite: Boolean,
    val lookingNumber: Int?,
    val publishedDate: String,
    val questions: List<String>,
    val responsibilities: String,
    val salary: SalaryDTO,
    val schedules: List<String>,
    val title: String
)