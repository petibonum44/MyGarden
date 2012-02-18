package org.ihm.toolbar.plan;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JSlider;

public class NavigationPanel extends JPanel {

	private JSlider spinner = null;

	public NavigationPanel() {
		super();
		setSize(new Dimension(100,100));
		spinner = new JSlider();
		
		this.add(spinner);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(100,100);
	}
	
}
