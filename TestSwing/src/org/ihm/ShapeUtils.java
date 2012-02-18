package org.ihm;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

import org.ihm.layeredpanel.gridpanel.model.EdgeBean;
import org.ihm.layeredpanel.gridpanel.model.GridModel;
import org.srv.objets.walls.Wall;
/**
 * Classe effectuant divers calculs liés aux surfaces
 * pour les parcels de végétaux
 * @author Fabrice
 *
 */
public class ShapeUtils {

		public static Boolean isPointInsideWall(Double x, Double y,Wall wall) {
				GeneralPath polygon = fromWallToShape(wall);
				return polygon.contains(x,y);
		}
		
		public static GeneralPath fromWallToShape(Wall wallInit) {
			
			List<Double> xPoint = new ArrayList<Double>();
			List<Double>  yPoints= new ArrayList<Double>();

			Wall wall = (Wall) wallInit.clone();
 			while (wall!=null && wall.getxStart()!=null) {
				
				if (wall!=null) {
					int x = GridModel.getInstance().getXScreen(wall.getxStart()).intValue();
					int y = GridModel.getInstance().getYScreen(wall.getyStart()).intValue();
					xPoint.add(new Double(x));
					yPoints.add(new Double(y));
			
				}
				wall = wall.getWallStart();
		}
		
		GeneralPath polygon = 
		        new GeneralPath(GeneralPath.WIND_EVEN_ODD,
		                        xPoint.size());
		polygon.moveTo((Double)xPoint.get(0), (Double)yPoints.get(0));

		for (int index = 1; index < xPoint.size(); index++) {
		        polygon.lineTo(xPoint.get(index), yPoints.get(index));
		};
		return polygon;
		}
		
		/**
		 * REcherche des points qui ont le focus
		 * @param xMouse
		 * @param yMouse
		 * @param wallInit
		 * @return
		 */
		public static EdgeBean isPointFocusEdge(Double xMouse, Double yMouse,Wall wallInit) {
			Wall wall = wallInit;
			EdgeBean edge = new EdgeBean(null, null);
 			boolean find = false;
			while (wall!=null && wall.getxStart()!=null) {
				
				if (wall!=null) {
					Double x = GridModel.getInstance().getXScreen(wall.getxStart());
					Double y = GridModel.getInstance().getYScreen(wall.getyStart());
					Shape sh = new Ellipse2D.Double(x-5, y-5, 10, 10);
					if (sh.contains(xMouse,yMouse)) {
						edge.setWallStart(wall);
						find = true;
					}
					 x = GridModel.getInstance().getXScreen(wall.getxEnd());
					 y = GridModel.getInstance().getYScreen(wall.getyEnd());
					 sh = new Ellipse2D.Double(x-5, y-5, 10, 10);
					if (sh.contains(xMouse,yMouse)) {
						edge.setWallEnd(wall);
						find = true;
					}
				}
				wall = wall.getWallStart();
		}
			if (find) {
				return edge;
			}
			else
				return null;
	}
	
}
