package org.ihm.toolbar.plan;

import org.ihm.model.AbstractAction;
import org.ihm.model.Event;

public class EventChangementMode extends Event {
	
	public EventChangementMode(String mode,String view){
		super(new ActionChangementMode(mode),view);	
	}
	
	public EventChangementMode(AbstractAction action, String dest) {
		super(action, dest);
		
	}

}
