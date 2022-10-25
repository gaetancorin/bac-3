import okhttp3.OkHttpClient
import okhttp3.Request

val client = OkHttpClient()

fun sendGet(url: String): String {
    println("url : $url")
    //Création de la requête
    val request = Request.Builder().url(url).build()
    //Execution de la requête
    return client.newCall(request).execute().use {
        //use permet de fermer la réponse qu'il y ait ou non une exception
        //Analyse du code retour
        if (!it.isSuccessful) {
            throw Exception("Réponse du serveur incorrect :${it.code}")
        }
        //Résultat de la requête
        it.body.string()
    }
}