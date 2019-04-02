package Default;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Agents.Chevre;
import Agents.Cochon;
import Agents.Lapin;

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
			int r=(int)(Math.random()*3+1);
			NOISE=ImageIO.read(new File("IMAGES/noise"+r+".png"));

			int h=NOISE.getHeight();
			int l=NOISE.getWidth();
			if(l<X || h<Y) {
				System.out.println("ERREUR : Resolution trop grande");
				System.exit(0);
			}
			x_max=(int)(Math.random()*(l+1));
			y_max=(int)(Math.random()*(h+1));
			while(x_max+X>l)
				x_max=(int)(Math.random()*(l+1));
			while(y_max+Y>h)
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
						if (var>=200) {
							alti[x-x_max][y-y_max]=(((int)(var/10))%10)+7;
							n++;
						}
						else {
						alti[x-x_max][y-y_max]=(((int)(var/10))%10)-3;
						n++;
						}
					}
					if(var>max)
						max=var;
				}
			}
			//System.out.println(n0+" "+n1+" "+n+" "+max);
			
		} catch (IOException e) {}
	}
}
