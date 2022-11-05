package util.calculos;

import doMain.AirPlane;

import java.util.*;

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

    public static List<String> distanciaEntreAvioes(Collection<AirPlane> airPlanes, float distancia){
        List<String> listaProximos = new ArrayList<String>();
        HashMap<String, Float> mapAux = new HashMap<String, Float>();

        for (AirPlane airPlane1: airPlanes){
            for (AirPlane airPlane2: airPlanes){
                if (!airPlane1.equals(airPlane2)){
                    if (airPlane1.getId() < airPlane2.getId()) {
                        if (!mapAux.containsKey(airPlane1.getId() + "-" + airPlane2.getId())) {
                            mapAux.put(airPlane1.getId() + "-" + airPlane2.getId(), calculaDist(airPlane1, airPlane2));
                            if (calculaDist(airPlane1, airPlane2) <= distancia){
                                listaProximos.add("Risco de colisão entro es aviões " + airPlane1.getId() + " e " + airPlane2.getId());
                            }
                        }
                    }
                }
            }
        }

        return listaProximos;
    }

    public static float calculaDist(AirPlane a1, AirPlane a2){
        float dx, dy;
        if (a1.getCordX()*a2.getCordX()>=0) {
            dx = Math.abs(a1.getCordX()) - Math.abs(a2.getCordX());
        } else {
            dx = Math.abs(a1.getCordX()) + Math.abs(a2.getCordX());
        }
        if (a1.getCordY()*a2.getCordY()>=0) {
            dy = Math.abs(a1.getCordY()) - Math.abs(a2.getCordY());
        } else {
            dy = Math.abs(a1.getCordY()) + Math.abs(a2.getCordY());
        }

        return (float) Math.sqrt((dx*dx)+(dy*dy));
    }

}
