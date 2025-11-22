package strategy;

import java.util.List;

public class RendaSimplesStrategy implements RendaStrategy {
    @Override
    public double calcular(List<Double> rendas) {
        if (rendas.isEmpty()) return 0;

        double soma = 0;
        for (double r : rendas) soma += r;
        return soma / rendas.size();
    }
}
