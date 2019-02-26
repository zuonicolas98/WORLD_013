package Agents;
import Default.*;

public abstract class Animal {
	protected int vie;
	protected int x,y;
	protected int direction;
	protected int action; //pour les images : 1:debout | 2:manger 
	protected World w;
	
	public Animal(int x, int y, World w) {
		this.w=w;
		vie=20;
		this.x=x;
		this.y=y;
		direction= (int)(Math.random()*4); //0:haut | 1:droite | 2:bas | 3:gauche | -1 :ne bouge pas
		action= 1;
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
	
}
