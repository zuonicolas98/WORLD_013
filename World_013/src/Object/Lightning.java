package Object;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
 
public class Lightning {
	
	public int cpt=0;
	private int frame=50;//temps d'attente avant de rafficher 
	private File file = new File("IMAGES/ELEMENTS/foudre.png");

	public Lightning() {
		try {
			this.setLight();
		} catch (IOException e) {}
	}

    public void setLight() throws IOException {
 
        int width = 100;
        int height = 100;
        int x1=width/2;
        int y1=height;
        int x2=-1,y2=-1;
        int taille=6;
 
        // Constructs a BufferedImage of one of the predefined image types.
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
 
        // Create a graphics which can be used to draw into the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();
        Color couleur=new Color(255,255,255,220);
        Color couleur2=new Color(114, 238, 226,120);
        // create a string with yellow
        
    	while(y1>0) {
    		g2d.setColor(couleur);
    		while(taille<2)
    			taille=taille+(int)(Math.random()*4)-2;
    		while(x2<0 || x2>100) {
    			if(Math.random()<0.5) {
    					x2=x1+2;//(int)((Math.random()*10)-5);
    			}
    			else
    				x2=x1-2;//+(int)((Math.random()*4)-2);;
    			}
        	y2=y1-(int)((Math.random()*4)-1);
    		for(int i=-taille/2;i<taille/2;i++)
    		{
    			g2d.drawLine(x1+i,y1, x2+i, y2);
    		}
    		g2d.setColor(couleur2);
    		for(int i=-taille/3;i<taille/3+1;i++)
    		{
    			g2d.drawLine(x1+i-taille,y1, x2+i-taille, y2);
    		}
    		for(int i=-taille/3-1;i<taille/3;i++)
    		{
    			g2d.drawLine(x1+i+taille,y1, x2+i+taille, y2);
    		}
    		x1=x2;
    		y1=y2;
    		x2=-1;
    	}
    	g2d.setColor(couleur2);
    	g2d.fillOval(35,90, 30, 20);
    	g2d.setColor(couleur);
    	g2d.fillOval(40, 95, 20, 10);
    	g2d.setColor(couleur2);
    	
    	for(int i=0;i<30;i++) {
    		while( (x2<40 || x2>60))
    			x2=(int)(Math.random()*20+1)+40;
    		while(y2<80)
    				y2=(int)(Math.random()*20+1)+80;
    		g2d.drawLine(x2,y2,x2,y2);
    		x2=-1;
    		y2=-1;
    	}
        // Disposes of this graphics context and releases any system resources that it is using. 
        g2d.dispose();
 
        ImageIO.write(bufferedImage, "png", file);

 
    }

    public boolean estAfficher() {
    	if(cpt<=frame) {
    		return true;
    	}
    	cpt=0;
    	return false;
    }
    public void deleteImage() {
    	file.delete();
    }
    public void setCpt() {cpt++;}
    public boolean Existe() {
    	return file.exists();
    }
 
}