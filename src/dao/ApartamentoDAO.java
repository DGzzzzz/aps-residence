package dao;

import model.ApartamentoModel;

import java.util.ArrayList;
import java.util.List;

public class ApartamentoDAO {
    private List<ApartamentoModel> lista = new ArrayList<>();

    public void salvar(ApartamentoModel a) { lista.add(a); }
    public void excluir(ApartamentoModel a) { lista.remove(a); }
    public List<ApartamentoModel> listar() { return lista; }
}
