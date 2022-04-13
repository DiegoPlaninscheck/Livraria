import java.util.ListResourceBundle;
import java.util.Scanner;

public class Main {

    //1- Aguardando Revisao, 2- Em Revisao, 3- Publicar, 4- Aprovado, 5- Reprovar, 6- Aguardando Edicao;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        teste();
        login();
    }

    private static void teste() {
        Pessoa autor = new Autor();
        autor.setNome("Diego");
        autor.setCpf("123");
        autor.setSobrenome("Plans");
        autor.setEmail("diego@gmail.com");
        autor.setGenero("M");
        autor.setSenha("123");
        Pessoa.listaPessoas.add(autor);

        Pessoa diretor = new Diretor();
        diretor.setNome("João");
        diretor.setCpf("321");
        diretor.setSobrenome("Silva");
        diretor.setEmail("joao@gmail.com");
        diretor.setGenero("M");
        diretor.setSenha("321");
        Pessoa.listaPessoas.add(diretor);

        Pessoa revisor = new Revisor();
        revisor.setNome("Thiago");
        revisor.setCpf("456");
        revisor.setSobrenome("Marins");
        revisor.setEmail("thiago@gmail.com");
        revisor.setGenero("M");
        revisor.setSenha("456");
        Pessoa.listaPessoas.add(revisor);

        Livro livro = new Livro();
        livro.setTitulo("livro 1");
        livro.setStatus(1);
        livro.setQtdPagina(150);
        livro.setIsbn(1);
        livro.setAutor((Autor) autor);
        Livro.listaLivros.add(livro);

        Livro livro2 = new Livro();
        livro2.setTitulo("livro 2");
        livro2.setStatus(2);
        livro2.setQtdPagina(250);
        livro2.setIsbn(2);
        livro2.setAutor((Autor) autor);
        Livro.listaLivros.add(livro2);

        Editora editora = new Editora();
        editora.setNome("Editora imperial");
        editora.setCnpj("1");
        Editora.listaEditoras.add(editora);
    }

    private static void login() {
        int indice;
        String nome, senha, cpf;
        System.out.println("1- Logar-se" + "\n2- Cadastrar-se" + "\n3- Fechar Programa");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("CPF: ");
                cpf = sc.next();
                System.out.println("Nome: ");
                nome = sc.next();
                System.out.println("Senha: ");
                senha = sc.next();
                indice = verifica(nome, senha, cpf);
                if (indice != -1) {
                    menu(indice);
                }
                login();
                break;
            case 2:
                String sobrenome, email, genero;
                System.out.println("Nome: ");
                nome = sc.next();
                System.out.println("CPF: ");
                cpf = sc.next();
                System.out.println("Sobrenome: ");
                sobrenome = sc.next();
                System.out.println("Email: ");
                email = sc.next();
                System.out.println("Genero: ");
                genero = sc.next();
                System.out.println("Senha: ");
                senha = sc.next();
                Pessoa autor = new Autor(nome, cpf, sobrenome, email, genero, senha);
                indice = verifica(nome, senha, cpf);
                if (indice == -1) {
                    Pessoa.listaPessoas.add(autor);
                }
                login();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Anta e de 1 a 3");
                login();
        }
    }

    private static void menu(int indice) {
        int opcao;
        int tipo = tipo(indice);
        switch (tipo) {
            case 1:
                System.out.println("1- Cadastrar revisor" + "\n2- Listar atividades" + "\n3- Editar livros" + "\n4- Listar livros" + "\n5- Deslogar");
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
                        cadastrar(indice);
                        break;
                    case 2:
                        listarAtividades(indice);
                        break;
                    case 3:
                        editarLivros(indice);
                        break;
                    case 4:
                        listarLivros(indice);
                        break;
                    case 5:
                        login();
                        break;
                }
                break;
            case 2:
                System.out.println("\n1- Listar atividades" + "\n2- Editar livros" + "\n3- Listar livros" + "\n4- Deslogar");
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
                        listarAtividades(indice);
                        break;
                    case 2:
                        editarLivros(indice);
                        break;
                    case 3:
                        listarLivros(indice);
                        break;
                    case 4:
                        login();
                        break;
                }
                break;
            case 3:
                System.out.println("\n1- Cadastrar livro" + "\n2- Listar livros" + "\n3- Editar livros" + "\n4- Deslogar");
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
                        cadastrar(indice);
                        break;
                    case 2:
                        listarLivros(indice);
                        break;
                    case 3:
                        editarLivros(indice);
                        break;
                    case 4:
                        login();
                        break;
                }
                break;
        }
        menu(indice);
    }

    private static void editarLivros(int indice) {
        int tipo = tipo(indice);
        switch (tipo) {
            case 1:
                for (int j = 0; j < Livro.listaLivros.size(); j++) {
                    if (Livro.listaLivros.get(j).getStatus() == 4) {
                        System.out.println(Livro.listaLivros.get(j).toString());
                    }
                }
                System.out.println("Digite o ISBN do livro: ");
                int isbn = sc.nextInt();
                int indiceLivro = verificaLivro(isbn);
                System.out.println("O que você deseja fazer? " +
                        "\n1 - Publicar o livro;" +
                        "\n2 - Reprovar o livro;" +
                        "\n3 - Aguardando revisão.");
                int opcao = sc.nextInt();
                for (int i = 0; i < Livro.listaLivros.size(); i++) {
                    if (Livro.listaLivros.get(i).getStatus() == 4) {
                        switch (opcao) {
                            case 1:
                                System.out.println("Livro publicado com sucesso!");
                                Livro.listaLivros.get(indiceLivro).setStatus(3);
                                break;
                            case 2:
                                System.out.println("Livro reprovado com sucesso!");
                                Livro.listaLivros.get(indiceLivro).setStatus(5);
                                break;
                            case 3:
                                System.out.println("Livro aguardando revisão com sucesso!");
                                Livro.listaLivros.get(indiceLivro).setStatus(1);
                                break;
                        }
                    }
                }
                break;
            case 2:
                for (int j = 0; j < Livro.listaLivros.size(); j++) {
                    if (Livro.listaLivros.get(j).getStatus() == 1 || Livro.listaLivros.get(j).getStatus() == 2) {
                        System.out.println(Livro.listaLivros.get(j).toString(0));
                    }
                }
                System.out.println("Digite o ISBN do livro: ");
                isbn = sc.nextInt();
                indiceLivro = verificaLivro(isbn);
                int statusDoLivro = Livro.listaLivros.get(indiceLivro).getStatus();
                if (statusDoLivro == 1){
                    System.out.println("O que você deseja fazer? " +
                            "\n1 - Colocar o livro em revisão.");
                    opcao = sc.nextInt();
                    switch (opcao){
                        case 1:
                            System.out.println("Livro em revisão com sucesso!");
                            Livro.listaLivros.get(indiceLivro).setStatus(2);
                            System.out.println("Em qual pagina parou? ");
                            int pagina = sc.nextInt();
                            double media = ((pagina * 100)/Livro.listaLivros.get(indiceLivro).getQtdPagina());
                            Livro.listaLivros.get(indiceLivro).setPorcentagem(media);
                            break;
                    }
                } else if(statusDoLivro == 2){
                    System.out.println("O que você deseja fazer? " +
                            "\n1 - Reprovar o livro;" +
                            "\n2 - Aprovar o livro;" +
                            "\n3 - Aguardando edição.");
                    opcao = sc.nextInt();
                    switch (opcao) {
                        case 1:
                            System.out.println("Livro reprovado com sucesso!");
                            Livro.listaLivros.get(indiceLivro).setStatus(5);
                            break;
                        case 2:
                            System.out.println("Livro aprovado com sucesso!");
                            Livro.listaLivros.get(indiceLivro).setStatus(4);
                            break;
                        case 3:
                            System.out.println("Livro aguardando edição com sucesso!");
                            Livro.listaLivros.get(indiceLivro).setStatus(6);
                            break;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < Livro.listaLivros.size(); i++){
                    if (Livro.listaLivros.get(i).getStatus() == 6){
                        System.out.println(Livro.listaLivros.get(i).toString());
                    }
                }
                System.out.println("Digite o ISBN do livro que desejas editar: ");
                isbn = sc.nextInt();
                indiceLivro = verificaLivro(isbn);
                if (indiceLivro != -1){
                    System.out.println("Título: ");
                    Livro.listaLivros.get(indiceLivro).setTitulo(sc.next());
                    System.out.println("Quantidade de páginas: ");
                    Livro.listaLivros.get(indiceLivro).setQtdPagina(sc.nextInt());
                    System.out.println("ISBN: ");
                    Livro.listaLivros.get(indiceLivro).setIsbn(sc.nextInt());
                    System.out.println("Livro editado com sucesso!");
                }
        }
        menu(indice);
    }

    private static int verificaLivro(int isbn) {
        for(int i = 0; i < Livro.listaLivros.size(); i++){
            if (Livro.listaLivros.get(i).getIsbn() == isbn){
                return i;
            }
        }
        return -1;
    }

    private static void listarAtividades(int indice) {
        int tipo = tipo(indice);
        switch (tipo){
            case 1:
                for(int i = 0; i < Livro.listaLivros.size(); i++){
                    if(Livro.listaLivros.get(i).getStatus() == 4){
                        System.out.println(Livro.listaLivros.get(i).toString());
                    }
                }
                break;
            case 2:
                for(int i = 0; i < Livro.listaLivros.size(); i++){
                    if(Livro.listaLivros.get(i).getStatus() == 2){
                        System.out.println(Livro.listaLivros.get(i).toString(0));
                    }
                }
                break;
        }
    }

    private static void listarLivros(int indice) {
        int tipo = tipo(indice);
        switch (tipo) {
            case 1:
                for (int i = 0; i < Livro.listaLivros.size(); i++){
                    System.out.println(Livro.listaLivros.get(i).toString());
                }
                break;
            case 2:
                for(int i = 0; i < Livro.listaLivros.size(); i++){
                    if(Livro.listaLivros.get(i).getStatus() == 1){
                        System.out.println(Livro.listaLivros.get(i).toString(0));
                    }
                }
                break;
            case 3:
                for (int i = 0; i < Livro.listaLivros.size(); i++) {
                    if (Livro.listaLivros.get(i).getAutor() == Pessoa.listaPessoas.get(indice)) {
                        System.out.println(Livro.listaLivros.get(i).toString());
                    }
                }
                break;
        }
    }

    private static void cadastrar(int indice) {
        String nome, cpf, sobrenome, email, genero, senha, titulo;
        int status, qtdPagina, isbn;
        int tipo = tipo(indice);
        switch (tipo) {
            case 1:
                System.out.println("Nome: ");
                nome = sc.next();
                System.out.println("CPF: ");
                cpf = sc.next();
                System.out.println("Sobrenome: ");
                sobrenome = sc.next();
                System.out.println("Email: ");
                email = sc.next();
                System.out.println("Genero: ");
                genero = sc.next();
                System.out.println("Senha: ");
                senha = sc.next();
                Pessoa revisor = new Revisor(nome, cpf, sobrenome, email, genero, senha);
                Pessoa.listaPessoas.add(revisor);
                break;
            case 3:
                System.out.println("Titulo: ");
                titulo = sc.next();
                System.out.println("Status: " + " 1- Aguardando revisao");
                status = sc.nextInt();
                System.out.println("Quantidade de paginas: ");
                qtdPagina = sc.nextInt();
                System.out.println("ISBN: ");
                isbn = sc.nextInt();
                Livro livro = new Livro(titulo, status, qtdPagina, isbn, (Autor) Pessoa.listaPessoas.get(indice));
                Livro.listaLivros.add(livro);
            break;
        }
    }

    private static int tipo(int indice) {
        if (Pessoa.listaPessoas.get(indice) instanceof Diretor) {
            return 1;
        } else if (Pessoa.listaPessoas.get(indice) instanceof Revisor) {
            return 2;
        } else if (Pessoa.listaPessoas.get(indice) instanceof Autor) {
            return 3;
        }
        return -1;
    }

    private static int verifica(String nome, String senha, String cpf) {
        for (int i = 0; i < Pessoa.listaPessoas.size(); i++) {
            if (Pessoa.listaPessoas.get(i).getNome().equals(nome) && Pessoa.listaPessoas.get(i).getSenha().equals(senha)
                    && Pessoa.listaPessoas.get(i).getCpf().equals(cpf)) {
                return i;
            }
        }
        return -1;
    }
}