package org.ihm.model;

import java.util.List;



public interface IDisplayView {
	
	public String getName();
	public void doDataOperations(List<DataOperation> listeDataOperation);
	public void doDataOperation(DataOperation dop);
}
