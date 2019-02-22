package Object;


public class Arbre {
	private String nom; 
	private boolean feu;
	private int vie;
	private int x,y;
	private int croissance; // 1:petit | 2:moyen | 3:grand
	
	public Arbre(String n,int vie,int x,int y) {
		nom=n;
		feu=false;
		this.vie=vie;
		this.x=x;
		this.y=y;
		croissance=1;
	}
	
	public void grandir() {
		if(croissance < 3)
			croissance++;
	}
	
	//Getters
	public String getNom() { return nom;}
	public boolean getFeu() { return feu;}
	public int getX() { return x;}
	public int getY() { return y;}
	
	//Setters
	public void setFeu() {
		if(feu)
			feu=false;
		else
			feu=true;
	}
	
}
