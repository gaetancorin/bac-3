import com.google.gson.annotations.SerializedName

class WeatherBean (
    // var coord :CoordBean,
    var visibility :Int,
    var name :String,

    //Indique que l'attribut main du JSON correspond à l'attribut temperature
    @SerializedName("main")
    var temperature:TempBean
)

class TempBean (
    var temp :Float,
)