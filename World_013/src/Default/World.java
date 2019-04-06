package Default;

import Object.*;
import Agents.*;
import java.util.ArrayList;

public class World {
	public int[][] world;
	public int[][] liquide;
	public Volcan v;
	private int X,Y,delay,cpt_lave;
	public ArrayList<Cloud> tab_Cloud;
	public ArrayList<Object> object;
	public ArrayList<Arbre> tab_Arbre;
	public ArrayList<Animal> tab_Animal;
	public ArrayList<Volcan> tab_Volcan;
	private int nb_arbre, nb_animal;
	private Fenetre f;
	private boolean fin;
	public Lightning l=new Lightning();
	public Noise n;
	public int nb_lapin=0,nb_cochon=0,nb_chevre=0;
	public int tx,ty;
	private int nb_max_volcan,cpt_volcan=0;
	public int vent;
	
	public World(int x, int y,int nb_arbre,int nb_animal,int nb_max_volcan, int tx,int ty) {
		if(x==0 || y==0) {
			System.out.println("ERREUR DIMENSION DU TABLEAU !!!");
			System.exit(0);
		}
		this.tx=tx;
		this.ty=ty;
		this.nb_max_volcan=nb_max_volcan;
		//Initialisations
		world=new int[x][y];
		liquide=new int[x][y];
		n=new Noise(x,y);
		X=x;
		Y=y;
		fin=true;
		delay = 51;
		vent=(int)(Math.random()*2);
		f= new Fenetre(this,tx,ty);
		this.nb_arbre=nb_arbre;
		this.nb_animal=nb_animal;
		
		//ArrayLists
		object=new ArrayList<Object>();
		tab_Arbre=new ArrayList<Arbre>();
		tab_Animal= new ArrayList<Animal>();
		tab_Cloud= new ArrayList<Cloud>();
		tab_Volcan = new ArrayList<Volcan>();
		
		tab_Volcan.add(new Volcan(this));
		cpt_lave=0;
		
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
	 *	LAVE 	= 4  */

	public void InitWorld() {

		for(int y=0;y<Y;y++) {
			for(int x=0;x<X;x++) {
				double m=Math.random();
				if(m<0.1 && n.alti[x][y]>=0 && n.alti[x][y]<7 && rebord(x,y)==0 && (x-1>=0 && y+1<Y && n.alti[x][y]==n.alti[x-1][y+1]) && (x+1<X && y+1<Y && n.alti[x][y]==n.alti[x+1][y+1])) //Herbes
					world[x][y]=1;
			
			}
		}
		//Initialisation des arbres
		
		for(int i=0;i<nb_arbre;i++) {
			int t=(int)(Math.random()*2);
			int _x=(int)(Math.random()*X);
			int _y=(int)(Math.random()*Y);
			if(world[_x][_y]==0 && n.alti[_x][_y]>=0 && n.alti[_x][_y]<7 && rebord(_x,_y)==0 && (_x-1>=0 && _y+1<Y && n.alti[_x][_y]==n.alti[_x-1][_y+1]) && (_x+1<X && _y+1<Y && n.alti[_x][_y]==n.alti[_x+1][_y+1])) { //s'il n'y a rien sur cette case et compris dans l'altitude
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
				if(world[_x][_y]!=2 && world[_x][_y]!=3 && n.alti[_x][_y]>=0 && n.alti[_x][_y]<7 && rebord(_x,_y)==0 && (_x-1>=0 && _y+1<Y && n.alti[_x][_y]==n.alti[_x-1][_y+1]) && (_x+1<X && _y+1<Y && n.alti[_x][_y]==n.alti[_x+1][_y+1])) {
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
			for(int i=0;i<tab_Animal.size();i++) {
				if(tab_Animal.get(i).getClass()==Lapin.class) 
					nb_lapin++;
				else if(tab_Animal.get(i).getClass()==Chevre.class) 
					nb_chevre++;
				else if(tab_Animal.get(i).getClass()==Cochon.class) 
					nb_cochon++;
			}
		//Volcan
			//if(n.alti)
		//Initialisation liquide
			for(int i=0; i<X; i++) {
				for(int j=0; j<Y; j++) {
						liquide[i][j]=0;
				}
			}
		//afficherAltitude();
		//afficherLiquide()
			
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
	
	public int RechercheAnimal(int __x,int __y) {
		for(int id=0;id<tab_Arbre.size();id++) {
			try {
				if(tab_Animal.get(id).getX()==__x && tab_Animal.get(id).getY()==__y) 
					return id;	
			}catch(Exception e) {}
		}
		return -1;	
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

		nb_lapin=0;
		nb_chevre=0;
		nb_cochon=0;
		
		//step() animaux
		for(int i=0; i < tab_Animal.size(); i++) {
			tab_Animal.get(i).step();
		}
		for(int i=0;i<tab_Animal.size();i++) {
			if(tab_Animal.get(i).getClass()==Lapin.class) 
				nb_lapin++;
			else if(tab_Animal.get(i).getClass()==Chevre.class) 
				nb_chevre++;
			else if(tab_Animal.get(i).getClass()==Cochon.class) 
				nb_cochon++;
		}
		//step() arbres
		for(int i=0; i < tab_Arbre.size(); i++) {
			tab_Arbre.get(i).step();
		}
		try {
		for(int i=0; i < tab_Cloud.size(); i++) {
			tab_Cloud.get(i).step();
		}
		}catch(Exception e) {}
		
		if(Math.random()<0.01 && tab_Cloud.size()<Y/5) {//proba apparition nuage 
			int ___x=(int)(Math.random()*X);
			int ___y=(int)(Math.random()*Y);
			while((n.alti[___x][___y]<-1 || n.alti[___x][___y]>6 || ___y>=Y-15 || ___x<3 || ___x>X-3)) {
				___x=(int)(Math.random()*X);
				___y=(int)(Math.random()*Y);
			}
			tab_Cloud.add(new Cloud(___x,___y,0,this));
		}
		//step() light
		l.setCpt();
		
		refreshground();
		
		//remise a 0
		for(int i=0; i<X; i++) {
			for(int j=0; j<Y; j++) {
					liquide[i][j]=0;
			}
		}
		System.out.println(tab_Volcan.size());
		if(Math.random()<1.005 && tab_Volcan.size()<nb_max_volcan) {
			tab_Volcan.add(new Volcan(this,"new_aleatoire"));
			cpt_volcan++;
		}
		for(int i=0;i<tab_Volcan.size();i++) {
			if(tab_Volcan.get(i).getMontee()==0) {
				cpt_lave++;
			}
			for(int i2=0;i2<tab_Volcan.get(i).tab_P.size();i2++) {
					tab_Volcan.get(i).tab_P.get(i2).step();

			}
			tab_Volcan.get(i).step();
		}
		
		for(int x=0;x<X;x++) {
			for(int y=0;y<Y;y++) {
				for(int i=0;i<tab_Volcan.size();i++) {
					if(tab_Volcan.get(i).liquide[x][y]>liquide[x][y]) 
						liquide[x][y]=tab_Volcan.get(i).liquide[x][y];
				}
			}
		}
		MajVent();
		f.getPanneau().repaint();
	

	}
	
	//Rafraichissement du sol + apparitions d'herbes + liquide
	void refreshground() {
		for(int y=0;y<Y;y++) {
			for(int x=0;x<X;x++) {
				if((Math.random()<0.00001 && world[x][y]==1 ) || (world[x][y]==3 && Math.random()<0.0001)) //disparition de l'herbe et rocher
					world[x][y]=0;
				//apparitions herbes
				if(Math.random()<0.000005 && world[x][y]==0 && n.alti[x][y]>=0 && n.alti[x][y]<7 &&  rebord(x,y)==0 && (x-1>=0 && y+1<Y && n.alti[x][y]==n.alti[x-1][y+1]) && (x+1<X && y+1<Y && n.alti[x][y]==n.alti[x+1][y+1])) //Herbes
					world[x][y]=1;	
				
				//sol non fertile qui redevient sol fertile
				if( (world[x][y]==-1) && (Math.random()<0.003) && 
				(  ((y-1>=0) && ((world[x][y-1]==0) || (world[x][y-1]==1) || (world[x][y-1]==2))) 
				|| ((x+1<X)  && ((world[x+1][y]==0) || (world[x+1][y]==1) || (world[x+1][y]==2)))
				|| ((y+1<Y)  && ((world[x][y+1]==0) || (world[x][y+1]==1) || (world[x][y+1]==2))) 
				|| ((x-1>=0) && ((world[x-1][y]==0) || (world[x-1][y]==1) || (world[x-1][y]==2))) ))
					world[x][y]=0;
				
				if(liquide[x][y]>0 && RechercheArbres(x,y).getX()==-1 && world[x][y]!=1) {
					//System.out.println(liquide[x][y]);
					world[x][y]=-1;
				}
			}
		}
		//afficherLiquide();
	}
	
	public void MajVent() {
		if(Math.random()<0.0005) {
			if(vent==0)
				vent=1;
			else 
				vent=0;
			for(int i=0;i<tab_Cloud.size();i++) {
				if(tab_Cloud.get(i).volcan)
					tab_Cloud.get(i).changeDirection();
			}
			for(int i=0;i<tab_Volcan.size();i++) {
				tab_Volcan.get(i).changeDir();
			}
		}
	}
	
	public int rebord(int x, int y) {
		if((y-1>=0 && n.alti[x][y]!=n.alti[x][y-1]) 
		|| (x+1<X && n.alti[x][y]!=n.alti[x+1][y])
		|| (y+1<Y && n.alti[x][y]!=n.alti[x][y+1])
		|| (x-1>=0 && n.alti[x][y]!=n.alti[x-1][y])) {
			return 1;
		}	
		return 0;
	}
	
	
	public void afficherAltitude() {	
		for(int i=0; i<Y; i++) {
			for(int j=0; j<X; j++) {
				System.out.print(n.alti[j][i]);
			}
			System.out.println();
		}
		
	}
	public void FinDuMonde() {
		
	}
	
	//Getters
	public int[][] getWorld() { return world ;}
	public int getX() { return X; }
	public int getY() { return Y; }
	public int getDelay() { return delay;}
	public int getLave() { return cpt_lave;}
	public Noise getNoise() { return n; }
	
	//Setters
	public void setDelay(int d) { delay = d; }
	public void setLave(int l) {cpt_lave=l;}
	public void setFin() { fin = false; }
}
