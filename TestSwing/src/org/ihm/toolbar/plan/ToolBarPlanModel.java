package org.ihm.toolbar.plan;

import org.ihm.layeredpanel.gridpanel.MainGridPanel;
import org.ihm.model.ClientRequest;
import org.ihm.model.MainController;
import org.ihm.toolbar.event.EventChangementZoom;

/**
 * Modele de la tool Bar liée au plan
 * Define wich is the current mode of drawing. The available mode are :
 *    - Select
 *    - Move
 *    - Draw
 *    - Delete (to be confirmed) probably replace by a state for vegetable. (not implemented yet)
 * @author doc
 *
 */
public class ToolBarPlanModel {
	
	private static ToolBarPlanModel instance = null;
	
	private static String currentMode = null;
	/**
	 * Constructor
	 */
	private  ToolBarPlanModel() {
		
	}
	public static ToolBarPlanModel getInstance() {
		if (instance==null) {
			instance = new ToolBarPlanModel();
		}
		return instance;
	}
	
	/** 
	 * Implementation of the model
	 */
	
	/**
	 * Changement de mode. Appelé par la vue vers le model.
	 * Le modele renvoie un évènement vers la vue au travers u controller 
	 * @param mode
	 */
	public static void setNexMode(String mode) {
		currentMode = mode;
		// Envoie de l'évènement au model
		ClientRequest cr = new ClientRequest();
		cr.setEvent(new EventChangementMode(mode,PlanButtonCommandsPanel.PLANBUTTONCOMMANDPANEL));
		MainController.getInstance().performRequest(cr);
		cr = new ClientRequest();
		cr.setEvent(new EventChangementMode(mode,MainGridPanel.MAINGRIDPANELNAME));
		MainController.getInstance().performRequest(cr);
	}
	
	
}
