package Object;

import Default.*;

public class Cloud {
	private World w;
	private int[][] alti;
	private int age;
	private int vie;
	private boolean mature=false;
	private boolean flag=false;
	private int x,y;
	public int ombre_x,ombre_y;
	public boolean pluie=false;
	public boolean foudre=false;
	public boolean fin_vie=false;
	private static int cpt_pluie=0;
	private int cpt=0;
	private int direction;
	private int ancien=-10;
	private int duree_pluie=20;
	public int duree_foudre=2;
	public int duree_instant=0;
	
	public Cloud(int x,int y,int age,World w) {
		this.w=w;
		this.alti=w.n.alti;
		this.x=x;
		this.y=y;
		this.age=age;
		if(w.getX()*2<20)
			vie=30;
		else
			vie=w.getX()*2;
		ombre_x=x;
		int d=(int)(Math.random()*2);
		if(d==0)
			direction=1;
		else
			direction=3;
		if(alti[x][y]>6 ) {
			System.out.println("Mauvaise initialisation des nuages");
			System.exit(0);
		}
		if(alti[x][y]==-1 || y+10<w.getY()) {
			ombre_y=y+10;
		}
		ombre_y=y+10-alti[x][ombre_y];
		if(age==10) {
			mature=true;
		}
	}
	
	public void step() {
		if(mature==false) {
			if (cpt>=10) {
				cpt=0;
				age++;
				if(age>=10)
					mature=true;
			}
			else
				cpt++;
		}else {
			if(cpt==50 ) {
				//--------PLUIE
				cpt=0;
				if(w.tab_Arbre.size() < w.getX()*w.getY()/10 && // faire quand ils manquent d'arbres
						//x!=-1 && x-1>=0 && //erreur sur les coté de la map
						cpt_pluie < w.getX()/20 && //pour pas que tout les arbres pleuvent d'un coup
						alti[x][ombre_y]>=0 && // verifier que c pas dans l'eau sur montagne
						pluie==false && //pour ne pas rerentrer dedans
						foudre==false &&
						fin_vie==false &&
						alti[x+1][ombre_y]==alti[x][ombre_y] && alti[x-1][ombre_y]==alti[x][ombre_y] && //pour ne pas afficher sur sur un relief
								Math.random()<0.05)//prob qui pleut 
				{
					//System.out.println(cpt_pluie);
					cpt_pluie++;
					pluie=true;
				}
				//--------FOUDRE
				if(w.tab_Arbre.size() > w.getX()*2 && // faire quand ils manquent d'arbres
						w.RechercheArbres(x,ombre_y).getX()!=-1 &&
						Math.random()<0.01*(w.tab_Cloud.size()) &&
						fin_vie==false &&
						pluie==false
						)
				{
					foudre=true;
				}
				
				if(foudre) {
					duree_instant++;
					if(duree_instant==duree_foudre/2)
					{
						w.RechercheArbres(x,ombre_y).setFeu(true);
					}
					if(duree_instant==duree_foudre) {
						w.tab_Cloud.remove(this);
					}
				}
				
				if(pluie) {
					duree_instant++;
					if(duree_instant==duree_pluie/2)
					{
						w.world[x][ombre_y]=2;
						int t=(int)(Math.random()*2);
						if(t==0)
							w.tab_Arbre.add(new Arbre("Pommier",30,x,ombre_y, w));
						else
							w.tab_Arbre.add(new Arbre("Cocotier",30,x,ombre_y, w));
					}
					if(duree_instant==duree_pluie) {
						cpt_pluie--;
						w.tab_Cloud.remove(this);
					}
				}
				if(pluie==false && foudre==false && fin_vie==false ) {
					
					if(	x+1>=w.getX()-1 || x-1<=1) {
						this.changeDirection();
					}
					//if(Math.random()<0.05 && flag==true)
						//this.changeDirection();
				
					if(direction==1) {
						if(alti[x+1][ombre_y]>=-1 && alti[x+1][ombre_y]<=6 ) {
						//System.out.println("x = "+x+" ombre_y = "+ombre_y);
						if( x!=-1 && ancien!=alti[x][ombre_y]) {
							ancien=-10;
						}
						if( x!=-1 && alti[x][ombre_y]<alti[x+1][ombre_y] && ancien==-10) {
							ancien=alti[x][ombre_y];
							ombre_y=ombre_y-1;
						}else if( x!=-1 && ((alti[x][ombre_y]!=-1 && alti[x+1][ombre_y]==-1) || alti[x][ombre_y]>alti[x+1][ombre_y] ) && ancien==-10){
							ancien=alti[x][ombre_y];
							ombre_y=ombre_y+1;
						}
						ombre_x=ombre_x+1;
						x=x+1;
						}else
							this.changeDirection();
					}else if(direction==3) {
						if(alti[x-1][ombre_y]>=-1 && alti[x+1][ombre_y]<=6) {
						if(ancien!=alti[x][ombre_y]) {
							ancien=-10;
						}
						if(x-1>=0 && alti[x][ombre_y]<alti[x-1][ombre_y] && ancien==-10) {
							ancien=alti[x][ombre_y];
							ombre_y=ombre_y-1;
						}else if(x-1>=0 &&((alti[x][ombre_y]!=-1 && alti[x-1][ombre_y]==-1) || alti[x][ombre_y]>alti[x-1][ombre_y]) && ancien==-10){		
							ancien=alti[x][ombre_y];
							ombre_y=ombre_y+1;
						}
						ombre_x=ombre_x-1;
						x=x-1;
						}else
							this.changeDirection();
					}
					cpt=0;
					flag=true;
				}
				vie--;
			}
			else {
				cpt++;
			}
		}
		if(vie>0 && vie<=5 && pluie==false && foudre ==false) {
			
			fin_vie=true;
			if(alti[x][ombre_y]>=0)
				w.world[x][ombre_y]=-1;
			if(w.RechercheArbres(x,ombre_y).getX()!=-1)
				w.RechercheArbres(x,ombre_y).setFeu(true);
			for(int x_bis=x-1;x_bis<=x+1;x_bis++) {
				int a=w.RechercheAnimal(x_bis, ombre_y);
				if(a!=-1)
					w.tab_Animal.remove(a);
			}
		}else if(vie<=0 && pluie==false && foudre ==false) {
			w.tab_Cloud.remove(this);
		}

	}
	
	public void changeDirection() {
		flag=false;
		if(direction==1)
			direction=3;
		else
			direction=1;
	}
	public int getCpt() {
		return cpt;
	}
	public int getX() {return this.x;}
	public int getY() {return this.y;}
	public int getDirection() {return direction;}
	public boolean getMature() { return mature;}
	public int getAge() { return age;}
	
	
}

