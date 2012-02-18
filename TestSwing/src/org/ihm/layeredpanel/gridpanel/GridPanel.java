package org.ihm.layeredpanel.gridpanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.List;

import javax.swing.JPanel;

import org.common.utils.GlobalOptions;
import org.ihm.layeredpanel.gridpanel.model.GridModel;
import org.ihm.model.DataOperation;
import org.ihm.model.IDisplayView;
import org.ihm.model.MainController;

public class GridPanel extends JPanel implements IDisplayView{


	private GridModel model;

	public static String GRIDPANELNAME = "GridPanelName";//nomlz
	
	public GridPanel(GridModel model) {
		super();
		setName(GRIDPANELNAME);
		
		this.model = model;
		MainController.getInstance().addView(this);

	}

	/***************************************************/
	/***                 Dessin du composant         ***/
	/***************************************************/
	

	@Override
	protected void paintComponent(Graphics g) {
	/* On passe en 2D */
		Graphics2D g2 = (Graphics2D)g.create();
		setBackground(g2);
		//drawMinorGrid(g2,(double)(getModel().getWidthOfGraduatedRulesInPixel()), (double)(getModel().getWidthOfGraduatedRulesInPixel()),getSize().getWidth(), getSize().getHeight());
		//drawMajorGrid(g2, 0d, (double)(getModel().getWidthOfGraduatedRulesInPixel()),getSize().getWidth(), getSize().getHeight());
		drawMinorGrid(g2,0d, 0d,getSize().getWidth(), getSize().getHeight());
		drawMajorGrid(g2, 0d, 0d,getSize().getWidth(), getSize().getHeight());
				
		if (GlobalOptions.debug) {
			System.out.println("Taille du composant :  X="+getSize().getWidth() + ", Y="+getSize().getHeight());
		}
		
	}
	
	private void setBackground(Graphics2D g2) {
		g2.setBackground(new Color(255,255,255));
	}
	
	/** 
	 * Dessine la grille la plus petite : coordonnées d'origine (0,0)
	 * @param g2
	 * @param xMin
	 * @param yMin
	 * @param xMax
	 * @param yMax
	 */
	private void drawMinorGrid(Graphics2D g2D,Double xMin,Double yMin,Double xMax, Double yMax) {
		 g2D.setColor(new Color(220,220,220));
		  g2D.setStroke(new BasicStroke(0.5f));
		// Recherche de la première ligne : Integer[xMin/ (nombres de pixels par Ligne)] * nombres de pixel par ligne

		  Double x0=model.getFirstXForMaxiGridOnScreen();
			Double y0 = model.getFirstYForMaxiGridOnScreen();
		if (GlobalOptions.debug) {
			System.out.println("pixel initial :  X="+x0 + ", Y="+y0);
		}
		 for (Double x =  x0; x < xMax; x += model.getMiniSpace()) {
		      g2D.draw(new Line2D.Double(x, yMin, x, yMax));
		    }
		    // Draw horizontal lines
		    for (Double y = y0; y < yMax; y += model.getMiniSpace()) {
		      g2D.draw(new Line2D.Double(xMin, y, xMax, y));
		    }
	}
	private void drawMajorGrid(Graphics2D g2D,Double xMin,Double yMin,Double xMax, Double yMax) {
			g2D.setColor(new Color(100,100,100));
			g2D.setStroke(new BasicStroke(0.5f));
		// Recherche de la première ligne : Integer[xMin/ (nombres de pixels par Ligne)] * nombres de pixel par ligne
			Double x0 = model.getFirstXForMaxiGridOnScreen();
			Double y0 = model.getFirstYForMaxiGridOnScreen();
		 for (Double x =  x0; x < xMax; x += model.getMaxiSpace()) {
		      g2D.draw(new Line2D.Double(x, yMin, x, yMax));
		    }
		    // Draw horizontal lines
		    for (Double y = y0; y < yMax; y += model.getMaxiSpace()) {
		      g2D.draw(new Line2D.Double(xMin, y, xMax, y));
		    }
	}
	/***************************************************/
	/***              Getters et Setters            ****/
	/***************************************************/
	
	
	public GridModel getModel() {
		return model;
	}


	public void setModel(GridModel model) {
		this.model = model;
	}

	/******************************************************/
	/** Implementation DisplayView                      ***/
	/******************************************************/
	
	@Override
	public void doDataOperations(List<DataOperation> listeDataOperation) {
		
	}

	@Override
	public void doDataOperation(DataOperation dop) {
	
		
	}

	
	
}
