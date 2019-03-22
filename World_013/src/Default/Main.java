package Default;

import Object.*;
import java.io.IOException;

public class Main {
	public static void main(String[] agrs) throws IOException {
		int largeur=50;
		int hauteur=50;
		//Lightning l=new Lightning();
		//Noise n=new Noise(largeur,hauteur);
		World w=new World(largeur,hauteur,20,50,1300,800); // (largeur_monde, hauteur_monde, nb_arbre, nb_animal, largeur_fenetre,hauteur_fenetre)

		/*for(int x=0;x<50;x++) {
			for(int y=0;y<50;y++) {
				System.out.print(w.alti[x][y]);
			}
			System.out.println();
		}*/
		//world w=new World(20,20,2,0,1950,1100);
		w.displayWorld();
		w.run();
		w.l.deleteImage();
	}
}
