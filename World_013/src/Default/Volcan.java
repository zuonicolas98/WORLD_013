package Default;

public class Volcan {
	private World w;
	private int montee;
	public Volcan(World w){
		this.w=w;
		montee=1;
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
		montee=0;
	}
	
	public int getMontee() {return montee;}
	
	public void setMontee(int m) {montee=m;}
}
