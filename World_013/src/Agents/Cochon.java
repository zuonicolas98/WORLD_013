package Agents;
import Default.*;

public class Cochon extends Animal{
	private int timer, cpt;
	
	public Cochon(int x, int y, World w) {
		super(x,y,w);
		timer=2;
		cpt=0;
	}
	
	public void step() { //bouge selon l'environnement
		if(cpt == timer) {
			if(vie<10) {
				if(this.chasser() == false) { //on le fait bouger si il n'a pas trouve de proie (il ne bouge pas avec chasser() s'il n'y a pas de proie).
					this.bouger();
				}
			}else {
				this.bouger();
			}
			cpt=0;
		}else {
			cpt++;
		}
		
		if(vie<=0)
			w.tab_Animal.remove(this);
		//System.out.println(vie);
	}
	
	public void bouger() { //bouge aléatoirement
		vie--;
		action=1;
		boolean b = true; //boolean pour l'arret boucle while
		int c=0; //2 tentatives de deplacement
		
		if(w.getWorld()[x][y] == 1) //si cette animal se trouve sur de l'herbe alors il gagne une vie en mangeant
			vie++;

		
		while(b==true && c<2 ) {
			this.direction=(int)(Math.random()*4);
			switch(direction) {
				case 0: 
					if( (y-1>=0) && (w.getWorld()[x][y-1] != 3)) { //s'il ne sort pas du tableau vers le haut && on peut y aller
						y--;
						b=false;
					}
					break;
					
				case 1:
					if( (x+1<w.getX()) && (w.getWorld()[x+1][y] != 3)) { //s'il ne sort pas du tableau vers la droite && on peut y aller
						x++;
						b=false;
					}
					break;
					
				case 2:
					if( (y+1<w.getY()) && (w.getWorld()[x][y+1] != 3)) { //s'il ne sort pas du tableau vers le bas && on peut y aller
						y++;
						b=false;
					}
					break;
				case 3:
					if( (x-1>=0) && (w.getWorld()[x-1][y] != 3)) { //s'il ne sort pas du tableau vers la gauche && on peut y aller
						x--; 
						b=false;
					}
					break;
				default: System.out.println("ERREUR DE DIRECTION");
			}	
			c++;
		}
		
		if(b) //s'il n'a pas reussi a bouger
			direction=-1;
		
	}	
	public boolean chasser() { //cherche une proie dans son environnement
		action=1;
		for(int i=x-2; i<=x+2; i++) { //on parcourt les cases voisines du cochon avec un rayon de 2 cases (voisinage de Moore)
			for(int j=y-2; j<=y+2; j++) {
				if( (i<0) || (j<0) || (i>=w.getX()) && (j>=w.getY())) { //si on sort du tableau, on passe a l'iteration suivante
					continue;
					
				}else { //si on ne sort pas du tableau
					for(int k=0; k<w.tab_Animal.size(); k++) { //parcours de la liste d'animaux
						if( (w.tab_Animal.get(k).getX() == i) && (w.tab_Animal.get(k).getY() == j) && (w.tab_Animal.get(k) instanceof Chevre)) { //on trouve une proie dans un rayon de 2 cases
							if(i<x) {     // Si la proie se trouve a gauche du cochon...
								if(w.getWorld()[x-1][y] != 3) {
									x--;
									direction = 3;
								}else
									direction = -1;
								
								if(j<y && w.getWorld()[x][y-1] != 3 && direction == -1)	{	// et si la proie se trouve en haut du cochon.
									y--;
									direction = 0;
								}
								else if(j>y && w.getWorld()[x][y+1] != 3 && direction == -1) {	// et si la proie se trouve en bas du cochon.
									y++;
									direction = 2;
								}
							}
							
							else if (i==x) { //Si la proie se trouve sur le meme x que le cochon...
								if(j<y && w.getWorld()[x][y-1] != 3)	{		// et si la proie se trouve en haut du cochon.
									y--;
									direction = 0;
								}
								else if(j>y && w.getWorld()[x][y+1] != 3) {   // et si la proie se trouve en bas de du cochon.
									y++;
									direction = 2;
								}else if( (i==x) && (j==y )) { //si ils sont sur la meme case
									w.tab_Animal.remove(k);
									vie=20;
									action=2;
									cpt=cpt-2;
									direction=-1;
								}
								else
									direction=-1;
							}
							else {			//Si la proie se trouve à droite de du cochon...
								if(w.getWorld()[x+1][y] != 3) {
									x++;
									direction = 1;
								}
								else
									direction=-1;
								if(j<y && w.getWorld()[x][y-1] != 3 && direction == -1)	{		// et si la proie se trouve en haut de du cochon.
									y--;
									direction = 0;
								}
								else if(j>y && w.getWorld()[x][y+1] != 3 && direction == -1 ) {    // et si la proie se trouve en bas de du cochon.
									y++;
									direction = 2;
								}
							}
							vie--;
							return true; //on s'arrete lorsqu'on trouve une proie et on renvoie true.
						}
					}
				}
			}
		}
		return false; //renvoie false s'il n'y a pas de proie a cote.	
	}
	
	
}
