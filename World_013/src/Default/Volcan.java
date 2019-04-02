package Default;

public class Volcan {
	private World w;
	private int lave,montee;
	public Volcan(World w){
		this.w=w;
		lave=0;
		montee=1;
	}
	
	public void ecoulement() {		
		for(int i=0; i<w.getY(); i++) {
			for(int j=0; j<w.getX(); j++) {
				if (montee==1) {
					if(Math.random()<0.2 && w.liquide[j][i]==0) {
						if(i-1>=0 && w.liquide[j][i-1]>0) {
							w.liquide[j][i]++;
							w.liquide[j][i-1]--;
						}
						else if(j+1<w.getX() && w.liquide[j+1][i]>0) {			
							w.liquide[j][i]++;
							w.liquide[j+1][i]--;
						}
						else if(i+1<w.getY() && w.liquide[j][i+1]>0) {			
							w.liquide[j][i]++;
							w.liquide[j][i+1]--;
						}
						else if(j-1>=0 && w.liquide[j-1][i]>0) {			
							w.liquide[j][i]++;
							w.liquide[j-1][i]--;
						}
						milieu(j,i);
					}
						
				}else {
					int m=milieu(j,i);
					if( m==-1 ) {
					//	System.out.println(w.liquide[j][i]);
						if(w.liquide[j][i]==0) {
							//System.out.println(w.liquide[j][i]);
							if( j-1>=0 && i-1>=0 && j+1<w.getX() && w.liquide[j][i-1]>0 && ((w.liquide[j-1][i-1]==0 && w.liquide[j+1][i-1]==0) || (w.liquide[j-1][i-1]>0 && w.liquide[j+1][i-1]==0) || (w.liquide[j-1][i-1]==0 && w.liquide[j+1][i-1]>0) )) {
							//	System.out.println("m= "+m);
								if(i-1>=0 && (w.n.alti[j][i]<w.n.alti[j][i-1] || (Math.random()<0.1 && w.liquide[j][i]==0 && w.n.alti[j][i]==w.n.alti[j][i-1] )) ) {
									w.liquide[j][i]++;
									w.liquide[j][i-1]--;
								}
							}else if( i+1<w.getY() && i-1>=0 && j+1<w.getX() && w.liquide[j+1][i]>0 && ((w.liquide[j+1][i-1]==0 && w.liquide[j+1][i+1]==0) || (w.liquide[j+1][i-1]>0 && w.liquide[j+1][i+1]==0) || (w.liquide[j+1][i-1]==0 && w.liquide[j+1][i+1]>0))) {
								if(j+1<w.getX() && (w.n.alti[j][i]<w.n.alti[j+1][i] || (Math.random()<0.1 && w.liquide[j][i]==0 && w.n.alti[j][i]==w.n.alti[j+1][i] )) ) {
									w.liquide[j][i]++;
									w.liquide[j+1][i]--;
								}
							}
							else if(j-1>=0 && i+1<w.getY() && j+1<w.getX() && w.liquide[j][i+1]>0 && ((w.liquide[j-1][i+1]==0 && w.liquide[j+1][i+1]==0) || (w.liquide[j-1][i+1]>0 && w.liquide[j+1][i+1]==0) || (w.liquide[j-1][i+1]==0 && w.liquide[j+1][i+1]>0) )) {
								if(i+1<w.getY() && (w.n.alti[j][i]<w.n.alti[j][i+1] || (Math.random()<0.1 && w.liquide[j][i]==0 && w.n.alti[j][i]==w.n.alti[j][i+1] )) ) {	
									w.liquide[j][i]++;
									w.liquide[j][i+1]--;
								}
							}
							else if(i+1<w.getY() && i-1>=0 && j-1>=0 && w.liquide[j-1][i]>0 && ((w.liquide[j-1][i-1]==0 && w.liquide[j-1][i+1]==0) || (w.liquide[j-1][i-1]>0 && w.liquide[j-1][i+1]==0) || (w.liquide[j-1][i-1]==0 && w.liquide[j-1][i+1]>0))) {
								if(j-1>=0 && (w.n.alti[j][i]<w.n.alti[j-1][i] || (Math.random()<0.1 && w.liquide[j][i]==0 && w.n.alti[j][i]==w.n.alti[j-1][i] )) ) {
									w.liquide[j][i]++;
									w.liquide[j-1][i]--;
								}
							}
						}else if(w.liquide[j][i]>0) {
						//	System.out.println(w.liquide[j][i]);
							if(i-1>=0 && w.liquide[j][i]<w.liquide[j][i-1]) {
								w.liquide[j][i]++;
								w.liquide[j][i-1]--;
							}
							else if(j+1<w.getX() && w.liquide[j][i]<w.liquide[j+1][i]) {
								w.liquide[j][i]++;
								w.liquide[j+1][i]--;
							}
							else if(i+1<w.getY() &&w.liquide[j][i]<w.liquide[j][i+1]) {
								w.liquide[j][i]++;
								w.liquide[j][i+1]--;
							}
							else if(j-1>=0 && w.liquide[j][i]<w.liquide[j-1][i]) {
								w.liquide[j][i]++;
								w.liquide[j-1][i]--;
							}
						}
					}	
				}
			}
		}
		montee=0;
	}
	
	public int milieu(int x, int y) {
		if(w.liquide[x][y]==0 && y-1>=0 && x-1>=0  && x+1<w.getX() && y+1<w.getY() && w.liquide[x][y-1]>0 && w.liquide[x+1][y]>0 && w.liquide[x][y+1]>0 && w.liquide[x-1][y]>0) {
			//on cherche la case ou il y a le plus de liquide
			if(w.liquide[x][y-1]>w.liquide[x][y+1] && w.liquide[x][y-1]>w.liquide[x-1][y] && w.liquide[x][y-1]>w.liquide[x+1][y] ) {
				w.liquide[x][y]++;
				w.liquide[x][y-1]--;
				return 0;
			}else if(w.liquide[x+1][y]>w.liquide[x][y-1] && w.liquide[x+1][y]>w.liquide[x][y+1] && w.liquide[x+1][y]>w.liquide[x-1][y] ) {
				w.liquide[x][y]++;
				w.liquide[x+1][y]--;
				return 1;
			}else if(w.liquide[x][y+1]>w.liquide[x][y-1] && w.liquide[x][y+1]>w.liquide[x+1][y] && w.liquide[x][y+1]>w.liquide[x-1][y] ) {
				w.liquide[x][y]++;
				w.liquide[x][y+1]--;
				return 2;
			}else if(w.liquide[x-1][y]>w.liquide[x][y-1] && w.liquide[x-1][y]>w.liquide[x+1][y] && w.liquide[x-1][y]>w.liquide[x][y+1] ) {
				w.liquide[x][y]++;
				w.liquide[x-1][y]--;
				return 3;
			}
		}else if (w.liquide[x][y]==1 && y-1>=0 && x-1>=0  && x+1<w.getX() && y+1<w.getY() && w.liquide[x][y-1]==0 && w.liquide[x+1][y]==0 && w.liquide[x][y+1]==0 && w.liquide[x-1][y]==0) {
			w.liquide[x][y]--;
		}
		return -1;
	}
	
	public int getLave() {return lave;}
	public int getMontee() {return montee;}
	
	public void setLave(int l) { lave=l; }
	public void setMontee(int m) {montee=m;}
}
