package condominioFactory;

import model.ApartamentoModel;
import model.ApartamentoModelLuxo;
import model.ApartamentoModelPadrao;

public class ApartamentosFactory {
    public static ApartamentoModel criarApartamento(
            String tipo,
            int numero,
            int andar,
            String info1,
            String info2,
            boolean extra1,
            boolean extra2
            ) {
        return switch (tipo.toLowerCase()) {
            case "padrao" -> new ApartamentoModelPadrao(numero, andar, info1, info2);
            case "luxo" -> new ApartamentoModelLuxo(numero, andar, info1, extra1, extra2);
            default -> throw new IllegalArgumentException("Tipo de apartamento inválido");
        };
    }
}
