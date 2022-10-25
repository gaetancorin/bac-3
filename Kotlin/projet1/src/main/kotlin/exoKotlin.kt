fun main() {
    println(min2(2,3,4))
    println(pair(2))
    println(pair(3))
    myPrint("toto")

    println( boulangerie(1, 2, 3))
}


fun min2(a:Int, b:Int, c:Int ) = if(a < b && a < c) a
else if(b < a && b < c) b
else  c


fun pair(c:Int) = c%2 == 0
fun myPrint(chaine:String) = println("##$chaine##")


fun boulangerie(a:Int=0 , b:Int=0 , c:Int=0 ) =
    (a*prixcroissant) + (b*prixbaguette) + (c*prixsandwich)