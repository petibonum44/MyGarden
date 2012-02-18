package org.ihm.toolbar.event;

import org.ihm.layeredpanel.gridpanel.dataoperations.DataOperationModificationZoom;
import org.ihm.model.AbstractAction;
import org.ihm.model.ActionContext;
import org.ihm.model.DataOperation;

public class ActionChangementZoom extends AbstractAction {

	private int valeur = 0;
	
	public ActionChangementZoom(int valeur) {
		super();
		this.valeur = valeur;
	}

	@Override
	public void execute(ActionContext ac) {
	
			DataOperation dop = new DataOperationModificationZoom(valeur);
			ac.addDataOperation(dop);
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	

}
