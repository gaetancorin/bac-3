import RequestUtils3.loadWeather
import http1.sendGet
import okhttp3.Request
import okhttp3.OkHttpClient
import com.google.gson.Gson

object RequestUtils3 {

    val gson = Gson()
    val client = OkHttpClient()

    fun loadWeather(ville: String): WeatherBean {

        //Réaliser la requête.
        val json: String = sendGet("https://api.openweathermap.org/data/2.5/weather?q=Toulouse&appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr")

        //Parser le JSON avec le bon bean et GSON
        val data : WeatherBean = gson.fromJson(json, WeatherBean::class.java)

        //Retourner la donnée
        return data
    }

    fun sendGet(url: String): String {
        println("url : $url")
        //Création de la requête
        val request = Request.Builder().url(url).build()
        //Execution de la requête
        return RequestUtils.client.newCall(request).execute().use { //it:Response
            //use permet de fermer la réponse qu'il y ait ou non une exception
            //Analyse du code retour
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            //Résultat de la requête
            it.body.string()
        }
    }
}

fun main(){
    var meteo : WeatherBean = loadWeather("toulouse")
    println("à Toulouse il fait ${meteo.temperature.temp} degrés")
}