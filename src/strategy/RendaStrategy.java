package strategy;

import model.Condominio;

import java.util.List;

public interface RendaStrategy {
    double calcular(List<Double> rendas);
}
