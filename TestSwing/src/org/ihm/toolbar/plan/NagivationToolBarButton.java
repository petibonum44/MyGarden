package org.ihm.toolbar.plan;

import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

public class NagivationToolBarButton extends JToggleButton {

	public NagivationToolBarButton(String text,ImageIcon icon) {
		super(text);
	
	   setIcon(icon);
	   setLabel("");
	   setOpaque(true);
	   setBorderPainted(false);
	   setMargin(new Insets(0, 0, 0, 0));
	}

	
	
}
