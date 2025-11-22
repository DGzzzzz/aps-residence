package dao;

import model.Apartamento;

import java.util.ArrayList;
import java.util.List;

public class ApartamentoDAO {
    private List<Apartamento> lista = new ArrayList<>();

    public void salvar(Apartamento a) { lista.add(a); }
    public List<Apartamento> listar() { return lista; }
}
