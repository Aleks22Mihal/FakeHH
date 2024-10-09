package effectivemobile.aleksey.fakehh.data.network.model

import kotlinx.serialization.Serializable

@Serializable
internal data class SalaryDTO(
    val full: String,
    val short: String?
)