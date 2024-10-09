package effectivemobile.aleksey.fakehh.domain.repository

import effectivemobile.aleksey.fakehh.common.utilities.NetworkError
import effectivemobile.aleksey.fakehh.common.utilities.Result
import effectivemobile.aleksey.fakehh.domain.models.InfoScreen

interface Repository {
    suspend fun getInfoScreen(): Result<InfoScreen, NetworkError>
}