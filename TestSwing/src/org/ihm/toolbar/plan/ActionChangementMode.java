package org.ihm.toolbar.plan;

import org.ihm.layeredpanel.gridpanel.dataoperations.DataOperationModificationZoom;
import org.ihm.model.AbstractAction;
import org.ihm.model.ActionContext;
import org.ihm.model.DataOperation;

public class ActionChangementMode extends AbstractAction {

	private String  mode ;
	
	public ActionChangementMode(String mode) {
		super();
		this.mode = mode;
	}

	@Override
	public void execute(ActionContext ac) {
	
			DataOperation dop = new DataOperationModificationMode(mode);
			ac.addDataOperation(dop);
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	

}
