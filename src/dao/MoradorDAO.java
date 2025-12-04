package dao;

import model.Morador;

import java.util.ArrayList;
import java.util.List;

public class MoradorDAO {
    private List<Morador> lista = new ArrayList<>();

    public void salvar(Morador m) { lista.add(m); }
    public void excluir(Morador m) { lista.remove(m); }
    public List<Morador> listar() { return lista; }
}
