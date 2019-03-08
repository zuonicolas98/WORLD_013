package Default;

import Object.*;
import java.io.IOException;

public class Main {
	public static void main(String[] agrs) throws IOException {

		//Lightning l=new Lightning();
		World w=new World(50,50,80,20,1950,1100); // (largeur_monde, hauteur_monde, nb_arbre, nb_animal, largeur_fenetre,hauteur_fenetre)
		//World w=new World(20,20,2,0,1950,1100);
		w.displayWorld();
		w.run();
	}
}
