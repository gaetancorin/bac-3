package http1

fun main(){
    var variable = sendGet("https://www.google.fr")
    println(variable)
}