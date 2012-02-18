package org.ihm.layeredpanel.gridpanel;

import org.ihm.model.AbstractAction;
import org.ihm.model.Event;

public class EventRefreshView extends Event {
	
	public EventRefreshView(String view){
		super(new ActionRefreshView(),view);	
	}
	
	public EventRefreshView(AbstractAction action, String dest) {
		super(action, dest);
		
	}

}
