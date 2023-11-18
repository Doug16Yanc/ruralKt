package services
import java.util.*
import entities.*
import interageLogin
import kotlin.random.Random


class Administração {

    companion object {
        val sc = Scanner(System.`in`)

        fun logaAdmin() {
            var chances: Int = 3
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
                } else {
                    println("Nome de usuário ou senha não reconhecidos, tente novamente.\n")
                    chances--

                }
            } while (!acessou && chances > 0)
        }

        fun interageAdmin(admin: Administrador) {
            var escolha: Int = 0
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
            } while (escolha != 4)
        }

        val cadastro : MutableList<Produtor> = ArrayList()
        fun gerarID(): Int {
            var produtor: List<Produtor> = ArrayList()
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
                } else {
                    entrada = Random.nextInt(100000, 1000000)
                }
            }

            return entrada
        }

        fun criarCadastro() {
            println("Processo para criar cadastro...\n")

            sc.nextLine()

            println("Nome : ")
            val nome = sc.nextLine()

            println("Localidade : ")
            val local = sc.nextLine()

            println("Cadastro de pessoa física: ")
            val cpf = sc.nextLine()

            println("Senha desse novo usuário:")
            val senha = sc.nextLine()

            val id = gerarID()

            val rebanho = 0

            val produtor =  Produtor(id, cpf, nome, local, senha, rebanho)

            cadastro.add(produtor)

            println("**********COMPROVANTE DE CADASTRO************\n")
            println("\nNome : ${produtor.nome} " +
                    "\nLocalidade : ${produtor.localidade} " +
                    "\nCPF : ${produtor.cpf} " +
                    "\nId : ${produtor.id}" +
                    "\nRebanho : ${produtor.rebanho}")
        }

        fun encontrarCadastro() {
            println("Digite 1 para procurar por CPF ou 2 para procurar por id:\n")
            var escolha = sc.nextInt()

            when (escolha) {
                1 -> {
                    println("Digite o CPF de quem desejas encontrar.\n")
                    var cpf = sc.next()
                    val produtorEncontrado = cadastro.find { it.cpf == cpf }
                    if (produtorEncontrado != null) {
                        println("Produtor encontrado com sucesso.\n")
                    } else {
                        println("Nenhum produtor encontrado com esse CPF.\n")
                    }
                }

                2 -> {
                    println("Digite o Id de quem desejas encontrar:\n")
                    var id = sc.nextInt()
                    var produtorEncontrado = false
                    for (produtor: Produtor in cadastro) {
                        if (id == produtor.id) {
                            println("Produtor encontrado com sucesso.\n")
                            produtorEncontrado = true
                            mostraDados(produtor)
                        }
                    }
                    if (!produtorEncontrado) {
                        println("Não há produtor com esse cadastro.\n")
                    }
                }

                else -> {
                    println("Opção impossível.\n")
                }
            }
        }
        fun mostraDados(produtor: Produtor){
            println("*************DADOS****************\n")
            println("\n> Id do produtor : ${produtor.id}" +
                    "\n> Nome : ${produtor.nome}" +
                    "\n> Localidade : ${produtor.localidade}" +
                    "\n> CPF : ${produtor.cpf}" +
                    "\n> Rebanho atual : ${produtor.rebanho}")
        }

        fun listarCadastros() {

            if (cadastro.isNotEmpty())
            {
                println("*******LISTAGEM DE PRODUTORES********\n")
                for (produtor: Produtor in cadastro) {
                    println("\n> Id do produtor : ${produtor.id}" +
                            "\n> Nome : ${produtor.nome}" +
                            "\n> Localidade : ${produtor.localidade}" +
                            "\n> CPF : ${produtor.cpf}" +
                            "\n> Rebanho atual : ${produtor.rebanho}")
                }
            }
            else{
                println("Nenhum dado registrado.\n")
            }

        }
    }

}