package model;

import java.util.ArrayList;
import java.util.List;

public class Edificio {
    private int numero;
    private String coresPintura;
    private int qtdAndares;
    private List<ApartamentoModel> apartamentoFactories = new ArrayList<>();

    public Edificio(int numero, String coresPintura, int qtdAndares) {
        this.numero = numero;
        this.coresPintura = coresPintura;
        this.qtdAndares = qtdAndares;
    }

    public void addApartamento(ApartamentoModel apartamentoModel){
        apartamentoFactories.add(apartamentoModel);
    }

    public List<ApartamentoModel> getApartamentos(){
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
