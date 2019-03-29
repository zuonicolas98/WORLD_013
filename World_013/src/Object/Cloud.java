package Object;

import java.util.ArrayList;

import Default.*;

public class Cloud {
	private World w;
	private int[][] alti;
	private int age;
	private int vie;
	private boolean mature=false;
	private boolean flag=false;
	private int x,y;
	public int ombre_x,ombre_y;
	private int cpt;
	private int direction;
	
	public Cloud(int x,int y,int age,World w) {
		this.w=w;
		this.alti=w.n.alti;
		this.x=x;
		this.y=y;
		this.age=age;
		vie=10;
		ombre_x=x;
		int d=0;//(int)(Math.random()*2);
		if(d==0)
			direction=1;
		else
			direction=3;
		if(alti[x][y]<=-2 )
			System.out.println("Mauvaise initialisation des nuages");
		if(alti[x][y]==-1 && y+10<w.getY())
			ombre_y=y+10;
		ombre_y=y+10-alti[x][ombre_y];
		if(age==10) {
			mature=true;
		}
	}
	
	public void step() {
		if(mature==false) {
			if (cpt>=200) {
				cpt=0;
				age++;
				if(age>=10)
					mature=true;
			}
			else
				cpt++;
		}else {
			if(cpt==10) {
				if(	x+1==w.getX() || x-1<0) {
					this.changeDirection();
				}
				//if(Math.random()<0.05 && flag==true)
					//this.changeDirection();
				
				if(direction==1) {
					if(alti[x][ombre_y]<alti[x+1][ombre_y]) {
						ombre_y=ombre_y-1;
					}else if((alti[x][ombre_y]!=-1 && alti[x+1][ombre_y]==-1) || alti[x][ombre_y]>alti[x+1][ombre_y]){
						ombre_y=ombre_y+1;
					}
					ombre_x=ombre_x+1;
					x=x+1;
					
				}else if(direction==3) {
					if(alti[x][ombre_y]<alti[x-1][ombre_y]) {
						ombre_y=ombre_y-1;
					}else if((alti[x][ombre_y]!=-1 && alti[x-1][ombre_y]==-1) || alti[x][ombre_y]>alti[x-1][ombre_y]){
						ombre_y=ombre_y+1;
					}
					ombre_x=ombre_x-1;
					x=x-1;
				}
				cpt=0;
				flag=true;
			}
			else
				cpt++;
		}
	}
	
	public void changeDirection() {
		flag=false;
		if(direction==1)
			direction=3;
		else
			direction=1;
	}
	public int getCpt() {
		return cpt;
	}
	public int getX() {return this.x;}
	public int getY() {return this.y;}
	
	
}

