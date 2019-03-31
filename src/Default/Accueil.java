package Default;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.File;
@SuppressWarnings("serial")
public class Accueil extends JPanel{
	private Fenetre fen;
	public Image IMG_FOND;
	
	public Accueil (Fenetre f) {
		fen=f;	
	}
	
	public void paintComponent(Graphics g) {
		try {
			IMG_FOND = ImageIO.read(new File("IMAGES/fond_a.jpg"));
			g.drawImage(IMG_FOND, 0, 0,fen.getX(),fen.getY(), this);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}