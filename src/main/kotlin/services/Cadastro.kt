package services

import entities.Produtor



data class Cadastro(val numeroCadastro : Int,
                    val produtor : Produtor,
                    var rebanho : Int)


fun adicionarRebanho(cadastro: Cadastro, quantidade : Int){
    if(quantidade > 0){
        cadastro.rebanho + quantidade
        println("$quantidade cabeças adicionadas ao rebanho.\n")
    }
    else{
        println("Número impossível.\n")
    }
}

fun excluirRebanho(cadastro: Cadastro, quantidade: Int){
    if(quantidade > cadastro.rebanho){
        println("O número requerido deve levar a um saldo negativo, portanto, operação encerrada.\n");
    }
    else{
        println("$quantidade excluída com sucesso.\n")
    }
}

fun realizarTransferencia(cadastro: Cadastro, quantidade: Int){
    if(quantidade > 0 && quantidade <= cadastro.rebanho){
        println("Transferência realizada com sucesso.\n")
    }
    else{
        println("Não foi possível realizar a transferência.\n")
    }
}