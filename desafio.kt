// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val sobrenome: String, val nivel: Nivel)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>,val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) { inscritos.add(usuario) }

    fun buscaAluno() {
        for(usuarioCadastrado in inscritos){
            println("O usuario ${usuarioCadastrado.nome+" "+usuarioCadastrado.sobrenome} foi matriculado com sucesso")
            }
    }

    fun buscaConteudo() {
        for(conteudoCadastrado in conteudos){
            println("O conteudo ${conteudoCadastrado.nome} foi cadastrado com sucesso")
            }
    }
}

fun main() {

        val conteudoBasico = ConteudoEducacional("Java Efetivo", 60, Nivel.BASICO)
        val conteudoInterm = ConteudoEducacional("Clean Code", 60, Nivel.INTERMEDIARIO)
        val conteudoAvanc = ConteudoEducacional("Clean Archictecture", 60, Nivel.DIFICIL)

        val usuarioBasico = Usuario("Gustavo", "Paulo", Nivel.BASICO)
        val usuarioInterm = Usuario("Pedro", "Alves", Nivel.INTERMEDIARIO)
        val usuarioAvanc = Usuario("Carla", "Almeida", Nivel.DIFICIL)

        val formacao1 = Formacao("Bootcamp Java Beginners Ifood", listOf(conteudoBasico, conteudoInterm, conteudoAvanc), Nivel.BASICO)

        formacao1.matricular(usuarioBasico)
        formacao1.matricular(usuarioInterm)
        formacao1.matricular(usuarioAvanc)

        formacao1.buscaAluno()
        formacao1.buscaConteudo()

        println(formacao1)

        val formacao2 = formacao1.copy(nome = "Bootcamp Carrefour")
        println(formacao2)

        val formacao3 = formacao1.copy(nome = "Bootcamp Cyber Security")
        println(formacao3)

        val formacao4 = formacao1.copy(nome = "Bootcamp Orange Tech")
        println(formacao4)

}
