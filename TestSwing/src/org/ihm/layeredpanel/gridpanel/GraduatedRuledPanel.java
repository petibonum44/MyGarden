package org.ihm.layeredpanel.gridpanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.JPanel;

import org.ihm.layeredpanel.gridpanel.model.GridModel;
import org.ihm.model.DataOperation;
import org.ihm.model.IDisplayView;
import org.ihm.model.MainController;

public class GraduatedRuledPanel extends JPanel implements IDisplayView{
	private GridModel model;
	public static String GRADUATEDRULEDPANELNAME="GraduatedRuledPanel";
	public GraduatedRuledPanel(GridModel model) {
		super();
		setName(GRADUATEDRULEDPANELNAME);
		this.model = model;
		MainController.getInstance().addView(this);
	}

	// dessine une règle graduée 
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2D = (Graphics2D)g.create();
		paintVerticalGraduated(g2D);
		
		paintHorizontalGraduated(g2D);
		
		printScale(g2D);
		
	}
	
	private void paintHorizontalGraduated(Graphics2D g2D) {
		Double y0 = model.getFirstYForMaxiGridOnScreen();
		Double x0 = model.getFirstXForMaxiGridOnScreen();
		g2D.setColor(new Color(100,100,100));
		 for (Double x =  x0; x < getSize().getWidth(); x += model.getMaxiSpace()) {
		     if (x>=model.getWidthOfGraduatedRulesInPixel()) { 
		    	 g2D.draw(new Line2D.Double(x, 0, x, model.getWidthOfGraduatedRulesInPixel()));
		     }
		 } 
		// Draw horizontal lines
	    for (Double y = y0; y < getSize().getHeight(); y += model.getMaxiSpace()) {
	    	if (y>=model.getWidthOfGraduatedRulesInPixel()) {
	    		g2D.draw(new Line2D.Double(0, y, model.getWidthOfGraduatedRulesInPixel(), y));   
	    	}
	    }

	}
	private void paintVerticalGraduated(Graphics2D g2D) {
		g2D.setColor(new Color(225,225,225));
//		g2D.fillRect(0, model.getWidthOfGraduatedRulesInPixel(),  model.getWidthOfGraduatedRulesInPixel()-1,getHeight());
//		g2D.fillRect(0, 0, getWidth(), model.getWidthOfGraduatedRulesInPixel()-1);
		
	}
	
	private void printScale(Graphics2D g2D) {
		 g2D.setColor(new Color(0100,100,100));
		  g2D.setStroke(new BasicStroke(0.5f));
		// Recherche de la première ligne : Integer[xMin/ (nombres de pixels par Ligne)] * nombres de pixel par ligne
		Double x0 = model.getFirstXForMaxiGridOnScreen();
		Double y0 = model.getFirstYForMaxiGridOnScreen();
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.FRANCE);
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("#.#");
	
		for (Double x =  x0; x < getWidth(); x += model.getMaxiSpace()) {
			 if (x>=model.getWidthOfGraduatedRulesInPixel()-1) { 
				 Double value = model.getXOnGrid(x);
				g2D.drawString(df.format(value), Math.round(x)+2, 15);
			 }
		}
		    
		for (Double y =  y0; y < getHeight(); y += model.getMaxiSpace()) {
			 if (y>=model.getWidthOfGraduatedRulesInPixel()-1) { 
				 Double value = model.getYOnGrid(y);
				g2D.drawString(df.format(value), 5,Math.round(y)+12);
			 }
		}
		 
	}

	@Override
	public void doDataOperations(List<DataOperation> listeDataOperation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doDataOperation(DataOperation dop) {
		// TODO Auto-generated method stub
		
	}
	
}
