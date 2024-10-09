package effectivemobile.aleksey.fakehh.data.network.model

import kotlinx.serialization.Serializable

@Serializable
internal data class AddressDTO(
    val house: String,
    val street: String,
    val town: String
)