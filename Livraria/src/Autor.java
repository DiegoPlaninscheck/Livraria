public class Autor extends Pessoa{

//    cadastrarLivro()
//    listarLivros()
//    editarLivros() (status: Aguardando edicao)


    private static void cadastrarLivro(){}
    private static void listarLivros(){}
    private static void editarLivros(){}

    @Override
    public String toString() {
        return super.toString() + "\nAutor{}";
    }

    public Autor() {
    }

    public Autor(String nome, String cpf, String sobrenome, String email, String genero, String senha) {
        super(nome, cpf, sobrenome, email, genero, senha);
    }
}
