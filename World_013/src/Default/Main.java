package Default;

import Object.*;
import java.io.IOException;
import java.awt.Dimension;

public class Main {
	public static void main(String[] agrs) throws IOException {
		int hauteur;//=400 max
		int largeur=hauteur=50;//640 max
		//Lightning l=new Lightning();
		//Noise n=new Noise(largeur,hauteur);
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		World w=new World(largeur,hauteur,0,0,2,width,height); // (largeur_monde, hauteur_monde, nb_arbre, nb_animal,nb_de_volcan_a_la_foix_max, largeur_fenetre,hauteur_fenetre)
		/*System.out.println("---------MAP EN INT---------");
		for(int x=0;x<largeur;x++) {
			for(int y=0;y<hauteur;y++) {
				System.out.print(w.n.alti[y][x]);
			}
			System.out.println();
		}
		System.out.println("---------MAP EN INT---------");*/
		//world w=new World(20,20,2,0,1950,1100);
		w.displayWorld();
		w.run();
		w.l.deleteImage();
	}
}
