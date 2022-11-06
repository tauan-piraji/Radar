package util.calculos;

import doMain.AirPlane;

import java.text.DecimalFormat;
import java.util.*;

public class FuncoesRastreamento{

    public static List<AirPlane> distanceBase(Collection<AirPlane> airPlanes, float distancia) {
        List<AirPlane> airPlaneList = new ArrayList<AirPlane>();

        for (AirPlane airPlane : airPlanes) {
            if (airPlane.getRaio() <= distancia) {
                airPlaneList.add(airPlane);
            }
        }

        Collections.sort(airPlaneList);

        return airPlaneList;
    }

    public static List<String> riskDistancePlanes(Collection<AirPlane> airPlanes, float distancia){
        List<String> riskList = new ArrayList<String>();
        HashMap<String, Float> aux = new HashMap<String, Float>();

        for (AirPlane airPlane1: airPlanes){
            for (AirPlane airPlane2: airPlanes){
                if (!airPlane1.equals(airPlane2)){
                    if ((!aux.containsKey(airPlane1.getId() + "-" + airPlane2.getId())) &&
                            (!aux.containsKey(airPlane2.getId() + "-" + airPlane1.getId()))) {
                        aux.put(airPlane1.getId() + "-" + airPlane2.getId(), distancePlanes(airPlane1, airPlane2));
                        aux.put(airPlane2.getId() + "-" + airPlane1.getId(), distancePlanes(airPlane1, airPlane2));
                        if (distancePlanes(airPlane1, airPlane2) <= distancia){
                            riskList.add("Risco de colisão entro es aviões " +
                                    airPlane1.getId() +
                                    " e " +
                                    airPlane2.getId() +
                                    " recaulcular rota");
                        }
                    }
                }
            }
        }

        return riskList;
    }

    public static float distancePlanes(AirPlane airPlane1, AirPlane airPlane2) {
        return (float) Math.sqrt(((airPlane1.getCordX() - airPlane2.getCordX()) * (airPlane1.getCordX() - airPlane2.getCordX())) +
                ((airPlane1.getCordY() - airPlane2.getCordY()) * (airPlane1.getCordY() - airPlane2.getCordY())));
    }

    public static List<String> collisionRiskList(List<AirPlane> airPlaneList, double tempoMinimo) {
        List<String> listaColisoes = new ArrayList<>();
        HashMap<String, Float> aux = new HashMap<String, Float>();

        for (AirPlane a: airPlaneList) {
            for (AirPlane b: airPlaneList) {
                if (a.equals(b)) {
                    continue;
                }

                if (!(aux.containsKey(a.getId() + "-" + b.getId())) &&
                        !(aux.containsKey(b.getId() + "-" + a.getId()))){
                    aux.put(a.getId() + "-" + b.getId(), distancePlanes(a, b));
                    aux.put(b.getId() + "-" + a.getId(), distancePlanes(a, b));
                    listaColisoes.add(collisionMSG(a, b, tempoMinimo));
                }
            }
        }

        return listaColisoes;
    }

    public static String collisionMSG(AirPlane airPlane1, AirPlane airPlane2, double tempoMinimo) {
        String message = "";

        HashMap<String, Float> pontos = intersection(airPlane1, airPlane2);

        float distanciaA1 = (calculateDistPoint(airPlane1, pontos.get("X"), pontos.get("Y")));

        float distanciaA2 = (calculateDistPoint(airPlane2, pontos.get("X"), pontos.get("Y")));

        float tempoA1 = distanciaA1/airPlane1.getVelocidade();
        float tempoA2 = distanciaA2/airPlane2.getVelocidade();

        float tempofinal = seconds(tempoA1 - tempoA2);

        if (tempofinal <= tempoMinimo){
            message = "ALERTA!!!: Colisão IMINENTE entre os aviões " +
                    airPlane1.getId() +
                    " e "+airPlane2.getId() +
                    " em " +
                    twoDicimal(tempofinal) +
                    " segundos, favor alterar rota";
        }

        return message;
    }

    private static float twoDicimal(double valor) {
        DecimalFormat df = new DecimalFormat("###.##");
        return Float.parseFloat(df.format(valor).replace(',', '.'));
    }

    public static HashMap<String, Float> intersection(AirPlane a1, AirPlane a2){
        HashMap<String, Float> pontos = new HashMap<String, Float>();

        float coefAngular1 = (float) Math.tan(Math.toRadians(a1.getDirecao()));
        float coefLinear1 = (coefAngular1 * a1.getCordX() - a1.getCordY()) * (-1);

        float coefAngular2 = (float) Math.tan(Math.toRadians(a2.getDirecao()));
        float coefLinear2 = (coefAngular2 * a2.getCordX() - a2.getCordY()) * (-1);

        if (!(a1.getAngulo() == a2.getAngulo()) && coefLinear1 != coefLinear2){
            System.out.println("colisão impossivel");
            pontos.put("IMPOSSIVEL", 0F);
        }else{
            if (a1.getAngulo() == a2.getAngulo() && coefLinear1==coefLinear2){
                pontos.put("TODOS", 0F);
            }else{
                float X = (coefLinear2 * -1) - (coefLinear1 * -1)/ (coefAngular2 - coefAngular1);

                pontos.put("X", (float) X);
                pontos.put("Y", (float) (coefAngular1 * X + coefLinear1));

            }
        }


        return pontos;
    }

    public static float calculateDistPoint(AirPlane airPlane, float x, float y){
        float dx, dy;

        if (airPlane.getCordX() * x >= 0){
            dx = Math.abs(airPlane.getCordX()) - Math.abs(x);
        }else{
            dx = Math.abs(airPlane.getCordX()) + Math.abs(x);
        }
        if (airPlane.getCordY() * y >= 0){
            dy = Math.abs(airPlane.getCordY()) - Math.abs(y);
        }else{
            dy = Math.abs(airPlane.getCordY()) + Math.abs(y);
        }

        return (float) Math.sqrt((dx * dx) + (dy * dy));
    }

    private static float seconds(double hora) {
        return (float) hora * 3600;
    }

}
