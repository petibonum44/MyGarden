package org.ihm.model;

import java.util.ArrayList;
import java.util.List;

public class ActionContext {

		private ClientRequest clientRequest = null;
		private IDisplayView destinationView = null;
		private List<DataOperation> listeDataOperation = new ArrayList<DataOperation>();
		
		public IDisplayView getDestinationView() {
			return destinationView;
		}

		public void setDestinationView(IDisplayView destinationView) {
			this.destinationView = destinationView;
		}

		public ClientRequest getClientRequest() {
			return clientRequest;
		}

		public void setClientRequest(ClientRequest clientRequest) {
			this.clientRequest = clientRequest;
		}

		public List<DataOperation> getListeDataOperation() {
			return listeDataOperation;
		}
		public DataOperation addDataOperation(DataOperation dop) {
			listeDataOperation.add(dop);
			return dop;
		}
		
}
