fun reverse(texte: String): String {
    // var sortie = ""
    return  texte.reversed()
}

fun main(){
    val texte = "Une phrase avec des e"
    println("reverse : ##" + reverse(texte) + "##")
}
