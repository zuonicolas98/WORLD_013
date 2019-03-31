package Default;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	private int f_x,f_y;
	private World w;
	private Panneau p;
	private JPanel co= new JPanel();
	private Accueil a;
	private JButton b = new JButton("START");
	
	public Fenetre(World w,int x,int y) {
		f_x=x;
		f_y=y;
		this.w=w;
		a= new Accueil(this);	
		p= new Panneau (w,this);
		this.setTitle("World");
		this.setSize(x, y);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ACCUEIL
		co.setLayout(new BorderLayout());
		co.add(a, BorderLayout.CENTER);
		co.add(b, BorderLayout.SOUTH);
		b.addActionListener(new EcouteurBoutonChanger());
		b.requestFocus();
		//this.setContentPane(co);
		
		this.setContentPane(p);
		p.setFocusable(true);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setVisible(false);
	}
	
	public void setC() {
		this.setContentPane(p);
		this.revalidate();
		p.requestFocus();
	}
	
	//getters
	public Panneau getPanneau() {return p;}
	public int getX() { return f_x;}
	public int getY() { return f_y;}
	
	public class EcouteurBoutonChanger implements ActionListener{
        public void actionPerformed(ActionEvent clic) {
            Fenetre.this.setC();
        }
    }
	
}
