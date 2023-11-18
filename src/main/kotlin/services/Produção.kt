package services

import entities.Produtor
import interageLogin
import services.Administração.Companion.cadastro
import java.util.*


class Produção {

    companion object {
       val sc = Scanner(System.`in`)

        fun logaProdutor() {
            var chances: Int = 3
            var acessou = false

            println("Programa protegido por nome de usuário e senha do produtor.\n")
            do {
                sc.nextLine()

                println("Nome de usuário: ")
                var nome = sc.nextLine()

                println("Senha: ")
                var senha = sc.nextLine()

                for (produtor: Produtor in cadastro) {
                    if (nome.equals(produtor.nome) && senha.equals(produtor.senha)) {
                        interageProdutor(produtor)
                        acessou = true
                    }
                }
                if(!acessou){
                    println("Nome de usuário ou senha não reconhecidos, tente novamente.\n")
                    chances--

                }

            } while (!acessou && chances > 0)
        }

        fun interageProdutor(produtor: Produtor) {


            var opcao: Int = 0
            println("************Programa Kotlin rural*************************")
            println("Bem vindo(a), ${produtor.nome}, caro(a) produtor(a).\n")
            do {
                println(
                    "O que temos para hoje?\n" +
                            "(1) - Visualizar seus dados \n" +
                            "(2) - Adicionar cabeças de gado ao rebanho:\n" +
                            "(3) - Excluir cabeças de gado do rebanho:\n" +
                            "(4) - Transferir cabeças de gado:\n" +
                            "(5) - Voltar para página principal:"
                )
                opcao = sc.nextInt()

                when (opcao) {
                    1 -> {
                        visualizarDados(produtor)
                    }
                    2 -> {
                        aumentarRebanho(produtor)
                    }
                    3 -> {
                        diminuirRebanho(produtor)
                    }

                    4 -> {
                        transferirRebanho(produtor)
                    }

                    5 -> {
                        interageLogin()
                    }

                    else -> {
                        println("Alternativa impossível.\n")
                    }
                }

            } while (opcao != 5)
        }

        fun visualizarDados(produtor : Produtor){
            println("\n> Id do produtor : ${produtor.id}" +
                    "\n> Nome : ${produtor.nome}" +
                    "\n> Localidade : ${produtor.localidade}" +
                    "\n> CPF : ${produtor.cpf}" +
                    "\n> Rebanho atual : ${produtor.rebanho}")
        }

        fun aumentarRebanho(produtor: Produtor) {

            println("Qual a quantidade que desejas adicionar?")
            var quantidade = sc.nextInt()

            Rebanho.adicionarRebanho(produtor, quantidade)
        }

        fun diminuirRebanho(produtor: Produtor) {
            println("Qual a quantidade que desejas remover?")
            var quantidade = sc.nextInt()

           Rebanho.excluirRebanho(produtor, quantidade)
        }

        fun transferirRebanho(produtor: Produtor) {
            println("Digite o nome e o CPF de quem desejas transferir as cabeças")
            sc.nextLine()
            println("Nome: ")
            var nome = sc.nextLine()
            println("CPF : ")
            var cpf = sc.nextLine()

            val produtorEncontrado = cadastro.find {it.nome == nome && it.cpf == cpf }

            if (produtorEncontrado != null){
                println("Informe a quantidade, por favor:")
                var quantidade = sc.nextInt()
                Rebanho.realizarTransferencia(produtor, quantidade)
                produtorEncontrado.rebanho += quantidade
            }
            else{
                println("Nome ou CPF não reconhecidos...")
            }
        }
    }

}

