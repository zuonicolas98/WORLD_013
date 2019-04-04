package Default;

public class Projectille {
	private World w;
	public int x,y,x2,y2;
	public int x_m,y_m;
	public int x_a,y_a;
	public boolean sol=false;
	private int erreur=0;
	private int cpt=0;
	private int d=0;
	private int ad=0;
	private int tmp1,tmp2,var;
	
	public Projectille(int x_,int y_,World w) {
		this.w=w;
		x=x_;
		y=y_;
		x_a=(w.tx/w.getX())*x;
		y_a=((w.ty-40)/w.getY())*y;
		var=x_a;
		//System.out.println("x_a:"+x_a+" y_a:"+y_a);
		x2=(int)(Math.random()*w.getX());
		y2=(int)(Math.random()*w.getY());
		while((Math.abs(x2-x)<10 || Math.abs(y2-y)<10) && (x-x2<0 && y-y2>0)) {
			x2=(int)(Math.random()*w.getX());
			y2=(int)(Math.random()*w.getY());
			erreur++;

			if(erreur==1000000000) {
				System.out.println("MAP TROP PETITE");
				System.exit(0);
			}
		}
		x_m=x-(int)(x-x2)/3;
		y_m=y-(w.getY()/10);
		/*if(x2<x && y2>y) {
			x_m=x-(int)(x-x2)/3;
			y_m=y-5;
			System.out.println("x:"+x+" y:"+y);
			System.out.println("x2:"+x2+" y2:"+y2);
			System.out.println("x_m:"+x_m+" y_m:"+y_m);
			System.out.println("-----------------------");
		}else 
			if(x2<=x && y2<=y) {
			x_m=(int)(x-x2)/3;
			y_m=y+10;
		}else 
			if(x2>x && y2>=y) {
			x_m=(int)(x2-x)/3;
			y_m=x_m-((int)((y-y2)/3));
		}else 
			if(x2>x && y2<y) {
			x_m=(int)(x2-x)/3;
			y_m=x_m+((int)((y-y2)/3));
		}else
			System.out.println("ERREUR INITIALISATION PROJECTILLE x:"+x+" y:"+y+" x2:"+x2+" y2:"+y2+" x_m:"+x_m+" y_m:"+y_m);
		//System.out.println("x:"+x+" y:"+y+" x2:"+x2+" y2:"+y2+" x_m:"+x_m+" y_m:"+y_m);*/
	}
	
	public void step() {
		if(x_a==x2*(w.tx/w.getX()) && y_a==y*(w.ty-40)/w.getY()) {
			//if(cpt==50) {
				w.world[x2][y2]=3;
				sol=true;
			//}
		}else {
			if(cpt==2) {
				if(x2<x && y2>y) {
					
					x_a--;
						if( (x_a>x_m*(w.tx/w.getX()) && y_a>=y_m*((w.ty-40)/w.getY())) || (x_a==x2*(w.ty)/w.getY()) ) {
							y_a--;
						}
						if(x_a<=x_m*(w.tx/w.getX()) && y_a<y2*((w.ty-40)/w.getY()))
							y_a++;
					//var=x_a;
					//var=(-(var*var)-(5*var));
						if(x_a<=x2*(w.tx/w.getX())) {
								w.world[x2][y2]=3;
								sol=true;
						}
				}
				cpt=0;
			}
		}
		cpt++;
	}
	
	
}
