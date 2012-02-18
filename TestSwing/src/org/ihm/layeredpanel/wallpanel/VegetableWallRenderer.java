package org.ihm.layeredpanel.wallpanel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

import org.ihm.ShapeUtils;
import org.ihm.layeredpanel.gridpanel.model.EdgeBean;
import org.ihm.layeredpanel.gridpanel.model.GridModel;
import org.ihm.layeredpanel.gridpanel.model.WallSelectionModel;
import org.ihm.layeredpanel.wallpanel.draganddrop.WallVegetableUtils;
import org.srv.objets.vegetables.VegetableBean;
import org.srv.objets.walls.Wall;
import org.srv.objets.walls.WallCst;

public class VegetableWallRenderer extends WallRendererDefault implements MouseMotionListener, MouseListener{
	
	
	private Color eventLineColor = new Color(200, 0,200).brighter();
	private Color eventFillColor2 = new Color(200, 100, 100);
	private Color eventFillColor1 = new Color(153, 183, 236);

	private Color focusLineColor = new Color(69, 94, 138);
	private Color focusFillColor1 = new Color(203, 218, 245);
	private Color focusFillColor2 = new Color(153, 183, 236);
	
	private Color selectionLineColor = (new Color(69, 148, 148)).darker();
	private Color selectionFillColor1 = new Color(250, 235, 235);
	private Color selectionFillColor2 = new Color(235, 180, 180);
	private Color[] colors = {new Color(200,100,100),new Color(100,200,200),new Color(200,100,200),new Color(200,200,100)};
	private int currIndex = 0;
	public Color getEventLineColor() {
		return eventLineColor;
	}
	public void setEventLineColor(Color eventLineColor) {
		this.eventLineColor = eventLineColor;
	}
	public Color getEventFillColor1() {
		return eventFillColor1;
	}
	public void setEventFillColor1(Color eventFillColor1) {
		this.eventFillColor1 = eventFillColor1;
	}
	public Color getEventFillColor2() {
		return eventFillColor2;
	}
	public void setEventFillColor2(Color eventFillColor2) {
		this.eventFillColor2 = eventFillColor2;
	}
	public Color getFocusLineColor() {
		return focusLineColor;
	}
	public void setFocusLineColor(Color focusLineColor) {
		this.focusLineColor = focusLineColor;
	}
	public Color getFocusFillColor1() {
		return focusFillColor1;
	}
	public void setFocusFillColor1(Color focusFillColor1) {
		this.focusFillColor1 = focusFillColor1;
	}
	public Color getFocusFillColor2() {
		return focusFillColor2;
	}
	public void setFocusFillColor2(Color focusFillColor2) {
		this.focusFillColor2 = focusFillColor2;
	}
	public Color getSelectionLineColor() {
		return selectionLineColor;
	}
	public void setSelectionLineColor(Color selectionLineColor) {
		this.selectionLineColor = selectionLineColor;
	}
	public Color getSelectionFillColor1() {
		return selectionFillColor1;
	}
	public void setSelectionFillColor1(Color selectionFillColor1) {
		this.selectionFillColor1 = selectionFillColor1;
	}
	public Color getSelectionFillColor2() {
		return selectionFillColor2;
	}
	public void setSelectionFillColor2(Color selectionFillColor2) {
		this.selectionFillColor2 = selectionFillColor2;
	}
	public VegetableWallRenderer() {
		
		super();
		wallType = WallCst.TYPE_VEGETABLE;
		widthLine = 1;
	}
	@Override
	public void fillPlanche(Graphics g, Wall wallWithVegetable) {
		// TODO Auto-generated method stub
	
		Wall wall = (Wall) wallWithVegetable.clone();
	List<Double> xPoint = new ArrayList<Double>();
	List<Double>  yPoints= new ArrayList<Double>();
	if (wall.getState().getIsSelected()) {
		g.setColor(eventFillColor2);
	}
	else {
		g.setColor(eventFillColor1);
	}


	boolean end = false;

	
	GeneralPath polygon = ShapeUtils.fromWallToShape(wall);
	        new GeneralPath(GeneralPath.WIND_EVEN_ODD,
	                        xPoint.size());


	Graphics2D g2D = (Graphics2D)g.create();

	
	g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
	g2D.fill(polygon);
	if (wallWithVegetable.getVegetable()!=null) drawVegetable(g, wallWithVegetable);
	if (WallSelectionModel.getInstance().getEdgeWithFocus()!=null)  {
		EdgeBean edge = WallSelectionModel.getInstance().getEdgeWithFocus();
		Double x = edge.getWallStart().getxStart();
		Double y = edge.getWallStart().getyStart();
		drawEgdeWithFocus(g, x, y);
	}
	
	}
	@Override
	public void drawVegetable(Graphics g, Wall wallWithVegetable) {
		VegetableBean vegetable = wallWithVegetable.getVegetable();
		
				Double distLigne = vegetable.getDistInterLigne(); 
				Double distPlant = vegetable.getDistPlants();
				String optionAlignement = null; 
				Boolean quinconce = true;

			List<Double> x2Points = new ArrayList<Double>();
			List<Double>  y2Points= new ArrayList<Double>();

			Wall wall = (Wall) wallWithVegetable.clone();
			while (wall!=null && wall.getxStart()!=null) {

				if (wall!=null) {
		
					x2Points.add(wall.getxStart());
					y2Points.add(wall.getyStart());

				}
				wall = wall.getWallStart();
			}

			/** Si distligne = null alors distLigne = distPlant **/ 
			if (distLigne==null) { 
				distLigne = distPlant; 
			} 
			/** Construction d'une forme géometrique**/ 


			GeneralPath polyline = 
					new GeneralPath(GeneralPath.WIND_EVEN_ODD, x2Points.size()); 

			polyline.moveTo (x2Points.get(0), y2Points.get(0)); 

			for (int index = 1; index < x2Points.size(); index++) { 
				polyline.lineTo(x2Points.get(index), y2Points.get(index)); 
			}; 
			polyline.lineTo(x2Points.get(0), y2Points.get(0)); 
			/** calcul du démarrage **/ 
			Double x0 = WallVegetableUtils.getMini(x2Points); 
			Double y0 = WallVegetableUtils.getMini(y2Points);         
			Double length; 
			Double width; 

			width = WallVegetableUtils.getMaxi(x2Points)-x0; 
			length = WallVegetableUtils.getMaxi(y2Points)-y0; 

			Double xStart = x0+distLigne/2.; 
			Double yStart = y0+distPlant/2.; 

			boolean isNextLine = false; 
			/** Compteur **/ 
			Integer cptNombre = new Integer(0); 
			/** On commence par descendre les lignes **/ 
			Double currWidth = xStart; 
			Double currWidthMax = x0 + width-distLigne/2.; 
			while (currWidth<currWidthMax) { 
				Double currLength = yStart; 
				Double currLengthMax = y0+length-distPlant/2.; 
				if (!isNextLine && quinconce) { 
					currLength = currLength+distPlant/2.; 
				} 
				while (currLength<currLengthMax) { 
					if (polyline.contains(currWidth, currLength))  {
					drawOneVegetable(g, currWidth, currLength);
					}
					currLength= currLength+distPlant; 
					
				} 
				currWidth = currWidth+distLigne; 
				isNextLine = !isNextLine; 
			} 

			
		
	}

	private void drawOneVegetable(Graphics g, Double xx, Double yy) {
		Graphics2D g2D = (Graphics2D)g.create();
		g2D.setColor(new Color(255,100,100));
		int x = GridModel.getInstance().getXScreen(xx).intValue();
		int y = GridModel.getInstance().getYScreen(yy).intValue();
		g.fillOval(x-7, y-7, 14, 14);
	}
	
	private void drawEgdeWithFocus(Graphics g, Double xx,Double yy) {
		Graphics2D g2D = (Graphics2D)g.create();
		g2D.setColor(new Color(0,00,000));
		int x = GridModel.getInstance().getXScreen(xx).intValue();
		int y = GridModel.getInstance().getYScreen(yy).intValue();
		g.fillOval(x-7, y-7, 14, 14);
	}
}
