package services

import entities.Produtor

class Cadastro{

    companion object {


        val numeroCadastro: Int = 0
        val produtor: Produtor
            get() {
                TODO()
            }
        var rebanho: Int
            get() {
                return rebanho
            }
            set(rebanho) {
                this.rebanho = rebanho
            }

        fun adicionarRebanho(quantidade: Int) {
            if (quantidade > 0) {
                rebanho + quantidade
                println("$quantidade cabeças adicionadas ao rebanho.\n")
            } else {
                println("Número impossível.\n")
            }
        }

        fun excluirRebanho(quantidade: Int) {
            if (quantidade > rebanho) {
                println("O número requerido deve levar a um saldo negativo, portanto, operação encerrada.\n");
            } else {
                println("$quantidade excluída com sucesso.\n")
            }
        }

        fun realizarTransferencia(quantidade: Int) {
            if (quantidade > 0 && quantidade <= rebanho) {
                println("Transferência realizada com sucesso.\n")
            }
            else {
                println("Não foi possível realizar a transferência.\n")
            }
        }

    }

}