package doMain;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Radar extends JPanel {
    private HashMap<Integer, AirPlane> lista_avioes = new HashMap<Integer, AirPlane>();
    private List<AirPlane> airPlaneList = new ArrayList<>();

    public void remove(Integer id) {
        lista_avioes.remove(id);
        airPlaneList.clear();
        for(int i = 0; i < lista_avioes.size(); i++) {
            airPlaneList.add(lista_avioes.get(i));
        }
    }

    public void setLista_avioes(Integer id, AirPlane airPlane) {
        lista_avioes.put(id, airPlane);
        airPlaneList.add(airPlane);
    }

    public List<AirPlane> getLista_avioes() {
        return airPlaneList;
    }

}
