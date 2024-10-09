package effectivemobile.aleksey.fakehh.data.network.model

import effectivemobile.aleksey.fakehh.common.models.OfferId
import kotlinx.serialization.Serializable

@Serializable
internal data class OfferDTO(
    val button: ButtonDTO?,
    val id: OfferId?,
    val link: String,
    val title: String
)