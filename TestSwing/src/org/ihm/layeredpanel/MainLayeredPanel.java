package org.ihm.layeredpanel;

import javax.swing.JFrame;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.ihm.mainpanel.MainPanel;

public class MainLayeredPanel {
	 static Logger logger = Logger.getLogger(MainLayeredPanel.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicConfigurator.configure();

	     logger.info("Entering application.");
	   
	JFrame jFrame = new JFrame();
//	MainGridPanel panel = new MainGridPanel();
	MainPanel panel = new MainPanel();
	jFrame.add(panel);
//	jFrame.addComponentListener(panel);
	 jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	jFrame.pack();
	jFrame.setVisible(true);
	}

}
