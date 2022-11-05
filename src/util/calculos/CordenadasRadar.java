package util.calculos;

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

    public static float calculaAngulo(int cordY, float raio) {
        if(cordY == 0) {
            return 0;
        } else if (cordY < 0) {
            return (float) Math.toDegrees(Math.sin(cordY* -1) / raio);
        } else {
            return (float) Math.toDegrees(Math.sin(cordY / raio));
        }
    }

    public static int X(int raio, int angulo){
        return (int) (Math.cos(Math.toRadians(angulo))*raio);
    }

    public static int Y(int raio, int angulo){
        return (int) (Math.sin(Math.toRadians(angulo))*raio);
    }
}
