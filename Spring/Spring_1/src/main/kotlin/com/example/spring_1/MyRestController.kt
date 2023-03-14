package com.example.spring_1

import org.springframework.web.bind.annotation.*

@RestController
class MyRestController {

    //http://localhost:8080/test
    @GetMapping("/test")
    fun testMethode(): String {
        println("/test")
        return "Hello World"
    }

    //http://localhost:8080/getStudent
    @GetMapping("/getStudent")
    fun getStudent(): StudentBean{
        println("/getStudent")
        var student =  StudentBean("monsieurApi", 12)
        return student
    }

    //http://localhost:8080/createStudent?nom=bob&note=12
    @GetMapping("/createStudent")
    fun createStudent(@RequestParam(value = "nom", defaultValue = "") p1: String, note: Int): StudentBean? {
        //p1 contiendra bob et note contiendra 12
        println("/createStudent : p1=$p1 note=$note")
        return StudentBean(p1, note)
    }

    //http://localhost:8080/createStudent?nom=bob&note=12
    @GetMapping("/createStudent2")
    fun createStudent2(p1: String, note: Int): StudentBean? {
        //p1 contiendra bob et note contiendra 12
        println("/createStudent : p1=$p1 note=$note")
        return StudentBean(p1, note)
    }

    //http://localhost:8080/max?p1=5&p2=10
    @GetMapping("/max")
    fun max(p1: Int, p2: Int?) :Int?{
        println("/max : p1=$p1 p2=$p2")
        if(p2==null){
            return p1
        }
        else if(p1==null){
            return p2
        }
        return Math.max(p1,p2)
    }

    //http://localhost:8080/receiveStudent
    //Json Attendu : {"name": "toto","note": 12}
    @PostMapping("/receiveStudent")
    fun receiveStudent(@RequestBody student: StudentBean) {
        println("/receiveStudent : " + student.name + " : " + student.note)
        println("/receiveStudent : $student")
    }

    //http://localhost:8080/increment
    //Json Attendu : {"name": "toto","note": 12}
    @PostMapping("/increment")
    fun increment(@RequestBody student: StudentBean): StudentBean {
        println("/increment : " + student.name + " : " + student.note)
        student.note += 1
        return student
    }
}