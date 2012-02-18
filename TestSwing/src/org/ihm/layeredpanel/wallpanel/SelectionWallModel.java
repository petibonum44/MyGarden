package org.ihm.layeredpanel.wallpanel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.ihm.layeredpanel.gridpanel.model.GridModel;
import org.srv.objets.walls.Wall;
import org.srv.objets.walls.WallCst;

public class SelectionWallModel {

		private static SelectionWallModel instance = null;
		
		private List<Wall> listSelectedElements =null;
		private List<Wall> listFocusedElements =null;
		private SelectionWallModel() {
			listSelectedElements = new ArrayList<Wall>();
			listFocusedElements = new ArrayList<Wall>();
		}
		
		public static SelectionWallModel getInstance() {
			if (instance==null) {
				instance = new SelectionWallModel();
			}
			return instance;
		}
		
		
		public void lookForElementsWithFocus(int x, int y) {
			Iterator<Wall> iterator = WallModel.getInstance().iterator(WallCst.TYPE_WALL);
			while (iterator.hasNext()) {
				Wall wall = iterator.next();
				// tranform x,y screen coordinates into x,y into grid coordinates.
				Double xGrid = GridModel.getInstance().getXOnGrid(new Double(x));
				Double yGrid = GridModel.getInstance().getYOnGrid(new Double(y));
				
			}
		}
		
		public void lookForElementsSelected(int x, int y) {
			
		}
		
		public void eventMouseClicked(int x, int y) {
			listSelectedElements.clear();
			lookForElementsSelected(x, y);
		}
		
		public void eventMouseMoved(int x,int y) {
			listFocusedElements.clear();
			lookForElementsWithFocus(x, y);
		}
}
