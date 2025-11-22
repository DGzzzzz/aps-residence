package model;

import strategy.RendaSimplesStrategy;
import strategy.RendaStrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class Apartamento {
    protected int numero;
    protected int andar;
//    double rendaMedia;
    protected List<Morador> moradores = new ArrayList<>();

    public Apartamento(int andar, int numero) {
        this.andar = andar;
        this.numero = numero;
    }

    public void addMorador(Morador morador){
        moradores.add(morador);
    }

    protected RendaStrategy strategy = new RendaSimplesStrategy();

    public void setStrategy(RendaStrategy strategy) {
        this.strategy = strategy;
    }

    public double calcularRendaMedia(List<Double> rendas) {
        return strategy.calcular(rendas);
    }

    public int getNumero() {
        return numero;
    }

    public int getAndar() {
        return andar;
    }

    public List<Morador> getMoradores() {
        return moradores;
    }

    public abstract String detalhesEspecificos();

    @Override
    public String toString(){
        return "Ap " + numero + " (andar " + andar + ") - " + detalhesEspecificos();
    }
}
