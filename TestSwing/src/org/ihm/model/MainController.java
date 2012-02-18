package org.ihm.model;

import java.util.HashMap;

/**
 * Classe qui va executer des actions.
 * Les actions vont venir d'une vue, pour soit aller vers une autre vue, soit vers la même vue.
 * 
 * @author doc
 *
 */
public class MainController {

	private static MainController instance = null;
	private static HashMap<String,IDisplayView> mapViews = null;
	
	private MainController() {
		super();
		mapViews = new HashMap<String,IDisplayView>();
	}
	
	/**
	 * Singleton.
	 * @return
	 */
	public static MainController getInstance() {
		
		if (instance == null) {
			instance = new MainController();
		}
		return instance;
	}
	
	/**
	 * Enregistrement des vues
	 * @param view
	 */
	public static void addView(IDisplayView view) {
		mapViews.put(view.getName(), view);
	}
	
	/**
	 * Le controller doit maintenant traiter l'action.
	 */
	public static void performRequest(ClientRequest cr) {
		if (cr.getEvent()!=null && cr.getEvent().getAction()!=null) {
			// récupération de l'action
			AbstractAction action = cr.getEvent().getAction();
			// construction d'un context pour l'action
			ActionContext ac = new ActionContext();
			ac.setClientRequest(cr);
			// Recherche de la vue de dstination
			ac.setDestinationView(mapViews.get(cr.getEvent().getDest()));
			// execution de l'action (possibilité de changer la destination dans l'action)
			action.execute(ac);
			// execution du résultat sur la vue destination
			IDisplayView destView = ac.getDestinationView();
			if (destView!=null && ac.getListeDataOperation()!=null && !ac.getListeDataOperation().isEmpty())
				destView.doDataOperations(ac.getListeDataOperation());
			
		}
	}
}
