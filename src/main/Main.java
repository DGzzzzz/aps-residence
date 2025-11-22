package main;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Lista principal
        List<Condominio> condominios = new ArrayList<>();

        //Criando os objetos

        //model.Condominio
        Condominio condominio1 = new Condominio(1, "Rsidencial Verão", "Porto Alegre", "Vila Nova");

        //model.Edificio
        Edificio edificio1 = new Edificio(1, "Branco e azul", 10);
        Edificio edificio2 = new Edificio(2, "Branco e verde", 15);

        //model.Apartamento Padrao
        Apartamento apPadrao1 = new ApartamentoPadrao(10, 1, "Armário MDF", "Piso Laminado");
        Apartamento apPadrao2 = new ApartamentoPadrao(15, 1, "Armário Madeira", "Piso Frio");

        //model.Apartamento de luxo
        Apartamento apLuxo1 = new ApartamentoLuxo(12, 2, "Luminária LED P", true, true);

        //Moradores
        Morador morador1 = new Morador("Jonas", "12345678900", "11223344", 'M', 30);
        Morador morador2 = new Morador("Luis", "98765432100", "55667788", 'M', 28);
        Morador morador3 = new Morador("Ana", "55566677788", "99887766", 'F', 40);

        //Adicionar moradores nos apartamentos
        apPadrao1.addMorador(morador1);
        apPadrao2.addMorador(morador2);
        apLuxo1.addMorador(morador3);

        //Adicionar apartamentos nos edificios
        edificio1.addApartamento(apPadrao1);
        edificio1.addApartamento(apPadrao2);
        edificio2.addApartamento(apLuxo1);

        //Adicionar edificios no condominio
        condominio1.addEdificio(edificio1);
        condominio1.addEdificio(edificio2);

        //Adicionar condominio na lista
        condominios.add(condominio1);

        //Exibir dados no terminal
        for (Condominio condominio : condominios) {
            System.out.println(condominio.toString());

            for (Edificio edificio : condominio.getEdificios()){
                System.out.println(edificio.toString());

                for (Apartamento apartamento : edificio.getApartamentos()){
                    System.out.println(apartamento.toString());

                    for (Morador morador : apartamento.getMoradores()){
                        System.out.println(morador.toString());
                    }
                }
            }
        }
    }
}
