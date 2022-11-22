import com.google.gson.annotations.SerializedName

class WeatherBean (

    var visibility :Int,
    var name :String,

    //Indique que l'attribut main du JSON correspond à l'attribut temperature
    @SerializedName("main")
    var temperature:TempBean,
    @SerializedName("wind")
    var coord :CoordBean,
)

class TempBean (
    var temp :Float,
)
class CoordBean (var speed :Float)