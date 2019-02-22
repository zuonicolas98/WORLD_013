package Agents;

public abstract class Animal {
	private int vie;
	private int x,y;
	private int direction;
	private int action; //pour les images : 1:debout | 2:manger | 3:dormir
	
	public Animal(int x, int y) {
		vie=10;
		this.x=x;
		this.y=y;
		direction= (int)(Math.random()*4); //0:haut | 1:droite | 2:bas | 3:gauche
		action= 1;
	}
	
	public abstract void bouger();
	public abstract void chasser();
	public abstract void fuir();
	
	//Getters	
	public int getX() { return x;}
	public int getY() { return y;}
	public int getVie() { return vie;}
	public int getDirection() { return direction;}
	public int getAction() { return action;}
	
	//Setters
	public void setAction(int a) { 
		if(a>=1 && a<=3)
			action = a;
	}
	
}
