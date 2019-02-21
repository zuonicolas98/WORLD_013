package Object;


public class Arbre {
	private String nom; 
	private boolean feu;
	private int vie;
	private int x,y;
	
	public Arbre(String n,int vie,int x,int y) {
		nom=n;
		feu=false;
		this.vie=vie;
		this.x=x;
		this.y=y;
	}
	
	public String getNom() { return nom;}
	public boolean getFeu() { return feu;}
	public int getX() { return x;}
	public int getY() { return y;}
	
	
	public void setFeu() {
		if(feu)
			feu=false;
		else
			feu=true;
	}
	
}
