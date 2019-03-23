package Agents;
import Default.*;

public abstract class Animal {
	protected int vie,timer,cpt,reproduire;
	protected int x,y;
	protected int direction;
	protected int action; //pour les images : 1:debout | 2:manger 
	protected World w;
	public int pixel=0;
	
	public Animal(int x, int y, World w) {
		this.w=w;
		this.x=x;
		this.y=y;
		reproduire=0;
		action= 1;
		
		direction= -1; //0:haut | 1:droite | 2:bas | 3:gauche | -1 :ne bouge pas

	}
	
	public void changer_direction() {
		this.direction=(int)(Math.random()*4);
		
		if(((direction == 0) && ((y-1<0) || (w.getWorld()[x][y-1]==3) || (w.getWorld()[x][y-1]==2))) //il ne peut pas se trouver sur un rocher ou arbre
		|| ((direction == 1) && ((x+1>=w.getX()) || (w.getWorld()[x+1][y]==3) || (w.getWorld()[x+1][y]==2)))
		|| ((direction == 2) && ((y+1>=w.getY()) || (w.getWorld()[x][y+1]==3) || (w.getWorld()[x][y+1]==2))) 
		|| ((direction == 3) && ((x-1<0) || (w.getWorld()[x-1][y]==3) || (w.getWorld()[x-1][y]==2))))
			direction =-1;
	}
	
	public abstract void bouger();
	public abstract boolean chasser();
	public abstract void step();
	
	//Getters	
	public int getX() { return x;}
	public int getY() { return y;}
	public int getVie() { return vie;}
	public int getDirection() { return direction;}
	public int getAction() { return action;}
	public int getCpt() {return cpt;}
	public int getTimer() { return timer;}
	public int getReproduire() {return reproduire;}
	//Setters
	public void setCpt(int c) { cpt=c;}
	public void setReproduire(int r) {reproduire = r;}
}
