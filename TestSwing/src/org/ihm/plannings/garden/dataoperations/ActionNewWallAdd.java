package org.ihm.plannings.garden.dataoperations;

import org.ihm.model.AbstractAction;
import org.ihm.model.ActionContext;
import org.ihm.model.DataOperation;

public class ActionNewWallAdd extends AbstractAction {

	
	public ActionNewWallAdd() {
		super();
	}

	@Override
	public void execute(ActionContext ac) {
	
			DataOperation dop = new NewWallDataOperation();
			ac.addDataOperation(dop);
	}

	

	

}
