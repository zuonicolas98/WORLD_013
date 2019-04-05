package Default;

import java.util.ArrayList;

public class Volcan {
	protected World w;
	private int alti_max=-2;
	public int[][] liquide;
	private boolean volcan=false;
	private boolean mort=false,zombie=false;
	private int change=2;
	private int cpt=0;
	private int x_max=0,y_max=0;
	private int montee;
	private ArrayList<Coor> max_alt;
	public ArrayList<Projectille> tab_P=new ArrayList<Projectille>();
	
	public Volcan(World w){
		max_alt=new ArrayList<Coor>();
		liquide=new int[w.getX()][w.getY()];
		this.w=w;
		montee=1;
		RecherchePlusHautAlti();
		for(int x=0; x < w.getX(); x++) {
			for(int y=0; y < w.getY(); y++) {
				liquide[x][y]=0;
			}
		}
	}
	public Volcan(World w,String n){
		this.w=w;
		liquide=new int[w.getX()][w.getY()];
		montee=1;
		RechercheAleatoireAlti();
		for(int x=0; x < w.getX(); x++) {
			for(int y=0; y < w.getY(); y++) {
				liquide[x][y]=0;
			}
		}
		
	}

	public void step() {
		if(volcan) {
			if(zombie==false) {
				init_erup();
				change=0;
			}
			else {
				if(cpt%100==0) {
					if(change==0) {
						if(Math.random()<0.3) {
							for(int x=x_max-20;x<x_max+20;x++) {
								for(int y=y_max-20; y < y_max+20; y++) {
									int a=Math.abs(y-y_max);
									int b=Math.abs(x-x_max);
									int h=(int)(Math.sqrt(a*a+b*b));
									if(x>=0 && x<w.getX() && y>=0 && y<w.getY() && h<10) {
										w.n.alti[x][y]=-1;
										w.world[x][y]=0;
									}
								}
							}
							change=20;
						}
						for(int x=0;x<w.getX();x++) {
							for(int y=0; y < w.getY(); y++) {
								if(w.n.alti[x][y]==8){
									w.n.alti[x][y]=7;
									w.world[x][y]=-1;
								}if(w.n.alti[x][y]==9){
									w.n.alti[x][y]=6;
									w.world[x][y]=-1;
								}
							}
						}
					}
					for(int x=x_max-change ; x <= x_max+change ; x++) {
						for(int y=y_max-change ; y <= y_max+change ; y++) {
							if(x>=0 && x<w.getX() && y>=0 && y<w.getY() ) {
								liquide[x][y]=0;
							}
						}
					}change++;
					if(change==20) {
						mort=true;
					}
				}
			}
				
			if(cpt>=1500 && tab_P.size()==0) {
				zombie=true;
				if(mort==true) {
					w.tab_Volcan.remove(this);
				}
			}else {
				if(cpt<=1500) {
					//System.out.println("New P");
					if(tab_P.size()<3 )
						tab_P.add(new Projectille(x_max,y_max,w));
				}
			}
			if(zombie==false) {
				for(int i=0;i<tab_P.size();i++) {
					if(tab_P.get(i).mort)
						tab_P.remove(i);
				}
				//afficherLiquide();
				ecoulement();
			}
			//if(cpt==2)
			//System.exit(0);
		}else {
			if(cpt==200) {
				if(alti_max<10) {
					alti_max++;
					for(int x=x_max-change ; x <= x_max+change ; x++) {
						for(int y=y_max-change ; y <= y_max+change ; y++) {
							if(y>=0 && y<w.getY() && x>=0 && x<w.getX() ){
								int a=Math.abs(y-y_max);
								int b=Math.abs(x-x_max);
								int h=(int)(Math.sqrt(a*a+b*b));
								if(w.n.alti[x][y]<9 && w.n.alti[x][y]<alti_max && h<10)
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
	public void init_erup() {
		change=5;
		for(int x=x_max-change ; x <= x_max+change ; x++) {
			for(int y=y_max-change ; y <= y_max+change ; y++) {
				if(x>=0 && x<w.getX() && y>=0 && y<w.getY() ) {
					if(w.n.alti[x][y]==9)
						liquide[x][y]=10;
				}
					
			}
		}
	}
	public void ecoulement() {	
		for(int x=0;x<w.getX();x++) {
			for(int y=0;y<w.getY();y++) {

				if(liquide[x][y]>=10) {
					if(liquide[x][y]>0) {
						if(w.n.alti[x][y]==-1) {
							w.n.alti[x][y]=0;
							w.world[x][y]=-1;
							liquide[x][y]=0;
						}
					}
					if( x+1<w.getX() && ((w.n.alti[x][y]>w.n.alti[x+1][y] ) || (Math.random()<0.1))) {
						liquide[x][y]--;
						liquide[x+1][y]++;
					}
					if(x-1>=0 && ((w.n.alti[x][y]>w.n.alti[x-1][y]) || (Math.random()<0.1))) {
						liquide[x][y]--;
						liquide[x-1][y]++;
					}

					if(y+1<w.getY() && ((w.n.alti[x][y]>w.n.alti[x][y+1] ) || (Math.random()<0.1))) {
						liquide[x][y]--;
						liquide[x][y+1]++;
					}
					if(y-1>=0 && ((w.n.alti[x][y]>w.n.alti[x][y-1] ) || (Math.random()<0.1))) {
						liquide[x][y]--;
						liquide[x][y-1]++;
					}
				}
			}
		}
	}
	
	public void retirerlave() {

		for(int y=0;y<w.getY();y++) {
			for(int x=0;x<w.getX();x++) {
				if(liquide[x][y]>0 && w.n.alti[x][y]==-1)
					w.n.alti[x][y]=0;
				if(liquide[x][y]>0) {
					liquide[x][y]=0;
					if(liquide[x][y]==0)
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
	
	public void afficherLiquide() {	
		for(int x=x_max-10; x<w.getX()+10; x++) {
			for(int y=y_max-10; y<w.getY()+10; y++) {
				if(x>=0 && x<w.getX() && y>=0 && y<w.getY() )
					if(liquide[x][y]>0)
						System.out.print(liquide[x][y]+"|"+w.n.alti[x][y]+" ");
					else
						System.out.print("    ");
			}
			System.out.println();
		}
		System.out.println("-------------------------------------------");
	}
	
	public int getMontee() {return montee;}
	public void setMontee(int m) {montee=m;}
}
