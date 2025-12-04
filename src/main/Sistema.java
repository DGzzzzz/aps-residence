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

    static Scanner sc = new Scanner(System.in);
    static SistemaService service = SistemaService.getInstancia();

    public static void main(String[] args) {

        int opc;

        do {
            System.out.println("\n=== RESIDENCE ===");
            System.out.println("\n1. Cadastrar condomínio");
            System.out.println("10 Excluir condomínio");
            System.out.println("\n=====================");
            System.out.println("\n2. Cadastrar edifício");
            System.out.println("20. Excluir edifício");
            System.out.println("\n=====================");
            System.out.println("\n3. Cadastrar apartamento");
            System.out.println("30. Excluir apartamento");
            System.out.println("\n=====================");
            System.out.println("\n4. Cadastrar morador");
            System.out.println("40. Excluir morador");
            System.out.println("\n=====================");
            System.out.println("\n5. Listar tudo");
            System.out.println("=====================");
            System.out.println("6. Calcular renda média de um apartamento");
            System.out.println("=====================");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1 -> cadastrarCondominio();
                case 10 -> excluirCondominio();
                case 2 -> cadastrarEdificio();
                case 20 -> excluirEdificio();
                case 3 -> cadastrarApartamento();
                case 30 -> excluirApartamento();
                case 4 -> cadastrarMorador();
                case 40 -> excluirMorador();
                case 5 -> listarTudo();
                case 6 -> calcularRenda();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opc != 0);
    }

    // Cadastros
    private static void cadastrarCondominio() {
        System.out.println("\n=== Cadastro de Condomínio ===");
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Cidade: ");
        String cidade = sc.nextLine();
        System.out.print("Bairro: ");
        String bairro = sc.nextLine();

        Condominio c = new Condominio(id, nome, cidade, bairro);
        service.condominioDAO.salvar(c);

        System.out.println("Condomínio cadastrado com sucesso!");
    }

    private static void cadastrarEdificio() {
        System.out.println("\n=== Cadastro de Edifício ===");

        Condominio c = selecionarCondominio();
        if (c == null) return;

        System.out.print("Número do edifício: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Cores: ");
        String cores = sc.nextLine();
        System.out.print("Andares: ");
        int andares = sc.nextInt();

        Edificio e = new Edificio(numero, cores, andares);
        c.addEdificio(e);
        service.edificioDAO.salvar(e);

        System.out.println("Edifício cadastrado com sucesso!");
    }

    private static void cadastrarApartamento() {
        System.out.println("\n=== Cadastro de Apartamento ===");

        Edificio e = selecionarEdificio();
        if (e == null) return;

        System.out.print("Tipo (padrao/luxo): ");
        sc.nextLine();
        String tipo = sc.nextLine();
        System.out.print("Número: ");
        int num = sc.nextInt();
        System.out.print("Andar: ");
        int andar = sc.nextInt();
        sc.nextLine();

        String info1 = "", info2 = "";
        boolean ex1 = false, ex2 = false;

        if (tipo.equalsIgnoreCase("padrao")) {
            System.out.print("Tipo de armários: ");
            info1 = sc.nextLine();
            System.out.print("Tipo de piso: ");
            info2 = sc.nextLine();
        } else {
            System.out.print("Modelo de luminária: ");
            info1 = sc.nextLine();
            System.out.print("Possui geladeira embutida? (true/false): ");
            ex1 = sc.nextBoolean();
            System.out.print("Possui fogão embutido? (true/false): ");
            ex2 = sc.nextBoolean();
        }

        ApartamentoFactory ap = ApartamentosFactory.criarApartamento(
                tipo, num, andar, info1, info2, ex1, ex2
        );

        e.addApartamento(ap);
        service.apartamentoDAO.salvar(ap);

        System.out.println("Apartamento cadastrado com sucesso!");
    }

    private static void cadastrarMorador() {
        System.out.println("\n=== Cadastro de Morador ===");

        ApartamentoFactory ap = selecionarApartamento();
        if (ap == null) return;

        sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("RG: ");
        String rg = sc.nextLine();
        System.out.print("Sexo (M/F): ");
        char sexo = sc.next().charAt(0);
        System.out.print("Idade: ");
        int idade = sc.nextInt();

        Morador m = new Morador(nome, cpf, rg, sexo, idade);

        ap.addMorador(m);
        service.moradorDAO.salvar(m);

        System.out.println("Morador cadastrado com sucesso!");
    }

    //Excluir
    private static Condominio excluirCondominio() {
        List<Condominio> lista = service.condominioDAO.listar();

        if (lista.isEmpty()) {
            System.out.println("Nenhum condomínio cadastrado!");
            return null;
        }

        System.out.println("\n=== EXCLUIR CONDOMÍNIO ===");

        int op = -1;

        // Seleção com validação
        do {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + " - " + lista.get(i).getNome());
            }

            System.out.print("Escolha um condomínio para excluir (0 para cancelar): ");
            op = sc.nextInt();

            if (op == 0);

            if (op < 1 || op > lista.size()) {
                System.out.println("Opção inválida. Tente novamente.\n");
            }

        } while (op < 1 || op > lista.size());

        Condominio escolhido = lista.get(op - 1);

        // Confirmação
        System.out.print("Tem certeza que deseja excluir '" + escolhido.getNome() + "'? (s/n): ");
        sc.nextLine();
        String conf = sc.nextLine().trim().toLowerCase();

        if (!conf.equals("s")) {
            System.out.println("Exclusão cancelada.");
            return null;
        }

        // Excluir edifícios e apartamentos do condomínio também
        for (Edificio e : escolhido.getEdificios()) {
            for (ApartamentoFactory ap : e.getApartamentos()) {
                service.apartamentoDAO.excluir(ap);
            }
            service.edificioDAO.excluir(e);
        }

        // Remover condomínio do DAO
        service.condominioDAO.excluir(escolhido);

        System.out.println("Condomínio '" + escolhido.getNome() + "' excluído com sucesso!");
        return escolhido;
    }

    private static void excluirEdificio() {

        System.out.println("\n=== EXCLUIR EDIFÍCIO ===");

        // Usuário escolhe o condomínio primeiro
        Condominio c = selecionarCondominio();
        if (c == null) return;

        List<Edificio> lista = c.getEdificios();

        if (lista.isEmpty()) {
            System.out.println("Nenhum edifício cadastrado neste condomínio.");
            return;
        }

        int op = -1;

        // Escolher edifício com validação
        do {
            System.out.println("\nEdifícios do condomínio '" + c.getNome() + "': ");

            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + " - Edifício número " + lista.get(i).getNumero());
            }

            System.out.print("Escolha um edifício para excluir (0 para cancelar): ");
            op = sc.nextInt();

            if (op == 0) return;

            if (op < 1 || op > lista.size()) {
                System.out.println("Opção inválida! Tente novamente.\n");
            }

        } while (op < 1 || op > lista.size());

        Edificio escolhido = lista.get(op - 1);

        // Confirmação
        System.out.print("Tem certeza que deseja excluir o edifício "
                + escolhido.getNumero() + "? (s/n): ");
        sc.nextLine();
        String conf = sc.nextLine().trim().toLowerCase();

        if (!conf.equals("s")) {
            System.out.println("Exclusão cancelada.");
            return;
        }

        // Excluir apartamentos do edifício
        for (ApartamentoFactory ap : escolhido.getApartamentos()) {
            service.apartamentoDAO.excluir(ap);
        }

        // Remover edifício do condomínio
        c.getEdificios().remove(escolhido);

        // Remover do DAO
        service.edificioDAO.excluir(escolhido);

        System.out.println("Edifício excluído com sucesso!");
    }

    private static void excluirApartamento() {

        System.out.println("\n=== EXCLUIR APARTAMENTO ===");

        // Primeiro o usuário seleciona o edifício
        Edificio e = selecionarEdificio();
        if (e == null) return;

        List<ApartamentoFactory> lista = e.getApartamentos();

        if (lista.isEmpty()) {
            System.out.println("Nenhum apartamento cadastrado neste edifício.");
            return;
        }

        int op = -1;

        // Escolher apartamento com validação
        do {
            System.out.println("\nApartamentos do edifício " + e.getNumero() + ": ");

            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + " - Apto " + lista.get(i).getNumero());
            }

            System.out.print("Escolha um apartamento para excluir (0 para cancelar): ");
            op = sc.nextInt();

            if (op == 0) return;

            if (op < 1 || op > lista.size()) {
                System.out.println("Opção inválida! Tente novamente.\n");
            }

        } while (op < 1 || op > lista.size());

        ApartamentoFactory escolhido = lista.get(op - 1);

        // Confirmação
        System.out.print("Tem certeza que deseja excluir o apartamento "
                + escolhido.getNumero() + "? (s/n): ");
        sc.nextLine();
        String conf = sc.nextLine().trim().toLowerCase();

        if (!conf.equals("s")) {
            System.out.println("Exclusão cancelada.");
            return;
        }

        // Excluir moradores associados (boa prática)
        for (Morador m : escolhido.getMoradores()) {
            service.moradorDAO.excluir(m);
        }

        // Remover apartamento do edifício
        e.getApartamentos().remove(escolhido);

        // Remover do DAO
        service.apartamentoDAO.excluir(escolhido);

        System.out.println("Apartamento excluído com sucesso!");
    }

    private static void excluirMorador() {

        System.out.println("\n=== EXCLUIR MORADOR ===");

        // Primeiro selecionar o apartamento
        ApartamentoFactory ap = selecionarApartamento();
        if (ap == null) return;

        List<Morador> lista = ap.getMoradores();

        if (lista.isEmpty()) {
            System.out.println("Nenhum morador cadastrado neste apartamento!");
            return;
        }

        int op = -1;

        do {
            System.out.println("\nMoradores do apartamento " + ap.getNumero() + ": ");

            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + " - " + lista.get(i).getNome());
            }

            System.out.print("Escolha o morador a excluir (0 para cancelar): ");
            op = sc.nextInt();

            if (op == 0) return;

            if (op < 1 || op > lista.size()) {
                System.out.println("Opção inválida! Tente novamente.\n");
            }

        } while (op < 1 || op > lista.size());

        Morador escolhido = lista.get(op - 1);

        // Confirmação
        System.out.print("Tem certeza que deseja excluir " + escolhido.getNome() + "? (s/n): ");
        sc.nextLine();
        String conf = sc.nextLine().trim().toLowerCase();

        if (!conf.equals("s")) {
            System.out.println("Exclusão cancelada.");
            return;
        }

        // Remover morador do apartamento
        ap.getMoradores().remove(escolhido);

        // Remover do DAO
        service.moradorDAO.excluir(escolhido);

        System.out.println("Morador excluído com sucesso!");
    }

    //Selecionar itens
    private static Condominio selecionarCondominio() {
        List<Condominio> lista = service.condominioDAO.listar();
        if (lista.isEmpty()) {
            System.out.println("Nenhum condomínio cadastrado!");
            return null;
        }

        int op = -1;

        do {
            System.out.println("\nCondomínios: ");
            for (int i = 0; i < lista.size(); i++)
                System.out.println((i + 1) + " - " + lista.get(i).getNome());

            System.out.print("Escolha (ou 0 para cancelar): ");
            op = sc.nextInt();

            if (op == 0) return null;

            if (op < 1 || op > lista.size()) {
                System.out.println("Número inválido! Tente novamente.\n");
            }

        } while (op < 1 || op > lista.size());

        return lista.get(op - 1);
    }

    private static Edificio selecionarEdificio() {
        Condominio c = selecionarCondominio();
        if (c == null) return null;

        if (c.getEdificios().isEmpty()) {
            System.out.println("Nenhum edifício neste condomínio!");
            return null;
        }

        List<Edificio> lista = c.getEdificios();

        int op = -1;

        do {
            System.out.println("\nEdifícios: ");
            for (int i = 0; i < lista.size(); i++)
                System.out.println((i + 1) + " - " + lista.get(i).getNumero());

            System.out.print("Escolha (ou 0 para cancelar): ");
            op = sc.nextInt();

            if (op == 0) return null;

            if (op < 1 || op > lista.size()) {
                System.out.println("Número inválido! Tente novamente.\n");
            }

        } while (op < 1 || op > lista.size());

        return lista.get(op - 1);
    }

    private static ApartamentoFactory selecionarApartamento() {
        Edificio e = selecionarEdificio();
        if (e == null) return null;

        List<ApartamentoFactory> lista = e.getApartamentos();

        if (lista.isEmpty()) {
            System.out.println("Nenhum apartamento neste edifício!");
            return null;
        }

        int op = -1;

        do {
            System.out.println("\nApartamentos:");
            for (int i = 0; i < lista.size(); i++)
                System.out.println((i + 1) + " - Apto " + lista.get(i).getNumero());

            System.out.print("Escolha (ou 0 para cancelar): ");
            op = sc.nextInt();

            if (op == 0) return null;

            if (op < 1 || op > lista.size()) {
                System.out.println("Número inválido! Tente novamente.\n");
            }

        } while (op < 1 || op > lista.size());

        return lista.get(op - 1);
    }

    //Listar
    private static void listarTudo() {
        System.out.println("\n=== LISTAGEM COMPLETA ===");

        for (Condominio cond : service.condominioDAO.listar()) {
            System.out.println(cond);

            for (Edificio e : cond.getEdificios()) {
                System.out.println("  " + e);

                for (ApartamentoFactory ap : e.getApartamentos()) {
                    System.out.println("    " + ap);

                    for (Morador m : ap.getMoradores()) {
                        System.out.println("      - " + m);
                    }
                }
            }
        }
    }

    //calcular renda
    private static void calcularRenda() {
        ApartamentoFactory ap = selecionarApartamento();
        if (ap == null) return;

        ap.setStrategy(new RendaSimplesStrategy());
        List<Double> rendas = new ArrayList<>();

        System.out.println("Quantos valores deseja informar?");
        int qt = sc.nextInt();

        for (int i = 0; i < qt; i++) {
            System.out.print("Renda " + (i + 1) + ": ");
            rendas.add(sc.nextDouble());
        }

        double media = ap.calcularRendaMedia(rendas);
        System.out.println("Renda média: " + media);
    }
}
