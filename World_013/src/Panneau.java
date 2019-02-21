import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.File;

public class Panneau extends JPanel{
	private World w;
	private Fenetre f;
	public Image IMG_BUSH;
	public Image IMG_GRASS;
	public Image IMG_TREE_LITTLE;
	public Image IMG_WOLF;
	public Panneau(World w,Fenetre f) {
		this.w=w;
		this.f=f;
	}
	
	public void paintComponent(Graphics g) {
		if(w.getY()==0 || w.getX()==0) {
			System.out.println("ERREUR Tableau World VIDE !!!");
			return;
		}
		try {
			IMG_BUSH = ImageIO.read(new File("IMAGES/bush.png"));
			IMG_GRASS = ImageIO.read(new File("IMAGES/grass.png"));
			IMG_TREE_LITTLE = ImageIO.read(new File("IMAGES/tree_little.png"));
			IMG_WOLF = ImageIO.read(new File("IMAGES/wolf.png"));
			for(int i=0;i<w.getY();i++) {
				for(int j=0;j<w.getX();j++) {
					g.drawImage(IMG_GRASS, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i ,f.getX()/(w.getX()),f.getY()/(w.getY()), this);
						switch(w.getWorld()[j][i]) {
							case 1:
								g.drawImage(IMG_BUSH, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i ,f.getX()/(w.getX()),f.getY()/(w.getY()), this);
								break;
							case 2:
								g.drawImage(IMG_TREE_LITTLE, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i-40 ,f.getX()/(w.getX()),f.getY()/(w.getY())+40, this);
								break;
							case 3:
								g.drawImage(IMG_WOLF, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i ,f.getX()/(w.getX()),f.getY()/(w.getY()), this);
								break;
							default:;
						}
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
