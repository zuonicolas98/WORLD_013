package Default;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.File;
@SuppressWarnings("serial")
public class Accueil extends JPanel implements KeyListener{
	private Fenetre fen;
	public Image IMG_FOND;
	
	public Accueil (Fenetre f) {
		fen=f;	
		addKeyListener(this);
	}
	
	public void paintComponent(Graphics g) {
		try {
			IMG_FOND = ImageIO.read(new File("IMAGES/image_accueil.png"));
			g.drawImage(IMG_FOND, 0,0,1200,800, this);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void keyPressed(KeyEvent e) {		
		int c= e.getKeyCode();
		if(c == KeyEvent.VK_H) { //retour
			fen.setC();
		}
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}