public class Diretor extends Pessoa{

    //editarLivros(Publicar, Reprovar, Aguardando Revisao)
    //listarAtividades(aprovados)
    //cadastrarRevisor
    //listarLivros(todos)

    private static void editarLivros(){}
    private static void listarAtividades(){}
    private static void cadastrarRevisor(){}
    private static void listarLivros(){}

    @Override
    public String toString() {
        return super.toString() + "\nDiretor{}";
    }

    public Diretor() {
    }

    public Diretor(String nome, String cpf, String sobrenome, String email, String genero, String senha) {
        super(nome, cpf, sobrenome, email, genero, senha);
    }
}
