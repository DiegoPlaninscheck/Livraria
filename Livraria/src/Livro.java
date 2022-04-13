import java.util.ArrayList;

public class Livro {

    static ArrayList<Livro> listaLivros = new ArrayList<>();

    private String titulo;
    private int status, qtdPagina, isbn;
    private Autor autor;
    private Editora editora;
    private double porcentagem;

// Autor
// Editora


    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", status=" + status +
                ", qtdPagina=" + qtdPagina +
                ", isbn=" + isbn +
                ", autor=" + autor +
                ", editora=" + editora +
                '}';
    }

    public String toString(int i) {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", status=" + status +
                ", qtdPagina=" + qtdPagina +
                ", isbn=" + isbn +
                ", autor=" + autor +
                ", editora=" + editora +
                ", porcentagem=" + porcentagem +
                '}';
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public static ArrayList<Livro> getListaLivros() {
        return listaLivros;
    }

    public static void setListaLivros(ArrayList<Livro> listaLivros) {
        Livro.listaLivros = listaLivros;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Livro(){}

    public Livro(String titulo, int status, int qtdPagina, int isbn, Autor autor) {
        this.titulo = titulo;
        this.status = status;
        this.qtdPagina = qtdPagina;
        this.isbn = isbn;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQtdPagina() {
        return qtdPagina;
    }

    public void setQtdPagina(int qtdPagina) {
        this.qtdPagina = qtdPagina;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
}
