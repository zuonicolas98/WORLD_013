package Default;

public class Main {
	public static void main(String[] agrs) {
	
		World w=new World(20,20,20,5,700,500); // (largeur_monde, hauteur_monde, nb_arbre, nb_animal, largeur_fenetre,hauteur_fenetre)
		//w.displayWorld();
		w.run();
	}
}
