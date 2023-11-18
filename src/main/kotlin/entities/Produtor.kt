package entities

data class Produtor(var id : Int,
                    var cpf : String,
                    var nome: String,
                    var localidade : String,
                    var senha : String,
                    var rebanho : Int
                    ) {
    companion object {
        var rebanho: Int = 0
    }
} 
