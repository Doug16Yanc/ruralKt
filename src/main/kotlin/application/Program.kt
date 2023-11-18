import entities.Administrador
import entities.*

import java.util.*
val sc = Scanner(System.`in`)

fun main(args: Array<String>) {
    interageLogin()
}
fun interageLogin(){
    println("**************PÁGINA DE LOGIN***************\n")
    println("           (A/a) - Administrador            \n")
    println("           (P/p) - Produtor                 \n")
    var opcao = sc.next()

    if (opcao.equals("A") || opcao.equals("a")){
        logaAdmin()
    }
    else if (opcao.equals("P") || opcao.equals("p")){
        logaProdutor()
    }
    else{
        println("Alternativa impossível.\n")
    }
}

