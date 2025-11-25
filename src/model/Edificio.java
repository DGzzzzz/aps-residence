package model;

import java.util.ArrayList;
import java.util.List;

public class Edificio {
    private int numero;
    private String coresPintura;
    private int qtdAndares;
    private List<ApartamentoFactory> apartamentoFactories = new ArrayList<>();

    public Edificio(int numero, String coresPintura, int qtdAndares) {
        this.numero = numero;
        this.coresPintura = coresPintura;
        this.qtdAndares = qtdAndares;
    }

    public void addApartamento(ApartamentoFactory apartamentoFactory){
        apartamentoFactories.add(apartamentoFactory);
    }

    public List<ApartamentoFactory> getApartamentos(){
        return apartamentoFactories;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "-------------" + "\nEdifício " + numero + " | Andares: " + qtdAndares +
                " | Cores: " + coresPintura;
    }
}
