fun main() {
    println( min(3,1,11))
}

fun min(a:Int, b:Int, c:Int) :Int {
    if(a < b && a < c){
        return a
    }
    else if(b < c){
        return b
    }
    else{
        return c
    }
}