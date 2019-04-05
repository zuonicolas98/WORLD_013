package Default;

public class Projectille {
	private World w;
	public int x,y,x2,y2;
	public int x_m,y_m;
	public int x_a,y_a;
	public boolean sol=false,mort=false;;
	private int cpt=0;
	public int direction,reste=0;

	
	public Projectille(int x,int y,World w) {
		this.w=w;
		this.x=x;
		this.y=y;
		x_a=0;
		direction=(int)(Math.random()*2);
		x2=(int)(Math.random()*30-20)+20;

		if(direction==0)
			y_a=-(x_a*x_a)-x2*x_a+reste;
		if(direction==1)
			y_a=-(x_a*x_a)+x2*x_a+reste;
	}
	
	public void step() {
		
		if(y_a<0 ) {
			sol=true;
			if(direction==0 && x-x_a<w.getX() && y+1<w.getY()) {
				int id=w.RechercheAnimal(x-x_a, y+1);
				if(w.RechercheArbres(x-x_a, y+1).getX()!=-1) {
					w.RechercheArbres(x-x_a, y+1).setFeu(true);
				}
				w.world[x-x_a][y+1]=3;
				if(id!=-1)
					w.tab_Animal.get(id).mort=true;
			}
			if(direction==1 && x-x_a>=0 && y+1<w.getY()) {
				int id=w.RechercheAnimal(x-x_a, y+1);
				if(w.rebord(x-x_a,y+1)==0)
					w.world[x-x_a][y+1]=3;
				if(id!=-1)
					w.tab_Animal.get(id).mort=true;
			}

			
			if(cpt==100) {
				mort=true;
			}
		}else {
			if(cpt==5) {
				if(direction==0) {
					x_a--;
					y_a=-(x_a*x_a)-x2*x_a+reste;
				}else if(direction==1) {
					x_a++;
					y_a=-(x_a*x_a)+x2*x_a+reste;
				}
				cpt=0;
			}
		}
		cpt++;
	}

	
}
