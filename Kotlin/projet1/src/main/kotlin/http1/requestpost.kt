package http1

import okhttp3.OkHttpClient
import okhttp3.Request

import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.MediaType.Companion.toMediaType

object RequestUtilsSend {
    val client = OkHttpClient()
    val MEDIA_TYPE_JSON = "application/json; charset=utf-8".toMediaType()

    fun sendPost(url: String, paramJson: String): String {
        println("url : $url")

        //Corps de la requête
        val body = paramJson.toRequestBody(MEDIA_TYPE_JSON)

        //Création de la requête
        val request = Request.Builder().url(url).post(body).build()


        return client.newCall(request).execute().use {
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            it.body.string()
        }
    }
}