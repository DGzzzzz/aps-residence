package main;

import condominioFactory.ApartamentosFactory;
import model.ApartamentoFactory;
import model.Condominio;
import model.Edificio;
import model.Morador;
import service.SistemaService;
import strategy.RendaSimplesStrategy;

import java.util.*;

public class Sistema {

    public static void main(String[] args) {

        SistemaService service = SistemaService.getInstancia();

        // Criando dados usando Factory
        ApartamentoFactory ap1 = ApartamentosFactory.criarApartamento(                "padrao", 101, 1,
                "Armários MDF", "Piso Laminado",
                false, false
        );

        ApartamentoFactory ap2 = ApartamentosFactory.criarApartamento(
                "luxo", 201, 2,
                "Luminária Premium", null,
                true, true
        );

        // Moradores
        Morador m1 = new Morador("João Silva", "1234", "1111", 'M', 30);
        Morador m2 = new Morador("Maria Souza", "5678", "2222", 'F', 28);

        ap1.addMorador(m1);
        ap1.addMorador(m2);

        // Criando edifício
        Edificio ed1 = new Edificio(1, "Branco e Azul", 10);
        ed1.addApartamento(ap1);
        ed1.addApartamento(ap2);

        // Criando condomínio
        Condominio c1 = new Condominio(1, "Cond. Primavera", "São Paulo", "Vila Mariana");
        c1.addEdificio(ed1);

        // Salvando no DAO via Singleton
        service.condominioDAO.salvar(c1);
        service.edificioDAO.salvar(ed1);
        service.apartamentoDAO.salvar(ap1);
        service.apartamentoDAO.salvar(ap2);
        service.moradorDAO.salvar(m1);
        service.moradorDAO.salvar(m2);

        // Calcular rendas
        ap1.setStrategy(new RendaSimplesStrategy());
        List<Double> rendas = new ArrayList<>();
        rendas.add(3800.00);
        rendas.add(1800.00);
        rendas.add(2800.00);
        double media = ap1.calcularRendaMedia(rendas);

        // Impressão
        System.out.println("=== dados carregados ===");
        for (Condominio cond : service.condominioDAO.listar()) {
            System.out.println(cond);

            for (Edificio e : cond.getEdificios()) {
                System.out.println("  " + e);

                for (ApartamentoFactory ap : e.getApartamentos()) {
                    System.out.println("    " + ap);

                    for (Morador mor : ap.getMoradores()) {
                        System.out.println("      - " + mor);
                    }
                }
            }
        }
    }
}