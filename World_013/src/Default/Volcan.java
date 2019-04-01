package Default;

public class Volcan {
	private World w;
	private int lave,x,y;
	public Volcan(World w){
		this.w=w;
		lave=0;
	}
	
	public void ecoulement() {		
		for(int i=0; i<w.getY(); i++) {
			for(int j=0; j<w.getX(); j++) {
				/*
				if(i-1>=0 && liquide[j][i-1]>0 && (n.alti[j][i]<n.alti[j][i-1] || (liquide[j][i-1]>2 && n.alti[j][i]==n.alti[j][i-1])) ) {
					liquide[j][i]++;
					liquide[j][i-1]--;
				}
				else if(j+1<X && liquide[j+1][i]>0 && (n.alti[j][i]<n.alti[j+1][i] || (liquide[j+1][i]>2 && n.alti[j][i]==n.alti[j+1][i])) ) {
					liquide[j][i]++;
					liquide[j+1][i]--;
				}
				else if(i+1<Y && liquide[j][i+1]>0 && (n.alti[j][i]<n.alti[j][i+1] || (liquide[j][i+1]>2 && n.alti[j][i]==n.alti[j][i+1])) ) {
					liquide[j][i]++;
					liquide[j][i+1]--;
				}
				else if(j-1>=0 && liquide[j-1][i]>0 && (n.alti[j][i]<n.alti[j-1][i] || (liquide[j-1][i]>2 && n.alti[j][i]==n.alti[j-1][i])) ) {
					liquide[j][i]++;
					liquide[j-1][i]--;
				}
				*/
				if(i-1>=0 && w.liquide[j][i-1]>0 && ((w.n.alti[j][i]<w.n.alti[j][i-1]) || ( w.n.alti[j][i]==w.n.alti[j][i-1])) ) {
					w.liquide[j][i]++;
					w.liquide[j][i-1]--;
				}
				else if(j+1<w.getX() && w.liquide[j+1][i]>0 && ((w.n.alti[j][i]<w.n.alti[j+1][i]) || ( w.n.alti[j][i]==w.n.alti[j+1][i])) ) {
					w.liquide[j][i]++;
					w.liquide[j+1][i]--;
				}
				else if(i+1<w.getY() && w.liquide[j][i+1]>0 && ((w.n.alti[j][i]<w.n.alti[j][i+1]) || ( w.n.alti[j][i]==w.n.alti[j][i+1])) ) {
					w.liquide[j][i]++;
					w.liquide[j][i+1]--;
				}
				else if(j-1>=0 && w.liquide[j-1][i]>0 && ((w.n.alti[j][i]<w.n.alti[j-1][i]) || ( w.n.alti[j][i]==w.n.alti[j-1][i])) ) {
					w.liquide[j][i]++;
					w.liquide[j-1][i]--;
				}
			}
		}
		
	}
	
	public int getLave() {
		return lave;
	}
	
	public void setLave(int l) { lave=l; }
	public void setX(int x) { this.x=x; }
	public void setY(int y) { this.y=y; }
}
