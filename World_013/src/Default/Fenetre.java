package Default;

import javax.swing.JFrame;

@SuppressWarnings("serial")
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
		//this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setFocusable(true);
		p.requestFocus();
		this.setContentPane(p);
		this.setVisible(false);
	}
	public Panneau getPanneau() {return p;}
	public int getX() { return f_x;}
	public int getY() { return f_y;}
}
