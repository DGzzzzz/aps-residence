package condominioFactory;

import model.ApartamentoFactory;
import model.ApartamentoFactoryLuxo;
import model.ApartamentoFactoryPadrao;

public class ApartamentosFactory {
    public static ApartamentoFactory criarApartamento(
            String tipo,
            int numero,
            int andar,
            String info1,
            String info2,
            boolean extra1,
            boolean extra2
            ) {
        return switch (tipo.toLowerCase()) {
            case "padrao" -> new ApartamentoFactoryPadrao(numero, andar, info1, info2);
            case "luxo" -> new ApartamentoFactoryLuxo(numero, andar, info1, extra1, extra2);
            default -> throw new IllegalArgumentException("Tipo de apartamento inválido");
        };
    }
}
