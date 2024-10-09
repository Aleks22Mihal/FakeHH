package effectivemobile.aleksey.fakehh.data.network.model

import kotlinx.serialization.Serializable

@Serializable
internal data class ExperienceDTO(
    val previewText: String,
    val text: String
)