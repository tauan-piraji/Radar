package util.calculos;

import java.text.DecimalFormat;

public class CordenadasRadar {

    public static int cordenadaX(int x) {
        return x+200-(20/2);
    }

    public static int cordenadaY(int y) {
        return (y*(-1))+200-(20/2);
    }

    public static int polarX(int raio, int angulo){
        int x = (int) (Math.cos(Math.toRadians(angulo))*raio);

        return cordenadaX(x);
    }

    public static int polarY(int raio, int angulo){
        int y = (int) (Math.sin(Math.toRadians(angulo))*raio);

        return cordenadaY(y);
    }

    public static float calculaRaio(int cordX, int cordY) {
        return (float) Math.sqrt((cordX * cordX) + (cordY * cordY));
    }

    public static float calculateAngle(int cordX, int cordY, float raio) {
        if(cordY == 0 && cordX > 0) {
            return 0;
        } else if (cordY == 0 && cordX < 0) {
            return 180;
        } else if (cordY > 0 && cordX == 0) {
            return 90;
        } else if (cordY < 0 && cordX == 0) {
            return 270;
        } else if (cordY < 0) {
            return twoDicimal(Math.toDegrees(Math.sin(cordY * -1) / raio));
        } else {
            return twoDicimal(Math.toDegrees(Math.sin(cordY / raio)));
        }
    }

    public static int X(int raio, int angulo){
        return (int) (Math.cos(Math.toRadians(angulo))*raio);
    }

    public static int Y(int raio, int angulo){
        return (int) (Math.sin(Math.toRadians(angulo))*raio);
    }

    public static float twoDicimal(double valor) {
        DecimalFormat df = new DecimalFormat("###.##");
        return Float.parseFloat(df.format(valor).replace(',', '.'));
    }
}
