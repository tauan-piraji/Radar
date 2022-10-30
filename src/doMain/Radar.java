package doMain;

import java.util.HashMap;

public class Radar {
    private Airplane airplane;

    private HashMap<Integer,Airplane> lista_avioes = new HashMap<Integer, Airplane>();

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public HashMap<Integer, Airplane> getLista_avioes() {
        return lista_avioes;
    }

    public void setLista_avioes(HashMap<Integer, Airplane> lista_avioes) {
        this.lista_avioes = lista_avioes;
    }

    public void setLista_avioes(Integer id, Airplane airPlane) {
        lista_avioes.put(id, airPlane);
    }
}
