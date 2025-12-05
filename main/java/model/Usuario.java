package model;

public class Usuario {

    private int id;
    private String nome;
    private int idade;
    private String tipo;
    private String login;
    private String senha;
    private boolean ativo;
    private String[] interesses;

    public Usuario() {}

    public Usuario(int id, String nome, int idade, String tipo, String login, String senha, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public String[] getInteresses() { return interesses; }
    public void setInteresses(String[] interesses) { this.interesses = interesses; }
}
