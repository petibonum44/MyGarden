package org.ihm.model;

public class Event {
	private AbstractAction action = null;
	private String destName = null;
	public Event(AbstractAction action, String dest) {
		this.action = action;
		this.destName = dest;
	}
	public AbstractAction getAction() {
		return action;
	}
	public void setAction(AbstractAction action) {
		this.action = action;
	}
	public String getDest() {
		return destName;
	}
	public void setDest(String dest) {
		this.destName = dest;
	}

}
