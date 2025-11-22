package service;

import dao.ApartamentoDAO;
import dao.CondominioDAO;
import dao.EdificioDAO;
import dao.MoradorDAO;

public class SistemaService {
    private static SistemaService instancia;

    public final CondominioDAO condominioDAO = new CondominioDAO();
    public final EdificioDAO edificioDAO = new EdificioDAO();
    public final ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
    public final MoradorDAO moradorDAO = new MoradorDAO();

    private SistemaService() {}  // construtor privado

    public static SistemaService getInstancia() {
        if (instancia == null)
            instancia = new SistemaService();
        return instancia;
    }
}
