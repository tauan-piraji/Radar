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
}
