package model;

public class Recurso {

    private int id;
    private String titulo;
    private String autor;
    private String categoria;
    private int usuarioId;
    private String dataCadastro;

    public Recurso() {}

    public Recurso(String titulo, String autor, String categoria, int usuarioId) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.usuarioId = usuarioId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public String getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(String dataCadastro) { this.dataCadastro = dataCadastro; }
}
