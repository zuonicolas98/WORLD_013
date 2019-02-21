import java.util.ArrayList;
import Object.*;

public class World {
	private int[][] world;
	private int X,Y;
	public ArrayList<Object> object;
	public ArrayList<Arbre> tab_Arbre;
	private int nb_arbre;
	public World(int x, int y,int nb_arbre) {
		world=new int[x][y];
		X=x;
		Y=y;
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
	 */
	public void InitWorld() {
		//Initialisation des arbres
		for(int i=0;i<nb_arbre;i++) {
			int _x=(int)(Math.random()*X);
			int _y=(int)(Math.random()*Y);
			if(world[_x][_y]!=1) {
				world[_x][_y]=1;
				tab_Arbre.add(new Arbre("Arbre",10,_x,_y));
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
				System.out.print(world[x2][y2]);
			}
			System.out.println();
		}
	}
	
	//Getters
	public int[][] getWorld() { return world ;}
	public int getX() { return X; }
	public int getY() { return Y; }
	
}
