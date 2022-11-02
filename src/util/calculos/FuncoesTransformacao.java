package util.calculos;

import doMain.Airplane;

public class FuncoesTransformacao {

    public static void translandar(Airplane airplane, int x, int y){
        airplane.setX(airplane.getX()+x);
        airplane.setY(airplane.getY()+y);
        converteCartesianoPolar(airplane);
        alteraPosicao(airplane);
    }

    public static void converteCartesianoPolar(Airplane airplane) {
        airplane.setRaio((float) Math.sqrt((airplane.getX() * airplane.getX())
                                            + (airplane.getY() * airplane.getY())));

        airplane.setAngulo((float) Math.toDegrees(Math.atan(airplane.getX() / airplane.getY())));
    }

    public static void alteraPosicao(Airplane airplane){
        airplane.getImgAirplane().setBounds(CordenadasRadar.cordenadaX((int) airplane.getX()),
                CordenadasRadar.cordenadaY((int) airplane.getY()),
                airplane.getImgAirplane().getWidth(),
                airplane.getImgAirplane().getHeight());

    }

}
