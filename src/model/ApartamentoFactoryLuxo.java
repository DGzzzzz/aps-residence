package model;

public class ApartamentoFactoryLuxo extends ApartamentoFactory {
    private String modeloLuminarias;
    private boolean possuiGeladeiraEmbutida;
    private boolean possuiFogaoEmbutido;

    public ApartamentoFactoryLuxo(int andar, int numero, String modeloLuminarias, boolean possuiGeladeiraEmbutida, boolean possuiFogaoEmbutido) {
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
