package org.ihm.layeredpanel.gridpanel.model;

import java.util.Iterator;

import javax.swing.text.EditorKit;

import org.apache.log4j.Logger;
import org.ihm.ShapeUtils;
import org.ihm.layeredpanel.wallpanel.WallModel;
import org.srv.objets.walls.Wall;
import org.srv.objets.walls.WallUtils;


public class WallSelectionModel {

	private static WallSelectionModel instance = null;
	
	private Wall currentSelectedWall = null;
	public Wall getCurrentSelectedWall() {
		return currentSelectedWall;
	}

	public void setCurrentSelectedWall(Wall currentSelectedWall) {
		this.currentSelectedWall = currentSelectedWall;
	}

	private Wall currentFocusWall = null;
	private WallSelectionModel() {
		
	}

	public Wall getCurrentFocusWall() {
		return currentFocusWall;
	}

	private EdgeBean edgeWithFocus = null;
	
	public EdgeBean getEdgeWithFocus() {
		return edgeWithFocus;
	}

	public void setEdgeWithFocus(EdgeBean edgeWithFocus) {
		this.edgeWithFocus = edgeWithFocus;
	}

	public void setCurrentFocusWall(Wall currentFocusWall) {
		this.currentFocusWall = currentFocusWall;
	}

	public static WallSelectionModel getInstance() {
		if (instance ==null) {
			instance = new WallSelectionModel();
			
		}
		return instance;
	}
	
	// recherche du mur selectionné
	public void lookingForSelectedWall(String type ,Double x, Double y) {
		
		// on parcours l'ensemble des murs
		
		for (Iterator<Wall> iterator = WallModel.getInstance().iterator(type); iterator.hasNext();) {
			Wall wall = iterator.next();
			if (ShapeUtils.isPointInsideWall(x, y, wall)) {
				deselectWall();
				currentSelectedWall = wall;
				currentSelectedWall.getState().setIsSelected(true);
				Logger.getLogger(this.getClass()).debug("Aire" + WallUtils.getAire(wall));
				return;
			}
		}
		deselectWall();
	}
	// recherche du mur selectionné
		public void lookingForFocusWall(String type ,Double x, Double y) {
			
			// on parcours l'ensemble des murs
			
			for (Iterator<Wall> iterator = WallModel.getInstance().iterator(type); iterator.hasNext();) {
				Wall wall = iterator.next();
				if (ShapeUtils.isPointInsideWall(x, y, wall)) {
					deFocusWall();
					currentFocusWall = wall;
					WallUtils.setHasFocus(true,currentFocusWall);
					return;
				}
			}
			deFocusWall();
		}
	
	public void lookingForFocusEdge(String type ,Double x, Double y) {
			
			// on parcours l'ensemble des murs
			deFocusEdge();
			if (isOneWallSelected() && currentSelectedWall.getState().getHasFocus()) { 
				edgeWithFocus = ShapeUtils.isPointFocusEdge(x, y, currentSelectedWall);
			}
		}
		
	public void deselectWall() {
		if (currentSelectedWall!=null) {
			currentSelectedWall.getState().setIsSelected(false);
			currentSelectedWall = null;
		}
	}
	public void deFocusWall() {
		if (currentFocusWall!=null) {
			WallUtils.setHasFocus(false,currentFocusWall);
			currentFocusWall = null;
		}
	}
	public void deFocusEdge() {
		if (edgeWithFocus!=null) {
			
			edgeWithFocus = null;
		}
	}
	public boolean isOneWallSelected() {
		return (currentSelectedWall!=null);
	}
	
}
