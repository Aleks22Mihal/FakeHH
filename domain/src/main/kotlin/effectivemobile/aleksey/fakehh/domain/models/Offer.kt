package effectivemobile.aleksey.fakehh.domain.models

import effectivemobile.aleksey.fakehh.common.models.OfferId

data class Offer(
    val button: Button?,
    val id: OfferId?,
    val link: String,
    val title: String
)