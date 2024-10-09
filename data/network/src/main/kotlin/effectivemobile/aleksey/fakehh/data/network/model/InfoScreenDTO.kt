package effectivemobile.aleksey.fakehh.data.network.model

import kotlinx.serialization.Serializable

@Serializable
internal data class InfoScreenDTO(
    val offers: List<OfferDTO>,
    val vacancies: List<VacancyDTO>
)