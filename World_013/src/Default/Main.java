package Default;

public class Main {
	public static void main(String[] agrs) {
	
		World w=new World(23,23,10,10,800,600); // (largeur_monde, hauteur_monde, nb_arbre, nb_animal, largeur_fenetre,hauteur_fenetre)
		//w.displayWorld();
		w.run();
	}
}
