package util.calculos;

import doMain.AirPlane;

public class FuncoesTransformacao {

    public static void translate(AirPlane airplane, int cordX, int cordY){
        airplane.setCordX(airplane.getCordX() + cordX);
        airplane.setCordY(airplane.getCordY() + cordY);
        convertPolarCastesian(airplane);
        changePosition(airplane, (int) airplane.getCordX(), (int) airplane.getCordY());
    }

    public static void stagger(AirPlane airplane, int x, int y){
        changePosition(airplane, (int) (airplane.getCordX() * (x/100)), (int) (airplane.getCordY() * (y/100)));
        convertPolarCastesian(airplane);
    }

    public static void rotate(AirPlane airplane, double cordX, double cordY, double angulo ) {
        float auxX = (float) (cordX > 0 ? -cordX : cordX);
        float auxY = (float) (cordY > 0 ? -cordY : cordY);

        translate(airplane, (int) (cordX > 0 ? -cordX : cordX), (int) (cordY > 0 ? -cordY : cordY));

        // rotacionar
        double anguloRadianos = Math.toRadians(angulo);
        double cosseno = Math.cos(anguloRadianos);
        double seno = Math.sin(anguloRadianos);

        double novoX = (airplane.getCordX() * cosseno) - (airplane.getCordY() * seno);
        double novoY = (airplane.getCordY() * cosseno) + (airplane.getCordX() * seno);

        airplane.setCordX((float) novoX);
        airplane.setCordY((float) novoY);

        // voltar a transla��o
        auxX = auxX * -1;
        auxY = auxY * -1;

        translate(airplane, (int) auxX, (int) auxY);
    }

    public static void convertPolarCastesian(AirPlane airplane) {
        airplane.setRaio((float) Math.sqrt((airplane.getCordX() * airplane.getCordX())
                                            + (airplane.getCordY() * airplane.getCordY())));

        airplane.setAngulo((float) Math.toDegrees(Math.atan(airplane.getCordX() / airplane.getCordY())));
    }

    public static void changePosition(AirPlane airplane, int cordX, int cordY){
        airplane.getImgAirplane().setBounds(CordenadasRadar.cordenadaX(cordX),
                CordenadasRadar.cordenadaY(cordY),
                airplane.getImgAirplane().getWidth(),
                airplane.getImgAirplane().getHeight());
    }
}
