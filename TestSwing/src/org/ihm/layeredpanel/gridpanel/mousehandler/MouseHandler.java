package org.ihm.layeredpanel.gridpanel.mousehandler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseMotionListener, MouseListener {

	private AbstractMouseHandler currentStrategy = null;
	
	
	
	public MouseHandler(AbstractMouseHandler currentStrategy) {
		super();
		this.currentStrategy = currentStrategy;
	}

	public AbstractMouseHandler getCurrentStrategy() {
		return currentStrategy;
	}

	public void setCurrentStrategy(AbstractMouseHandler currentStrategy) {
		this.currentStrategy = currentStrategy;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		currentStrategy.mouseClicked(e);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		currentStrategy.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		currentStrategy.mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		currentStrategy.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		currentStrategy.mouseExited(e);

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		currentStrategy.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		currentStrategy.mouseMoved(e);
	}

}
