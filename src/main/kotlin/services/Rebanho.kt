package services

import entities.Produtor

class Rebanho{

    companion object {

        fun adicionarRebanho(produtor : Produtor, quantidade: Int) {
            if (quantidade > 0) {
                produtor.rebanho += quantidade
                println("$quantidade cabeça(s) adicionadas ao rebanho.\n")
            } else {
                println("Número impossível.\n")
            }
        }

        fun excluirRebanho(produtor: Produtor, quantidade: Int) {
            if (quantidade > produtor.rebanho) {
                println("O número requerido deve levar a um saldo negativo, portanto, operação encerrada.\n");
            }
            else {
                produtor.rebanho -= quantidade
                println("$quantidade excluída(s) com sucesso.\n")
            }
        }

        fun realizarTransferencia(produtor: Produtor, quantidade: Int) {
            if (quantidade > 0 && quantidade <= produtor.rebanho) {
                println("Transferência realizada com sucesso.\n")
                produtor.rebanho -= quantidade
            }
            else {
                println("Não foi possível realizar a transferência.\n")
            }
        }

    }

}