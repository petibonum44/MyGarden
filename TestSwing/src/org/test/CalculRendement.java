package org.test;



import java.awt.geom.GeneralPath;
import java.util.List;

public class CalculRendement { 
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
                public static Integer getNumberOfVegetable(List<Double> x2Points,List<Double> y2Points, 
                                                                                                   Double distLigne, 
                                                                                                   Double distPlant, 
                                                                                                   String optionAlignement, 
                                                                                                   Boolean quinconce) { 
                        
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
                Double currWidthMax = width-xStart; 
                while (currWidth<currWidthMax) { 
                        Double currLength = yStart; 
                        Double currLengthMax = length-yStart; 
                        if (!isNextLine && quinconce) { 
                                currLength = currLength+yStart; 
                        } 
                        while (currLength<currLengthMax) { 
                                if (polyline.contains(currWidth, currLength)) 
                                                cptNombre++; 
                                currLength= currLength+distPlant; 
                        } 
                        currWidth = currWidth+distLigne; 
                        isNextLine = !isNextLine; 
                } 
                
                return cptNombre; 
                } 
                private static Double getMini(List<Double> xs) { 
                        Double valMini = new Double(10000000000.); 
                        for (int index = 1; index < xs.size(); index++) { 
                                  if (valMini>xs.get(0)) { 
                                          valMini = new Double(xs.get(0)); 
                                  } 
                        }; 
                        return valMini; 
                } 
                private static Double getMaxi(List<Double> xs) { 
                        Double valMaxi = new Double(0.); 
                        for (int index = 1; index < xs.size(); index++) { 
                                  if (valMaxi<xs.get(index)) { 
                                          valMaxi = new Double(xs.get(index)); 
                                  } 
                        }; 
                        return valMaxi; 
                } 
 



public static void main(String[] args) { 
                float x2Points[] = {0, 1.6f, 1.6f, 0}; 
                float y2Points[] = {0, 0, 4.f, 4.f}; 
                Double distLigne = 0.4; 
                Double distPlant = 0.8; 
                String aligne =null; 
                Boolean quinconce = false; 
 //               Integer cpt = CalculRendement.getNumberOfVegetable(x2Points, y2Points, distLigne, distPlant, aligne, quinconce); 
 //               System.out.println("Nombre d''éléments : " + cpt.toString()); 
        }
}