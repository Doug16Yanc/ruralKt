package entities

import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

data class Produtor(var id : Int,
                    var cpf : String,
                    var nome: String,
                    var localidade : String)


val cadastro : MutableList<Produtor> = ArrayList()
val sc = Scanner(System.`in`)

fun gerarID(): Int {
    var produtor : List<Produtor> = ArrayList()
    var num = 0

    var entrada = Random.nextInt(100000, 1000000)
    var aux = true

    while (entrada != 1) {
        for (i in 0 until produtor.size) {
            if (entrada == produtor[i].id) {
                aux = false
            }
        }

        if (aux) {
            return entrada
        }
        else {
            entrada = Random.nextInt(100000, 1000000)
        }
    }

    return entrada
}

fun criarCadastro(){
    println("Processo para criar cadastro...\n")

    sc.nextLine()

    println("Nome : ")
    val nome = sc.nextLine()

    println("Localidade : ")
    val local = sc.nextLine()

    println("Cadastro de pessoa física: ")
    val cpf = sc.nextLine()

    val id = gerarID()

    val produtor = Produtor(id, cpf, nome, local)

    cadastro.add(produtor)

    println("**********COMPROVANTE DE CADASTRO************\n")
    println("\nNome : ${produtor.nome} " +
            "      \nLocalidade : ${produtor.localidade} " +
            "       \nCPF : ${produtor.cpf} " +
            "       \nId : ${produtor.id}\n"
    )
}

fun encontrarCadastro(){
    println("Digite 1 para procurar por CPF ou 2 para procurar por id:\n")
    var escolha = sc.nextInt()

    when(escolha){
        1 -> {
            println("Digite o CPF de quem desejas encontrar.\n")
            var cpf = sc.next()
            val produtorEncontrado = cadastro.find{it.cpf == cpf}
            if(produtorEncontrado != null){
                println("Produtor encontrado com sucesso.\n")
            }
            else{
                println("Nenhum produtor encontrado com esse CPF.\n")
            }
        }

        2-> {
            println("Digite o Id de quem desejas encontrar:\n")
            var id = sc.nextInt()

            for(produtor : Produtor in cadastro){
                if (id == produtor.id){
                    println("Produtor encontrado com sucesso.\n")
                }
                else{
                    println("Não há produtor com esse cadastro.\n")
                }

            }
        }
        else -> {
            println("Opção impossível.\n")
        }
    }
}

fun listarCadastros(){
    for (produtor : Produtor in cadastro){
        println(produtor)
    }
}


fun logaProdutor() {

}