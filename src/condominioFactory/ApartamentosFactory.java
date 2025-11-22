package condominioFactory;

import model.Apartamento;
import model.ApartamentoLuxo;
import model.ApartamentoPadrao;

public class ApartamentosFactory {
    public static Apartamento criarApartamento(
            String tipo,
            int numero,
            int andar,
            String info1,
            String info2,
            boolean extra1,
            boolean extra2
            ) {
        return switch (tipo.toLowerCase()) {
            case "padrao" -> new ApartamentoPadrao(numero, andar, info1, info2);
            case "luxo" -> new ApartamentoLuxo(numero, andar, info1, extra1, extra2);
            default -> throw new IllegalArgumentException("Tipo de apartamento inválido");
        };
    }
}
