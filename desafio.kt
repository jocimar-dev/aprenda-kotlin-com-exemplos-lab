// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }
enum class Categoria { PROGRAMACAO, ARQUITETURA, INFRAESTRUTURA }

class Usuario(val nome: String, val sobrenome: String, val categoria: Categoria)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>,val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) { inscritos.add(usuario) }

    fun buscaAluno() {
        for(usuarioCadastrado in inscritos){
            println("O usuario ${usuarioCadastrado.nome+" "+usuarioCadastrado.sobrenome} foi matriculado com sucesso," +
                    " em bootcamp na categoria de ${usuarioCadastrado.categoria}!")
            }
    }

    fun buscaConteudo() {
        for(conteudoCadastrado in conteudos){
            println("O conteudo ${conteudoCadastrado.nome} foi cadastrado com sucesso")
            }
    }
}

fun main() {
        val conteudoJava = ConteudoEducacional("Java Efetivo", 60)
        val conteudoEngenharia = ConteudoEducacional("Clean Code", 20)
        val conteudoArquitetura = ConteudoEducacional("Clean Archictecture", 30)
        val conteudoKotlin = ConteudoEducacional("Kotlin", 40)
        val conteudoGolang = ConteudoEducacional("Golang", 50)
        val conteudoJavascript = ConteudoEducacional("Javascript", 60)

        val usuarioProgram = Usuario("Gustavo", "Paulo", Categoria.PROGRAMACAO)
        val usuarioArq = Usuario("Pedro", "Alves", Categoria.ARQUITETURA)
        val usuarioInfra = Usuario("Carla", "Almeida", Categoria.INFRAESTRUTURA)

        val formacaoJava = Formacao("Bootcamp Java Beginners Ifood", listOf(conteudoJava, conteudoEngenharia), Nivel.BASICO)

        formacaoJava.matricular(usuarioProgram)

        formacaoJava.buscaAluno()
        formacaoJava.buscaConteudo()

        println(formacaoJava)

        val formacaoJavaAtual = formacaoJava.copy(nome = "Bootcamp Carrefour")
        println(formacaoJavaAtual)
        println("______________________________________________________")

        val formacaoSeguranca = Formacao("Bootcamp Cyber Security", listOf(conteudoKotlin, conteudoGolang,
            conteudoJavascript, conteudoArquitetura, conteudoEngenharia), Nivel.DIFICIL)
        println(formacaoSeguranca)

        formacaoSeguranca.matricular(usuarioProgram)
        formacaoSeguranca.matricular(usuarioArq)
        formacaoSeguranca.matricular(usuarioInfra)

        formacaoSeguranca.buscaAluno()
        formacaoSeguranca.buscaConteudo()

        println("______________________________________________________")

        val formacaoDevOps = Formacao("Bootcamp Orange Tech", listOf(conteudoJavascript, conteudoKotlin,
            conteudoJava), Nivel.INTERMEDIARIO)
        formacaoDevOps.matricular(usuarioInfra)
        formacaoDevOps.matricular(usuarioArq)

        formacaoDevOps.buscaAluno()
        formacaoDevOps.buscaConteudo()
        println(formacaoDevOps)

}
