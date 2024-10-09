package effectivemobile.aleksey.fakehh.data.network.data_source

import effectivemobile.aleksey.fakehh.data.network.model.InfoScreenDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ApiService {
    @GET("u/0/uc")
    suspend fun getInfoScreen(
        @Query("id") id: String = "1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r",
        @Query("export") export: String = "download",
    ): Response<InfoScreenDTO>
}
