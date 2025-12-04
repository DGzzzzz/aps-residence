package model;

import java.util.ArrayList;
import java.util.List;

public class Condominio {
    private int id;
    private String nome;
    private String cidade;
    private String bairro;
    private List<Edificio> edificios = new ArrayList<>();

    public Condominio(int id, String nome, String cidade, String bairro) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.bairro = bairro;
    }

    public void addEdificio(Edificio edificio) {
        edificios.add(edificio);
    }

    public List<Edificio> getEdificios() {
        return edificios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Condomínio: " + nome + " (" + cidade + ", " + bairro + ")";
    }
}
