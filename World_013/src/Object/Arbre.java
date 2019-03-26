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
			if(cpt_cendre == 50) { //reste en cendre pendant x iterations
				w.tab_Arbre.remove(this);
				w.getWorld()[x][y]=-1;
			}else
				cpt_cendre++;
			//System.out.println(cpt_cendre);
		}	
		
		//1% de chance que le feu s'eteint
		if(feu == true) {
			vie--;
			if(Math.random()<0.01) 
				feu=false;
			
		//Apparition d'un arbre a cote d'un autre
		}else if(Math.random()<0.003 && (croissance==3)){ 
			boolean b=false;
			int c=0;
			do {
				int d=(int)(Math.random()*4);
				if((d==0) && (y-1>=0) && (w.getWorld()[x][y-1]==0) && (w.getNoise().alti[x][y-1]>=0) && (rebord(x,y-1)==0) ) {
					w.getWorld()[x][y-1]=2;
					w.tab_Arbre.add(new Arbre(nom,30,x,y-1, w));
					b=true;
				}else if((d==1) && (x+1<w.getX()) && (w.getWorld()[x+1][y]==0) && (w.getNoise().alti[x+1][y]>=0) && (rebord(x+1,y)==0) && (x+2<w.getX() && y+1<w.getY() && w.n.alti[x+1][y]==w.n.alti[x+2][y+1]) ) {
					w.getWorld()[x+1][y]=2;
					w.tab_Arbre.add(new Arbre(nom,30,x+1,y, w));
					b=true;
				}else if((d==2) && (y+1<w.getY()) && (w.getWorld()[x][y+1]==0) && (w.getNoise().alti[x][y+1]>=0) && (rebord(x,y+1)==0) && (x-1>=0 && y+2<w.getY() && w.n.alti[x][y+1]==w.n.alti[x-1][y+2]) && (x+1<w.getX() && y+2<w.getY() && w.n.alti[x][y+1]==w.n.alti[x+1][y+2]) ) {
					w.getWorld()[x][y+1]=2;
					w.tab_Arbre.add(new Arbre(nom,30,x,y+1, w));
					b=true;
				}else if((d==3) && (x-1>=0) && (w.getWorld()[x-1][y]==0) && (w.getNoise().alti[x-1][y]>=0) && (rebord(x-1,y)==0) && (x-2>=0 && y+1<w.getY() && w.n.alti[x-1][y]==w.n.alti[x-2][y+1]) ) {
					w.getWorld()[x-1][y]=2;
					w.tab_Arbre.add(new Arbre(nom,30,x-1,y, w));
					b=true;
				}
				c++;
			}while(b == false && c<4);
		}
		
		//Mise en feu
		//if(Math.random()<0.000)
			//feu=true;
		//System.out.println(vie);
		
		//Croissance de l'arbre
		if((croissance < 3) && (cpt == 200) && (cendre==false)) { 
			croissance++;
			cpt=0;
		}else {
			cpt++;
		}
		
		//Feu de foret
		if( Math.random()<0.10 && (feu==false) && (w.RechercheArbres(x,y-1).getFeu()==true || w.RechercheArbres(x+1,y).getFeu()==true 
							|| w.RechercheArbres(x,y+1).getFeu()==true || w.RechercheArbres(x-1,y).getFeu()==true)) 
				feu=true;
		
	}
	
	public int rebord(int x, int y) {
		if((y-1>=0 && w.getNoise().alti[x][y]!=w.getNoise().alti[x][y-1]) 
		|| (x+1<w.getX() && w.getNoise().alti[x][y]!=w.getNoise().alti[x+1][y])
		|| (y+1<w.getY() && w.getNoise().alti[x][y]!=w.getNoise().alti[x][y+1])
		|| (x-1>=0 && w.getNoise().alti[x][y]!=w.getNoise().alti[x-1][y])) {
			return 1;
		}
		
		return 0;
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
