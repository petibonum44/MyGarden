package org.ihm.layeredpanel.wallpanel.draganddrop;

import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

import org.ihm.layeredpanel.gridpanel.model.GridModel;
import org.srv.objets.walls.Wall;

public class WallVegetableUtils {
    /** 
     * Calcul le nombre d'éléments qui peuvent être cultivé à l'intérieur d'une 
     * parcelle de largeur width et longueur length 
     * 
     * @param length 
     * @param width 
     * @param distLigne : distance entre les lignes (si null on prend distPlant) 
     * @param distPlant : distance entre les plants 
     * @param optionAlignement : alignement horizontal ou vertical 
     * @param quinconce 
     * @return 
     */ 
    public static Integer getNumberOfVegetable(Wall wallWithVegetable, 
                                                                                       Double distLigne, 
                                                                                       Double distPlant, 
                                                                                       String optionAlignement, 
                                                                                       Boolean quinconce) { 
           
		List<Double> x2Points = new ArrayList<Double>();
		List<Double>  y2Points= new ArrayList<Double>();

		Wall wall = (Wall) wallWithVegetable.clone();
			while (wall!=null && wall.getxStart()!=null) {
			
			if (wall!=null) {
				int x = GridModel.getInstance().getXScreen(wall.getxStart()).intValue();
				int y = GridModel.getInstance().getYScreen(wall.getyStart()).intValue();
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
    Double x0 = getMini(x2Points); 
    Double y0 = getMini(y2Points);         
    Double length; 
    Double width; 

    width = getMaxi(x2Points)-x0; 
    length = getMaxi(y2Points)-y0; 
    
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
                                    cptNombre++; 
                    }
                    currLength= currLength+distPlant; 
            } 
            currWidth = currWidth+distLigne; 
            isNextLine = !isNextLine; 
    } 
    
    return cptNombre; 
    } 
    public  static Double getMini(List<Double> xs) { 
            Double valMini = new Double(10000000000.); 
            for (int index = 0; index < xs.size(); index++) { 
                      if (valMini>xs.get(index)) { 
                              valMini = new Double(xs.get(index)); 
                      } 
            }; 
            return valMini; 
    } 
    public static Double getMaxi(List<Double> xs) { 
            Double valMaxi = new Double(0.); 
            for (int index = 0; index < xs.size(); index++) { 
                      if (valMaxi<xs.get(index)) { 
                              valMaxi = new Double(xs.get(index)); 
                      } 
            }; 
            return valMaxi; 
    } 




}
