package util.rotacionaImg;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class RotacionaAviao extends JPanel {

    public static BufferedImage rodarImg(URL img2, int angulo) {
        BufferedImage img = null;

        try{
             BufferedImage imgOriginal = ImageIO.read(img2);
             img = new BufferedImage(imgOriginal.getWidth(),
                                        imgOriginal.getHeight(),
                                        imgOriginal.getType());

            Graphics2D graphics2D = img.createGraphics();
            graphics2D.rotate(Math.toRadians(angulo*(-1)), imgOriginal.getWidth() / 2, imgOriginal.getHeight() / 2);
            graphics2D.drawImage(imgOriginal, null, 0, 0);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return img;
    }

}
