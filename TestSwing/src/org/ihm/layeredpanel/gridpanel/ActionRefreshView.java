package org.ihm.layeredpanel.gridpanel;

import org.ihm.layeredpanel.gridpanel.dataoperations.DataOperationModificationZoom;
import org.ihm.layeredpanel.gridpanel.dataoperations.DataOperationRefreshView;
import org.ihm.model.AbstractAction;
import org.ihm.model.ActionContext;
import org.ihm.model.ClientRequest;
import org.ihm.model.DataOperation;
import org.ihm.model.MainController;
import org.ihm.plannings.garden.PlanningGardenTable;
import org.ihm.plannings.garden.dataoperations.EventNewWallAdd;

public class ActionRefreshView extends AbstractAction {

	
	public ActionRefreshView() {
		super();
	}

	@Override
	public void execute(ActionContext ac) {
	
			DataOperation dop = new DataOperationRefreshView();
			ac.addDataOperation(dop);
			// on envoie un evenement à la table
						ClientRequest cr2 = new ClientRequest();
						EventNewWallAdd event2 = new EventNewWallAdd(PlanningGardenTable.PLANNINGGARDENTABLE);
						cr2.setEvent(event2);
						MainController.getInstance().performRequest(cr2);
	}

	

	

}
