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

    @Override
    public String toString() {
        return "Condomínio: " + nome + " (" + cidade + ", " + bairro + ")";
    }
}
