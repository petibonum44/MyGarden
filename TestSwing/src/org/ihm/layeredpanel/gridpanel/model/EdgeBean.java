package org.ihm.layeredpanel.gridpanel.model;

import org.srv.objets.walls.Wall;

public class EdgeBean {
	private Wall wallStart = null;
	private Wall wallEnd = null;
	public EdgeBean(Wall wallStart, Wall wallEnd) {
		super();
		this.wallStart = wallStart;
		this.wallEnd = wallEnd;
	}
	public Wall getWallStart() {
		return wallStart;
	}
	public void setWallStart(Wall wallStart) {
		this.wallStart = wallStart;
	}
	public Wall getWallEnd() {
		return wallEnd;
	}
	public void setWallEnd(Wall wallEnd) {
		this.wallEnd = wallEnd;
	}
	
}
