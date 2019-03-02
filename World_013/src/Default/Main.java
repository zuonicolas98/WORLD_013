package Default;

public class Main {
	public static void main(String[] agrs) {
	
		World w=new World(25,25,10,30,1500,800); // (largeur_monde, hauteur_monde, nb_arbre, nb_animal, largeur_fenetre,hauteur_fenetre)
		//w.displayWorld();
		w.run();
	}
}
