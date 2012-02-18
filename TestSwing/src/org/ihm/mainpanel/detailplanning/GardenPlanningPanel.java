package org.ihm.mainpanel.detailplanning;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import org.ihm.layeredpanel.gridpanel.MainGridPanel;
import org.ihm.plannings.garden.PlanningGardenTable;

public class GardenPlanningPanel extends JSplitPane {

	PlanningGardenTable table;
	MainGridPanel panel;
	public GardenPlanningPanel() {
		super();
		setPreferredSize(new Dimension(500,400));
		JPanel panelTable = new JPanel();
	
		table = new PlanningGardenTable(); 
		panelTable.setLayout(new BorderLayout());
		panelTable.add(table.getTableHeader(),BorderLayout.PAGE_START);
		panelTable.add(table,BorderLayout.CENTER);
		
		 panel = new MainGridPanel();
		 addComponentListener(panel);
		 addAncestorListener(panel);
		 setResizeWeight(0.5);
	     setOneTouchExpandable(true);
	     setContinuousLayout(true);
		 this.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, new PropertyChangeListener() {
	            public void propertyChange(PropertyChangeEvent evt) {
	                panel.resizeIt();
	            }
	        });
		 setResizeWeight(0.5);
		 setDividerLocation(300);
		setLeftComponent(panel);
		setRightComponent(panelTable);
		setOrientation(VERTICAL_SPLIT);
		
	}

}
