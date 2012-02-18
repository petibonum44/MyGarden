package org.ihm.buttons;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JToggleButton;

/**
 * Classe générique
 * @author doc
 *
 */
public class IconsButtons extends JToggleButton {

	public IconsButtons(String text) {
		super(text);
		setOpaque(false);
		setMaximumSize(new Dimension(20,20));
		setPreferredSize(new Dimension(20,20));
	}

	@Override
	protected void paintComponent(Graphics g) {
		// dessine uniquement l'icone.
		getIcon().paintIcon(this, g, 0, 0);
	}

	@Override
	public Rectangle getBounds(Rectangle rv) {
	return new Rectangle(new Dimension(20,20));
	}
	
}
