package Agents;
import Default.*;

public class Cochon extends Animal{
	
	public Cochon(int x, int y, World w) {
		super(x,y,w);
		
	}
	
	public void step() { //bouge selon l'environnement
		if(vie<10) {
			if(this.chasser() == false)
				this.bouger();
		}else
			this.bouger();
	}
	public void bouger() { //bouge aléatoirement
		vie--;
		boolean b = true;
		
		do {
			this.direction=(int)(Math.random()*4);
			switch(direction) {
				case 0: 
					if( (y-1>=0) && (w.getWorld()[x][y-1] != 2)) { //s'il ne sort pas du tableau vers le haut && on peut y aller
						y--;
						b=false;
					}
					break;
					
				case 1:
					if( (x+1<w.getX()) && (w.getWorld()[x+1][y] != 2)) { //s'il ne sort pas du tableau vers la droite && on peut y aller
						x++;
						b=false;
					}
					break;
					
				case 2:
					if( (y+1<w.getY()) && (w.getWorld()[x][y+1] != 2)) { //s'il ne sort pas du tableau vers le bas && on peut y aller
						y++;
						b=false;
					}
					break;
				case 3:
					if( (x-1>=0) && (w.getWorld()[x-1][y] != 2)) { //s'il ne sort pas du tableau vers la gauche && on peut y aller
						x--; 
						b=false;
					}
					break;
				default: System.out.println("Erreur de direction");
			}	
		}while(b);
		
	}	
	public boolean chasser() {
		vie--;
		boolean b=false;
		int unique=0; //on ne regarde qu'une proie
		
		for(int i=x-2; i<=x+2; i++) { //on parcourt les cases voisines du cochon avec un rayon de 2 cases (voisinage de Moore)
			for(int j=y-2; j<=y+2; j++) {
				if( (i<0) || (j<0) || (i>=w.getX()) && (j>=w.getY())) { //si on sort du tableau, on passe a l'iteration suivante
					continue;
					
				}else { //si on ne sort pas du tableau
					for(int k=0; k<w.tab_Animal.size(); k++) { //parcours de la liste d'animaux
						if( (unique==0) && (w.tab_Animal.get(k).getX() == i) && (w.tab_Animal.get(k).getY() == j) && (w.tab_Animal.get(k) instanceof Chevre)) { //on trouve une proie dans un rayon de 2 cases
							b=true;
							unique=1;
							if(i<x) {     // Si la proie se trouve a gauche du cochon...
								x--;
								direction = 3;
								if(j<y)	{	// et si la proie se trouve en haut du cochon.
									y--;
									direction = 0;
								}
								else if(j>y) {	// et si la proie se trouve en bas du cochon.
									y++;
									direction = 2;
								}
							}
							else if (i==x) { //Si la proie se trouve sur le meme x que le cochon...
								if(j<y)	{		// et si la proie se trouve en haut du cochon.
									y--;
									direction = 0;
								}
								else if(j>y) {   // et si la proie se trouve en bas de du cochon.
									y++;
									direction = 2;
								}else { //si ils sont sur la meme case
									w.tab_Animal.remove(k);
									vie=20;
								}
							}
							else {			//Si la proie se trouve à droite de du cochon...
								x++;
								direction = 1;
								if(j<y)	{		// et si la proie se trouve en haut de du cochon.
									y--;
									direction = 0;
								}
								else if(j>y) {    // et si la proie se trouve en bas de du cochon.
									y++;
									direction = 2;
								}
							}
						}
					}
				}
			}
		}
		return b; //renvoie true si une proie est trouve, false sinon.	
	}
	
	public void fuir() { //fuis un prédateur dans son environnement ( à voir si on le fait car on ne pourra jamais l'attraper sinon)
	
	
	}
	
}
