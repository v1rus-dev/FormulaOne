package yegor.cheprasov.formulaone.core.api.di

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import yegor.cheprasov.formulaone.core.api.NetworkParams
import yegor.cheprasov.formulaone.core.api.interceptors.PrettyLoggingInterceptor
import yegor.cheprasov.formulaone.core.api.services.DriversRemoteApi
import yegor.cheprasov.formulaone.core.api.services.SessionsRemoteApi
import java.util.concurrent.TimeUnit

internal const val CONTENT_TYPE_JSON = "application/json"

private const val TIMEOUT_SECONDS = 10L

val apiModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .apply {
                callTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                addInterceptor(PrettyLoggingInterceptor())
            }.build()
    }

    single<Json> {
        Json {
            isLenient = true
            ignoreUnknownKeys = true
            coerceInputValues = true
            explicitNulls = false
        }
    }

    factory<Retrofit> { (params: NetworkParams) ->
        val baseBuilder = get<OkHttpClient>().newBuilder()
        val client = (params.okHttpBuilder?.invoke(baseBuilder) ?: baseBuilder).build()

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(params.baseUrl)
            .addConverterFactory(get<Json>().asConverterFactory(CONTENT_TYPE_JSON.toMediaType()))
            .client(client)

        retrofitBuilder.build()
    }

    single<Retrofit>(named(RETROFIT_OPEN_F1)) {
        get<Retrofit> {
            val params = NetworkParams(
                baseUrl = OPEN_F1_URL,
                okHttpBuilder = {
                    get<OkHttpClient>().newBuilder()
                }
            )
            parametersOf(params)
        }
    }

    single<DriversRemoteApi> {
        get<Retrofit>(named(RETROFIT_OPEN_F1))
            .create(DriversRemoteApi::class.java)
    }

    single<SessionsRemoteApi> {
        get<Retrofit>(named(RETROFIT_OPEN_F1))
            .create(SessionsRemoteApi::class.java)
    }
}

private const val OPEN_F1_URL = "https://api.openf1.org/v1/"
private const val RETROFIT_OPEN_F1 = "retrofitOpenF1"