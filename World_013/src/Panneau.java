import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.File;

public class Panneau extends JPanel{
	private World w;
	private Fenetre f;
	private int time=0;
	public Image IMG_BUSH;
	public Image IMG_GRASS;
	public Image IMG_TREE_LITTLE;
	public Image IMG_WOLF;
	public Image IMG_FIRE1;
	public Image IMG_FIRE2;
	public Image IMG_FIRE3;
	
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
				IMG_FIRE1 = ImageIO.read(new File("IMAGES/feu1.png"));
				IMG_FIRE2 = ImageIO.read(new File("IMAGES/feu2.png"));
				IMG_FIRE3 = ImageIO.read(new File("IMAGES/feu3.png"));

				for(int i=0;i<w.getY();i++) {
					for(int j=0;j<w.getX();j++) {
						g.drawImage(IMG_GRASS, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i ,f.getX()/(w.getX()),f.getY()/(w.getY()), this);
							switch(w.getWorld()[j][i]) {
								case 1: //Herbes
									g.drawImage(IMG_BUSH, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i ,f.getX()/(w.getX()),f.getY()/(w.getY()), this);
									break;
									
								case 2: //Arbres
									g.drawImage(IMG_TREE_LITTLE, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i-40 ,f.getX()/(w.getX()),f.getY()/(w.getY())+40, this);
									
									if(w.RechercheArbres(j,i).getFeu()) { //Si l'arbre est en feu
										if(time==0) {
											g.drawImage(IMG_FIRE1, (f.getX()/(w.getX()))*j-20,((f.getY()-40)/(w.getY()))*i-80,f.getX()/(w.getX())+40,f.getY()/(w.getY())+40, this);
										}
										else if(time==1) {
											g.drawImage(IMG_FIRE2, (f.getX()/(w.getX()))*j-20,((f.getY()-40)/(w.getY()))*i-80,f.getX()/(w.getX())+40,f.getY()/(w.getY())+40, this);

										}else if(time==2) {									
											g.drawImage(IMG_FIRE3, (f.getX()/(w.getX()))*j-20,((f.getY()-40)/(w.getY()))*i-80,f.getX()/(w.getX())+40,f.getY()/(w.getY())+40, this);
										}
									}
									break;
									
								case 3:
									g.drawImage(IMG_WOLF, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i ,f.getX()/(w.getX()),f.getY()/(w.getY()), this);
									break;
									
								default:;
							}
					}
				}
				if(time==2)
					time=0;
				else
					time++;
				//System.out.println(time);
			}catch(IOException e) {
				e.printStackTrace();
			}
	
	}
}
