package org.ihm.layeredpanel.wallpanel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.srv.objets.walls.Wall;
import org.srv.objets.walls.WallCst;

public class WallModel {

		private static WallModel instance =null;
	
		private List listWall = null;
		private List<Wall> listVegetableWall = null;
		
		private Wall currentDrawingWall = null;
		
		
		private WallModel() {
			listWall = new ArrayList<Wall>();
			listVegetableWall = new ArrayList<Wall>();
			initTest();
		}
	
		public static WallModel getInstance() {
			if (instance ==null) {
				instance = new WallModel();
				
			}
			return instance;
		}
		
		public int getNumberOfWall() {
			return listVegetableWall.size();
		}
		
		public Wall getWallAt(int index) {
			return listVegetableWall.get(index);
		}
		public Wall addWall(Wall wall,String type) {
			if (type==null || WallCst.TYPE_WALL.equals(type)) {
				listWall.add(wall);
			}
			else {
				listVegetableWall.add(wall);
			}
			return wall;
		}
		
		public Iterator<Wall> iterator(String type) {
			if (type==null || WallCst.TYPE_WALL.equals(type)) {
				return listWall.iterator();
			}
			return listVegetableWall.iterator();
		}
		
		public Boolean isSelected(Wall wall) {
			return true;
		}
		
		public Boolean hasFocus(Wall wall) {
			return false;
		}
		
		private void initTest()  {
			
		}

		public Wall getCurrentDrawingWall() {
			return currentDrawingWall;
		}

		public void setCurrentDrawingWall(Wall currentDrawingWall) {
			this.currentDrawingWall = currentDrawingWall;
		}
		
		public void createNewWall(Double x, Double y,Wall wallStart,String type) {
			Wall wall = new Wall(x, y, x, y,type);
			if (wallStart!=null) {
				wall.setxStart(wall.getxEnd());
				wall.setyStart(wall.getyEnd());
			}
			wall.setWallStart(wallStart);
			currentDrawingWall = wall;
			
		}
		public void updateWall(Double x, Double y) {
			
			currentDrawingWall.setxEnd(x);
			currentDrawingWall.setyEnd(y);
		}
		
		public void closeWall() {
			// relier la fin du mur courant avec le debut du premier mur.
			Double xStart = currentDrawingWall.getxStart();
			Double yStart =currentDrawingWall.getyStart();
			Wall wall = currentDrawingWall;
			while (wall.getWallStart()!=null) {
				wall = wall.getWallStart();
			}
			Double xEnd = wall.getxStart();
			Double yEnd = wall.getyStart();
//			createNewWall(xStart, yStart, currentDrawingWall);
			updateWall(xEnd, yEnd);
			addWall(currentDrawingWall,currentDrawingWall.getWallType());
			// il faut envoyer le mur en base
			
			currentDrawingWall =null;
			
			
		}
		
		public void deleteWall() {
			Wall wall = currentDrawingWall.getWallStart();
			currentDrawingWall = wall;
		}
		
		public Double getLength(Wall wall) {
			Double x1 = (wall.getxEnd()-wall.getxStart());
			Double y1 = (wall.getyEnd()-wall.getyStart());
			Double x2 = x1*x1+y1*y1;
			return Math.sqrt(x2);
			
		}
}
