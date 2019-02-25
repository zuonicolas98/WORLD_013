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
	
	public Panneau(World w,Fenetre f) {
		this.w=w;
		this.f=f;
		IMG_RABBIT = Toolkit.getDefaultToolkit().createImage("IMAGES/ANIMAL/lapin.gif");
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
				
				for(int i=0;i<w.getY();i++) {
					for(int j=0;j<w.getX();j++) {
						g.drawImage(IMG_GRASS, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i ,f.getX()/(w.getX()),f.getY()/(w.getY()), this);
						//affichage des animaux
						for(int k=0; k<w.tab_Animal.size();k++) {
							if((w.tab_Animal.get(k).getX()==j) && (w.tab_Animal.get(k).getY()==i) ) {
								
								if(w.tab_Animal.get(k) instanceof Cochon) {
									if(w.tab_Animal.get(k).getAction()==1) //s'il est debout
										g.drawImage(IMG_RABBIT, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i -20 ,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
									else if(w.tab_Animal.get(k).getAction()==2) //s'il mange
										g.drawImage(IMG_RABBIT, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
									else //s'il dort
										g.drawImage(IMG_RABBIT, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
								}
								
								else if (w.tab_Animal.get(k) instanceof Chevre) {
									if(w.tab_Animal.get(k).getAction()==1) 	//s'il est debout
										g.drawImage(IMG_WOLF, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i ,f.getX()/(w.getX()),f.getY()/(w.getY()), this);	
									else if(w.tab_Animal.get(k).getAction()==2) //s'il mange
										g.drawImage(IMG_WOLF, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i ,f.getX()/(w.getX()),f.getY()/(w.getY()), this);
									else //s'il dort
										g.drawImage(IMG_WOLF, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i ,f.getX()/(w.getX()),f.getY()/(w.getY()), this);
								}
								
							}
						}
						
						//affichage des éléments
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
