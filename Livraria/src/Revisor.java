public class Revisor extends Pessoa{

    // listarAtividades() - listar os livros que devem ser revisados( status: Em revisao)
    // listarLivros (Status: Aguardando revisao)
    //editarLivros (Reprovado, Aprovado, Em revisão, Aguardando Edição)

    private static void listarAtividades(){}
    private static void listarLivros(){}
    private static void editarLivros(){}


    @Override
    public String toString() {
        return super.toString() + "\nRevisor{}";
    }

    public Revisor() {
    }

    public Revisor(String nome, String cpf, String sobrenome, String email, String genero, String senha) {
        super(nome, cpf, sobrenome, email, genero, senha);
    }
}
