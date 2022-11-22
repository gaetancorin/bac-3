import java.util.Random

class RandomName {
    private val list = arrayListOf("Toto", "Tata", "Bob")
    private var old = ""

    fun add(name: String) {
        if (name.isNotBlank() && name !in list) {
            list += name
        }
    }

    fun addV2(name: String) = if (name.isNotBlank() && name !in list)  list.add(name) else false

    //version simple
    fun next() = list.random()

    //version pas 2 identique de suite
    fun nextDiff(): String {
        var send = next()
        while (send == old) {
            send = next()
        }
        old = send
        return send
    }

    //Idem sur une ligne
    //Also retourne l'objet sur lequel il est appelé
    fun nextDiffV2() = list.filter { it != old }.random().also { old = it }

    //Retourne 2 noms differents
    fun next2() = Pair(nextDiffV2(), nextDiffV2())
}

fun main() {
    val randomName = RandomName()
    randomName.add("bobby")
    repeat(10) {
        println(randomName.next() + " ")
    }
}
