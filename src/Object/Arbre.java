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
		
		if(feu == true) {
			vie--;
			if(Math.random()<0.01) //1% de chance que le feu s'eteint
				feu=false;
			
		}else if(Math.random()<0.006){ //Apparition d'un arbre à coté d'un autre
			boolean b=false;
			int c=0;
			do {
				int d=(int)(Math.random()*4);
				if((d==0) && (y-1>=0) && (w.getWorld()[x][y-1]==0)) {
					w.getWorld()[x][y-1]=2;
					w.tab_Arbre.add(new Arbre(nom,30,x,y-1, w));
					b=true;
				}else if((d==1) && (x+1<w.getX()) && (w.getWorld()[x+1][y]==0)) {
					w.getWorld()[x+1][y]=2;
					w.tab_Arbre.add(new Arbre(nom,30,x+1,y, w));
					b=true;
				}else if((d==2) && (y+1<w.getY()) && (w.getWorld()[x][y+1]==0)) {
					w.getWorld()[x][y+1]=2;
					w.tab_Arbre.add(new Arbre(nom,30,x,y+1, w));
					b=true;
				}else if((d==3) && (x-1>=0) && (w.getWorld()[x-1][y]==0)) {
					w.getWorld()[x-1][y]=2;
					w.tab_Arbre.add(new Arbre(nom,30,x-1,y, w));
					b=true;
				}
				c++;
			}while(b == false && c<4);
		}
		//System.out.println(vie);
		
		if((croissance < 3) && (cpt == 30)) { //l'arbre grandi 
			croissance++;
			cpt=0;
		}else {
			cpt++;
		}
		
		//Feu de forêt
		if( (feu==false) && (w.RechercheArbres(x,y-1).getFeu()==true || w.RechercheArbres(x+1,y).getFeu()==true 
							|| w.RechercheArbres(x,y+1).getFeu()==true || w.RechercheArbres(x-1,y).getFeu()==true)) 
				feu=true;
		
	}
	
	//Getters
	public String getNom() { return nom;}
	public boolean getFeu() { return feu;}
	public boolean getCendre() { return cendre;}
	public int getX() { return x;}
	public int getY() { return y;}
	public int getCroissance() { return croissance;}
	
	//Setters
	public void setFeu(boolean f) {
		feu=f;
	}
	
}
