package Default;

import java.util.ArrayList;
import Object.*;
import Agents.*;

public class World {
	private int[][] world;
	private int X,Y;
	public ArrayList<Object> object;
	public ArrayList<Arbre> tab_Arbre;
	public ArrayList<Animal> tab_Animal;
	private int nb_arbre, nb_animal;
	private Fenetre f;
	
	public World(int x, int y,int nb_arbre,int nb_animal, int tx,int ty) {
		if(x==0 || y==0) {
			System.out.println("ERREUR DIMENSION DU TABLEAU !!!");
			System.exit(0);
		}
		//Initialisations
		world=new int[x][y];
		X=x;
		Y=y;
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
	 *	BUISSON = 1  *
	 *	ARBRE   = 2  *
	 *	ROCHER  = 3  *
	 *	EAU     = 4  *
	 *	LAVE 	= 5  */

	public void InitWorld() {
		
		for(int y=0;y<Y;y++) {
			for(int x=0;x<X;x++) {
				
			}
		}
		
		/*//Initialisation des arbres
		for(int i=0;i<nb_arbre;i++) {
			int _x=(int)(Math.random()*X);
			int _y=(int)(Math.random()*Y);
			if(world[_x][_y]==0) { //s'il n'y a rien sur cette case
				world[_x][_y]=2;
				tab_Arbre.add(new Arbre("Arbre",30,_x,_y, this));
				if(Math.random()<1) {
					tab_Arbre.get(i).setFeu(true);
					//System.out.println(i+"  "+tab_Arbre.get(i).getFeu());
				}
			}else
				i--;
		}
		*/
		//Initialisation des animaux
			for(int i=0;i<nb_animal;i++) {
				int _x=(int)(Math.random()*X);
				int _y=(int)(Math.random()*Y);
				int type=(int)(Math.random()*3);
				if(world[_x][_y]!=2) {
					switch(type) { // 0:Chevre | 1:Cochon
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
		//world[9][10]=2;
		//world[9][11]=2;
		//tab_Arbre.add(new Arbre("Arbre",30,9,10, this));
		//tab_Arbre.add(new Arbre("Arbre",30,9,11, this));
		
		//tab_Animal.add(new Cochon(10,10, this));
		//tab_Animal.add(new Cochon(11,10, this));
		
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
			if(tab_Arbre.get(id).getX()==__x && tab_Arbre.get(id).getY()==__y) 
				return tab_Arbre.get(id);	
		}
		return a;	
	}
	
	public void run() {
		f.setVisible(true);
		while(true) {
			this.step();
		}	
	}
	
	public void step() {
		
		try {
			Thread.sleep(100);
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
		
		f.getPanneau().repaint();
	}
	
	//Getters
	public int[][] getWorld() { return world ;}
	public int getX() { return X; }
	public int getY() { return Y; }
	
}
