package org.ihm.drawing;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import org.ihm.layeredpanel.gridpanel.MainGridPanel;
import org.ihm.model.DataOperation;
import org.ihm.model.IDisplayView;
import org.ihm.model.MainController;
import org.ihm.toolbar.plan.GridToolBarPanel;

public class DrawingPanel extends JPanel implements IDisplayView {
	
	public static String DRAWINGPANELNAME="DrawingPanelName";
	/**
	 * Toolbar du composant
	 */
	GridToolBarPanel toolBar = new GridToolBarPanel();
	/**
	 * Grille
	 */
	MainGridPanel grille = new MainGridPanel();
	
	JSplitPane splitPane = null;
	
	public DrawingPanel() {
		super();
		setName(DRAWINGPANELNAME);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		buildComposant();
		//enregistrement de la vue.
		MainController.getInstance().addView(this);
	}
	public MainGridPanel getGrille() {
		return grille;
	}

	public void setGrille(MainGridPanel grille) {
		this.grille = grille;
	}

	private void buildComposant() {
		splitPane =new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				toolBar, grille);
		splitPane.setOneTouchExpandable(false);
	    splitPane.setDividerLocation(50);

		this.add(splitPane);
	}
	

	/*******************************************************/
	/*** Implementation du principe MVC                  ***/
	/*******************************************************/
	
	@Override
	public void doDataOperations(List<DataOperation> listeDataOperation) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doDataOperation(DataOperation dop) {
		// TODO Auto-generated method stub
		
	}

}
