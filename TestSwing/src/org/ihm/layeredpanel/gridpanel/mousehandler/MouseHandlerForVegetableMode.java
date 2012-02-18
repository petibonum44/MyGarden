package org.ihm.layeredpanel.gridpanel.mousehandler;

import java.awt.event.MouseEvent;

import org.ihm.layeredpanel.gridpanel.EventRefreshView;
import org.ihm.layeredpanel.gridpanel.MainGridPanel;
import org.ihm.layeredpanel.gridpanel.model.GridModel;
import org.ihm.model.ClientRequest;
import org.ihm.model.MainController;

public class MouseHandlerForVegetableMode extends AbstractMouseHandler {
	GridModel model ;
	public MouseHandlerForVegetableMode(GridModel model) {
		super();
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		super.mouseMoved(e);
	}





}
