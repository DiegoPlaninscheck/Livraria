import java.util.ArrayList;

public class Editora {


    static ArrayList<Editora> listaEditoras = new ArrayList<>();

    private String nome, cnpj;

    @Override
    public String toString() {
        return "Editora{" +
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }

    public Editora(){}

    public Editora(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
