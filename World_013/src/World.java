import java.util.ArrayList;
import Object.*;

public class World {
	private int[][] world;
	private int X,Y;
	public ArrayList<Object> object;
	public ArrayList<Arbre> tab_Arbre;
	private int nb_arbre;
	private Fenetre f;
	
	public World(int x, int y,int nb_arbre,int dx,int dy) {
		world=new int[x][y];
		X=x;
		Y=y;
		f= new Fenetre(this,dx,dy);
		this.nb_arbre=nb_arbre;
		
		
		object=new ArrayList<Object>();
		tab_Arbre=new ArrayList<Arbre>();
		
		InitWorld();
		if(nb_arbre>x*y) {
			System.out.println("Trop d'arbres par rapport a la taille du monde");
			System.exit(0);
		}
		

	}
	//Initialisation du monde
	/*	
	 *	BUISSON = 1
	 *	ARBRE   = 2
	 *	ROCHER  = 3
	 *	EAU     = 4
	 *	FEU 	= 5
	 */
	public void InitWorld() {
		//Initialisation des arbres
		for(int i=0;i<nb_arbre;i++) {
			int _x=(int)(Math.random()*X);
			int _y=(int)(Math.random()*Y);
			if(world[_x][_y]!=2) {
				world[_x][_y]=2;
				tab_Arbre.add(new Arbre("Arbre",10,_x,_y));
				if(Math.random()<1) {
					tab_Arbre.get(i).setFeu();
					System.out.println(i+"  "+tab_Arbre.get(i).getFeu());
				}
			}else
				i--;
		}
		
		
		for(int y=0;y<Y;y++) {
			for(int x=0;x<X;x++) {
			}
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
		Arbre a=new Arbre("a",0,-1,-1);
		for(int id=0;id<tab_Arbre.size();id++) {
			if(tab_Arbre.get(id).getX()==__x && tab_Arbre.get(id).getY()==__y) {
				return tab_Arbre.get(id);
			}
		}
		return a;
		
	}
	
	public void run() {
		f.setVisible(true);
		while(true) {
			f.getPanneau().repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	//Getters
	public int[][] getWorld() { return world ;}
	public int getX() { return X; }
	public int getY() { return Y; }
	
}
