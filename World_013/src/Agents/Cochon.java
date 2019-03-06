package Agents;
import Default.*;

public class Cochon extends Animal{
	
	private int fecond=5;//nb de case pour etre fecond
	
	public Cochon(int x, int y, World w) {
		super(x,y,w);
		timer=5;
		cpt=0;
	}
	
	public void step() { //bouge selon l'environnement	
		boolean surpopulation = false;
		int s=0;
		for(int i=x-1; i<=x+1; i++) { //on parcourt les cases voisines avec un rayon de 2 cases (voisinage de Moore)
			for(int j=y-1; j<=y+1; j++) {
				if( (i<0) || (j<0) || (i>=w.getX()) && (j>=w.getY())) { //si on sort du tableau, on passe a l'iteration suivante
					continue;
				}else {
					for(int k=0; k<w.tab_Animal.size(); k++) {
						if( (w.tab_Animal.get(k).getX() == i) && (w.tab_Animal.get(k).getY() == j) && (w.tab_Animal.get(k) instanceof Cochon) && (w.tab_Animal.get(k)!=this)) {
							s++;
						}
					}
					if(s>=4) {
						surpopulation = true;
					}
				}
				
			}
		}
		if(surpopulation == true) {
			w.tab_Animal.remove(this);
		}
		
		if(cpt == timer) {
			reproduire++;
			if(vie<25) {
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
		//System.out.print(cpt+" ");
		
		//Meurt
		if(vie<=0 )
			w.tab_Animal.remove(this);
		//System.out.println(vie);
		
		//manger
		if(vie<35) {
			for(int k=0; k < w.tab_Animal.size(); k++) {
				if( (w.tab_Animal.get(k).getX()==x) && (w.tab_Animal.get(k).getY()==y) && (w.tab_Animal.get(k) instanceof Chevre) && Math.random()>0.5 ) { //si ils sont sur la meme case
					w.tab_Animal.remove(k);
					vie=vie+50;
					action=2;
					cpt=cpt-2;
					direction =-1;
				}
			}	
		}

		//reproduction
		if(Math.random()<0.9) {
			for(int k=0; k < w.tab_Animal.size(); k++) {
				if( (w.tab_Animal.get(k).getX()==x) && (w.tab_Animal.get(k).getY()==y) && (w.tab_Animal.get(k) instanceof Cochon) && (w.tab_Animal.get(k) != this) && (reproduire>timer*fecond) && (w.tab_Animal.get(k).getReproduire()>w.tab_Animal.get(k).getTimer()*fecond)) { //si ils sont sur la meme case
					w.tab_Animal.add(new Cochon(x, y, w));
					reproduire=0;
					w.tab_Animal.get(k).setReproduire(0);
					//System.out.println(reproduire);
					break;
				}
			}
		}
	}
	
	public void bouger() { //bouge aléatoirement
		vie--;
		action=1;
		if(w.getWorld()[x][y] == 1) { //si cette animal se trouve sur de l'herbe alors il gagne une vie en mangeant
			vie=vie+6;
			w.getWorld()[x][y]=0;
		}
		//bouge en fonction de sa direction
		if(direction == 0)
			y--;
		else if(direction == 1)
			x++;
		else if(direction == 2)
			y++;
		else if(direction == 3)
			x--;
				
		//initialise la direction pour le prochain mouvement
		//regarde s'il y a de l'herbe dans un rayon de 1 case
		if( (y-1>=0) && w.getWorld()[x][y-1]==1)
			direction=0;
		else if( (x+1<w.getX()) && w.getWorld()[x+1][y]==1)
			direction=1;
		else if( (y+1<w.getY()) && w.getWorld()[x][y+1]==1)
			direction=2;
		else if( (x-1>=0) && w.getWorld()[x-1][y]==1)
			direction=3;
		//sinon regarde s'il y a de l'herbe dans un rayon de 2 cases
		else if( (y-2>=0) && w.getWorld()[x][y-2]==1 && w.getWorld()[x][y-1]!=2 && w.getWorld()[x][y-1]!=3)
			direction=0;
		else if( (x+2<w.getX()) && w.getWorld()[x+2][y]==1 && w.getWorld()[x+1][y]!=2 && w.getWorld()[x+1][y]!=3)
			direction=1;
		else if( (y+2<w.getY()) && w.getWorld()[x][y+2]==1 && w.getWorld()[x][y+1]!=2 && w.getWorld()[x][y+1]!=3)
			direction=2;
		else if( (x-2>=0) && w.getWorld()[x-2][y]==1 && w.getWorld()[x-1][y]!=2 && w.getWorld()[x-1][y]!=3)
			direction=3;
		//s'il n'y a pas d'herbes dans un rayon de 2 cases
		else
			this.direction=(int)(Math.random()*4);
						
		//ne bouge pas si impossible de se deplacer
		if(((direction == 0) && ((y-1<0) || (w.getWorld()[x][y-1]==3) || (w.getWorld()[x][y-1]==2))) //il ne peut pas se trouver sur un rocher ou arbre
		|| ((direction == 1) && ((x+1>=w.getX()) || (w.getWorld()[x+1][y]==3) || (w.getWorld()[x+1][y]==2)))
		|| ((direction == 2) && ((y+1>=w.getY()) || (w.getWorld()[x][y+1]==3) || (w.getWorld()[x][y+1]==2))) 
		|| ((direction == 3) && ((x-1<0) || (w.getWorld()[x-1][y]==3) || (w.getWorld()[x-1][y]==2))))
			direction =-1;
		
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
							
							//deplacement selon direction
							if((direction == 0) && (w.getWorld()[x][y-1]!=3) && (w.getWorld()[x][y-1]!=2))
								y--;
							else if((direction == 1) && (w.getWorld()[x+1][y]!=3) && (w.getWorld()[x+1][y]!=2))
								x++;
							else if((direction == 2) && (w.getWorld()[x][y+1]!=3) && (w.getWorld()[x][y+1]!=2))
								y++;
							else if((direction == 3) && (w.getWorld()[x-1][y]!=3) && (w.getWorld()[x-1][y]!=2))
								x--;

							//initialisation direction
							if(i<x) {     // Si la proie se trouve a gauche par rapport au cochon...
								if(w.getWorld()[x-1][y] != 3 && w.getWorld()[x-1][y] != 2) {
									direction = 3;
								}else
									direction = -1;
								
								if(j<y && w.getWorld()[x][y-1] != 3 && direction == -1 && w.getWorld()[x][y-1] != 2) {		// et si la proie se trouve en haut du cochon.
									direction = 0;
								}
								else if(j>y && w.getWorld()[x][y+1] != 3 && direction == -1 && w.getWorld()[x][y+1] != 2) {	// et si la proie se trouve en bas du cochon
									direction = 2;
								}
							}
							
							else if (i==x) { //Si la proie se trouve sur le meme x que le cochon...
								if(j<y && w.getWorld()[x][y-1] != 3 && w.getWorld()[x][y-1] != 2) {			// et si la proie se trouve en haut
									direction = 0;
								}
								else if(j>y && w.getWorld()[x][y+1] != 3 && w.getWorld()[x][y+1] != 2) {    // et si la proie se trouve en bas 
									direction = 2;
								
								}else
									direction =-1;
							}
							else {			//Si la proie se trouve à droite du cochon...
								if(w.getWorld()[x+1][y] != 3 && w.getWorld()[x+1][y] != 2) {
									direction = 1;
								}else
									direction=-1;
								if(j<y && w.getWorld()[x][y-1] != 3 && direction == -1 && w.getWorld()[x][y-1] != 2) {			// et si la proie se trouve en haut 
									direction = 0;
								}
								else if(j>y && w.getWorld()[x][y+1] != 3 && direction == -1 && w.getWorld()[x][y+1] != 2) {    // et si la proie se trouve en bas 
									direction = 2;
								}
							}
							//vie--;
							return true; //on s'arrete lorsqu'on trouve une proie et on renvoie true.
						}
					}
				}
			}
		}
		return false; //renvoie false s'il n'y a pas de proie a cote.	
	}
	
}
