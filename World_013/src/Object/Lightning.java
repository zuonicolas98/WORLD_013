package Object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
 
public class Lightning {
 
    public static void main(String[] args) throws IOException {
 
        int width = 100;
        int height = 100;
 
        // Constructs a BufferedImage of one of the predefined image types.
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
 
        // Create a graphics which can be used to draw into the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();
        Color couleur=new Color(255,255,255,0);
        Color couleur2=new Color(255,255,255,255);
 
        // create a string with yellow
        g2d.setColor(couleur2);
        
        g2d.drawLine(x1, y1, x2, y2);

        // Disposes of this graphics context and releases any system resources that it is using. 
        g2d.dispose();
 
        // Save as PNG
        File file = new File("abd/im2.png");
        ImageIO.write(bufferedImage, "png", file);
        //file.delete();
        System.out.println(file.exists());
 
 
    }
 
}