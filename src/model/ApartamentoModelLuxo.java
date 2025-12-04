package model;

public class ApartamentoModelLuxo extends ApartamentoModel {
    private String modeloLuminarias;
    private boolean possuiGeladeiraEmbutida;
    private boolean possuiFogaoEmbutido;

    public ApartamentoModelLuxo(int andar, int numero, String modeloLuminarias, boolean possuiGeladeiraEmbutida, boolean possuiFogaoEmbutido) {
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
