package model;

public class ApartamentoFactoryPadrao extends ApartamentoFactory {
    private String tipoArmarios;
    private String tipoPisos;

    public ApartamentoFactoryPadrao(int andar, int numero, String tipoArmarios, String tipoPisos) {
        super(andar, numero);
        this.tipoArmarios = tipoArmarios;
        this.tipoPisos = tipoPisos;
    }

    @Override
    public String detalhesEspecificos() {
        return "Padrão | Armários: " + tipoArmarios + " | Piso: " + tipoPisos;
    }
}
