package dao;

import model.Edificio;

import java.util.ArrayList;
import java.util.List;

public class EdificioDAO {

    private List<Edificio> lista = new ArrayList<>();

    public void salvar(Edificio e) { lista.add(e); }
    public List<Edificio> listar() { return lista; }
}
