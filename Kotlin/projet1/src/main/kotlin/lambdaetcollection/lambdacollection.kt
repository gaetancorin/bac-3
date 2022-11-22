data class PersonBean(var name:String, var note:Int)

fun exo4(){
    val list = arrayListOf(PersonBean ("toto", 16),
        PersonBean ("Tata", 20),
        PersonBean ("Toto", 8),
        PersonBean ("Charles", 14))

    println("Afficher la sous liste de personne ayant 10 et +")
    //println(list.filter { it.note >=10 })
    //Pour un affichage de notre choix
    println(list.filter { it.note >=10 }.joinToString("\n") { "-${it.name} : ${it.note}"})

    //TODO
    println("\n\nAfficher combien il y a de Toto dans la classe ?")
    println(list.count { it.name.equals("toto", true)})

    println("\n\nAfficher combien de Toto ayant la moyenne (10 et +)")
    println(list.count { it.name.equals("toto", true) && it.note >=10 })

    println("\n\nAfficher combien de Toto ont plus que la moyenne de la classe")
    println(list.count { it.name.equals("toto", true) && it.note > list.map { it.note }.average() })

    println("\n\nAfficher la list triée par nom sans doublon")
    println(list.distinctBy { it.name }.sortedBy { it.name })

    println("\n\nAjouter un point a ceux n’ayant pas la moyenne (<10)")
    println( list.filter { it.note < 10 }.forEach { it.note++ } )

    println("\n\nAjouter un point à tous les Toto")


    println("\n\nRetirer de la liste ceux ayant la note la plus petite. (Il faut une ArrayList)")
    println("\n\nAfficher les noms de ceux ayant la moyenne(10et+) par ordre alphabétique")
}

fun main() {
    exo4()
}