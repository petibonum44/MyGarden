package org.ihm.plannings.garden.dataoperations;

import org.ihm.model.AbstractAction;
import org.ihm.model.Event;

public class EventNewWallAdd extends Event {
	
	public EventNewWallAdd(String view){
		super(new ActionNewWallAdd(),view);	
	}
	
	public EventNewWallAdd(AbstractAction action, String dest) {
		super(action, dest);
	}

}
