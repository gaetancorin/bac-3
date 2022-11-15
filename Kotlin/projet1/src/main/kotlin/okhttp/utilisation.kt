package http1

//Utilisation
fun main() {
    //Lazy loading + une seule instanciation
    var html =  RequestUtils.sendGet("https://www.google.fr")
}