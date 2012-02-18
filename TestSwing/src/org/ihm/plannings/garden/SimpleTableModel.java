package org.ihm.plannings.garden;

import javax.swing.table.DefaultTableModel;

import org.ihm.layeredpanel.wallpanel.WallModel;
import org.ihm.layeredpanel.wallpanel.draganddrop.WallVegetableUtils;
import org.srv.objets.walls.Wall;
import org.srv.objets.walls.WallUtils;

/**
 * Model simple pour afficher les legumes dans leur pacelle
 * @author Fabrice
 *
 */
public class SimpleTableModel extends DefaultTableModel {

	// Le modele de données est géré par le modele de base.
	// les colonnes sont les suivantes .
	// 1 - Legumes (llVegetable)
	// 2 - quantité
	// 3 - Aire de la surface
	String[] columnsName = new String[]{"Legumes","Quantité","Surface"};

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnsName[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return WallModel.getInstance().getNumberOfWall();
	}
	
	// retourne le nombre de colonne
	@Override
	public int getColumnCount() { 
		return columnsName.length; 
	}

	@Override
	public Object getValueAt(int row, int column) {
		Wall wall = WallModel.getInstance().getWallAt(row);
		if (column==0) {
			if( wall.getVegetable()!=null)
				return (wall.getVegetable().getLlVegetable());
			
			return "A définir";
		}
		else
			if (column==1) {
				if (wall.getVegetable()!=null)
						return WallVegetableUtils.getNumberOfVegetable(wall,
																	wall.getVegetable().getDistInterLigne(),
																	wall.getVegetable().getDistPlants(),
																	null,
																	true);
				return new Integer(0);
			}
			else
				if (column==2) {
					
					return WallUtils.getAire(wall);
				}
		return null;
	}
	
	  public void setValueAt(Object value, int row, int col) {
	        
	        fireTableCellUpdated(row, col);
	    }

	
	  
	
}
