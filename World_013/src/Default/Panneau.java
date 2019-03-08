package Default;
import Agents.*;
import Object.*;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
//import java.io.IOException;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Panneau extends JPanel  implements KeyListener{
	private World w;
	private Fenetre f;
	private int time=0;
	private boolean foudre=false;

	private Arbre arbre;
	public Image IMG_BUSH;
	public Image IMG_GRASS;
	//Variable image feu
	public Image IMG_FIRE;
	//Variable foudre
	public Image IMG_LIGHT;
	//Variables images animaux
	public Image IMG_PIG;
	public Image[][] IMG_PIG_M;
	public Image IMG_RABBIT;
	public Image[][] IMG_RABBIT_M;
	public Image IMG_GOAT;
	public Image[][] IMG_GOAT_M;
	//Variables images arbres
	public Image IMG_TREE_LITTLE;
	public Image IMG_TREE_LITTLE_BURNED;
	//--Pommier--
	public Image IMG_POMMIER_P;
	public Image IMG_POMMIER_PB;
	public Image IMG_POMMIER_M;
	public Image IMG_POMMIER_MB;
	public Image IMG_POMMIER_G;
	public Image IMG_POMMIER_GB;
	
	//--Cocotier--
	public Image IMG_COCOTIER_P;
	public Image IMG_COCOTIER_PB;
	public Image IMG_COCOTIER_M;
	public Image IMG_COCOTIER_MB;
	public Image IMG_COCOTIER_G;
	public Image IMG_COCOTIER_GB;
	
	
	public Panneau(World w,Fenetre f) {
		this.w=w;
		this.f=f;
		addKeyListener(this);
		IMG_PIG_M=new Image[4][3];
		IMG_RABBIT_M=new Image[4][3];
		IMG_GOAT_M=new Image[4][3];
		IMG_FIRE = Toolkit.getDefaultToolkit().createImage("IMAGES/ELEMENTS/fire.gif");
	}
	
	public void paintComponent(Graphics g) {
		
			try {
				
				//--------------------- PIG -----------------------
				
				IMG_PIG_M[0][0]=ImageIO.read(new File("IMAGES/ANIMAL/COCHON/haut/pig_haut0.png"));
				IMG_PIG_M[0][1]=ImageIO.read(new File("IMAGES/ANIMAL/COCHON/haut/pig_haut1.png"));
				IMG_PIG_M[0][2]=ImageIO.read(new File("IMAGES/ANIMAL/COCHON/haut/pig_haut2.png"));
				
				IMG_PIG_M[1][0]=ImageIO.read(new File("IMAGES/ANIMAL/COCHON/droite/pig_droite0.png"));
				IMG_PIG_M[1][1]=ImageIO.read(new File("IMAGES/ANIMAL/COCHON/droite/pig_droite1.png"));
				IMG_PIG_M[1][2]=ImageIO.read(new File("IMAGES/ANIMAL/COCHON/droite/pig_droite2.png"));
				
				IMG_PIG_M[2][0]=ImageIO.read(new File("IMAGES/ANIMAL/COCHON/bas/pig_bas0.png"));
				IMG_PIG_M[2][1]=ImageIO.read(new File("IMAGES/ANIMAL/COCHON/bas/pig_bas1.png"));
				IMG_PIG_M[2][2]=ImageIO.read(new File("IMAGES/ANIMAL/COCHON/bas/pig_bas2.png"));
				
				IMG_PIG_M[3][0]=ImageIO.read(new File("IMAGES/ANIMAL/COCHON/gauche/pig_gauche0.png"));
				IMG_PIG_M[3][1]=ImageIO.read(new File("IMAGES/ANIMAL/COCHON/gauche/pig_gauche1.png"));
				IMG_PIG_M[3][2]=ImageIO.read(new File("IMAGES/ANIMAL/COCHON/gauche/pig_gauche2.png"));
				
				//-------------------- RABBIT -----------------------
				
				IMG_RABBIT_M[0][0]=ImageIO.read(new File("IMAGES/ANIMAL/LAPIN/haut/rabbit_haut0.png"));
				IMG_RABBIT_M[0][1]=ImageIO.read(new File("IMAGES/ANIMAL/LAPIN/haut/rabbit_haut1.png"));
				IMG_RABBIT_M[0][2]=ImageIO.read(new File("IMAGES/ANIMAL/LAPIN/haut/rabbit_haut2.png"));
				
				IMG_RABBIT_M[1][0]=ImageIO.read(new File("IMAGES/ANIMAL/LAPIN/droite/rabbit_droite0.png"));
				IMG_RABBIT_M[1][1]=ImageIO.read(new File("IMAGES/ANIMAL/LAPIN/droite/rabbit_droite1.png"));
				IMG_RABBIT_M[1][2]=ImageIO.read(new File("IMAGES/ANIMAL/LAPIN/droite/rabbit_droite2.png"));
				
				IMG_RABBIT_M[2][0]=ImageIO.read(new File("IMAGES/ANIMAL/LAPIN/bas/rabbit_bas0.png"));
				IMG_RABBIT_M[2][1]=ImageIO.read(new File("IMAGES/ANIMAL/LAPIN/bas/rabbit_bas1.png"));
				IMG_RABBIT_M[2][2]=ImageIO.read(new File("IMAGES/ANIMAL/LAPIN/bas/rabbit_bas2.png"));
				
				IMG_RABBIT_M[3][0]=ImageIO.read(new File("IMAGES/ANIMAL/LAPIN/gauche/rabbit_gauche0.png"));
				IMG_RABBIT_M[3][1]=ImageIO.read(new File("IMAGES/ANIMAL/LAPIN/gauche/rabbit_gauche1.png"));
				IMG_RABBIT_M[3][2]=ImageIO.read(new File("IMAGES/ANIMAL/LAPIN/gauche/rabbit_gauche2.png"));
				
				//--------------------- GOAT ------------------------
				
				IMG_GOAT_M[0][0]=ImageIO.read(new File("IMAGES/ANIMAL/CHEVRE/haut/goat_haut0.png"));
				IMG_GOAT_M[0][1]=ImageIO.read(new File("IMAGES/ANIMAL/CHEVRE/haut/goat_haut1.png"));
				IMG_GOAT_M[0][2]=ImageIO.read(new File("IMAGES/ANIMAL/CHEVRE/haut/goat_haut2.png"));
				
				IMG_GOAT_M[1][0]=ImageIO.read(new File("IMAGES/ANIMAL/CHEVRE/droite/goat_droite0.png"));
				IMG_GOAT_M[1][1]=ImageIO.read(new File("IMAGES/ANIMAL/CHEVRE/droite/goat_droite1.png"));
				IMG_GOAT_M[1][2]=ImageIO.read(new File("IMAGES/ANIMAL/CHEVRE/droite/goat_droite2.png"));
				
				IMG_GOAT_M[2][0]=ImageIO.read(new File("IMAGES/ANIMAL/CHEVRE/bas/goat_bas0.png"));
				IMG_GOAT_M[2][1]=ImageIO.read(new File("IMAGES/ANIMAL/CHEVRE/bas/goat_bas1.png"));
				IMG_GOAT_M[2][2]=ImageIO.read(new File("IMAGES/ANIMAL/CHEVRE/bas/goat_bas2.png"));
				
				IMG_GOAT_M[3][0]=ImageIO.read(new File("IMAGES/ANIMAL/CHEVRE/gauche/goat_gauche0.png"));
				IMG_GOAT_M[3][1]=ImageIO.read(new File("IMAGES/ANIMAL/CHEVRE/gauche/goat_gauche1.png"));
				IMG_GOAT_M[3][2]=ImageIO.read(new File("IMAGES/ANIMAL/CHEVRE/gauche/goat_gauche2.png"));
				
				//--------------------- DECORS --------------------
				
				IMG_BUSH = ImageIO.read(new File("IMAGES/ELEMENTS/bush.png"));
				IMG_GRASS = ImageIO.read(new File("IMAGES/ELEMENTS/grass.png"));
				IMG_TREE_LITTLE = ImageIO.read(new File("IMAGES/ELEMENTS/tree_little.png"));
				IMG_TREE_LITTLE_BURNED  = ImageIO.read(new File("IMAGES/ELEMENTS/tree_little_burned.png"));
				IMG_LIGHT = ImageIO.read(new File("IMAGES/ELEMENTS/foudre.png"));
				
				IMG_POMMIER_P = ImageIO.read(new File("IMAGES/ELEMENTS/POMMIER/pommier_petit.png"));
				IMG_POMMIER_PB = ImageIO.read(new File("IMAGES/ELEMENTS/POMMIER/pommier_petit_bruler.png"));
				IMG_POMMIER_M = ImageIO.read(new File("IMAGES/ELEMENTS/POMMIER/pommier_moyen.png")); 
				IMG_POMMIER_MB = ImageIO.read(new File("IMAGES/ELEMENTS/POMMIER/pommier_moyen_bruler.png"));
				IMG_POMMIER_G = ImageIO.read(new File("IMAGES/ELEMENTS/POMMIER/pommier_grand.png"));
				IMG_POMMIER_GB = ImageIO.read(new File("IMAGES/ELEMENTS/POMMIER/pommier_grand_bruler.png"));
				
				IMG_COCOTIER_P = ImageIO.read(new File("IMAGES/ELEMENTS/COCOTIER/cocotier_petit.png"));
				IMG_COCOTIER_PB = ImageIO.read(new File("IMAGES/ELEMENTS/COCOTIER/cocotier_petit_bruler.png"));
				IMG_COCOTIER_M = ImageIO.read(new File("IMAGES/ELEMENTS/COCOTIER/cocotier_moyen.png")); 
				IMG_COCOTIER_MB = ImageIO.read(new File("IMAGES/ELEMENTS/COCOTIER/cocotier_moyen_bruler.png"));
				IMG_COCOTIER_G = ImageIO.read(new File("IMAGES/ELEMENTS/COCOTIER/cocotier_grand.png"));
				IMG_COCOTIER_GB = ImageIO.read(new File("IMAGES/ELEMENTS/COCOTIER/cocotier_grand_bruler.png"));

				afficher_terrain(g);
				
				for(int i=0;i<w.getY();i++) {
					for(int j=0;j<w.getX();j++) {
						//int taille_x=(f.getX()/(w.getX()));
						//int taille_y=(f.getY()-40)/(w.getY());
						/////////////((f.getY()-40)/(w.getY()))
						//affichage des animaux
						afficher_animaux(i,j,g);
						//g.drawImage(IMG_BUSH, (f.getX()/(w.getX()))*4,((f.getY()-40)/(w.getY()))*5 ,f.getX()/(w.getX()),f.getY()/(w.getY()), this);
						//g.drawImage(IMG_POMMIER_G, taille_x*3-taille_x,taille_y*5-taille_y*3,taille_x*3,taille_y*4, this);
						//affichage des éléments
						afficher_decors(i,j,g);
						
					}
				}
				if(time==2)
					time=0;
				else
					time++;
				//System.out.println(time);
			}catch(Exception e) {}
	
	}
	
	public void afficher_terrain(Graphics g) {
		for(int i=0;i<w.getY();i++) {
			for(int j=0;j<w.getX();j++) {
				g.drawImage(IMG_GRASS, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i ,f.getX()/(w.getX()),f.getY()/(w.getY()), this);
			}
		}
	}
	
	public void afficher_animaux(int i,int j,Graphics g) {
		try {

		for(int k=0; k<w.tab_Animal.size();k++) {
			if((w.tab_Animal.get(k).getX()==j) && (w.tab_Animal.get(k).getY()==i) ) {
				
				if(w.tab_Animal.get(k) instanceof Cochon) {
					if(w.tab_Animal.get(k).getAction()==1 ) //s'il est debout
					{
						if(w.tab_Animal.get(k).getDirection()!=-1) {
						if(w.tab_Animal.get(k).getDirection()==1 || w.tab_Animal.get(k).getDirection()==3) {
							if(w.tab_Animal.get(k).getCpt()==1) {
								w.tab_Animal.get(k).pixel=(((f.getX()/w.getX()))/4);
								IMG_PIG=IMG_PIG_M[w.tab_Animal.get(k).getDirection()][1];
							}
							else if(w.tab_Animal.get(k).getCpt()==2) {
								w.tab_Animal.get(k).pixel=2*(((f.getX()/w.getX()))/4);
								IMG_PIG=IMG_PIG_M[w.tab_Animal.get(k).getDirection()][0];
							}
							else if(w.tab_Animal.get(k).getCpt()==3) {
								w.tab_Animal.get(k).pixel=3*(((f.getX()/w.getX()))/4);
								IMG_PIG=IMG_PIG_M[w.tab_Animal.get(k).getDirection()][2];
							}
							else if(w.tab_Animal.get(k).getCpt()==0){
								w.tab_Animal.get(k).pixel=0;
								IMG_PIG=IMG_PIG_M[w.tab_Animal.get(k).getDirection()][0];

							}
							else if(w.tab_Animal.get(k).getCpt()>3)
								IMG_PIG=IMG_PIG_M[w.tab_Animal.get(k).getDirection()][0];
						}else {
							if(w.tab_Animal.get(k).getCpt()==1) {
								w.tab_Animal.get(k).pixel=(((f.getY()/w.getY()))/4);
								IMG_PIG=IMG_PIG_M[w.tab_Animal.get(k).getDirection()][1];
							}
							else if(w.tab_Animal.get(k).getCpt()==2) {
								w.tab_Animal.get(k).pixel=2*(((f.getY()/w.getY()))/4);
								IMG_PIG=IMG_PIG_M[w.tab_Animal.get(k).getDirection()][0];
							}
							else if(w.tab_Animal.get(k).getCpt()==3) {
								w.tab_Animal.get(k).pixel=3*(((f.getY()/w.getY()))/4);
								IMG_PIG=IMG_PIG_M[w.tab_Animal.get(k).getDirection()][2];
							}
						
							else if(w.tab_Animal.get(k).getCpt()==0 ){
								w.tab_Animal.get(k).pixel=0;
								IMG_PIG=IMG_PIG_M[w.tab_Animal.get(k).getDirection()][0];

							}
							else if(w.tab_Animal.get(k).getCpt()>3)
								IMG_PIG=IMG_PIG_M[w.tab_Animal.get(k).getDirection()][0];
						}
						
						//System.out.println(w.tab_Animal.get(k).getDirection()+" "+pixel+" "+"X="+f.getX()/w.getX()+" Y="+f.getY()/w.getY());
						if(w.tab_Animal.get(k).getDirection()==0)
							g.drawImage(IMG_PIG, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i  -20-w.tab_Animal.get(k).pixel,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
						if(w.tab_Animal.get(k).getDirection()==1)
							g.drawImage(IMG_PIG, w.tab_Animal.get(k).pixel+(f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i  -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
						if(w.tab_Animal.get(k).getDirection()==2)
							g.drawImage(IMG_PIG, (f.getX()/(w.getX()))*j,w.tab_Animal.get(k).pixel+((f.getY()-40)/(w.getY()))*i  -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
						if(w.tab_Animal.get(k).getDirection()==3)
							g.drawImage(IMG_PIG, (f.getX()/(w.getX()))*j  -w.tab_Animal.get(k).pixel,((f.getY()-40)/(w.getY()))*i  -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
					}else {
						g.drawImage(IMG_PIG, (f.getX()/(w.getX()))*j ,((f.getY()-40)/(w.getY()))*i  -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
					}
					}
						
					else if(w.tab_Animal.get(k).getAction()==2) //s'il mange
						g.drawImage(IMG_PIG, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
					
				}
				
				//*******************************************************************************************************************************************************
				
				else if (w.tab_Animal.get(k) instanceof Chevre) {

					if(w.tab_Animal.get(k).getAction()==1 ) //s'il est debout
					{
						if(w.tab_Animal.get(k).getDirection()!=-1) {
						if(w.tab_Animal.get(k).getDirection()==1 || w.tab_Animal.get(k).getDirection()==3) {
							if(w.tab_Animal.get(k).getCpt()==1) {
								w.tab_Animal.get(k).pixel=(((f.getX()/w.getX()))/4);
								IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][1];
							}
							else if(w.tab_Animal.get(k).getCpt()==2) {
								w.tab_Animal.get(k).pixel=2*(((f.getX()/w.getX()))/4);
								IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][0];
							}
							else if(w.tab_Animal.get(k).getCpt()==3) {
								w.tab_Animal.get(k).pixel=3*(((f.getX()/w.getX()))/4);
								IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][2];
							}
							else if(w.tab_Animal.get(k).getCpt()==0){
								IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][0];
								w.tab_Animal.get(k).pixel=0;
							}
							else if(w.tab_Animal.get(k).getCpt()>3)
								IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][0];
						}else {
							if(w.tab_Animal.get(k).getCpt()==1) {
								w.tab_Animal.get(k).pixel=(((f.getY()/w.getY()))/4);
								IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][1];
							}
							else if(w.tab_Animal.get(k).getCpt()==2) {
								w.tab_Animal.get(k).pixel=2*(((f.getY()/w.getY()))/4);
								IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][0];
							}
							else if(w.tab_Animal.get(k).getCpt()==3) {
								w.tab_Animal.get(k).pixel=3*(((f.getY()/w.getY()))/4);
								IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][2];
							}
						
							else if(w.tab_Animal.get(k).getCpt()==0 ){
								w.tab_Animal.get(k).pixel=0;
								IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][0];

							}
							else if(w.tab_Animal.get(k).getCpt()>3)
								IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][0];
						}
						//System.out.println(w.tab_Animal.get(k).getDirection()+" "+pixel+" "+"X="+f.getX()/w.getX()+" Y="+f.getY()/w.getY());
						if(w.tab_Animal.get(k).getDirection()==0)
							g.drawImage(IMG_GOAT, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i  -20-w.tab_Animal.get(k).pixel,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
						if(w.tab_Animal.get(k).getDirection()==1)
							g.drawImage(IMG_GOAT, w.tab_Animal.get(k).pixel+(f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i  -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
						if(w.tab_Animal.get(k).getDirection()==2)
							g.drawImage(IMG_GOAT, (f.getX()/(w.getX()))*j,w.tab_Animal.get(k).pixel+((f.getY()-40)/(w.getY()))*i  -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
						if(w.tab_Animal.get(k).getDirection()==3)
							g.drawImage(IMG_GOAT, (f.getX()/(w.getX()))*j  -w.tab_Animal.get(k).pixel,((f.getY()-40)/(w.getY()))*i  -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);

					}else {
						g.drawImage(IMG_GOAT, (f.getX()/(w.getX()))*j ,((f.getY()-40)/(w.getY()))*i  -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
					}
					}
						
					else if(w.tab_Animal.get(k).getAction()==2) //s'il mange
						g.drawImage(IMG_GOAT, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
					
				}
				
				//*******************************************************************************************************************************************************
				else if (w.tab_Animal.get(k) instanceof Lapin) {
					if(w.tab_Animal.get(k).getAction()==1) 	//s'il est debout
					{
						
						if(w.tab_Animal.get(k).getDirection()!=-1) {
							if(w.tab_Animal.get(k).getDirection()==1 || w.tab_Animal.get(k).getDirection()==3) {
								if(w.tab_Animal.get(k).getCpt()==1) {
									w.tab_Animal.get(k).pixel=(((f.getX()/w.getX()))/4);
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][1];
								}
								else if(w.tab_Animal.get(k).getCpt()==2) {
									w.tab_Animal.get(k).pixel=2*(((f.getX()/w.getX()))/4);
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][0];
								}
								else if(w.tab_Animal.get(k).getCpt()==3) {
									w.tab_Animal.get(k).pixel=3*(((f.getX()/w.getX()))/4);
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][2];
								}
								else if(w.tab_Animal.get(k).getCpt()==0 ){
									w.tab_Animal.get(k).pixel=0;
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][0];
								}
								else if(w.tab_Animal.get(k).getCpt()>3)
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][0];
							}else {
								if(w.tab_Animal.get(k).getCpt()==1) {
									w.tab_Animal.get(k).pixel=(((f.getY()/w.getY()))/4);
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][1];
								}
								else if(w.tab_Animal.get(k).getCpt()==2) {
									w.tab_Animal.get(k).pixel=2*(((f.getY()/w.getY()))/4);
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][0];
								}
								else if(w.tab_Animal.get(k).getCpt()==3) {
									w.tab_Animal.get(k).pixel=3*(((f.getY()/w.getY()))/4);
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][2];
								}
							
								else if(w.tab_Animal.get(k).getCpt()==0 ){
									w.tab_Animal.get(k).pixel=0;
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][0];

								}
								else if(w.tab_Animal.get(k).getCpt()>3)
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][0];
							}
							
							//System.out.println(w.tab_Animal.get(k).getDirection()+" "+pixel+" "+"X="+f.getX()/w.getX()+" Y="+f.getY()/w.getY());
							if(w.tab_Animal.get(k).getDirection()==0)
								g.drawImage(IMG_RABBIT, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i  -20-w.tab_Animal.get(k).pixel,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
							if(w.tab_Animal.get(k).getDirection()==1)
								g.drawImage(IMG_RABBIT, w.tab_Animal.get(k).pixel+(f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i  -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
							if(w.tab_Animal.get(k).getDirection()==2)
								g.drawImage(IMG_RABBIT, (f.getX()/(w.getX()))*j,w.tab_Animal.get(k).pixel+((f.getY()-40)/(w.getY()))*i  -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
							if(w.tab_Animal.get(k).getDirection()==3)
								g.drawImage(IMG_RABBIT, (f.getX()/(w.getX()))*j  -w.tab_Animal.get(k).pixel,((f.getY()-40)/(w.getY()))*i  -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
							
						}else {
							g.drawImage(IMG_RABBIT, (f.getX()/(w.getX()))*j ,((f.getY()-40)/(w.getY()))*i  -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
						}
						
					}
					else if(w.tab_Animal.get(k).getAction()==2) //s'il mange
						g.drawImage(IMG_RABBIT, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i -20,f.getX()/(w.getX()),f.getY()/(w.getY())+20, this);
					
				}
				
			}
		}
		}catch(Exception e){}
	}
	
	
	public void afficher_decors(int i,int j,Graphics g) {
		try {
		switch(w.getWorld()[j][i]) {
		case 1: //Herbes
			g.drawImage(IMG_BUSH, (f.getX()/(w.getX()))*j,((f.getY()-40)/(w.getY()))*i ,f.getX()/(w.getX()),f.getY()/(w.getY()), this);
			break;
				
		case 2: //Arbres
			int taille_x=(f.getX()/(w.getX()));
			int taille_y=(f.getY()-40)/(w.getY());
			for(int a=0; a < w.tab_Arbre.size(); a++) {
				if( (w.tab_Arbre.get(a).getX()==j) && (w.tab_Arbre.get(a).getY()==i) ) {
					if(w.tab_Arbre.get(a).getNom().equals("Pommier")) { 
						
						switch(w.tab_Arbre.get(a).getCroissance()) {
							case 1: //petit
								if(w.tab_Arbre.get(a).getCendre() == false) {
									g.drawImage(IMG_POMMIER_P,  taille_x*j-taille_x,taille_y*i-taille_y*3,taille_x*3,taille_y*4, this);
								}
								else 
									g.drawImage(IMG_POMMIER_PB, taille_x*j-taille_x,taille_y*i-taille_y*3,taille_x*3,taille_y*4, this);
								break;
							case 2: //moyen
								if(w.tab_Arbre.get(a).getCendre() == false)
									g.drawImage(IMG_POMMIER_M,  taille_x*j-taille_x,taille_y*i-taille_y*3,taille_x*3,taille_y*4, this);
								else 
									g.drawImage(IMG_POMMIER_MB, taille_x*j-taille_x,taille_y*i-taille_y*3,taille_x*3,taille_y*4, this);
								break;
							case 3: //grand
								if(w.tab_Arbre.get(a).getCendre() == false)
									g.drawImage(IMG_POMMIER_G, taille_x*j-taille_x,taille_y*i-taille_y*3,taille_x*3,taille_y*4, this);
								else 
									g.drawImage(IMG_POMMIER_GB, taille_x*j-taille_x,taille_y*i-taille_y*3,taille_x*3,taille_y*4, this);
								break;
							default:;	
						}
						
					}else if(w.tab_Arbre.get(a).getNom().equals("Cocotier")) {
						switch(w.tab_Arbre.get(a).getCroissance()) {
						case 1: //petit
							if(w.tab_Arbre.get(a).getCendre() == false)
								g.drawImage(IMG_COCOTIER_P,  taille_x*j-taille_x,taille_y*i-taille_y*3,taille_x*3,taille_y*4, this);
							else 
								g.drawImage(IMG_COCOTIER_PB,  taille_x*j-taille_x,taille_y*i-taille_y*3,taille_x*3,taille_y*4, this);
							break;
						case 2: //moyen
							if(w.tab_Arbre.get(a).getCendre() == false)
								g.drawImage(IMG_COCOTIER_M,  taille_x*j-taille_x,taille_y*i-taille_y*3,taille_x*3,taille_y*4, this);
							else 
								g.drawImage(IMG_COCOTIER_MB,  taille_x*j-taille_x,taille_y*i-taille_y*3,taille_x*3,taille_y*4, this);
							break;
						case 3: //grand
							if(w.tab_Arbre.get(a).getCendre() == false)
								g.drawImage(IMG_COCOTIER_G, taille_x*j-taille_x,taille_y*i-taille_y*3,taille_x*3,taille_y*4, this);
							else 
								g.drawImage(IMG_COCOTIER_GB,  taille_x*j-taille_x,taille_y*i-taille_y*3,taille_x*3,taille_y*4, this);
							break;
						default:;	
					}
					
					}		
					
				}
			}
			if(foudre) {
				if(w.l.estAfficher()) {
					g.drawImage(IMG_LIGHT,  taille_x*arbre.getX()-taille_x,taille_y*arbre.getY()-taille_y*5,taille_x*3,taille_y*6, this);

				}
				else {
					foudre=false;
					w.l.setLight();
				}
			}
			if(w.RechercheArbres(j,i).getFeu()) { //Si l'arbre est en feu
					g.drawImage(IMG_FIRE, taille_x*j-taille_x*2,(taille_y)*i-taille_y*5,taille_x*5,taille_y*6, this);

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
	}catch(Exception e) {}
	}
	
	public void keyPressed(KeyEvent e) {
	
		int c= e.getKeyCode();
		
		if(c == KeyEvent.VK_LEFT) {
			if(w.getDelay()>50) {
				w.setDelay((w.getDelay())-50);
				System.out.println("Thread.sleep : "+ w.getDelay());
			}
		}
		else if(c == KeyEvent.VK_RIGHT) {
			if(w.getDelay()<52) {
				w.setDelay((w.getDelay())+50);
				System.out.println("Thread.sleep : "+ w.getDelay());
			}
		}else if(c == KeyEvent.VK_F) {
			f.dispose();
			w.setFin();
		}
		try {
		if(c == KeyEvent.VK_B) {
			foudre=true;
			arbre=w.tab_Arbre.get((int)(Math.random()*w.tab_Arbre.size()));
			arbre.setFeu(true);
		}
		}catch(Exception x) {};
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
}




















