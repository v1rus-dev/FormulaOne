package yegor.cheprasov.formulaone.core.api

import okhttp3.OkHttpClient

data class NetworkParams(
    val baseUrl: String,
    val okHttpBuilder: ((builder: OkHttpClient.Builder) -> OkHttpClient.Builder)? = null
)
