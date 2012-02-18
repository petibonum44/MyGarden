package org.ihm.layeredpanel.gridpanel.dataoperations;

import org.ihm.model.DataOperation;

public class DataOperationModificationZoom extends DataOperation {

	private int valeur = 0;

	public DataOperationModificationZoom(int valeur) {
		super();
		this.valeur = valeur;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
}
