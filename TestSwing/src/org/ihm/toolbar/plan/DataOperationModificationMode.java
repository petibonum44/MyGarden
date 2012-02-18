package org.ihm.toolbar.plan;

import org.ihm.model.DataOperation;

public class DataOperationModificationMode extends DataOperation {

	private String mode ;

	public DataOperationModificationMode(String mode) {
		super();
		this.mode = mode;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	
	
}
