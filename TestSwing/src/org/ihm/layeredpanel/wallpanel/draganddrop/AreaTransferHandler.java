package org.ihm.layeredpanel.wallpanel.draganddrop;

import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceAdapter;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

import org.apache.log4j.Logger;
import org.ihm.layeredpanel.gridpanel.EventRefreshView;
import org.ihm.layeredpanel.gridpanel.MainGridPanel;
import org.ihm.layeredpanel.gridpanel.model.GridModel;
import org.ihm.layeredpanel.gridpanel.model.WallSelectionModel;
import org.ihm.layeredpanel.wallpanel.WallPanel;
import org.ihm.model.ClientRequest;
import org.ihm.model.MainController;
import org.ihm.plannings.garden.PlanningGardenTable;
import org.ihm.plannings.garden.dataoperations.EventNewWallAdd;
import org.ihm.treeview.draganddrop.VegetableTransfer;
import org.srv.objets.vegetables.VegetableBean;
import org.srv.objets.walls.Wall;
import org.srv.objets.walls.WallCst;

public class AreaTransferHandler extends TransferHandler {
	private static Point dropLocation;
	static {
		DragSourceAdapter listener = new DragSourceAdapter() {
		@Override
		public void dragMouseMoved(DragSourceDragEvent ev) {
		dropLocation = ev.getLocation();
	
		}
		@Override
		public void dragDropEnd(DragSourceDropEvent ev) {
		dropLocation = null; 
		}
		
		};
		DragSource dragSource = DragSource.getDefaultDragSource();
		dragSource.addDragSourceMotionListener(listener); 
		dragSource.addDragSourceListener(listener);
		}
	@Override
	public boolean canImport(JComponent comp, DataFlavor[] transferFlavors) {
		if (comp instanceof WallPanel) {
			WallPanel wallPanel = (WallPanel)comp;
////			SwingUtilities.convertPointFromScreen(
////					dropLocation, wallPanel);
//			Double x = dropLocation.getX();
//			Double y = dropLocation.getY();//OnScreen()-48;
//			// Recherche de l'élément sélectionné
//			WallSelectionModel.getInstance().lookingForFocusWall(WallCst.TYPE_VEGETABLE, x,y);

			// on envoie un evenement à la table
			ClientRequest cr2 = new ClientRequest();
			EventNewWallAdd event2 = new EventNewWallAdd(PlanningGardenTable.PLANNINGGARDENTABLE);
			cr2.setEvent(event2);
			MainController.getInstance().performRequest(cr2);
			// envoie d'un évènement de rafraichissement à la vue
			ClientRequest cr = new ClientRequest();
			EventRefreshView event = new EventRefreshView(MainGridPanel.MAINGRIDPANELNAME);
			cr.setEvent(event);
			MainController.getInstance().performRequest(cr);
		}
		return Arrays.asList(transferFlavors).contains(
				VegetableTransfer.VEGETABLE_FLAVOR);
	}

	

	@Override
	public boolean importData(JComponent comp, Transferable t) {
		
		try {
			VegetableBean vegetable = (VegetableBean)t.getTransferData(VegetableTransfer.VEGETABLE_FLAVOR);
			if (comp instanceof WallPanel) {
				WallPanel wallPanel = (WallPanel)comp;
				if (dropLocation!=null) {
					SwingUtilities.convertPointFromScreen(
							dropLocation, wallPanel);
					WallSelectionModel.getInstance().lookingForFocusWall(WallCst.TYPE_VEGETABLE, dropLocation.getX(), dropLocation.getY());
					Double xDrop = GridModel.getInstance().getXOnGrid(dropLocation.getX());
					Double yDrop = GridModel.getInstance().getYOnGrid(dropLocation.getY());
					// récupération de la zone qui à le focus.
					Wall wallWithFocus = WallSelectionModel.getInstance().getCurrentFocusWall();
					if (wallWithFocus!=null){
						wallWithFocus.setVegetable(vegetable);
						Integer nb = WallVegetableUtils.getNumberOfVegetable(wallWithFocus, vegetable.getDistInterLigne(),vegetable.getDistPlants(), null, true);
						Logger.getLogger(this.getClass()).debug("Number ofvegetable "+nb );
						ClientRequest cr = new ClientRequest();
						EventRefreshView event = new EventRefreshView(MainGridPanel.MAINGRIDPANELNAME);
						cr.setEvent(event);
						MainController.getInstance().performRequest(cr);
					}
				}
			}
 		} catch (UnsupportedFlavorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.importData(comp, t);
	}


	

}
