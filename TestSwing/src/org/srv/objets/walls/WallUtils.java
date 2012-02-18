package org.srv.objets.walls;

import java.util.ArrayList;
import java.util.List;

import org.ihm.layeredpanel.gridpanel.model.EdgeBean;

public class WallUtils {
	/**
	 * REtourne l'aire d'un polygone
	 * http://www.developpez.net/forums/d865192/java/general-java/debuter/polygone-calcul-daire/
	 * @param wall
	 * @return
	 */
	public static Double getAire(Wall wall) {
		Wall currWall = wall;
		List<Double> xList = new ArrayList<Double>();
		List<Double> yList = new ArrayList<Double>();
		while (currWall!=null) {
			xList.add(currWall.getxStart());
			yList.add(currWall.getyStart());
			currWall = currWall.getWallStart();
		}
		// on ajoute le point en 0 en dernier
		xList.add(wall.getxStart());
		yList.add(wall.getyStart());
		
		// calcul de l'aire propement dite
		Double aire = 0d;
		for (int i = 0; i < xList.size()-1; i++) {
			Double x = xList.get(i);
			Double y = yList.get(i);
			Double xplusun = xList.get(i+1);
			Double yplusun = yList.get(i+1);
			Double element = x*yplusun-xplusun*y;
			aire = aire + element;
		}
		// renvoie de l'aire
		return 0.5d * aire;
	}
	
	/**
	 * Positionne le has focus
	 * @param hasFocus
	 * @param wallInit
	 */
	public static void setHasFocus(Boolean hasFocus,Wall wall) {
	
			while (wall!=null && wall.getxStart()!=null) {
			
			if (wall!=null) {
				wall.setHasFocus(hasFocus);	
			}
			wall = wall.getWallStart();
			}	
	}
	/**
	 * Effectue une translation d'un mur lors du drag and drop d'un mur complet.
	 * @param wall
	 * @param dx
	 * @param dy
	 */
	public static void doTranslation(Wall wall, Double dx, Double dy) {
		Wall currWall = wall;
		while (currWall!=null) {
			currWall.setxStart(currWall.getxStart()+dx);
			currWall.setxEnd(currWall.getxEnd()+dx);
			currWall.setyStart(currWall.getyStart()+dy);
			currWall.setyEnd(currWall.getyEnd()+dy);
			currWall = currWall.getWallStart();
		}
	}
	/**
	 * Effectue une translation d'un mur lors du drag and drop d'un mur complet.
	 * @param wall
	 * @param dx
	 * @param dy
	 */
	public static void doTranslationForEdge(EdgeBean edge, Double dx, Double dy) {
		Wall currWall = edge.getWallStart();
	
			currWall.setxStart(currWall.getxStart()+dx);
//			currWall.setxEnd(currWall.getxEnd()+dx);
			currWall.setyStart(currWall.getyStart()+dy);
//			currWall.setyEnd(currWall.getyEnd()+dy);
			currWall = edge.getWallEnd();
			
//			currWall.setxStart(currWall.getxStart()+dx);
			currWall.setxEnd(currWall.getxEnd()+dx);
//			currWall.setyStart(currWall.getyStart()+dy);
			currWall.setyEnd(currWall.getyEnd()+dy);

	}
}
