package org.ihm.layeredpanel.gridpanel.mousehandler;

import java.awt.event.MouseEvent;

import org.ihm.layeredpanel.gridpanel.EventRefreshView;
import org.ihm.layeredpanel.gridpanel.MainGridPanel;
import org.ihm.layeredpanel.gridpanel.model.GridModel;
import org.ihm.layeredpanel.wallpanel.WallModel;
import org.ihm.model.ClientRequest;
import org.ihm.model.MainController;
import org.ihm.plannings.garden.PlanningGardenTable;
import org.ihm.plannings.garden.dataoperations.EventNewWallAdd;
import org.srv.objets.walls.Wall;

public class MouseHandlerForDrawMode extends AbstractMouseHandler {
	GridModel model ;
	String type = null;
	public MouseHandlerForDrawMode(GridModel model,String type) {
		super();
		this.type = type;
		this.model=model;
	}



	public GridModel getModel() {
		return model;
	}


	public void setModel(GridModel model) {
		this.model = model;
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		if (MouseEvent.BUTTON1==e.getButton()) {
			// pas de mur en construction
			if (WallModel.getInstance().getCurrentDrawingWall()==null) {
				// new Wall
				int x = e.getX();
				int y = e.getY();//OnScreen()-48;
				Double xGrid = getModel().getClosestXOnGrid(new Double(x));
				Double yGrid = getModel().getClosestYOnGrid(new Double(y));
				WallModel.getInstance().createNewWall(xGrid, yGrid,null,type);
				// envoie d'un évènement de rafraichissement à la vue
				ClientRequest cr = new ClientRequest();
				EventRefreshView event = new EventRefreshView(MainGridPanel.MAINGRIDPANELNAME);
				cr.setEvent(event);
				MainController.getInstance().performRequest(cr);
			}
			else {
				// nouveau mur!
				Wall exCurrent = WallModel.getInstance().getCurrentDrawingWall();
				// new Wall
				int x = e.getX();
				int y = e.getY();
				Double xGrid = getModel().getClosestXOnGrid(new Double(x));
				Double yGrid = getModel().getClosestYOnGrid(new Double(y));
				exCurrent.setxEnd(xGrid);
				exCurrent.setyEnd(yGrid);
				WallModel.getInstance().createNewWall(xGrid, yGrid,exCurrent,type);
				// envoie d'un évènement de rafraichissement à la vue
				ClientRequest cr = new ClientRequest();
				EventRefreshView event = new EventRefreshView(MainGridPanel.MAINGRIDPANELNAME);
				cr.setEvent(event);
				MainController.getInstance().performRequest(cr);

			}
		}
		else
			if (MouseEvent.BUTTON2==e.getButton()) {
			 // on ferme la zone courante.
				WallModel.getInstance().closeWall();
				// envoie d'un évènement de rafraichissement à la vue
				ClientRequest cr = new ClientRequest();
				EventRefreshView event = new EventRefreshView(MainGridPanel.MAINGRIDPANELNAME);
				cr.setEvent(event);
				MainController.getInstance().performRequest(cr);
				
				// on envoie un evenement à la table
				// envoie d'un évènement de rafraichissement à la vue
				ClientRequest cr2 = new ClientRequest();
				EventNewWallAdd event2 = new EventNewWallAdd(PlanningGardenTable.PLANNINGGARDENTABLE);
				cr2.setEvent(event2);
				MainController.getInstance().performRequest(cr2);
				
				

			}
			else
				if (MouseEvent.BUTTON3==e.getButton()) {
				 // on revient en arrière 
					WallModel.getInstance().deleteWall();
					// envoie d'un évènement de rafraichissement à la vue
					ClientRequest cr = new ClientRequest();
					EventRefreshView event = new EventRefreshView(MainGridPanel.MAINGRIDPANELNAME);
					cr.setEvent(event);
					MainController.getInstance().performRequest(cr);

				}
		super.mouseClicked(e);
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mousePressed(e);
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseReleased(e);
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseEntered(e);
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseExited(e);
	}



	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseDragged(e);
	}



	@Override
	public void mouseMoved(MouseEvent e) {
		if (WallModel.getInstance().getCurrentDrawingWall()!=null) {
			int x = e.getX();
			int y = e.getY();
			Double xGrid = getModel().getXOnGrid(new Double(x));
			Double yGrid = getModel().getYOnGrid(new Double(y));
			WallModel.getInstance().updateWall(xGrid, yGrid);
			// envoie d'un évènement de rafraichissement à la vue
			ClientRequest cr = new ClientRequest();
			EventRefreshView event = new EventRefreshView(MainGridPanel.MAINGRIDPANELNAME);
			cr.setEvent(event);
			MainController.getInstance().performRequest(cr);
		}
		super.mouseMoved(e);
	}





}
