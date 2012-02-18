package org.ihm.mainpanel;

import java.awt.Dimension;

import javax.swing.JSplitPane;

import org.ihm.mainpanel.detailplanning.GardenPlanningPanel;
import org.ihm.mainpanel.vegetablegarden.VegetableDetailPanel;

public class MainPanel extends JSplitPane {
	GardenPlanningPanel detail;
	VegetableDetailPanel table;
	public MainPanel() {
		super();
		setPreferredSize(new Dimension(500,400));
		detail = new GardenPlanningPanel();
		table = new VegetableDetailPanel(); 
		 
		setLeftComponent(table);
		setRightComponent(detail);
		setOrientation(HORIZONTAL_SPLIT);
		 setResizeWeight(0.2);
	     setOneTouchExpandable(true);
	     setContinuousLayout(true);
	     setDividerLocation(100);
	}

}
