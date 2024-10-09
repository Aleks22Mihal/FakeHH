package effectivemobile.aleksey.fakehh.data.network.repository

import android.util.Log
import effectivemobile.aleksey.fakehh.common.utilities.NetworkError
import effectivemobile.aleksey.fakehh.common.utilities.Result
import effectivemobile.aleksey.fakehh.data.network.data_source.ApiService
import effectivemobile.aleksey.fakehh.data.network.mappers.mapToInfoScreen
import effectivemobile.aleksey.fakehh.domain.models.InfoScreen
import effectivemobile.aleksey.fakehh.domain.repository.Repository
import kotlinx.serialization.SerializationException
import java.nio.channels.UnresolvedAddressException
import javax.inject.Inject

internal class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
) : Repository {
    override suspend fun getInfoScreen(): Result<InfoScreen, NetworkError> {

        val response = try {
            apiService.getInfoScreen()
        } catch (e: UnresolvedAddressException) {
            e.printStackTrace()
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            e.printStackTrace()
            return Result.Error(NetworkError.SERIALIZATION)
        } catch (e: Exception) {
            e.printStackTrace()
            return Result.Error(NetworkError.UNKNOWN)
        }

        return when (response.code()) {
            in 200..299 -> {
                val data = response.body()
                if (data != null) {
                    Result.Success(data.mapToInfoScreen())
                } else {
                    Log.e("Response body", "Response body is Null")
                    Result.Error(NetworkError.UNKNOWN)
                }
            }

            401 -> Result.Error(NetworkError.UNAUTHORIZED)

            409 -> Result.Error(NetworkError.CONFLICT)

            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)

            413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)

            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)

            else -> {
                Log.e("Error code: ", "${response.code()}")
                Result.Error(NetworkError.UNKNOWN)
            }
        }
    }

}