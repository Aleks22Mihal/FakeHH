package effectivemobile.aleksey.fakehh.data.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import effectivemobile.aleksey.fakehh.data.network.data_source.ApiService
import effectivemobile.aleksey.fakehh.data.network.repository.RepositoryImpl
import effectivemobile.aleksey.fakehh.domain.repository.Repository
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {

        val loginInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val origin = chain.request()
                val requestBuilder = origin.newBuilder()
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .addNetworkInterceptor(loginInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRestClient(client: OkHttpClient): ApiService {

        val json = Json {
            prettyPrint = true
            explicitNulls = false
            isLenient = true
            ignoreUnknownKeys = true
        }

        val jsonConvertFactory = json.asConverterFactory("application/json".toMediaType())

        return Retrofit.Builder()
            .addConverterFactory(jsonConvertFactory)
            .baseUrl("https://drive.usercontent.google.com")
            .client(client)
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMainRepository(apiService: ApiService): Repository {
        return RepositoryImpl(apiService)
    }
}