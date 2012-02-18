package org.ihm.layeredpanel.gridpanel.mousehandler;

import java.awt.event.MouseEvent;

import org.apache.log4j.Logger;
import org.common.utils.GlobalOptions;
import org.ihm.layeredpanel.gridpanel.EventRefreshView;
import org.ihm.layeredpanel.gridpanel.MainGridPanel;
import org.ihm.layeredpanel.gridpanel.model.GridModel;
import org.ihm.layeredpanel.gridpanel.model.WallSelectionModel;
import org.ihm.model.ClientRequest;
import org.ihm.model.MainController;
import org.srv.objets.walls.WallUtils;

public class MouseHandlerForSelectMode extends AbstractMouseHandler {
	GridModel model ;
	String type;
	private int previousX = -1; // for dragged and drop
	private int previousY = -1; // for dragged and drop
	public MouseHandlerForSelectMode(GridModel model,String type) {
		super();
		this.model=model;
		this.type=type;
	}



	public GridModel getModel() {
		return model;
	}


	public void setModel(GridModel model) {
		this.model = model;
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		Logger.getLogger(this.getClass()).debug("Clicked event  ");
		if (MouseEvent.BUTTON1==e.getButton()) {
			
			int x = e.getX();
			int y = e.getY();//OnScreen()-48;
		
			// Recherche de l'élément sélectionné
			WallSelectionModel.getInstance().lookingForSelectedWall(type, new Double(x), new Double(y));
			// envoie d'un évènement de rafraichissement à la vue
			ClientRequest cr = new ClientRequest();
			EventRefreshView event = new EventRefreshView(MainGridPanel.MAINGRIDPANELNAME);
			cr.setEvent(event);
			MainController.getInstance().performRequest(cr);
		}
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mousePressed(e);
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		previousX=-1;previousY=-1;
		super.mouseReleased(e);
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseEntered(e);
	}



	@Override
	public void mouseExited(MouseEvent e) {
		
		WallSelectionModel.getInstance().deFocusWall();
		WallSelectionModel.getInstance().deFocusEdge();
		
		ClientRequest cr = new ClientRequest();
		EventRefreshView event = new EventRefreshView(MainGridPanel.MAINGRIDPANELNAME);
		cr.setEvent(event);
		MainController.getInstance().performRequest(cr);
		super.mouseExited(e);
	}



	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();//OnScreen()-48;
	
		// Recherche de l'élément sélectionné
		WallSelectionModel.getInstance().lookingForFocusWall(type, new Double(x), new Double(y));
		if (WallSelectionModel.getInstance().getEdgeWithFocus()!=null) {
			if (previousX==-1) {
				previousX = e.getXOnScreen();
				previousY= e.getYOnScreen();
			}
			else {
				int deltaX =-previousX+e.getXOnScreen();
				int deltaY = e.getYOnScreen()-previousY;
				// transformation en coordonnées de la grille.
				Double dx = (new Double(deltaX))/GridModel.getInstance().getScale();
				Double dy = (new Double(deltaY))/GridModel.getInstance().getScale();
				WallUtils.doTranslationForEdge(WallSelectionModel.getInstance().getEdgeWithFocus(), dx, dy);
				previousX = e.getXOnScreen();
				previousY= e.getYOnScreen();
			}
		}
		else
		if (WallSelectionModel.getInstance().isOneWallSelected() &&  WallSelectionModel.getInstance().getCurrentSelectedWall().getState().getHasFocus()) {
			if (previousX==-1) {
				previousX = e.getXOnScreen();
				previousY= e.getYOnScreen();
			}
			else {
				int deltaX =-previousX+e.getXOnScreen();
				int deltaY = e.getYOnScreen()-previousY;
				// transformation en coordonnées de la grille.
				Double dx = (new Double(deltaX))/GridModel.getInstance().getScale();
				Double dy = (new Double(deltaY))/GridModel.getInstance().getScale();
				WallUtils.doTranslation(WallSelectionModel.getInstance().getCurrentSelectedWall(), dx, dy);
				previousX = e.getXOnScreen();
				previousY= e.getYOnScreen();
			}
			
		}
		
		// envoie d'un évènement de rafraichissement à la vue
		ClientRequest cr = new ClientRequest();
		EventRefreshView event = new EventRefreshView(MainGridPanel.MAINGRIDPANELNAME);
		cr.setEvent(event);
		MainController.getInstance().performRequest(cr);
		super.mouseDragged(e);
	}


	/** Gestion du focus **/
	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();//OnScreen()-48;
	
		// Recherche de l'élément sélectionné
		WallSelectionModel.getInstance().lookingForFocusWall(type, new Double(x), new Double(y));
		
		// Recherche d'une eventuelle edge qui serait sélectionnée.
		WallSelectionModel.getInstance().lookingForFocusEdge(type, new Double(x), new Double(y));
		// envoie d'un évènement de rafraichissement à la vue
		ClientRequest cr = new ClientRequest();
		EventRefreshView event = new EventRefreshView(MainGridPanel.MAINGRIDPANELNAME);
		cr.setEvent(event);
		MainController.getInstance().performRequest(cr);
		super.mouseMoved(e);
	}





}
