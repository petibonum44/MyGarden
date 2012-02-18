package org.srv.objets.walls;

import org.ihm.layeredpanel.gridpanel.model.EdgeBean;
import org.ihm.layeredpanel.wallpanel.WallState;
import org.srv.objets.vegetables.VegetableBean;


public class Wall implements Cloneable {

		private Double xStart = null;
		private Double yStart = null;
		private Double xEnd = null;
		private Double yEnd = null;
		
		private EdgeBean edge = null;
		
		private String wallType = null;
		
		private VegetableBean vegetable = null;
		public VegetableBean getVegetable() {
			return vegetable;
		}
		public void setVegetable(VegetableBean vegetable) {
			this.vegetable = vegetable;
		}

		private WallState state = new WallState(false,false);
		public WallState getState() {
			return state;
		}
		public void setState(WallState state) {
			this.state = state;
		}
		public String getWallType() {
			return wallType;
		}
		public void setWallType(String wallType) {
			this.wallType = wallType;
		}
		public Wall(Double xStart, Double yStart, Double xEnd, Double yEnd,String wallType) {
			super();
			this.xStart = xStart;
			this.yStart = yStart;
			this.xEnd = xEnd;
			this.yEnd = yEnd;
			this.wallType = wallType;
			edge = new EdgeBean(null, null);
		}
		public Double getxStart() {
			return xStart;
		}
		public void setxStart(Double xStart) {
			this.xStart = xStart;
		}
		public Double getyStart() {
			return yStart;
		}
		public void setyStart(Double yStart) {
			this.yStart = yStart;
		}
		public Double getxEnd() {
			return xEnd;
		}
		public void setxEnd(Double xEnd) {
			this.xEnd = xEnd;
		}
		public Double getyEnd() {
			return yEnd;
		}
		public void setyEnd(Double yEnd) {
			this.yEnd = yEnd;
		}
		public Wall getWallEnd() {
			return edge.getWallEnd();
		}
		public void setWallEnd(Wall wallEnd) {
			
			edge.setWallEnd(wallEnd);
		}
		public Wall getWallStart() {
			return edge.getWallStart();
		}
		public void setWallStart(Wall wallStart) {
			edge.setWallStart(wallStart);
		}
		@Override
		public Object clone() {
			Wall cp = new Wall(this.xStart, this.yStart, this.xEnd, this.yEnd, this.wallType);
			cp.getState().setIsSelected(getState().getIsSelected());
			cp.getState().setHasFocus(getState().getHasFocus());
			
			if (edge.getWallEnd()!=null) {
				cp.setWallEnd((Wall)edge.getWallEnd().clone());
			}
			if (edge.getWallStart()!=null) {
				cp.setWallStart((Wall)edge.getWallStart().clone());
			}
			
			return cp;
		}
		
		public void setHasFocus(Boolean hasFocus) {
			getState().setHasFocus(hasFocus);
			
		}
		
	
}
