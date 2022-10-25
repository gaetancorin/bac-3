import java.util.Random

fun main() {
    var seat = CarBean("Seat", "Leon", "Grise")
    println( "la marque "+seat.marque+" le modele "+seat.model+" la couleur "+seat.couleur+seat )

    var seat2 = CarBean2("Seat", "Leon", "Grise")
    println( "la marque ${seat2.marque} le modele "+seat2.model+" la couleur "+seat2.couleur+seat )

    var seat3 = CarBean3()
    seat3.marque = "Seat";
    seat3.model = "Leon";
    seat3.couleur= "Grise";
    println( "la marque "+seat3.marque+" le modele "+seat3.model+" la couleur "+seat3.couleur+seat)

    var eleve = StudentBean("Richard")
    eleve.note+= 1
    println( "l'élève "+eleve.name+" a la note de "+eleve.note)

    var random = PrintRandomIntBean(10)

    var userBean = UserBean("nameuserBean", 2)
    println( userBean.name+" "+ userBean.id )
    // println( userBean )
    // println( userBean.id )

}

class CarBean(var marque: String , var model: String, var couleur: String)

class CarBean2(lamarque: String , lemodel: String, lacouleur: String){
    var marque = lamarque
    var model = lemodel
    var couleur = lacouleur
}

class CarBean3(){
    var marque :String? = null
    var model :String? = null
    var couleur :String? = null
}

class StudentBean(val name: String){
    var note: Int = 0
}

class PrintRandomIntBean(var max: Int){
    val random = Random()
    init {
        println( random.nextInt(max) )
        println( random.nextInt(max) )
        println( random.nextInt(max) )
    }
    constructor() :this(100) {
        println( random.nextInt(max) )
    }
}

class UserBean(val name: String , var note: Int){
    val id: Int = this.hashCode()
    constructor(name: String) :this(name, 0)
}