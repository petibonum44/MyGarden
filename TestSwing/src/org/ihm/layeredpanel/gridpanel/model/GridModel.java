package org.ihm.layeredpanel.gridpanel.model;


/**
 * 
 * @author Fabrice
 * Modele de données de la grille.
 * Stocke la grille actuellement affichee.
 * Les données importantes sont :
 *    - L'espace maxi
 *    - L'espace mini
 *    - L'echelle 1m = n pixels
 *    - le zoom actuel :=> echelle relative = echelle * zoom 
 *    - La postion  en X
 *    - La position en y
 *     
 */
public class GridModel {
	
	private static GridModel instance = null;
	
	/**
	 * Espace maxi entre deux grosses ligne 
	 */
	private Double maxiSpace = 1. ; 
	
	/**
	 * Espace mini entre des lignes intermédiaires
	 */
	private Double miniSpace = 0.1;
	
	/**
	 * Echelle : 1m => n pixels
	 * scale = n
	 */
	private Double scale = 1280./5.;
	
	/**
	 * Zoom 1. = 100%
	 */
	private Double zoom = 1.;
	
	/**
	 *  position en m de l'origine de l'ecran
	 */
	private Double originX =-0.6;
	
	/**
	 * position y de l'écran
	 */
	private double originY=-0.6;
	
	
	
	/**
	 * Largeur de la règle graduée
	 */
	private Double widthOfGraduatedRules = 0.4;
	
	/**
	 * pas de déplacement de la grille
	 */
	
	private Double step=0.05;

	private GridModel() {
		super();
		originX = -widthOfGraduatedRules;
		originY = -widthOfGraduatedRules;
		
	}
	
	public static GridModel getInstance() {
		if (instance == null) {
			instance = new GridModel();
		}
		return instance;
	}

	/********************************************************************/
	/***            Méthodes métiers                                  ***/
	/********************************************************************/
	
	public  Double getFirstXForMiniGridOnScreen() {
		 return Math.round((getOriginX() )/ getMiniSpace())*getMiniSpace()-getOriginX()*getScale();
	}
 
	public  Double getFirstYForMiniGridOnScreen() {
		 return Math.round((getOriginY() )/ getMiniSpace())*getMiniSpace()-getOriginY()*getScale();
	}
	
	/**
	 * Method who return the starting point for the minor grid
	 * @return
	 */
	public  Double getFirstXForMaxiGridOnScreen() {
		 Double firstX =  Math.round(getOriginX() *getScale()/ getMaxiSpace())*getMaxiSpace()-getOriginX()*getScale();
		 return firstX ;
	}

	public  Double getFirstYForMaxiGridOnScreen() {
		 Double firstY =  Math.round(getOriginY() * getScale() / getMaxiSpace())*getMaxiSpace()-getOriginY()*getScale() ;
		 
		 return firstY;
	}
		
	public Double getXOnGrid(Double xScreen) {
		return (xScreen+getOriginX()*getScale())/getScale();
	}
	public Double getYOnGrid(Double yScreen) {
		return (yScreen+getOriginY()*getScale())/getScale();
	}
	
	public Double getClosestXOnGrid(Double xScreen) {
		
		Double xGrid = getXOnGrid(xScreen) ;
		int nbOccurence = (int)(xGrid/miniSpace);
		Double x0 = (nbOccurence)*miniSpace;
		Double x01 = (nbOccurence+1)*miniSpace;
		if (Math.abs(x0-xGrid)>miniSpace/2.) {
			return x01;
		}
		return x0;
	}
	public Double getClosestYOnGrid(Double yScreen) {
		Double yGrid = getYOnGrid(yScreen) ;
		long nbOccurence = Math.round(yGrid/miniSpace);
		Double y0 = (nbOccurence)*miniSpace;
		Double y01 = (nbOccurence+1)*miniSpace;
		if (Math.abs(y0-yGrid)>miniSpace/2.) {
			return y01;
		}
		return y0;
	}
	public Double getXScreen(Double x) {
		return x*getScale()-getOriginX()*getScale();
	}
	public Double getYScreen(Double y) {
		return y*getScale()-getOriginY()*getScale();
	}
	
	public void incrementX(Double dx) {
		originX = originX-dx/getScale();
		if (originX<-widthOfGraduatedRules) {
			originX = -widthOfGraduatedRules;
		}
	}
	
	public void incrementY(Double dy) {
		originY = originY-dy/getScale() ;
		if (originY<-widthOfGraduatedRules) {
			originY = -widthOfGraduatedRules;
		}
	}
	/********************************************************************/
	/**                Ensemble de Getters et de Setters               **/
	/********************************************************************/
	
	public Double getMaxiSpace() {
		return maxiSpace*getScale();
	}

	public void setMaxiSpace(Double maxiSpace) {
		this.maxiSpace = maxiSpace;
	}

	public Double getMiniSpace() {
		return miniSpace*getScale();
	}

	public void setMiniSpace(Double miniSpace) {
		this.miniSpace = miniSpace;
	}

	public Double getScale() {
		return scale*getZoom();
	}

	public void setScale(Double scale) {
		this.scale = scale;
	}

	public Double getZoom() {
		return zoom;
	}

	public void setZoom(Double zoom) {
		this.zoom = zoom;
		if (zoom>1.5) {
			setMaxiSpace(0.5d);
			setMiniSpace(0.1d);
			}
		else if (zoom>0.8) {

			setMaxiSpace(1d);
			setMiniSpace(0.1d);
		}
		else  {

			setMaxiSpace(2d);
			setMiniSpace(0.2d);
		}
	}

	public Double getOriginX() {
		return originX;
	}

	public void setOriginX(Double originX) {
		this.originX = originX;
	}

	public Double getOriginY() {
		return originY;
	}

	public void setOriginY(Double originY) {
		this.originY = originY;
	}

	public Double getWidthOfGraduatedRules() {
		return widthOfGraduatedRules;
	}

	public void setWidthOfGraduatedRules(Double widthOfGraduatedRules) {
		this.widthOfGraduatedRules = widthOfGraduatedRules;
	}
	
	public int getWidthOfGraduatedRulesInPixel() {
		return (int)Math.round(widthOfGraduatedRules*getScale());
	}

	
}
