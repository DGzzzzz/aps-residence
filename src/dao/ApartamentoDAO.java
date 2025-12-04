package dao;

import model.ApartamentoFactory;

import java.util.ArrayList;
import java.util.List;

public class ApartamentoDAO {
    private List<ApartamentoFactory> lista = new ArrayList<>();

    public void salvar(ApartamentoFactory a) { lista.add(a); }
    public void excluir(ApartamentoFactory a) { lista.remove(a); }
    public List<ApartamentoFactory> listar() { return lista; }
}
