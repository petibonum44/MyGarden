package org.ihm.layeredpanel.wallpanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import org.srv.objets.walls.Wall;

public interface IWallRenderer {

	public abstract String getWallType();

	public abstract void setWallType(String wallType);

	public abstract Boolean getIsSelected();

	public abstract void setIsSelected(Boolean isSelected);

	public abstract Boolean getHasFocus();

	public abstract void setHasFocus(Boolean hasFocus);

	public abstract Color getEventLineColor();

	public abstract void setEventLineColor(Color eventLineColor);

	public abstract Color getEventFillColor1();

	public abstract void setEventFillColor1(Color eventFillColor1);

	public abstract Color getEventFillColor2();

	public abstract void setEventFillColor2(Color eventFillColor2);

	public abstract Color getFocusLineColor();

	public abstract void setFocusLineColor(Color focusLineColor);

	public abstract Color getFocusFillColor1();

	public abstract void setFocusFillColor1(Color focusFillColor1);

	public abstract Color getFocusFillColor2();

	public abstract void setFocusFillColor2(Color focusFillColor2);

	public abstract Color getSelectionLineColor();

	public abstract void setSelectionLineColor(Color selectionLineColor);

	public abstract Color getSelectionFillColor1();

	public abstract void setSelectionFillColor1(Color selectionFillColor1);

	public abstract Color getSelectionFillColor2();

	public abstract void setSelectionFillColor2(Color selectionFillColor2);

	public abstract Wall getCurrentWall();

	public abstract int getWidthLine();

	public abstract void setWidthLine(int widthLine);

	public abstract Component getTimeLineComponent(boolean isSelected,
			boolean hasFocus);

	public abstract void setCurrentWall(Wall currentWall);

	/**
	 * Peindre un mur de (0,0) à (w,h).
	 */
	public abstract void paint(Graphics g);

	public abstract void mouseClicked(MouseEvent e);

	public abstract void mouseEntered(MouseEvent e);

	public abstract void mouseExited(MouseEvent e);

	public abstract void mousePressed(MouseEvent e);

	public abstract void mouseReleased(MouseEvent e);

	public abstract void mouseDragged(MouseEvent arg0);

	public abstract void mouseMoved(MouseEvent arg0);
	
	// Remplissage du polygon
	public void fillPlanche(Graphics g, Wall wall);

}