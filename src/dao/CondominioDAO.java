package dao;

import model.Condominio;

import java.util.ArrayList;
import java.util.List;

public class CondominioDAO {
    private List<Condominio> lista = new ArrayList<>();

    public void salvar(Condominio c) { lista.add(c); }
    public void excluir(Condominio c) { lista.remove(c); }
    public List<Condominio> listar() { return lista; }
}
