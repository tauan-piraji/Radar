package util.calculos;

import doMain.AirPlane;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FuncoesRastreamento{

    public static List<AirPlane> distanciaBase(Collection<AirPlane> airPlanes, float distancia) {
        List<AirPlane> airPlaneList = new ArrayList<AirPlane>();

        for (AirPlane airPlane : airPlanes) {
            if (airPlane.getRaio() <= distancia) {
                airPlaneList.add(airPlane);
            }
        }

        Collections.sort(airPlaneList);

        return airPlaneList;
    }

    public static List<AirPlane> distanciaEntreAvioes(Collection<AirPlane> airPlanes, float distancia) {
        List<AirPlane> airPlaneList = new ArrayList<AirPlane>();

        for (AirPlane airPlane : airPlanes) {
            if (airPlane.getRaio() <= distancia) {
                airPlaneList.add(airPlane);
            }
        }

        Collections.sort(airPlaneList);

        return airPlaneList;
    }

}
