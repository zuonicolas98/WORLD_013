package Default;
import Agents.*;
import Object.*;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
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
	private int x1,x2,y1,y2,xtmp,ytmp;

	private Arbre arbre;
	public Image IMG_BUSH;
	public Image IMG_GRASS;
	public Image IMG_DRY;
	public Image IMG_WATER;
	public Image IMG_ROCHER_EAU;
	public Image IMG_ROCHER;
	public Image IMG_ROCKY;
	//Variables bordures eau
	public Image IMG_BORD_BAS;
	public Image IMG_BORD_DROITE;
	public Image IMG_BORD_GAUCHE;
	public Image IMG_BORD_HAUT;
	public Image IMG_BORD_HAUT_DROITE;
	public Image IMG_BORD_HAUT_GAUCHE;
	//Variables wall
	public Image IMG_WALL_DROITE;
	public Image IMG_WALL_GAUCHE;
	public Image IMG_WALL_HAUT;
	public Image IMG_WALL_BAS;
	public Image IMG_WALL_HAUT_DROITE;
	public Image IMG_WALL_HAUT_GAUCHE;
	public Image IMG_WALL_BAS_GAUCHE;
	public Image IMG_WALL_BAS_DROITE;
	public Image IMG_WALL_INTER_DROITE;
	public Image IMG_WALL_INTER_GAUCHE;
	//montagne
	public Image IMG_MONTAGNE_DROITE;
	public Image IMG_MONTAGNE_GAUCHE;
	public Image IMG_MONTAGNE_HAUT;
	public Image IMG_MONTAGNE_BAS;
	public Image IMG_MONTAGNE_HAUT_DROITE;
	public Image IMG_MONTAGNE_HAUT_GAUCHE;
	public Image IMG_MONTAGNE_BAS_GAUCHE;
	public Image IMG_MONTAGNE_BAS_DROITE;
	public Image IMG_MONTAGNE_INTER_DROITE;
	public Image IMG_MONTAGNE_INTER_GAUCHE;
	//Variable image feu
	public Image IMG_FIRE;
	//Variable foudre
	public Image IMG_LIGHT;
	//Variable nuage
	public Image IMG_NUAGE;
	public Image IMG_NUAGE0;
	public Image IMG_NUAGE1;
	public Image IMG_NUAGE2;
	public Image IMG_NUAGE_NORMAL;
	public Image IMG_OMBRE;
	public Image IMG_PLUIE;
	public Image IMG_HEART0;
	public Image IMG_HEART1;
	public Image IMG_NUAGE_HEART;
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
		x1=0;
		y1=0;
		x2=w.getX();
		y2=w.getY();
		addKeyListener(this);
		IMG_PIG_M=new Image[4][3];
		IMG_RABBIT_M=new Image[4][3];
		IMG_GOAT_M=new Image[4][3];
		IMG_FIRE = Toolkit.getDefaultToolkit().createImage("IMAGES/ELEMENTS/fire.gif");
		IMG_WATER= Toolkit.getDefaultToolkit().createImage("IMAGES/ELEMENTS/water.gif");
		IMG_PLUIE= Toolkit.getDefaultToolkit().createImage("IMAGES/ELEMENTS/NUAGE/pluie.gif");
		IMG_HEART0= Toolkit.getDefaultToolkit().createImage("IMAGES/ELEMENTS/NUAGE/rain_heart.gif");
		IMG_HEART1= Toolkit.getDefaultToolkit().createImage("IMAGES/ELEMENTS/NUAGE/rain_heart_inter.gif");
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
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
				IMG_DRY = ImageIO.read(new File("IMAGES/ELEMENTS/dry.png"));
				IMG_TREE_LITTLE = ImageIO.read(new File("IMAGES/ELEMENTS/tree_little.png"));
				IMG_TREE_LITTLE_BURNED  = ImageIO.read(new File("IMAGES/ELEMENTS/tree_little_burned.png"));
				IMG_ROCKY = ImageIO.read(new File("IMAGES/ELEMENTS/rocky.png"));
				try {
					IMG_LIGHT = ImageIO.read(new File("IMAGES/ELEMENTS/foudre.png"));
				}catch(IndexOutOfBoundsException e) {}
				IMG_ROCHER_EAU = ImageIO.read(new File("IMAGES/ELEMENTS/rocher_eau.png"));
				IMG_ROCHER = ImageIO.read(new File("IMAGES/ELEMENTS/rocher.png"));
				//NUAGE
				IMG_NUAGE_NORMAL  = ImageIO.read(new File("IMAGES/ELEMENTS/NUAGE/nuage.png"));
				IMG_NUAGE0 = ImageIO.read(new File("IMAGES/ELEMENTS/NUAGE/nuage0.png"));
				IMG_NUAGE1 = ImageIO.read(new File("IMAGES/ELEMENTS/NUAGE/nuage1.png"));
				IMG_NUAGE2 = ImageIO.read(new File("IMAGES/ELEMENTS/NUAGE/nuage2.png"));
				IMG_NUAGE_HEART = ImageIO.read(new File("IMAGES/ELEMENTS/NUAGE/nuage_rose.png"));
				IMG_OMBRE  = ImageIO.read(new File("IMAGES/ELEMENTS/NUAGE/ombre.png"));
				//bordures eau
				IMG_BORD_BAS = ImageIO.read(new File("IMAGES/ELEMENTS/bordure_eau/bord_bas.png"));
				IMG_BORD_DROITE = ImageIO.read(new File("IMAGES/ELEMENTS/bordure_eau/bord_droite.png"));
				IMG_BORD_GAUCHE = ImageIO.read(new File("IMAGES/ELEMENTS/bordure_eau/bord_gauche.png"));
				IMG_BORD_HAUT = ImageIO.read(new File("IMAGES/ELEMENTS/bordure_eau/bord_haut.png"));
				IMG_BORD_HAUT_DROITE = ImageIO.read(new File("IMAGES/ELEMENTS/bordure_eau/bord_haut_droite.png"));
				IMG_BORD_HAUT_GAUCHE = ImageIO.read(new File("IMAGES/ELEMENTS/bordure_eau/bord_haut_gauche.png"));
				//wall
				IMG_WALL_DROITE = ImageIO.read(new File("IMAGES/ELEMENTS/wall/wall_droite.png"));
				IMG_WALL_GAUCHE = ImageIO.read(new File("IMAGES/ELEMENTS/wall/wall_gauche.png"));
				IMG_WALL_HAUT = ImageIO.read(new File("IMAGES/ELEMENTS/wall/wall_haut.png"));
				IMG_WALL_BAS = ImageIO.read(new File("IMAGES/ELEMENTS/wall/wall_bas.png"));
				IMG_WALL_HAUT_DROITE = ImageIO.read(new File("IMAGES/ELEMENTS/wall/wall_haut_droite.png"));
				IMG_WALL_HAUT_GAUCHE = ImageIO.read(new File("IMAGES/ELEMENTS/wall/wall_haut_gauche.png"));
				IMG_WALL_BAS_GAUCHE = ImageIO.read(new File("IMAGES/ELEMENTS/wall/wall_bas_gauche.png"));
				IMG_WALL_BAS_DROITE = ImageIO.read(new File("IMAGES/ELEMENTS/wall/wall_bas_droite.png"));
				IMG_WALL_INTER_GAUCHE = ImageIO.read(new File("IMAGES/ELEMENTS/wall/wall_inter_gauche.png"));
				IMG_WALL_INTER_DROITE = ImageIO.read(new File("IMAGES/ELEMENTS/wall/wall_inter_droite.png"));
				//montagne
				IMG_MONTAGNE_DROITE = ImageIO.read(new File("IMAGES/ELEMENTS/montagne/montagne_droite.png"));
				IMG_MONTAGNE_GAUCHE = ImageIO.read(new File("IMAGES/ELEMENTS/montagne/montagne_gauche.png"));
				IMG_MONTAGNE_HAUT = ImageIO.read(new File("IMAGES/ELEMENTS/montagne/montagne_haut.png"));
				IMG_MONTAGNE_BAS = ImageIO.read(new File("IMAGES/ELEMENTS/montagne/montagne_bas.png"));
				IMG_MONTAGNE_HAUT_DROITE = ImageIO.read(new File("IMAGES/ELEMENTS/montagne/montagne_haut_droite.png"));
				IMG_MONTAGNE_HAUT_GAUCHE = ImageIO.read(new File("IMAGES/ELEMENTS/montagne/montagne_haut_gauche.png"));
				IMG_MONTAGNE_BAS_GAUCHE = ImageIO.read(new File("IMAGES/ELEMENTS/montagne/montagne_bas_gauche.png"));
				IMG_MONTAGNE_BAS_DROITE = ImageIO.read(new File("IMAGES/ELEMENTS/montagne/montagne_bas_droite.png"));
				IMG_MONTAGNE_INTER_GAUCHE = ImageIO.read(new File("IMAGES/ELEMENTS/montagne/montagne_inter_gauche.png"));
				IMG_MONTAGNE_INTER_DROITE = ImageIO.read(new File("IMAGES/ELEMENTS/montagne/montagne_inter_droite.png"));
				//arbres
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
				
				xtmp=x1;
				ytmp=y1;
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
				for(int i=0;i<w.getY();i++) {
					for(int j=0;j<w.getX();j++) {
						afficherNuage(i,j,g); 	
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
				//sols
				if(w.n.alti[j][i]==-1 ) 
					g.drawImage(IMG_WATER, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);			
				else if(w.getWorld()[j][i]==-1)
					g.drawImage(IMG_DRY, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
				else if(w.n.alti[j][i]>=7)
					g.drawImage(IMG_ROCKY, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
				else	
					g.drawImage(IMG_GRASS, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
				
				//liquide
				if(w.liquide[j][i]>=1) 
					g.drawImage(IMG_WATER, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
			}
			
		}
		//bordures
		for(int i=0;i<w.getY();i++) {
			for(int j=0;j<w.getX();j++) {
				if( w.n.alti[j][i]==-1) { //bordure_eau
					if(i-1>=0 && w.n.alti[j][i-1]!=-1) { //haut
						if(j+1<w.getX() && w.n.alti[j+1][i]!=-1) 
							g.drawImage(IMG_BORD_HAUT_DROITE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
						else if(j-1>=0 && w.n.alti[j-1][i]!=-1) 
							g.drawImage(IMG_BORD_HAUT_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
						else 
							g.drawImage(IMG_BORD_HAUT, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
					}
					else if(j+1<w.getX() && w.n.alti[j+1][i]!=-1) { //droit
						if(i-1>=0 && w.n.alti[j][i-1]!=-1) 
							g.drawImage(IMG_BORD_HAUT_DROITE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
						else if(i+1<w.getY() && w.n.alti[j][i+1]!=-1) {
							g.drawImage(IMG_BORD_DROITE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
							g.drawImage(IMG_BORD_BAS, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*(i+1))-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
						}else 
							g.drawImage(IMG_BORD_DROITE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
					}
					else if(i+1<w.getY() && w.n.alti[j][i+1]!=-1) { //bas
						if(j+1<w.getX() && w.n.alti[j+1][i]!=-1) {
							g.drawImage(IMG_BORD_DROITE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
							g.drawImage(IMG_BORD_BAS, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
						}else if(j-1>=0 && w.n.alti[j-1][i]!=-1) {
							g.drawImage(IMG_BORD_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
							g.drawImage(IMG_BORD_BAS, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*(i+1))-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
						}else 
							g.drawImage(IMG_BORD_BAS, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*(i+1))-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
					}
					else if(j-1>=0 && w.n.alti[j-1][i]!=-1) { //gauche
						if(i-1>=0 && w.n.alti[j][i-1]!=-1) 
							g.drawImage(IMG_BORD_HAUT_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
						else if(i+1<w.getY() && w.n.alti[j][i+1]!=-1) {
							g.drawImage(IMG_BORD_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
							g.drawImage(IMG_BORD_BAS, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*(i+1))-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
						}else 
							g.drawImage(IMG_BORD_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
					}	
				//----------------------------------------------------------------------------------------
				}else if ( w.n.alti[j][i]>=0 )  { //wall
					if(i-1>=0 && w.n.alti[j][i]>w.n.alti[j][i-1] && w.n.alti[j][i-1]>-1) { //haut
						if(j+1<w.getX() && w.n.alti[j][i]>w.n.alti[j+1][i]  && w.n.alti[j+1][i]>-1) {
							if(w.n.alti[j][i]>=7) {
								g.drawImage(IMG_MONTAGNE_HAUT_DROITE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
								g.drawImage(IMG_MONTAGNE_HAUT, ((f.getX()/(x2-x1))*(j))-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*(i+1))-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);								
							}else {
								g.drawImage(IMG_WALL_HAUT_DROITE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
								g.drawImage(IMG_WALL_HAUT, ((f.getX()/(x2-x1))*(j))-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*(i+1))-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);								
							}
						}else if(j-1>=0 && w.n.alti[j][i]>w.n.alti[j-1][i]  && w.n.alti[j-1][i]>-1) {
							if(w.n.alti[j][i]>=7) {
								g.drawImage(IMG_MONTAGNE_HAUT_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
								g.drawImage(IMG_MONTAGNE_HAUT, ((f.getX()/(x2-x1))*(j))-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*(i+1))-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
							}else {
								g.drawImage(IMG_WALL_HAUT_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
								g.drawImage(IMG_WALL_HAUT, ((f.getX()/(x2-x1))*(j))-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*(i+1))-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
							}
						}else 
							if(w.n.alti[j][i-1]>-1) {
								if(w.n.alti[j][i]>=7)
									g.drawImage(IMG_MONTAGNE_HAUT, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);									
								else
									g.drawImage(IMG_WALL_HAUT, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
							}
					}else if(j+1<w.getX() && w.n.alti[j][i]>w.n.alti[j+1][i]) { //droit
						if(i-1>=0 && w.n.alti[j][i]>w.n.alti[j][i-1]  && w.n.alti[j][i-1]>-1) {
							if(w.n.alti[j][i]>=7)
								g.drawImage(IMG_MONTAGNE_HAUT_DROITE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);							
							else
								g.drawImage(IMG_WALL_HAUT_DROITE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
						}else if(i+1<w.getY() && w.n.alti[j][i]>w.n.alti[j][i+1]  && w.n.alti[j][i+1]>-1) {
							if(w.n.alti[j][i]>=7)
								g.drawImage(IMG_MONTAGNE_BAS_DROITE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
							else
								g.drawImage(IMG_WALL_BAS_DROITE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
						}else 
							if(w.n.alti[j+1][i]>-1) {
								if(w.n.alti[j][i]>=7)
									g.drawImage(IMG_MONTAGNE_DROITE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
								else
									g.drawImage(IMG_WALL_DROITE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
								
							}if(i-1>=0 && j+1<w.getX() && w.n.alti[j][i]==w.n.alti[j+1][i-1] && (i+1<w.getY() && j+1<w.getX() && w.n.alti[j+1][i+1]>-1 )) {
								if(w.n.alti[j][i]>=7)
									g.drawImage(IMG_MONTAGNE_INTER_DROITE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*(i-1))-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
								else
									g.drawImage(IMG_WALL_INTER_DROITE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*(i-1))-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
							}
					}else if(i+1<w.getY() && w.n.alti[j][i]>w.n.alti[j][i+1]) { //bas
						if(j+1<w.getX() && w.n.alti[j][i]>w.n.alti[j+1][i]  && w.n.alti[j+1][i]>-1) {
							if(w.n.alti[j][i]>=7)
								g.drawImage(IMG_MONTAGNE_BAS_DROITE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
							else
								g.drawImage(IMG_WALL_BAS_DROITE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
						}else if(j-1>=0 && w.n.alti[j][i]>w.n.alti[j-1][i]  && w.n.alti[j-1][i]>-1) {
							if(w.n.alti[j][i]>=7)
								g.drawImage(IMG_MONTAGNE_BAS_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);							
							else
								g.drawImage(IMG_WALL_BAS_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);							
							if(i-1>=0 && j-1>=0 && w.n.alti[j][i]==w.n.alti[j-1][i-1]) {
								if(w.n.alti[j][i]>=7)
									g.drawImage(IMG_MONTAGNE_INTER_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*(i-1))-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
								else
									g.drawImage(IMG_WALL_INTER_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*(i-1))-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
							}
						}else {
							if(w.n.alti[j][i+1]>-1) {
								if(w.n.alti[j][i]>=7)
									g.drawImage(IMG_MONTAGNE_BAS, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
								else
									g.drawImage(IMG_WALL_BAS, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
							}
						}
					}else if(j-1>=0 && w.n.alti[j][i]>w.n.alti[j-1][i]) { //gauche
						if(i-1>=0 &&  w.n.alti[j][i]>w.n.alti[j][i-1]  && w.n.alti[j][i-1]>-1) {
							if(w.n.alti[j][i]>=7)
								g.drawImage(IMG_MONTAGNE_HAUT_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);				
							else
								g.drawImage(IMG_WALL_HAUT_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);				
						}else if(i+1<w.getY() &&  w.n.alti[j][i]>w.n.alti[j][i+1]  && w.n.alti[j][i+1]>-1) {
							if(w.n.alti[j][i]>=7)
								g.drawImage(IMG_MONTAGNE_BAS_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
							else
								g.drawImage(IMG_WALL_BAS_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
						}else 
							if(w.n.alti[j-1][i]>-1) {
								if(w.n.alti[j][i]>=7)
									g.drawImage(IMG_MONTAGNE_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
								else
									g.drawImage(IMG_WALL_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
							}if((i-1>=0 && j-1 >=0 && w.n.alti[j][i]==w.n.alti[j-1][i-1]) && (i+1<w.getY() && j-1>=0 && w.n.alti[j-1][i+1]>-1 )) {
								if(w.n.alti[j][i]>=7)
									g.drawImage(IMG_MONTAGNE_INTER_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*(i-1))-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
								else
									g.drawImage(IMG_WALL_INTER_GAUCHE, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*(i-1))-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);	
							}
					}		
			
				}
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
								w.tab_Animal.get(k).pixel=(((f.getX()/(x2-x1)))/4);
								IMG_PIG=IMG_PIG_M[w.tab_Animal.get(k).getDirection()][1];
							}
							else if(w.tab_Animal.get(k).getCpt()==2) {
								w.tab_Animal.get(k).pixel=(2*(((f.getX()/(x2-x1)))/4));
								IMG_PIG=IMG_PIG_M[w.tab_Animal.get(k).getDirection()][0];
							}
							else if(w.tab_Animal.get(k).getCpt()==3) {
								w.tab_Animal.get(k).pixel=(3*(((f.getX()/(x2-x1)))/4));
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
								w.tab_Animal.get(k).pixel=(((f.getY()/(y2-y1)))/4);
								IMG_PIG=IMG_PIG_M[w.tab_Animal.get(k).getDirection()][1];
							}
							else if(w.tab_Animal.get(k).getCpt()==2) {
								w.tab_Animal.get(k).pixel=(2*(((f.getY()/(y2-y1)))/4));
								IMG_PIG=IMG_PIG_M[w.tab_Animal.get(k).getDirection()][0];
							}
							else if(w.tab_Animal.get(k).getCpt()==3) {
								w.tab_Animal.get(k).pixel=(3*(((f.getY()/(y2-y1)))/4));
								IMG_PIG=IMG_PIG_M[w.tab_Animal.get(k).getDirection()][2];
							}
						
							else if(w.tab_Animal.get(k).getCpt()==0 ){
								w.tab_Animal.get(k).pixel=0;
								IMG_PIG=IMG_PIG_M[w.tab_Animal.get(k).getDirection()][0];

							}
							else if(w.tab_Animal.get(k).getCpt()>3)
								IMG_PIG=IMG_PIG_M[w.tab_Animal.get(k).getDirection()][0];
						}
						
						//System.out.println(w.tab_Animal.get(k).getDirection()+" "+pixel+" "+"X="+f.getX()/(x2-x1)+" Y="+f.getY()/(y2-y1));
						if(w.tab_Animal.get(k).getDirection()==0)
							g.drawImage(IMG_PIG, ((f.getX()/((x2-x1)))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/((y2-y1)))*i  -20-w.tab_Animal.get(k).pixel)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
						if(w.tab_Animal.get(k).getDirection()==1)
							g.drawImage(IMG_PIG, (w.tab_Animal.get(k).pixel+(f.getX()/((x2-x1)))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/((y2-y1)))*i  -20)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
						if(w.tab_Animal.get(k).getDirection()==2)
							g.drawImage(IMG_PIG, ((f.getX()/((x2-x1)))*j)-(xtmp*(f.getX()/(x2-x1))),(w.tab_Animal.get(k).pixel+((f.getY()-40)/((y2-y1)))*i  -20)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
						if(w.tab_Animal.get(k).getDirection()==3)
							g.drawImage(IMG_PIG, ((f.getX()/((x2-x1)))*j  -w.tab_Animal.get(k).pixel)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/((y2-y1)))*i  -20)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
					}else {
						g.drawImage(IMG_PIG, ((f.getX()/((x2-x1)))*j)-(xtmp*(f.getX()/(x2-x1))) ,(((f.getY()-40)/((y2-y1)))*i  -20)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
					}
					}
						
					else if(w.tab_Animal.get(k).getAction()==2) //s'il mange
						g.drawImage(IMG_PIG, ((f.getX()/((x2-x1)))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/((y2-y1)))*i -20)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
					
				}
				
				//*******************************************************************************************************************************************************
				
				else if (w.tab_Animal.get(k) instanceof Chevre) {

					if(w.tab_Animal.get(k).getAction()==1 ) //s'il est debout
					{
						if(w.tab_Animal.get(k).getDirection()!=-1) {
							if(w.tab_Animal.get(k).getDirection()==1 || w.tab_Animal.get(k).getDirection()==3) {
								if(w.tab_Animal.get(k).getCpt()==1) {
									w.tab_Animal.get(k).pixel=(((f.getX()/(x2-x1)))/4);
									IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][1];
								}
								else if(w.tab_Animal.get(k).getCpt()==2) {
									w.tab_Animal.get(k).pixel=(2*(((f.getX()/(x2-x1)))/4));
									IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][0];
								}
								else if(w.tab_Animal.get(k).getCpt()==3) {
									w.tab_Animal.get(k).pixel=(3*(((f.getX()/(x2-x1)))/4));
									IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][2];
								}
								else if(w.tab_Animal.get(k).getCpt()==0){
									w.tab_Animal.get(k).pixel=0;
									IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][0];

								}
								else if(w.tab_Animal.get(k).getCpt()>3)
									IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][0];
							}else {
								if(w.tab_Animal.get(k).getCpt()==1) {
									w.tab_Animal.get(k).pixel=(((f.getY()/(y2-y1)))/4);
									IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][1];
								}
								else if(w.tab_Animal.get(k).getCpt()==2) {
									w.tab_Animal.get(k).pixel=(2*(((f.getY()/(y2-y1)))/4));
									IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][0];
								}
								else if(w.tab_Animal.get(k).getCpt()==3) {
									w.tab_Animal.get(k).pixel=(3*(((f.getY()/(y2-y1)))/4));
									IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][2];
								}
							
								else if(w.tab_Animal.get(k).getCpt()==0 ){
									w.tab_Animal.get(k).pixel=0;
									IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][0];

								}
								else if(w.tab_Animal.get(k).getCpt()>3)
									IMG_GOAT=IMG_GOAT_M[w.tab_Animal.get(k).getDirection()][0];
							}
							
							//System.out.println(w.tab_Animal.get(k).getDirection()+" "+pixel+" "+"X="+f.getX()/(x2-x1)+" Y="+f.getY()/(y2-y1));
							if(w.tab_Animal.get(k).getDirection()==0)
								g.drawImage(IMG_GOAT, ((f.getX()/((x2-x1)))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/((y2-y1)))*i  -20-w.tab_Animal.get(k).pixel)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
							if(w.tab_Animal.get(k).getDirection()==1)
								g.drawImage(IMG_GOAT, (w.tab_Animal.get(k).pixel+(f.getX()/((x2-x1)))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/((y2-y1)))*i  -20)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
							if(w.tab_Animal.get(k).getDirection()==2)
								g.drawImage(IMG_GOAT, ((f.getX()/((x2-x1)))*j)-(xtmp*(f.getX()/(x2-x1))),(w.tab_Animal.get(k).pixel+((f.getY()-40)/((y2-y1)))*i  -20)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
							if(w.tab_Animal.get(k).getDirection()==3)
								g.drawImage(IMG_GOAT, ((f.getX()/((x2-x1)))*j  -w.tab_Animal.get(k).pixel)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/((y2-y1)))*i  -20)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
						}else {
							g.drawImage(IMG_GOAT, ((f.getX()/((x2-x1)))*j)-(xtmp*(f.getX()/(x2-x1))) ,(((f.getY()-40)/((y2-y1)))*i  -20)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
						}
						}
							
						else if(w.tab_Animal.get(k).getAction()==2) //s'il mange
							g.drawImage(IMG_GOAT, ((f.getX()/((x2-x1)))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/((y2-y1)))*i -20)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
						
					
				}
				
				//*******************************************************************************************************************************************************
				else if (w.tab_Animal.get(k) instanceof Lapin) {
					if(w.tab_Animal.get(k).getAction()==1) 	//s'il est debout
					{
						
						if(w.tab_Animal.get(k).getDirection()!=-1) {
							if(w.tab_Animal.get(k).getDirection()==1 || w.tab_Animal.get(k).getDirection()==3) {
								if(w.tab_Animal.get(k).getCpt()==1) {
									w.tab_Animal.get(k).pixel=(((f.getX()/(x2-x1)))/4);
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][1];
								}
								else if(w.tab_Animal.get(k).getCpt()==2) {
									w.tab_Animal.get(k).pixel=(2*(((f.getX()/(x2-x1)))/4));
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][0];
								}
								else if(w.tab_Animal.get(k).getCpt()==3) {
									w.tab_Animal.get(k).pixel=(3*(((f.getX()/(x2-x1)))/4));
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][2];
								}
								else if(w.tab_Animal.get(k).getCpt()==0){
									w.tab_Animal.get(k).pixel=0;
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][0];

								}
								else if(w.tab_Animal.get(k).getCpt()>3)
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][0];
							}else {
								if(w.tab_Animal.get(k).getCpt()==1) {
									w.tab_Animal.get(k).pixel=(((f.getY()/(y2-y1)))/4);
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][1];
								}
								else if(w.tab_Animal.get(k).getCpt()==2) {
									w.tab_Animal.get(k).pixel=(2*(((f.getY()/(y2-y1)))/4));
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][0];
								}
								else if(w.tab_Animal.get(k).getCpt()==3) {
									w.tab_Animal.get(k).pixel=(3*(((f.getY()/(y2-y1)))/4));
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][2];
								}
							
								else if(w.tab_Animal.get(k).getCpt()==0 ){
									w.tab_Animal.get(k).pixel=0;
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][0];

								}
								else if(w.tab_Animal.get(k).getCpt()>3)
									IMG_RABBIT=IMG_RABBIT_M[w.tab_Animal.get(k).getDirection()][0];
							}
							
							//System.out.println(w.tab_Animal.get(k).getDirection()+" "+pixel+" "+"X="+f.getX()/(x2-x1)+" Y="+f.getY()/(y2-y1));
							if(w.tab_Animal.get(k).getDirection()==0)
								g.drawImage(IMG_RABBIT, ((f.getX()/((x2-x1)))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/((y2-y1)))*i  -20-w.tab_Animal.get(k).pixel)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
							if(w.tab_Animal.get(k).getDirection()==1)
								g.drawImage(IMG_RABBIT, (w.tab_Animal.get(k).pixel+(f.getX()/((x2-x1)))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/((y2-y1)))*i  -20)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
							if(w.tab_Animal.get(k).getDirection()==2)
								g.drawImage(IMG_RABBIT, ((f.getX()/((x2-x1)))*j)-(xtmp*(f.getX()/(x2-x1))),(w.tab_Animal.get(k).pixel+((f.getY()-40)/((y2-y1)))*i  -20)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
							if(w.tab_Animal.get(k).getDirection()==3)
								g.drawImage(IMG_RABBIT, ((f.getX()/((x2-x1)))*j  -w.tab_Animal.get(k).pixel)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/((y2-y1)))*i  -20)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
						}else {
							g.drawImage(IMG_RABBIT, ((f.getX()/((x2-x1)))*j)-(xtmp*(f.getX()/(x2-x1))) ,(((f.getY()-40)/((y2-y1)))*i  -20)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
						}
						}
							
						else if(w.tab_Animal.get(k).getAction()==2) //s'il mange
							g.drawImage(IMG_RABBIT, ((f.getX()/((x2-x1)))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/((y2-y1)))*i -20)-(ytmp*(f.getY()/((y2-y1)))),f.getX()/((x2-x1)),f.getY()/((y2-y1))+20, this);
						
				}
			}
		}
		}catch(Exception e){}
	}
	
	public void afficher_decors(int i,int j,Graphics g) {
		try {
		switch(w.getWorld()[j][i]) {
		case 1: //Herbes
			g.drawImage(IMG_BUSH, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
			break;
				
		case 2: //Arbres
			int taille_x=(f.getX()/(x2-x1));
			int taille_y=(f.getY()-40)/(y2-y1);
			for(int a=0; a < w.tab_Arbre.size(); a++) {
				if( (w.tab_Arbre.get(a).getX()==j) && (w.tab_Arbre.get(a).getY()==i) ) {
					if(w.tab_Arbre.get(a).getNom().equals("Pommier")) { 
						
						switch(w.tab_Arbre.get(a).getCroissance()) {
							case 1: //petit
								if(w.tab_Arbre.get(a).getCendre() == false) {
									g.drawImage(IMG_POMMIER_P,  ((taille_x*j)-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
								}
								else 
									g.drawImage(IMG_POMMIER_PB, ((taille_x*j)-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
								break;
							case 2: //moyen
								if(w.tab_Arbre.get(a).getCendre() == false)
									g.drawImage(IMG_POMMIER_M,  ((taille_x*j)-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
								else 
									g.drawImage(IMG_POMMIER_MB, ((taille_x*j)-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
								break;
							case 3: //grand
								if(w.tab_Arbre.get(a).getCendre() == false)
									g.drawImage(IMG_POMMIER_G, ((taille_x*j)-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
								else 
									g.drawImage(IMG_POMMIER_GB, ((taille_x*j)-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
								break;
							default:;	
						}
						
					}else if(w.tab_Arbre.get(a).getNom().equals("Cocotier")) {
						switch(w.tab_Arbre.get(a).getCroissance()) {
						case 1: //petit
							if(w.tab_Arbre.get(a).getCendre() == false)
								g.drawImage(IMG_COCOTIER_P,  ((taille_x*j)-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
							else 
								g.drawImage(IMG_COCOTIER_PB,  ((taille_x*j)-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
							break;
						case 2: //moyen
							if(w.tab_Arbre.get(a).getCendre() == false)
								g.drawImage(IMG_COCOTIER_M,  ((taille_x*j)-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
							else 
								g.drawImage(IMG_COCOTIER_MB,  ((taille_x*j)-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
							break;
						case 3: //grand
							if(w.tab_Arbre.get(a).getCendre() == false)
								g.drawImage(IMG_COCOTIER_G, (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
							else 
								g.drawImage(IMG_COCOTIER_GB,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
							break;
						default:;	
					}
					
					}		
					
				}

			}
			if(foudre) {
				if(w.l.estAfficher()) {
					g.drawImage(IMG_NUAGE2,  (taille_x*arbre.getX()-taille_x*2)-(xtmp*(taille_x)),(taille_y*arbre.getY()-taille_y*12)-(ytmp*(taille_y)),taille_x*6,taille_y*6, this);
					g.drawImage(IMG_LIGHT,  (taille_x*arbre.getX()-taille_x)-(xtmp*(taille_x)),(taille_y*arbre.getY()-taille_y*7)-(ytmp*(taille_y)),taille_x*3,taille_y*8, this);
					w.l.setLight();//sa bug trop meme si c'est beau avec
				}
				else {
					foudre=false;
					w.l.setLight();
				}
			}

			if(w.RechercheArbres(j,i).getFeu()) { //Si l'arbre est en feu
					g.drawImage(IMG_FIRE, (taille_x*j-taille_x*2)-(xtmp*(taille_x)),((taille_y)*i-taille_y*7)-(ytmp*(taille_y)),taille_x*5,taille_y*8, this);

			}
			
			break;
				
		case 3: //Rochers
			if(w.n.alti[j][i]==-1)
				g.drawImage(IMG_ROCHER_EAU, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
			else
				g.drawImage(IMG_ROCHER, ((f.getX()/(x2-x1))*j)-(xtmp*(f.getX()/(x2-x1))),(((f.getY()-40)/(y2-y1))*i)-(ytmp*(f.getY()/(y2-y1))) ,f.getX()/(x2-x1),f.getY()/(y2-y1), this);
			break;
		
		case 4:	 //Eau
			break;
		
		case 5: //Lave	
			break;
			
		default:;
	}
	}catch(Exception e) {}
	}
	public void afficherNuage(int i,int j,Graphics g) {
		int taille_x=(f.getX()/(x2-x1));
		int taille_y=(f.getY()-40)/(y2-y1);
		for(int var=0;var<w.tab_Cloud.size();var++) {
			Cloud c=w.tab_Cloud.get(var);
			if(c.getY()==i && c.getX()==j) {
				int decalage=(taille_x/5);
				//System.out.println(decalage+" "+taille_x+" "+(taille_x/5)*2);
				if(c.fin_vie) {
					int d=c.ombre_y-c.getY()-2;
					g.drawImage(IMG_NUAGE2,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
					g.drawImage(IMG_OMBRE,  (taille_x*c.ombre_x-taille_x)-(xtmp*(taille_x)),(taille_y*c.ombre_y)-(ytmp*(taille_y)),taille_x*3,taille_y, this);
					g.drawImage(IMG_LIGHT,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i)-(ytmp*(taille_y)),taille_x*3,taille_y*(3+d), this);
					try {
						w.l.setLight();
					} catch (IOException e) {}
					int distance=0;
					int d2=c.ombre_y-c.getY()-2;
					while(distance<d2) {
						if(distance%2==0)
							g.drawImage(IMG_PLUIE,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i+taille_y*distance)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
						distance++;
					}
				}else if(c.pluie) {
					g.drawImage(IMG_NUAGE1,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
					g.drawImage(IMG_OMBRE,  (taille_x*c.ombre_x-taille_x)-(xtmp*(taille_x)),(taille_y*c.ombre_y)-(ytmp*(taille_y)),taille_x*3,taille_y, this);
					int distance=0;
					int d=c.ombre_y-c.getY()-2;
					while(distance<d) {
						if(distance%2==0)
							g.drawImage(IMG_PLUIE,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i+taille_y*distance)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
						distance++;
					}
				}else if(c.heart) {
					g.drawImage(IMG_NUAGE_HEART,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
					g.drawImage(IMG_OMBRE,  (taille_x*c.ombre_x-taille_x)-(xtmp*(taille_x)),(taille_y*c.ombre_y)-(ytmp*(taille_y)),taille_x*3,taille_y, this);
					int distance=0;
					int d=c.ombre_y-c.getY()-2;
					while(distance<d) {
						if(distance==d-1)
							g.drawImage(IMG_HEART1,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i+taille_y*distance)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
						else if(distance%2==0)
							g.drawImage(IMG_HEART0,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i+taille_y*distance)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
						distance++;
					}
				}else if(c.foudre) {
					
					int d=c.ombre_y-c.getY()-2;
					g.drawImage(IMG_NUAGE2,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
					g.drawImage(IMG_OMBRE,  (taille_x*c.ombre_x-taille_x)-(xtmp*(taille_x)),(taille_y*c.ombre_y)-(ytmp*(taille_y)),taille_x*3,taille_y, this);
					if(c.duree_instant>=c.duree_foudre/2) {
						g.drawImage(IMG_LIGHT,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i)-(ytmp*(taille_y)),taille_x*3,taille_y*(3+d), this);
					try {
						w.l.setLight();
					} catch (IOException e) {}
					}
					
					
				}else if(c.getMature()==false) {
					IMG_NUAGE=IMG_NUAGE_NORMAL;
					int taillex=(taille_x*3)/5;
					int tailley=(taille_y*4)/5;
					if(c.getAge()<2 ) {
						g.drawImage(IMG_NUAGE,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taillex,tailley, this);
					}
					else if(c.getAge()<4 ) {
						g.drawImage(IMG_NUAGE,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taillex*2,tailley*2, this);
					}else if(c.getAge()<6 ) {
						g.drawImage(IMG_NUAGE,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taillex*3,tailley*3, this);
					}else if(c.getAge()<8 ) {
						g.drawImage(IMG_NUAGE,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taillex*4,tailley*4, this);
					}else if(c.getAge()<=10 ) {
						g.drawImage(IMG_NUAGE,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taillex*5,tailley*5,this);
					}
				}else if(c.getDirection()==1 ) {
					IMG_NUAGE=IMG_NUAGE0;
					if(c.getCpt()<10 ) {
						g.drawImage(IMG_NUAGE,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
						g.drawImage(IMG_OMBRE,  (taille_x*c.ombre_x-taille_x)-(xtmp*(taille_x)),(taille_y*c.ombre_y)-(ytmp*(taille_y)),taille_x*3,taille_y, this);
					}
					else if(c.getCpt()<20) {
						g.drawImage(IMG_NUAGE,  (taille_x*j-taille_x+decalage)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
						g.drawImage(IMG_OMBRE,  (taille_x*c.ombre_x-taille_x+decalage)-(xtmp*(taille_x)),(taille_y*c.ombre_y)-(ytmp*(taille_y)),taille_x*3,taille_y, this);
					}else if(c.getCpt()<30) {
						g.drawImage(IMG_NUAGE,  (taille_x*j-taille_x+decalage*2)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
						g.drawImage(IMG_OMBRE,  (taille_x*c.ombre_x-taille_x+decalage*2)-(xtmp*(taille_x)),(taille_y*c.ombre_y)-(ytmp*(taille_y)),taille_x*3,taille_y, this);
					}else if(c.getCpt()<40) {
						g.drawImage(IMG_NUAGE,  (taille_x*j-taille_x+decalage*3)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
						g.drawImage(IMG_OMBRE,  (taille_x*c.ombre_x-taille_x+decalage*3)-(xtmp*(taille_x)),(taille_y*c.ombre_y)-(ytmp*(taille_y)),taille_x*3,taille_y, this);
					}else if(c.getCpt()<=50) {
						g.drawImage(IMG_NUAGE,  (taille_x*j-taille_x+decalage*4)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
						g.drawImage(IMG_OMBRE,  (taille_x*c.ombre_x-taille_x+decalage*4)-(xtmp*(taille_x)),(taille_y*c.ombre_y)-(ytmp*(taille_y)),taille_x*3,taille_y, this);
					}
				}else if(c.getDirection()==3) {
					IMG_NUAGE=IMG_NUAGE0;
					if(c.getCpt()<10 ) {
						g.drawImage(IMG_NUAGE,  (taille_x*j-taille_x)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
						g.drawImage(IMG_OMBRE,  (taille_x*c.ombre_x-taille_x)-(xtmp*(taille_x)),(taille_y*c.ombre_y)-(ytmp*(taille_y)),taille_x*3,taille_y, this);
					}
					else if(c.getCpt()<20) {
						g.drawImage(IMG_NUAGE,  (taille_x*j-taille_x-decalage)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
						g.drawImage(IMG_OMBRE,  (taille_x*c.ombre_x-taille_x-decalage)-(xtmp*(taille_x)),(taille_y*c.ombre_y)-(ytmp*(taille_y)),taille_x*3,taille_y, this);
					}else if(c.getCpt()<30) {
						g.drawImage(IMG_NUAGE,  (taille_x*j-taille_x-decalage*2)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
						g.drawImage(IMG_OMBRE,  (taille_x*c.ombre_x-taille_x-decalage*2)-(xtmp*(taille_x)),(taille_y*c.ombre_y)-(ytmp*(taille_y)),taille_x*3,taille_y, this);
					}else if(c.getCpt()<40) {
						g.drawImage(IMG_NUAGE,  (taille_x*j-taille_x-decalage*3)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
						g.drawImage(IMG_OMBRE,  (taille_x*c.ombre_x-taille_x-decalage*3)-(xtmp*(taille_x)),(taille_y*c.ombre_y)-(ytmp*(taille_y)),taille_x*3,taille_y, this);
					}else if(c.getCpt()<=50) {
						g.drawImage(IMG_NUAGE,  (taille_x*j-taille_x-decalage*4)-(xtmp*(taille_x)),(taille_y*i-taille_y*3)-(ytmp*(taille_y)),taille_x*3,taille_y*4, this);
						g.drawImage(IMG_OMBRE,  (taille_x*c.ombre_x-taille_x-decalage*4)-(xtmp*(taille_x)),(taille_y*c.ombre_y)-(ytmp*(taille_y)),taille_x*3,taille_y, this);
					}
				}
			}
		}
	}
	public void keyPressed(KeyEvent e) {
	
		int c= e.getKeyCode();
		//deplacement zoom
		if(c == KeyEvent.VK_NUMPAD8) {
			if(y1>0) {
				y1--;
				y2--;
			}
		}else if(c == KeyEvent.VK_NUMPAD5) {
			if(y2<w.getY()) {
				y1++;
				y2++;
			}
		
		}else if(c == KeyEvent.VK_NUMPAD4) {
			if(x1>0) {
				x1--;
				x2--;
			}
		
		}else if(c == KeyEvent.VK_NUMPAD6) {
			if(x2<w.getX()) {
				x1++;
				x2++;
			}
		}
		//flèches
		else if(c == KeyEvent.VK_LEFT) {
			if(w.getDelay()>50) {
				w.setDelay((w.getDelay())-50);
			}
		}
		else if(c == KeyEvent.VK_RIGHT) {
			if(w.getDelay()<52) {
				w.setDelay((w.getDelay())+50);
			}
		}else if(c == KeyEvent.VK_UP) { //zoom
			if (x2>x1+10) 
				x2=x2-2;
			else if (x1<x2-10)
				x1=x1+2;	
			if (y2>y1+10)
				y2=y2-2;
			else if (y1<y2-10)
				y1=y1+2;
		}else if(c == KeyEvent.VK_DOWN) { //de-zoom
			if (x2+1<w.getX())
				x2=x2+2;
			else if (x1-1>0)
				x1=x1-2;	
			if (y2+1<w.getY())
				y2=y2+2;
			else if (y1-1>0)
				y1=y1-2;
			
		//autres	
		}else if(c == KeyEvent.VK_F) { //fin
			f.dispose();
			w.setFin();
		
		}
		try {
			if(c == KeyEvent.VK_L) { //foudre
				w.l.setLight();
				w.l.cpt=0;
				foudre=true;
				arbre=w.tab_Arbre.get((int)(Math.random()*w.tab_Arbre.size()));
				arbre.setFeu(true);
			}
		}catch(Exception x) {};
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
}




















