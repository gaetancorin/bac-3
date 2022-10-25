fun main() {
    println("HelloWorld")
    var v1 = "toto"
    println(v1.uppercase())

    var v2: String? = "Toto"
    println(v2?.uppercase())

    var v3: String? = null
    println(v3)

    //La concaténation de v1+V2 donne String


    //non null, non vide ou fait que d'espaces
    if (!v2.isNullOrBlank()) {

    }
}