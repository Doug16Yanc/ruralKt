
import services.Administração.Companion.logaAdmin
import services.Produção.Companion.logaProdutor
import java.lang.System.exit

import java.util.*
val sc = Scanner(System.`in`)

fun main(args: Array<String>) {
    interageLogin()
}
fun interageLogin(){
    println("**************PÁGINA DE LOGIN***************\n")
    println("           (A/a) - Administrador            \n")
    println("           (P/p) - Produtor                 \n")
    println("           (E/e) - Encerrar                 \n")
    var opcao = sc.next()

    if (opcao.equals("A") || opcao.equals("a")){
        logaAdmin()
    }
    else if (opcao.equals("P") || opcao.equals("p")){
        logaProdutor()
    }
    else if (opcao.equals("E") || opcao.equals("e")){
        println("Volte sempre!\n")
        exit(0)
    }
    else{
        println("Alternativa impossível.\n")
    }
}

