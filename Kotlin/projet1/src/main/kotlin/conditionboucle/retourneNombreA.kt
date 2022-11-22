fun numbera(texte: String): Number {
    var sortie = 0
    for (i in texte) {
        //V1
        if (i == 'a') {
            sortie += 1
        }
    }
    return sortie
}

fun main(){
    val texte = "Une phrase avec des a"
    println("number of a : ##" + numbera(texte) + "##")
}