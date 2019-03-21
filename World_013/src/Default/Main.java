package Default;

import Object.*;
import java.io.IOException;

public class Main {
	public static void main(String[] agrs) throws IOException {

		//Lightning l=new Lightning();
		World w=new World(50,50,20,50,1950,1100); // (largeur_monde, hauteur_monde, nb_arbre, nb_animal, largeur_fenetre,hauteur_fenetre)
		Noise n=new Noise(w);
		for(int x=0;x<50;x++) {
			for(int y=0;y<50;y++) {
				System.out.print(w.alti[x][y]);
			}
			System.out.println();
		}
		//world w=new World(20,20,2,0,1950,1100);
		//w.displayWorld();
		//w.run();
		//w.l.deleteImage();
	}
}
