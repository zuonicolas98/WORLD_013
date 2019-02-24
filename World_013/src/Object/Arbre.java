package Object;
import Default.*;

public class Arbre {
	private World w;
	private String nom; 
	private boolean feu,cendre;
	private int cpt_cendre;
	private int vie;
	private int x,y;
	private int croissance, cpt; // 1:petit | 2:moyen | 3:grand
	
	public Arbre(String n,int vie,int x,int y, World w) {
		this.w=w;
		nom=n;
		feu=false;
		cendre=false;
		this.vie=vie;
		this.x=x;
		this.y=y;
		croissance=1;
		cpt=0;
		cpt_cendre=0;
	}
	
	public void step() {
		if(vie <= 0) {
			feu=false;
			cendre=true;
			if(cpt_cendre == 10) //reste en cendre pendant 10 iterations
				w.tab_Arbre.remove(this);
			else
				cpt_cendre++;
			//System.out.println(cpt_cendre);
		}	
		if(feu == true)
			vie--;
		
		//System.out.println(vie);
		
		if((croissance < 3) && (cpt == 20)) {
			croissance++;
			cpt=0;
		}else {
			cpt++;
		}
	}
	
	//Getters
	public String getNom() { return nom;}
	public boolean getFeu() { return feu;}
	public boolean getCendre() { return cendre;}
	public int getX() { return x;}
	public int getY() { return y;}
	public int getCroissance() { return croissance;}
	
	//Setters
	public void setFeu() {
		if(feu)
			feu=false;
		else
			feu=true;
	}
	
}
