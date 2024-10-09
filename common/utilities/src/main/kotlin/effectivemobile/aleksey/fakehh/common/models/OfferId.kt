package effectivemobile.aleksey.fakehh.common.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class OfferId {
    @SerialName("near_vacancies")
    NearVacancies,

    @SerialName("level_up_resume")
    LevelUpResume,

    @SerialName("temporary_job")
    TemporaryJob
}