package Default;

import java.util.ArrayList;

public class Volcan {
	protected World w;
	private int alti_max=-2;
	private boolean volcan=false;
	private int change=2;
	private int cpt=0;
	private int x_max=0,y_max=0;
	private int montee;
	private ArrayList<Coor> max_alt;
	public ArrayList<Projectille> tab_P=new ArrayList<Projectille>();
	
	public Volcan(World w){
		max_alt=new ArrayList<Coor>();
		this.w=w;
		montee=1;
		RecherchePlusHautAlti();
	}
	public Volcan(World w,String n){
		this.w=w;
		montee=1;
		RechercheAleatoireAlti();
	}

	public void step() {
		if(volcan) {
			
			if(cpt==1000) {
				w.tab_Volcan.remove(this);
			}else {
				if(cpt%50==0) {
					//System.out.println("New P");
					tab_P.add(new Projectille(x_max,y_max,w));
				}
			}
		}else {
			if(cpt==100) {
				if(alti_max<10) {
					alti_max++;
					for(int x=x_max-change ; x <= x_max+change ; x++) {
						for(int y=y_max-change ; y <= y_max+change ; y++) {
							if(y>=0 && y<w.getY() && x>=0 && x<w.getX() ){
								if(w.n.alti[x][y]<9 && w.n.alti[x][y]<alti_max)
								w.n.alti[x][y]++;
								w.world[x][y]=0;
							}
						}
					}

					change++;

					/*System.out.println("---------MAP EN INT---------");
					for(int x=0;x<w.getX();x++) {
						for(int y=0;y<w.getY();y++) {
							System.out.print(w.n.alti[y][x]);
						}
						System.out.println();
					}
					System.out.println("---------MAP EN INT---------");*/
				}else
					volcan=true;
				cpt=0;
			}
		}
		cpt++;
	}
	
	public void ecoulement() {	
		//manière asynchrone randomisée
		for(int i=0;i<200;i++) { //on cherche aléatoirement plusieurs cases 
			int x=(int)(Math.random()*(w.getX()));
			int y=(int)(Math.random()*(w.getY()));
			int v=(int)(Math.random()*4); //on cherche un voisin aléatoirement
			switch(v) {
				case 0:
					if(y-1>=0 && w.liquide[x][y-1]>0 && (w.n.alti[x][y]<w.n.alti[x][y-1] || (Math.random()<0.1 && w.liquide[x][y-1]>1 && w.n.alti[x][y]==w.n.alti[x][y-1] ))) {
						w.liquide[x][y]++;
						w.liquide[x][y-1]--;
					}
					break;
				case 1:
					if(x+1<w.getX() && w.liquide[x+1][y]>0 && (w.n.alti[x][y]<w.n.alti[x+1][y] || (Math.random()<0.1 && w.liquide[x+1][y]>1 && w.n.alti[x][y]==w.n.alti[x+1][y] ))) { 
						w.liquide[x][y]++;
						w.liquide[x+1][y]--;
					}
					break;
				case 2:
					if(y+1<w.getY() && w.liquide[x][y+1]>0 && (w.n.alti[x][y]<w.n.alti[x][y+1] || (Math.random()<0.1 && w.liquide[x][y+1]>1 && w.n.alti[x][y]==w.n.alti[x][y+1] ))) {
						w.liquide[x][y]++;
						w.liquide[x][y+1]--;
					}
					break;			
				case 3:
					if(x-1>=0 && w.liquide[x-1][y]>0 && (w.n.alti[x][y]<w.n.alti[x-1][y] || (Math.random()<0.1 && w.liquide[x-1][y]>1 && w.n.alti[x][y]==w.n.alti[x-1][y] ))) {
						w.liquide[x][y]++;
						w.liquide[x-1][y]--;
					}
					break;
				default:;
		}
				
		}
		
	}
	
	public void retirerlave() {

		for(int y=0;y<w.getY();y++) {
			for(int x=0;x<w.getX();x++) {
				if(w.liquide[x][y]>0 && w.n.alti[x][y]==-1)
					w.n.alti[x][y]=0;
				if(w.liquide[x][y]>0) {
					w.liquide[x][y]=0;
					if(w.liquide[x][y]==0)
						w.world[x][y]=-1;
				}
			}
		}
	}
	
	
	public void RechercheAleatoireAlti() {
		x_max=(int)(Math.random()*w.getX());
		y_max=(int)(Math.random()*w.getY());
		while(w.n.alti[x_max][y_max]>8) {
			x_max=(int)(Math.random()*w.getX());
			y_max=(int)(Math.random()*w.getY());
		}
		alti_max=w.n.alti[x_max][y_max];
	}
	
	public void RecherchePlusHautAlti() {
		for(int y=0;y<w.getY();y++) {
			for(int x=0;x<w.getX();x++) {
				if(w.n.alti[x][y]>alti_max) {
					alti_max=w.n.alti[x][y];
				}
			}
		}
		for(int y=0;y<w.getY();y++) {
			for(int x=0;x<w.getX();x++) {
				if(w.n.alti[x][y]==alti_max) {
					max_alt.add(new Coor(x,y,w.n.alti[x][y]));
				}
			}
		}
		int x=(int)(Math.random()*max_alt.size());
		//System.out.println(x+" "+max_alt.size()+" "+alti_max);
		Coor var=max_alt.get(x);
		x_max=var.x;
		y_max=var.y;
	}
	public int getMontee() {return montee;}
	public void setMontee(int m) {montee=m;}
}
