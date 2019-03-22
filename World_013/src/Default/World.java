package Default;

import Object.*;
import Agents.*;
import java.util.ArrayList;

public class World {
	private int[][] world;
	private int X,Y,delay;
	public ArrayList<Object> object;
	public ArrayList<Arbre> tab_Arbre;
	public ArrayList<Animal> tab_Animal;
	private int nb_arbre, nb_animal;
	private Fenetre f;
	private boolean fin;
	public Lightning l=new Lightning();
	public int[][] alti;
	
	public World(int x, int y,int nb_arbre,int nb_animal, int tx,int ty) {
		if(x==0 || y==0) {
			System.out.println("ERREUR DIMENSION DU TABLEAU !!!");
			System.exit(0);
		}
		//Initialisations
		world=new int[x][y];
		alti=new int[x][y];
		X=x;
		Y=y;
		fin=true;
		delay = 51;
		f= new Fenetre(this,tx,ty);
		this.nb_arbre=nb_arbre;
		this.nb_animal=nb_animal;
		
		//ArrayLists
		object=new ArrayList<Object>();
		tab_Arbre=new ArrayList<Arbre>();
		tab_Animal= new ArrayList<Animal>();
		
		if(nb_arbre>x*y) {
			System.out.println("Trop d'arbres par rapport a la taille du monde");
			System.exit(0);
		}
		
		InitWorld();	
		

	}
	//Initialisation du monde
	/*	RIEN    = 0  *
	 *	HERBES = 1  *
	 *	ARBRE   = 2  *
	 *	ROCHER  = 3  *
	 *	EAU     = 4  *
	 *	LAVE 	= 5  */

	public void InitWorld() {

		for(int y=0;y<Y;y++) {
			for(int x=0;x<X;x++) {
				double m=Math.random();
				
				if(m<0.1) //Herbes
					world[x][y]=1;
				
			}
		}
		
		//Initialisation des arbres
		
		for(int i=0;i<nb_arbre;i++) {
			int t=(int)(Math.random()*2);
			int _x=(int)(Math.random()*X);
			int _y=(int)(Math.random()*Y);
			if(world[_x][_y]==0) { //s'il n'y a rien sur cette case
				world[_x][_y]=2;
				if(t==0)
					tab_Arbre.add(new Arbre("Pommier",30,_x,_y, this));
				else 
					tab_Arbre.add(new Arbre("Cocotier",30,_x,_y, this));
			}else
				i--;
		}
		

		
		//Initialisation des animaux
			for(int i=0;i<nb_animal;i++) {
				int _x=(int)(Math.random()*X);
				int _y=(int)(Math.random()*Y);
				int type=(int)(Math.random()*3);
				if(world[_x][_y]!=2 && world[_x][_y]!=3  ) {
					switch(type) { // 0:Chevre | 1:Cochon | 2:Lapin
						case 0: 
							tab_Animal.add(new Chevre(_x,_y, this));
							break;
						case 1: 
							tab_Animal.add(new Cochon(_x,_y, this));
							break;
						case 2: 
							tab_Animal.add(new Lapin(_x,_y, this));
							break;
						default:;
					}		
				}else
					i--;
			}
		
	}
	

	public void displayWorld() {
		for(int y2=0;y2<Y;y2++) {
			for(int x2=0;x2<X;x2++) {
				//System.out.print(world[x2][y2]);
			}
			//System.out.println();
		}
	}
	
	public Arbre RechercheArbres(int __x,int __y) {
		Arbre a=new Arbre("a",0,-1,-1,this);
		for(int id=0;id<tab_Arbre.size();id++) {
			try {
				if(tab_Arbre.get(id).getX()==__x && tab_Arbre.get(id).getY()==__y) 
					return tab_Arbre.get(id);	
			}catch(NullPointerException e) {}
		}
		return a;	
	}
	
	public void run() {
		f.setVisible(true);
		while(fin) {
			this.step();
		}
		if(fin == false) {
			System.out.println("Merci d'etre passe !");
			
		}
	}
	
	public void step() {
		
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//step() animaux
		for(int i=0; i < tab_Animal.size(); i++) {
			tab_Animal.get(i).step();
		}
		
		//step() arbres
		for(int i=0; i < tab_Arbre.size(); i++) {
			tab_Arbre.get(i).step();
		}
		
		//step() light
		l.setCpt();
		
		refreshground();
		
		f.getPanneau().repaint();
	}
	
	//Rafraichissement du sol + apparition d'herbes
	void refreshground() {
		for(int y=0;y<Y;y++) {
			for(int x=0;x<X;x++) {
				if(Math.random()<0.000005 && world[x][y]==0) //Herbes
					world[x][y]=1;	
				
				if( (world[x][y]==-1) && (Math.random()<0.003) && 
				(  ((y-1>=0) && ((world[x][y-1]==0) || (world[x][y-1]==1) || (world[x][y-1]==2))) 
				|| ((x+1<X)  && ((world[x+1][y]==0) || (world[x+1][y]==1) || (world[x+1][y]==2)))
				|| ((y+1<Y)  && ((world[x][y+1]==0) || (world[x][y+1]==1) || (world[x][y+1]==2))) 
				|| ((x-1>=0) && ((world[x-1][y]==0) || (world[x-1][y]==1) || (world[x-1][y]==2))) ))
					world[x][y]=0;
					
			}
		}
	}
	
	
	//Getters
	public int[][] getWorld() { return world ;}
	public int getX() { return X; }
	public int getY() { return Y; }
	public int getDelay() { return delay;}
	
	//Setters
	public void setDelay(int d) { delay = d; }
	public void setFin() { fin = false; }
}
