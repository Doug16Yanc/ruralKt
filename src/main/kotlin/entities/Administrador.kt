package entities

import interageLogin

data class Administrador(var nome : String,
                        var senha : String)

fun logaAdmin(){
    var chances : Int = 3
    var acessou = false
    val admin = Administrador("Douglas", "1530")
    println("Programa protegido por nome de usuário e senha do administrador.\n")
    do {
        println("Nome de usuário: ")
        var nome = sc.nextLine()

        println("Senha: ")
        var senha = sc.nextLine()

        if (nome.equals(admin.nome) && senha.equals(admin.senha)) {
            interageAdmin(admin)
            acessou = true
        }
        else {
            println("Nome de usuário ou senha não reconhecidos, tente novamente.\n")
            chances--

        }
    } while(!acessou && chances > 0)
}
fun interageAdmin(admin : Administrador){
    var escolha : Int = 0
    println("************Programa Kotlin rural*************************")
    println("Bem vindo, ${admin.nome}, caro administrador.\n")
    do {
        println("**********O que temos para hoje?***************")
        println("       1 - Realizar cadastro de produtor       ")
        println("       2 - Consultar cadastro de produtor      ")
        println("       3 - Listar produtores e seus rebanhos   ")
        println("       4 - Ir para a página de login           ")
        escolha = sc.nextInt()

        when (escolha) {
            1 -> {
                criarCadastro()
            }

            2 -> {
                encontrarCadastro()
            }

            3 -> {
                listarCadastros()
            }

            4 -> {
                interageLogin()
            }

            else -> {
                println("Alternativa impossível.\n")
            }
        }
    } while(escolha != 4)
}
