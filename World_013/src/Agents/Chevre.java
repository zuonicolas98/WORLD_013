package Agents;
import Default.*;

public class Chevre extends Animal{
	
	private int fecond=5;//nb de case pour etre fecond
	public static int nb_chevre = 0;
	
	public Chevre(int x, int y, World w) {
		super(x,y,w);
		timer=4;
		cpt=0;
		vie=400;
		nb_chevre++;
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
						if( (w.tab_Animal.get(k).getX() == i) && (w.tab_Animal.get(k).getY() == j) && (w.tab_Animal.get(k) instanceof Chevre) && (w.tab_Animal.get(k)!=this)) {
							s++;
						}
					}
					if(s>=5) {
						surpopulation = true;
					}
				}
				
			}
		}
		if(surpopulation == true) {
			nb_chevre--;
			w.tab_Animal.remove(this);
		}
		
		if(cpt == timer) {
			reproduire++;
			boolean f=false;
			if(Math.random()<0.8) //80% qu'il fuit
				f=this.fuir();
			if(f==false) { //s'il ne fuit pas
				if(vie<200) { //commence à chasser ses proies 
					if(this.chasser() == false) { //on le fait bouger si il n'a pas trouve de proie (il ne bouge pas avec chasser() s'il n'y a pas de proie).
						this.bouger();
					}
				}else { //s'il n'a pas faim et s'il ne fuit pas alors il bouge normalement 
					this.bouger();
				}
			}
			cpt=0;
		}else {
			cpt++;
		}
		
		//Meurt
		if(vie<=0) {
			nb_chevre--;
			w.tab_Animal.remove(this);
		}
		//System.out.println(vie);
		
		
		//manger
		manger();
		
		//reproduction
		if(Math.random()<0.8 && nb_chevre<40) {
			for(int k=0; k < w.tab_Animal.size(); k++) {
				if( (w.tab_Animal.get(k).getX()==x) && (w.tab_Animal.get(k).getY()==y) && (w.tab_Animal.get(k) instanceof Chevre) && (w.tab_Animal.get(k) != this) && (reproduire>timer*fecond) && (w.tab_Animal.get(k).getReproduire()>w.tab_Animal.get(k).getTimer()*fecond)) {  //si ils sont sur la meme case
					w.tab_Animal.add(new Chevre(x, y, w));
					reproduire=0;
					w.tab_Animal.get(k).setReproduire(0);
					//System.out.println(reproduire);
					break;
				}
			}
		}
	}
	
	public void manger() {
		if(vie<300) { //commence à manger
			for(int k=0; k < w.tab_Animal.size(); k++) {
				if((Math.random()<0.7) && (w.tab_Animal.get(k) instanceof Lapin) && (((w.tab_Animal.get(k).getX()==x) && (w.tab_Animal.get(k).getY()==y)) 		//si ils sont sur la meme case
															|| ((w.tab_Animal.get(k).getX()==x-1) && (w.tab_Animal.get(k).getY()==y))		//si la proie est a gauche
															|| ((w.tab_Animal.get(k).getX()==x+1) && (w.tab_Animal.get(k).getY()==y))		//si la proie est a droite
															|| ((w.tab_Animal.get(k).getX()==x) && (w.tab_Animal.get(k).getY()==y-1))		//si la proie est en haut
															|| ((w.tab_Animal.get(k).getX()==x) && (w.tab_Animal.get(k).getY()==y+1))) ) {  //si la proie est en bas
					nb_chevre--;
					w.tab_Animal.remove(k);
					vie=vie+50;
					action=2;
					cpt=cpt-2;
					direction =-1;
				}
			}
		}
		
	}
	
	public void bouger() { //bouge aléatoirement
		action=1;
		vie--;
		if(w.getWorld()[x][y] == 1) { //si cette animal se trouve sur de l'herbe alors il gagne une vie en mangeant
			vie=vie+5;
			w.getWorld()[x][y]=0;
			//System.out.println(vie);
		}
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
		if(((direction == 0) && ((y-1<0) || (w.getWorld()[x][y-1]==3) || (w.getWorld()[x][y-1]==2) || (w.getNoise().alti[x][y-1]==-1) || (w.getNoise().alti[x][y]!=w.getNoise().alti[x][y-1] ) || (w.rebord(x, y-1)==1) )) //il ne peut pas se trouver sur un rocher ou arbre
		|| ((direction == 1) && ((x+1>=w.getX()) || (w.getWorld()[x+1][y]==3) || (w.getWorld()[x+1][y]==2) || (w.getNoise().alti[x+1][y]==-1) || (w.getNoise().alti[x][y]!=w.getNoise().alti[x+1][y] ) || (w.rebord(x+1, y)==1) || (x+2<w.getX() && y+1<w.getY() && w.n.alti[x+1][y]!=w.n.alti[x+2][y+1] ) ))
		|| ((direction == 2) && ((y+1>=w.getY()) || (w.getWorld()[x][y+1]==3) || (w.getWorld()[x][y+1]==2) || (w.getNoise().alti[x][y+1]==-1) || (w.getNoise().alti[x][y]!=w.getNoise().alti[x][y+1] ) || (w.rebord(x, y+1)==1) || (x-1>=0 && y+2<w.getY() && w.n.alti[x][y+1]!=w.n.alti[x-1][y+2] ) || (x+1<w.getX() && y+2<w.getY() && w.n.alti[x][y+1]!=w.n.alti[x+1][y+2] ) )) 
		|| ((direction == 3) && ((x-1<0) || (w.getWorld()[x-1][y]==3) || (w.getWorld()[x-1][y]==2) || (w.getNoise().alti[x-1][y]==-1) || (w.getNoise().alti[x][y]!=w.getNoise().alti[x-1][y] ) || (w.rebord(x-1, y)==1) || (x-2>=0 && y+1<w.getY() && w.n.alti[x-1][y]!=w.n.alti[x-2][y+1] ) )) ) {		
			
			direction =-1;
				
		}
		
	}	
	public boolean chasser() { //cherche une proie dans son environnement
		action=1;
		for(int i=x-2; i<=x+2; i++) { //on parcourt les cases voisines de la chevre avec un rayon de 2 cases (voisinage de Moore)
			for(int j=y-2; j<=y+2; j++) {
				if( (i<0) || (j<0) || (i>=w.getX()) && (j>=w.getY())) { //si on sort du tableau, on passe a l'iteration suivante
					continue;
					
				}else { //si on ne sort pas du tableau
					for(int k=0; k<w.tab_Animal.size(); k++) { //parcours de la liste d'animaux
						if( (w.tab_Animal.get(k).getX() == i) && (w.tab_Animal.get(k).getY() == j) && (w.tab_Animal.get(k) instanceof Lapin)) { //on trouve une proie dans un rayon de 2 cases
							
							//deplacement selon direction
							if(direction == 0)
								y--;
							else if(direction == 1)
								x++;
							else if(direction == 2)
								y++;
							else if(direction == 3)
								x--;
							
							//initialisation direction
							if(i<x) {     // Si la proie se trouve a gauche par rapport à la chevre...
								if(w.getWorld()[x-1][y] != 3 && w.getWorld()[x-1][y] != 2 && (w.n.alti[x-1][y]!=-1)) {
									direction = 3;
								}else
									direction = -1;
								
								if(j<y && w.getWorld()[x][y-1] != 3 && direction == -1 && w.getWorld()[x][y-1] !=2 && (w.n.alti[x][y-1]!=-1)) {		// et si la proie se trouve en haut de la chevre.
									direction = 0;
								}
								else if(j>y && w.getWorld()[x][y+1] != 3 && direction == -1 && w.getWorld()[x][y+1] !=2 && (w.n.alti[x][y+1]!=-1)) {	// et si la proie se trouve en bas de la chevre.
									direction = 2;
								}
							}
							
							else if (i==x) { //Si la proie se trouve sur le meme x que la chevre...
								if(j<y && w.getWorld()[x][y-1] != 3 && w.getWorld()[x][y-1] != 2 && (w.n.alti[x][y-1]!=-1)) {			// et si la proie se trouve en haut de la chevre.
									direction = 0;
								}
								else if(j>y && w.getWorld()[x][y+1] != 3 && w.getWorld()[x][y+1] != 2 && (w.n.alti[x][y+1]!=-1)) {    // et si la proie se trouve en bas de la chevre.
									direction = 2;
								
								}else
									direction =-1;
							}
							else {			//Si la proie se trouve à droite de la chevre...
								if(w.getWorld()[x+1][y] != 3) {
									direction = 1;
								}else
									direction=-1;
								if(j<y && w.getWorld()[x][y-1] != 3 && direction == -1 && w.getWorld()[x][y-1] !=2 && (w.n.alti[x][y-1]!=-1)) {			// et si la proie se trouve en haut de la chevre.
									direction = 0;
								}
								else if(j>y && w.getWorld()[x][y+1] != 3 && direction == -1 && w.getWorld()[x][y+1] !=2 && (w.n.alti[x][y+1]!=-1)) {    // et si la proie se trouve en bas de la chevre.
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
	
	public boolean fuir() { //fuit un predateur dans son environnement
		action=1;
		for(int i=x-2; i<=x+2; i++) { //on parcourt les cases voisines a la chèvre avec un rayon de 2 cases (voisinage de Moore)
			for(int j=y-2; j<=y+2; j++) {
				if( (i<0) || (j<0) || (i>=w.getX()) && (j>=w.getY())) { //si on sort du tableau, on passe a l'iteration suivante
					continue;
					
				}else { //si on ne sort pas du tableau
					for(int k=0; k<w.tab_Animal.size(); k++) { //parcours de la liste d'animaux
						if( (w.tab_Animal.get(k).getX() == i) && (w.tab_Animal.get(k).getY() == j) && (w.tab_Animal.get(k) instanceof Cochon)) { //on trouve un predateur dans un rayon de 2 cases
							
							//deplacement selon direction
							if(direction == 0)
								y--;
							else if(direction == 1)
								x++;
							else if(direction == 2)
								y++;
							else if(direction == 3)
								x--;

							//initialisation direction
							if(i<x) {     // Si le predateur se trouve a gauche par rapport a la chèvre...
								if(x+1<w.getX() && w.getWorld()[x+1][y] != 3 && w.getWorld()[x+1][y] != 2 && (w.n.alti[x+1][y]!=-1)) {
									direction = 1;
								}else
									direction = -1;
								
								if(j<y && y+1<w.getY() && w.getWorld()[x][y+1] != 3 && direction == -1 && w.getWorld()[x][y+1] != 2 && (w.n.alti[x][y+1]!=-1)) {		// et si le predateur se trouve en haut de la chèvre.
									direction = 2;
								}
								else if(j>y && y-1>=0 && w.getWorld()[x][y-1] != 3 && direction == -1 && w.getWorld()[x][y-1] != 2 && (w.n.alti[x][y-1]!=-1)) {	// ou si le predateur se trouve en bas de la chèvre
									direction = 0;
								}
							}
							
							else if (i==x) { //Si le predateur se trouve sur le meme x que la chèvre...
								if(j<y && y+1<w.getY() && w.getWorld()[x][y+1] != 3 && w.getWorld()[x][y+1] != 2 && (w.n.alti[x][y+1]!=-1)) {			// et si le predateur se trouve en haut
									direction = 2;
								}
								else if(j>y && y-1>=0 && w.getWorld()[x][y-1] != 3 && w.getWorld()[x][y-1] != 2 && (w.n.alti[x][y-1]!=-1)) {    // et si le predateur se trouve en bas 
									direction = 0;
								
								}else
									direction =-1;
							}
							else {			//Si le predateur se trouve à droite a la chèvre...
								if(x-1>=0 && w.getWorld()[x-1][y] != 3 && w.getWorld()[x-1][y] != 2 && (w.n.alti[x-1][y]!=-1)) {
									direction = 3;
								}else
									direction=-1;
								if(j<y && y+1<w.getY() && w.getWorld()[x][y+1] != 3 && direction == -1 && w.getWorld()[x][y+1] != 2 && (w.n.alti[x][y+1]!=-1)) {			// et si le predateur se trouve en haut 
									direction = 2;
								}
								else if(j>y && y-1>=0 && w.getWorld()[x][y-1] != 3 && direction == -1 && w.getWorld()[x][y-1] != 2 && (w.n.alti[x][y-1]!=-1)) {    // et si le predateur se trouve en bas 
									direction = 0;
								}
							}
							//vie--;
							return true; //on s'arrete lorsqu'on trouve un predateur et on renvoie true.
						}
					}
				}
			}
		}
		return false; //renvoie false s'il n'y a pas de predateur a cote.	
	}
	public int getNb_chevre() { return nb_chevre;}

	
}
