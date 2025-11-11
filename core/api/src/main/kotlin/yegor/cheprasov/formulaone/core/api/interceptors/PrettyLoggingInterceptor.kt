package yegor.cheprasov.formulaone.core.api.interceptors

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.json.JSONArray
import org.json.JSONObject

class PrettyLoggingInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        val url = request.url.toString()
        val method = request.method
        val responseBody = response.body
        val contentType = responseBody?.contentType()
        val content = responseBody?.string() ?: ""

        Log.i("HTTP", "➡️ $method $url")

        if (contentType?.subtype == "json") {
            try {
                val formatted = when {
                    content.trim().startsWith("{") -> JSONObject(content).toString(2)
                    content.trim().startsWith("[") -> JSONArray(content).toString(2)
                    else -> content
                }
                Log.i("HTTP", "⬅️ Response:\n$formatted")
            } catch (e: Exception) {
                Log.i("HTTP", "⬅️ Raw JSON:\n$content")
            }
        } else {
            Log.i("HTTP", "⬅️ Response: $content")
        }

        // Нужно пересоздать тело, иначе его больше нельзя читать
        val newBody = responseBody?.contentType()?.let {
            content.toByteArray().toResponseBody(it)
        }

        return response.newBuilder()
            .body(newBody)
            .build()
    }
}