package Default;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Noise {
	public BufferedImage NOISE;
	private int min=255;
	private int max=0;
	private int x_max,y_max;
	private int X,Y;
	private int n0,n1,n;
	public int[][] alti;
	
	public Noise (int x,int y) { 
		X=x;
		Y=y;
		alti=new int[x][y];
		this.generateur();
	}
	
	public void generateur() {
		try {
			NOISE=ImageIO.read(new File("IMAGES/noise.png"));
			int h=NOISE.getHeight();
			int l=NOISE.getWidth();
			
			x_max=(int)(Math.random()*(l+1));
			y_max=(int)(Math.random()*(h+1));
			
			for(int x=x_max;x<x_max+X;x++) {
				for(int y=y_max;y<y_max+Y;y++) {
					
					int x1=x%l;
					int y1=y%h;
					
					Color mycolor = new Color(NOISE.getRGB(x1, y1));
					int var=mycolor.getBlue();
					//System.out.println(mycolor.getBlue());
					if(var<100) {
						alti[x-x_max][y-y_max]=-1;
						n0++;
					}
					else if(var<140) {
						alti[x-x_max][y-y_max]=0;
						n1++;
					}
					else {
						alti[x-x_max][y-y_max]=(((int)(var/10))%10)-3;
						n++;
					}
					if(var>max)
						max=var;
				}
			}
			//System.out.println(n0+" "+n1+" "+n+" "+max);
			
		} catch (IOException e) {}
	}
}
