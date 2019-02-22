import javax.swing.JFrame;

public class Fenetre extends JFrame{
	private int f_x,f_y;
	private Panneau p;
	public Fenetre(World w,int x,int y) {
		f_x=x;
		f_y=y;
		p= new Panneau (w,this);
		
		this.setTitle("World");
		this.setSize(x, y);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(p);
		//this.setAlwaysOnTop(true);
		this.setVisible(false);
	}
	public Panneau getPanneau() {return p;}
	public int getX() { return f_x;}
	public int getY() { return f_y;}
}
