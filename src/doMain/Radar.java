package doMain;

import javax.swing.*;
import java.util.HashMap;

public class Radar extends JPanel {
    private HashMap<Integer,Airplane> lista_avioes = new HashMap<Integer, Airplane>();

    public void remove(Integer id) {
        lista_avioes.remove(id);
    }

    public void setLista_avioes(Integer id, Airplane airPlane) {
        lista_avioes.put(id, airPlane);
    }

    public HashMap<Integer, Airplane> getLista_avioes() {
        return lista_avioes;
    }

}
