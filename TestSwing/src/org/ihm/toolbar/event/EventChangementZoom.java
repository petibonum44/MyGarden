package org.ihm.toolbar.event;

import org.ihm.layeredpanel.gridpanel.MainGridPanel;
import org.ihm.model.AbstractAction;
import org.ihm.model.Event;

public class EventChangementZoom extends Event {
	
	public EventChangementZoom(int valeur){
		super(new ActionChangementZoom(valeur),MainGridPanel.MAINGRIDPANELNAME);	
	}
	
	public EventChangementZoom(AbstractAction action, String dest) {
		super(action, dest);
		
	}

}
