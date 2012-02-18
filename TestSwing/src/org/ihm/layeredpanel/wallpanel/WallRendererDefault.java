package org.ihm.layeredpanel.wallpanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import org.common.utils.GlobalOptions;
import org.srv.objets.walls.Wall;

public class WallRendererDefault extends JPanel  implements MouseMotionListener, MouseListener, IWallRenderer{

	protected String wallType ;
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#getWallType()
	 */
	@Override
	public String getWallType() {
		return wallType;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#setWallType(java.lang.String)
	 */
	@Override
	public void setWallType(String wallType) {
		this.wallType = wallType;
	}


	protected Boolean isSelected = false;
	protected Boolean hasFocus;

	private Color eventLineColor = new Color(69, 94, 138).brighter();
	private Color eventFillColor1 = new Color(203, 218, 245);
	private Color eventFillColor2 = new Color(153, 183, 236);

	private Color focusLineColor = new Color(69, 94, 138);
	private Color focusFillColor1 = new Color(203, 218, 245);
	private Color focusFillColor2 = new Color(153, 183, 236);
	
	private Color selectionLineColor = (new Color(69, 148, 148)).darker();
	private Color selectionFillColor1 = new Color(250, 235, 235);
	private Color selectionFillColor2 = new Color(235, 180, 180); 
	
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#getIsSelected()
	 */
	@Override
	public Boolean getIsSelected() {
		return isSelected;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#setIsSelected(java.lang.Boolean)
	 */
	@Override
	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#getHasFocus()
	 */
	@Override
	public Boolean getHasFocus() {
		return hasFocus;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#setHasFocus(java.lang.Boolean)
	 */
	@Override
	public void setHasFocus(Boolean hasFocus) {
		this.hasFocus = hasFocus;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#getEventLineColor()
	 */
	@Override
	public Color getEventLineColor() {
		return eventLineColor;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#setEventLineColor(java.awt.Color)
	 */
	@Override
	public void setEventLineColor(Color eventLineColor) {
		this.eventLineColor = eventLineColor;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#getEventFillColor1()
	 */
	@Override
	public Color getEventFillColor1() {
		return eventFillColor1;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#setEventFillColor1(java.awt.Color)
	 */
	@Override
	public void setEventFillColor1(Color eventFillColor1) {
		this.eventFillColor1 = eventFillColor1;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#getEventFillColor2()
	 */
	@Override
	public Color getEventFillColor2() {
		return eventFillColor2;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#setEventFillColor2(java.awt.Color)
	 */
	@Override
	public void setEventFillColor2(Color eventFillColor2) {
		this.eventFillColor2 = eventFillColor2;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#getFocusLineColor()
	 */
	@Override
	public Color getFocusLineColor() {
		return focusLineColor;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#setFocusLineColor(java.awt.Color)
	 */
	@Override
	public void setFocusLineColor(Color focusLineColor) {
		this.focusLineColor = focusLineColor;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#getFocusFillColor1()
	 */
	@Override
	public Color getFocusFillColor1() {
		return focusFillColor1;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#setFocusFillColor1(java.awt.Color)
	 */
	@Override
	public void setFocusFillColor1(Color focusFillColor1) {
		this.focusFillColor1 = focusFillColor1;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#getFocusFillColor2()
	 */
	@Override
	public Color getFocusFillColor2() {
		return focusFillColor2;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#setFocusFillColor2(java.awt.Color)
	 */
	@Override
	public void setFocusFillColor2(Color focusFillColor2) {
		this.focusFillColor2 = focusFillColor2;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#getSelectionLineColor()
	 */
	@Override
	public Color getSelectionLineColor() {
		return selectionLineColor;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#setSelectionLineColor(java.awt.Color)
	 */
	@Override
	public void setSelectionLineColor(Color selectionLineColor) {
		this.selectionLineColor = selectionLineColor;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#getSelectionFillColor1()
	 */
	@Override
	public Color getSelectionFillColor1() {
		return selectionFillColor1;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#setSelectionFillColor1(java.awt.Color)
	 */
	@Override
	public void setSelectionFillColor1(Color selectionFillColor1) {
		this.selectionFillColor1 = selectionFillColor1;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#getSelectionFillColor2()
	 */
	@Override
	public Color getSelectionFillColor2() {
		return selectionFillColor2;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#setSelectionFillColor2(java.awt.Color)
	 */
	@Override
	public void setSelectionFillColor2(Color selectionFillColor2) {
		this.selectionFillColor2 = selectionFillColor2;
	}
	public static int getOffsetX() {
		return offsetX;
	}
	public static void setOffsetX(int offsetX) {
		WallRendererDefault.offsetX = offsetX;
	}
	public static int getOffsetY() {
		return offsetY;
	}
	public static void setOffsetY(int offsetY) {
		WallRendererDefault.offsetY = offsetY;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#getCurrentWall()
	 */
	@Override
	public Wall getCurrentWall() {
		return currentWall;
	}

	
	public static int offsetX = 5;
	public static int offsetY = 5;
	protected int widthLine = 3;
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#getWidthLine()
	 */
	@Override
	public int getWidthLine() {
		return widthLine;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#setWidthLine(int)
	 */
	@Override
	public void setWidthLine(int widthLine) {
		this.widthLine = widthLine;
	}


	private Wall currentWall = null;
	public WallRendererDefault() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#getTimeLineComponent(boolean, boolean)
	 */
	@Override
	public Component getTimeLineComponent(boolean isSelected,boolean hasFocus) {
		this.isSelected = isSelected;
		this.hasFocus = hasFocus;
		this.setOpaque(false);
		return this;
	}

	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#setCurrentWall(org.srv.objets.Wall)
	 */
	@Override
	public void setCurrentWall(Wall currentWall) {
		this.currentWall = currentWall;
	}
	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D)g.create();
		
		float x0 = offsetX;
		float x1 = getWidth()-offsetX;
		float y0 = offsetY;
		float y1 = getHeight()-offsetY;
		
		if (currentWall.getxStart()>currentWall.getxEnd()) {
			x0 = getWidth()-offsetX;
			x1 = offsetX;
		}
		if (currentWall.getyStart()>currentWall.getyEnd()) {
			y0 = getHeight()-offsetY;
			y1 = offsetY;
		}
		Line2D line = new Line2D.Float(x0,
				y0,x1,y1);
		
		if (isSelected) {
			g2D.setColor(getEventLineColor());
			g2D.setStroke(new BasicStroke(widthLine,
					BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
			g2D.draw(line);
			g2D.setColor(getSelectionLineColor());

			g2D.setStroke(new BasicStroke(1,
					BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
		}
		else
			if (hasFocus) {
				g2D.setColor(getFocusLineColor());

				g2D.setStroke(new BasicStroke(3,
						BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
			}
			else {
				g2D.setColor(getEventLineColor());

				g2D.setStroke(new BasicStroke(1,
						BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
			}
		g2D.draw(line);
		
		
	}


	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#mouseClicked(java.awt.event.MouseEvent)
	 */

	@Override
	public void mouseClicked(MouseEvent e) {
		if(GlobalOptions.debug) {
			GlobalOptions.print("mouse Clioked",this.getName());
		}
		
	}

	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		if(GlobalOptions.debug) {
			GlobalOptions.print("mouse Clioked",this.getName());
		}
		
	}

	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		if(GlobalOptions.debug) {
			GlobalOptions.print("mouse Clioked",this.getName());
		}
		
	}

	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent arg0) {
		if(GlobalOptions.debug) {
			GlobalOptions.print("mouse Dragged",this.getName());
		}
		
	}

	/* (non-Javadoc)
	 * @see org.ihm.layeredpanel.wallpanel.IWallRenderer#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void fillPlanche(Graphics g, Wall wall) {
		
		
	}

	public void drawVegetable(Graphics g, Wall wall) {
		
	}
}