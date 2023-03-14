import com.example.spring_1.PlaneBean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/airport")
class AirportAPI {

    var tab = Array<PlaneBean?>(5) { null}

    //Méthode qui permet de réinitialiser les données entre 2 tests
    //http://localhost:8080/airport/reset
    @GetMapping("/reset")
    fun reset(){
        tab = Array(5) { null}
    }

    //méthode retournant la position de la prochaine place null ou -1 si c'est complet
    //http://localhost:8080/airport/nextplace
    @GetMapping("/nextplace")
    fun nextplace(): Int{
        println("/nextplace")
        return tab.indexOf(null)
    }

}