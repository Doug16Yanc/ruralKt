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
                            "(1) - Adicionar cabeças de gado ao rebanho:\n" +
                            "(2) - Excluir cabeças de gado do rebanho:\n" +
                            "(3) - Transferir cabeças de gado:\n" +
                            "(4) - Voltar para página principal:"
                )
                opcao = sc.nextInt()

                when (opcao) {
                    1 -> {

                        aumentarRebanho()
                    }

                    2 -> {
                        diminuirRebanho()
                    }

                    3 -> {
                        transferirRebanho()
                    }

                    4 -> {
                        interageLogin()
                    }

                    else -> {
                        println("Alternativa impossível.\n")
                    }
                }

            } while (opcao != 4)
        }

        fun aumentarRebanho() {

            println("Qual a quantidade que desejas adicionar?")
            var quantidade = sc.nextInt()

            /*Cadastro.excluirRebanho(quantidade)*/
        }

        fun diminuirRebanho() {
            println("Qual a quantidade que desejas remover?")
            var quantidade = sc.nextInt()

           /* Cadastro.adicionarRebanho(quantidade)*/
        }

        fun transferirRebanho() {

        }
    }

}

