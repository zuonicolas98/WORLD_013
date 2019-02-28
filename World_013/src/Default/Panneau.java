package Default;
import Agents.*;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.File;

@SuppressWarnings("serial")
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
	public Image IMG_RABBIT;
	public Image IMG_PIG;
	public Image IMG_GOAT;
	public Image IMG_FIRE;
	public Image IMG_PIG_DROITE;

	
	public Panneau(World w,Fenetre f) {
		this.w=w;
		this.f=f;
		IMG_RABBIT = Toolkit.getDefaultToolkit().createImage("IMAGES/ANIMAL/LAPIN/lapin_devant.gif");
		IMG_PIG_DROITE = Toolkit.getDefaultToolkit().createImage("IMAGES/ANIMAL/PIG.gif");
		IMG_GOAT = Toolkit.getDefaultToolkit().createImage("IMAGES/ANIMAL/CHEVRE/chevre_devant.gif");
		IMG_FIRE = Toolkit.getDefaultToolkit().createImage("IMAGES/ELEMENTS/fire.gif");
	}
	
	public void paintComponent(Graphics g) {
			try {
				IMG_BUSH = ImageIO.read(new File("IMAGES/ELEMENTS/bush.png"));
				IMG_GRASS = ImageIO.read(new File("IMAGES/ELEMENTS/grass.png"));
				IMG_TREE_LITTLE = ImageIO.read(new File("IMAGES/ELEMENTS/tree_little.png"));
				IMG_WOLF = ImageIO.read(new File("IMAGES/ANIMAL/wolf.png"));
				IMG_FIRE1 = ImageIO.read(new File("IMAGES/ELEMENTS/feu1.png"));
				IMG_FIRE2 = ImageIO.read(new File("IMAGES/ELEMENTS/feu2.png"));
				IMG_FIRE3 = ImageIO.read(new File("IMAGES/ELEMENTS/feu3.png"));
				IMG_PIG =	ImageIO.read(new File("IMAGES/ANIMAL/COCHON/cochon_droite.gif"));
				afficher_terrain(g);
				for(int i=0;i<w.getY();i++) {
					for(int j=0;j<w.getX();j++) {
						//afficher_terrain(g);
						//g.drawImage(IMG_GRASS,0,0,800,600,this);
						//affichage des animaux
						afficher_animaux(i,j,g);
						
						//affichage des éléments
						afficher_decors(i,j,g);
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
	
	public void afficher_terrain(Graphics g) {
		for(int i=0;i<w.getY();i++) {
			for(int j=0;j<w.getX();j++) {
				g.drawImage(IMG_GRASS, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i ,f.getX()/(w.getX()),f.getY()/(w.getY()), this);
			}
		}
	}
	
	public void afficher_animaux(int i,int j,Graphics g) {
		for(int k=0; k<w.tab_Animal.size();k++) {
			if((w.tab_Animal.get(k).getX()==j) && (w.tab_Animal.get(k).getY()==i) ) {
				
				if(w.tab_Animal.get(k) instanceof Cochon) {
					if(w.tab_Animal.get(k).getAction()==1) //s'il est debout
					{				
						if(w.tab_Animal.get(k).getDirection()==3)
							g.drawImage(IMG_PIG_DROITE, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i -20 ,-f.getX()/(w.getX())*2,f.getY()/(w.getY())+20, this);
						else
							g.drawImage(IMG_PIG, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i -20 ,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);

					}
					else if(w.tab_Animal.get(k).getAction()==2) //s'il mange
						g.drawImage(IMG_PIG, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
					
				}
				
				else if (w.tab_Animal.get(k) instanceof Chevre) {
					if(w.tab_Animal.get(k).getAction()==1) 	//s'il est debout
						g.drawImage(IMG_GOAT, (f.getX()/(w.getX()))*j-5,((f.getY()-40)/(w.getY()))*i -20,f.getX()/(w.getX())+10,f.getY()/(w.getY())+20, this);	
					else if(w.tab_Animal.get(k).getAction()==2) //s'il mange
						g.drawImage(IMG_GOAT, (f.getX()/(w.getX()))*j-5,((f.getY()-40)/(w.getY()))*i -20,f.getX()/(w.getX())+10,f.getY()/(w.getY())+20, this);
					
				}
				else if (w.tab_Animal.get(k) instanceof Lapin) {
					if(w.tab_Animal.get(k).getAction()==1) 	//s'il est debout
						g.drawImage(IMG_RABBIT, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);	
					else if(w.tab_Animal.get(k).getAction()==2) //s'il mange
						g.drawImage(IMG_RABBIT, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
					
				}
				
			}
		}
	}
	
	
	public void afficher_decors(int i,int j,Graphics g) {
		switch(w.getWorld()[j][i]) {
		case 1: //Herbes
			g.drawImage(IMG_BUSH, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i ,f.getX()/(w.getX()),f.getY()/(w.getY()), this);
			break;
				
		case 2: //Arbres
			for(int a=0; a < w.tab_Arbre.size(); a++) {
				if( (w.tab_Arbre.get(a).getX()==j) && (w.tab_Arbre.get(a).getY()==i) ) {
					
					if(w.tab_Arbre.get(a).getNom().equals("Arbre")) { //le nom "Arbre" � changer
						switch(w.tab_Arbre.get(a).getCroissance()) {
							case 1: //petit
								if(w.tab_Arbre.get(a).getCendre() == false)
									g.drawImage(IMG_TREE_LITTLE, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i-40 ,f.getX()/(w.getX()),f.getY()/(w.getY())+40, this);
								else 
									g.drawImage(IMG_TREE_LITTLE, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i-40 ,f.getX()/(w.getX()),f.getY()/(w.getY())+40, this);
								break;
							case 2: //moyen
								if(w.tab_Arbre.get(a).getCendre() == false)
									g.drawImage(IMG_TREE_LITTLE, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i-40 ,f.getX()/(w.getX()),f.getY()/(w.getY())+40, this);
								else 
									g.drawImage(IMG_TREE_LITTLE, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i-40 ,f.getX()/(w.getX()),f.getY()/(w.getY())+40, this);
								break;
							case 3: //grand
								if(w.tab_Arbre.get(a).getCendre() == false)
									g.drawImage(IMG_TREE_LITTLE, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i-40 ,f.getX()/(w.getX()),f.getY()/(w.getY())+40, this);
								else 
									g.drawImage(IMG_TREE_LITTLE, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i-40 ,f.getX()/(w.getX()),f.getY()/(w.getY())+40, this);
								break;
							default:;	
						}
					}
					
					//AUTRES ARBRES
				}
			}
			if(w.RechercheArbres(j,i).getFeu()) { //Si l'arbre est en feu
					g.drawImage(IMG_FIRE, (f.getX()/(w.getX()))*j-20,((f.getY()-40)/(w.getY()))*i-80,f.getX()/(w.getX())+40,f.getY()/(w.getY())+40, this);

			}
			
			break;
				
		case 3: //Rochers
			break;
		
		case 4:	 //Eau
			break;
		
		case 5: //Lave	
			break;
			
		default:;
	}
	}
	
}




















