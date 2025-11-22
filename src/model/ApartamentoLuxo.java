package model;

public class ApartamentoLuxo extends Apartamento {
    private String modeloLuminarias;
    private boolean possuiGeladeiraEmbutida;
    private boolean possuiFogaoEmbutido;

    public ApartamentoLuxo(int andar, int numero, String modeloLuminarias, boolean possuiGeladeiraEmbutida, boolean possuiFogaoEmbutido) {
        super(andar, numero);
        this.modeloLuminarias = modeloLuminarias;
        this.possuiGeladeiraEmbutida = possuiGeladeiraEmbutida;
        this.possuiFogaoEmbutido = possuiFogaoEmbutido;
    }

    @Override
    public String detalhesEspecificos() {
        return "Luxo | Luminárias: " + modeloLuminarias +
                " | Geladeira: " + (possuiGeladeiraEmbutida ? "Sim" : "Não") +
                " | Fogão: " + (possuiFogaoEmbutido ? "Sim" : "Não");
    }
}
