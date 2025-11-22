package model;

public class ApartamentoPadrao extends Apartamento {
    private String tipoArmarios;
    private String tipoPisos;

    public ApartamentoPadrao(int andar, int numero, String tipoArmarios, String tipoPisos) {
        super(andar, numero);
        this.tipoArmarios = tipoArmarios;
        this.tipoPisos = tipoPisos;
    }

    @Override
    public String detalhesEspecificos() {
        return "Padrão | Armários: " + tipoArmarios + " | Piso: " + tipoPisos;
    }
}
