package org.ihm.layeredpanel.wallpanel;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.CellRendererPane;
import javax.swing.JPanel;

import org.ihm.layeredpanel.gridpanel.EventRefreshView;
import org.ihm.layeredpanel.gridpanel.MainGridPanel;
import org.ihm.layeredpanel.gridpanel.model.GridModel;
import org.ihm.layeredpanel.gridpanel.model.WallSelectionModel;
import org.ihm.layeredpanel.wallpanel.draganddrop.AreaTransferHandler;
import org.ihm.model.ClientRequest;
import org.ihm.model.DataOperation;
import org.ihm.model.IDisplayView;
import org.ihm.model.MainController;
import org.srv.objets.walls.Wall;

public class WallPanel extends JPanel implements IDisplayView {
	public static String WALLPANENAME = "WALLPANENAME";
	CellRendererPane cellRendererPane = new CellRendererPane();
	WallRendererDefault renderer = null;
    final static float dash1[] = {10.0f};
	 final static BasicStroke dashed = new BasicStroke(1.0f, 
             BasicStroke.CAP_BUTT, 
             BasicStroke.JOIN_MITER, 
             10.0f, dash1, 0.0f);
	public WallPanel(	WallRendererDefault renderer ) {
		super();
		this.setName(WALLPANENAME);
		this.add(cellRendererPane);
		this.renderer = renderer;
		this.setOpaque(true);
		
		setTransferHandler(new AreaTransferHandler());
		
	}
	/**
	 * Dessin du composant
	 */
	@Override
	protected void paintComponent(Graphics g) {
	
		// on parcours l'ensemble du model pour afficher les murs
		Iterator<Wall> iteratorWall = WallModel.getInstance().iterator(renderer.getWallType());
		while(iteratorWall.hasNext()) {
			Wall wall = iteratorWall.next();
			fillPlanche(g, wall);

			while (wall!=null) {
				paintOneWall(renderer, g, wall);
				wall = wall.getWallStart();
			}
		
		}
		if (WallModel.getInstance().getCurrentDrawingWall()!=null && WallModel.getInstance().getCurrentDrawingWall().getWallType().equals(renderer.getWallType())) {
			Wall wall = WallModel.getInstance().getCurrentDrawingWall();
		
			while (wall!=null) {
				
				paintOneWall(renderer, g, wall);
			wall = wall.getWallStart();
			}
			fillPlanche(g, WallModel.getInstance().getCurrentDrawingWall());
		}
	}
	
	private void paintOneWall(WallRendererDefault renderer, Graphics g,Wall wall) {
	
			renderer.setCurrentWall(wall);
			Component comp = renderer.getTimeLineComponent(false,//WallModel.getInstance().isSelected(wall) ,
				 wall.getState().getHasFocus());
			int xStart = GridModel.getInstance().getXScreen(wall.getxStart()).intValue();
		int yStart = GridModel.getInstance().getYScreen(wall.getyStart()).intValue();
		int xEnd = GridModel.getInstance().getXScreen(wall.getxEnd()).intValue();
		int yEnd = GridModel.getInstance().getYScreen(wall.getyEnd()).intValue();
		
		int w = Math.abs(xEnd-xStart)+2*WallRenderer.offsetX;
		int h = Math.abs(yEnd-yStart)+2*WallRenderer.offsetY;
		cellRendererPane.paintComponent(g,
				comp, 
				this,
				xStart<xEnd?xStart-WallRenderer.offsetX:xEnd-WallRenderer.offsetX,
				yStart<yEnd?yStart-WallRenderer.offsetY:yEnd-WallRenderer.offsetY,
				w,
				h);
		
		
	}
	
	private void fillPlanche(Graphics g, Wall wall) {
		// construction de tableau de int;
		renderer.fillPlanche(g, wall);
	}
/** 
 * Gestion des dataOperation en provenance de MainController
 */
	@Override
	public void doDataOperations(List<DataOperation> listeDataOperation) {

	}



	@Override
	public void doDataOperation(DataOperation dop) {
	}


}
