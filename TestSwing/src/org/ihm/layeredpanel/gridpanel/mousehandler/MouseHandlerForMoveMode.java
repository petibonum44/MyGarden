package org.ihm.layeredpanel.gridpanel.mousehandler;

import java.awt.event.MouseEvent;

import org.ihm.layeredpanel.gridpanel.EventRefreshView;
import org.ihm.layeredpanel.gridpanel.MainGridPanel;
import org.ihm.layeredpanel.gridpanel.model.GridModel;
import org.ihm.model.ClientRequest;
import org.ihm.model.MainController;

public class MouseHandlerForMoveMode extends AbstractMouseHandler {
	GridModel model ;
	public MouseHandlerForMoveMode(GridModel model) {
		super();
		this.model=model;
	}



	public GridModel getModel() {
		return model;
	}


	public void setModel(GridModel model) {
		this.model = model;
	}


	private int previousX = -1;
	private int previousY = -1;
	@Override
	public void mouseReleased(MouseEvent e) {
		previousX=-1;previousY=-1;
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		if (previousX==-1) {
			previousX = e.getXOnScreen();
			previousY= e.getYOnScreen();
		}
		else {
			int deltaX =-previousX+e.getXOnScreen();
			int deltaY = e.getYOnScreen()-previousY;
			
				getModel().incrementX(new Double(deltaX));
			
			
				getModel().incrementY(new Double(deltaY));
			
			previousX = e.getXOnScreen();
			previousY= e.getYOnScreen();
		}
		
		// envoie d'un évènement de rafraichissement à la vue
		ClientRequest cr = new ClientRequest();
		EventRefreshView event = new EventRefreshView(MainGridPanel.MAINGRIDPANELNAME);
		cr.setEvent(event);
		MainController.getInstance().performRequest(cr);
	}

	


}
