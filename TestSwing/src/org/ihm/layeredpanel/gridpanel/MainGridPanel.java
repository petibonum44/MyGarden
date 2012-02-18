package org.ihm.layeredpanel.gridpanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.List;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import org.common.utils.GlobalOptions;
import org.ihm.layeredpanel.gridpanel.dataoperations.DataOperationModificationZoom;
import org.ihm.layeredpanel.gridpanel.dataoperations.DataOperationRefreshView;
import org.ihm.layeredpanel.gridpanel.model.GridModel;
import org.ihm.layeredpanel.gridpanel.model.WallSelectionModel;
import org.ihm.layeredpanel.gridpanel.mousehandler.MouseHandler;
import org.ihm.layeredpanel.gridpanel.mousehandler.MouseHandlerForDrawMode;
import org.ihm.layeredpanel.gridpanel.mousehandler.MouseHandlerForMoveMode;
import org.ihm.layeredpanel.gridpanel.mousehandler.MouseHandlerForSelectMode;
import org.ihm.layeredpanel.gridpanel.mousehandler.MouseHandlerForVegetableMode;
import org.ihm.layeredpanel.wallpanel.VegetableWallRenderer;
import org.ihm.layeredpanel.wallpanel.WallPanel;
import org.ihm.layeredpanel.wallpanel.WallRenderer;
import org.ihm.model.ClientRequest;
import org.ihm.model.DataOperation;
import org.ihm.model.IDisplayView;
import org.ihm.model.MainController;
import org.ihm.toolbar.plan.DataOperationModificationMode;
import org.ihm.toolbar.plan.GridToolBarPanel;
import org.ihm.toolbar.plan.ToolBarPlanModeCst;
import org.srv.objets.walls.WallCst;

public class MainGridPanel extends JPanel  implements ComponentListener,IDisplayView,AncestorListener{
	

	GridPanel panel = null;
	WallPanel wallPanel = null;
	WallPanel vegetablePanel = null;
	GraduatedRuledPanel regle = null;
	GridModel modelDeLaGrille = null;
	GridToolBarPanel toolBar = new GridToolBarPanel();
	MouseHandler mouseHandler = null;
	MouseHandlerForMoveMode mouseHandlerMove  = null;
	MouseHandlerForSelectMode mouseHandlerSelect  = null;
	MouseHandlerForDrawMode mouseHandlerDraw  = null;
	MouseHandlerForDrawMode mouseHandlerVegetable  = null;
	private JLayeredPane layeredPanel = null;
	public static String MAINGRIDPANELNAME="MainGridPanel";
	
	
	public MainGridPanel() {
		super();
		setName(MAINGRIDPANELNAME);
		setLayout(new GridLayout());
		setPreferredSize(new Dimension(500,500));
		buildPanel();
		buildMouseHandler();
		setVisible(true);
		addAncestorListener(this);
		panel.addMouseListener(mouseHandler);
		panel.addMouseMotionListener(mouseHandler);
		MainController.getInstance().addView(this);
		
	}

 
	private void buildMouseHandler() {
		mouseHandlerMove = new MouseHandlerForMoveMode(getModel());
		mouseHandlerDraw = new MouseHandlerForDrawMode(getModel(),WallCst.TYPE_WALL);
		mouseHandlerSelect = new MouseHandlerForSelectMode(getModel(),WallCst.TYPE_VEGETABLE);
		mouseHandlerVegetable = new MouseHandlerForDrawMode(getModel(),WallCst.TYPE_VEGETABLE); //new MouseHandlerForVegetableMode(getModel());
		mouseHandler = new MouseHandler(mouseHandlerMove);
		
	}
	private void buildPanel() {
		layeredPanel =  new JLayeredPane();
		layeredPanel.setPreferredSize(new Dimension(getWidth(), getHeight()));
		this.add(layeredPanel);
		modelDeLaGrille = GridModel.getInstance();
		panel = new GridPanel(modelDeLaGrille);
		regle = new GraduatedRuledPanel(modelDeLaGrille);
		
		wallPanel = new WallPanel(new WallRenderer());
		vegetablePanel = new WallPanel(new VegetableWallRenderer());
		layeredPanel.add(toolBar,180);
		layeredPanel.add(vegetablePanel,140);
		layeredPanel.add(wallPanel,150);
		layeredPanel.add(regle,120);
		layeredPanel.add(panel, 100);
	
	}

		public GridModel getModel() {
			return modelDeLaGrille;
		}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D)g.create();
		g2D.setBackground(new Color(0,0,100));
		super.paintComponent(g);
		if (GlobalOptions.debug) {
			System.out.println("Taille panel Grille : X="+getWidth());
		}
	}


	@Override
	public void setPreferredSize(Dimension preferredSize) {
		// TODO Auto-generated method stub
		super.setPreferredSize(preferredSize);
	}


	@Override
	public void componentResized(ComponentEvent e) {
		resizeIt();
	}
	
	public void resizeIt() {
		// my component is being rezid
				if (panel!=null) {
					
					panel.setSize(new Dimension(getWidth(),getHeight()));
					panel.repaint();
				}
				if (regle!=null) {
					
					regle.setSize(new Dimension(getWidth(),getHeight()));
					regle.repaint();
				}
				if (wallPanel!=null) {
					wallPanel.setSize(new Dimension(getWidth(),getHeight()));
					wallPanel.repaint();
					
				}
				if (vegetablePanel!=null) {
					vegetablePanel.setSize(new Dimension(getWidth(),getHeight()));
					vegetablePanel.repaint();
					
				}
	}
	@Override
	public void ancestorMoved(AncestorEvent event) {
	
		resizeIt();
	}
	@Override
	public void ancestorAdded(AncestorEvent event) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ancestorRemoved(AncestorEvent event) {
		// TODO Auto-generated method stub
		
	}


	


	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void componentShown(ComponentEvent e) {
	}


	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void doDataOperations(List<DataOperation> listeDataOperation) {
		if (listeDataOperation!=null) {
			for (DataOperation dataOperation : listeDataOperation) {
				doDataOperation(dataOperation);
			}
		}
		
	}


	@Override
	public void doDataOperation(DataOperation dop) {
		if (dop instanceof DataOperationModificationZoom) {
			//récupération de la nouvelle valeur
			Double dValue = ((DataOperationModificationZoom) dop).getValeur()/100.;
			modelDeLaGrille.setZoom(dValue);
			this.repaint();
			this.revalidate();
			
		}
		else
			if (dop instanceof DataOperationModificationMode) {
				DataOperationModificationMode dopMode = (DataOperationModificationMode)dop;
				//on commence par deselectionner
				WallSelectionModel.getInstance().deselectWall();
				ClientRequest cr = new ClientRequest();
				EventRefreshView event = new EventRefreshView(MainGridPanel.MAINGRIDPANELNAME);
				cr.setEvent(event);
				MainController.getInstance().performRequest(cr);
				String mode = dopMode.getMode();
				if (ToolBarPlanModeCst.MODE_MOVE.equals(mode)) {
					
					setCursor(new Cursor(Cursor.HAND_CURSOR));
					mouseHandler.setCurrentStrategy(mouseHandlerMove);
				}
				else 
					if (ToolBarPlanModeCst.MODE_SELECT.equals(mode)) {
						
						setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						mouseHandler.setCurrentStrategy(mouseHandlerSelect);
					}
					else 
						if (ToolBarPlanModeCst.MODE_DRAW.equals(mode)) {
							
							setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
							mouseHandler.setCurrentStrategy(mouseHandlerDraw);
						}
						else 
							if (ToolBarPlanModeCst.MODE_VEGETABLE.equals(mode)) {
								
								setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
								mouseHandler.setCurrentStrategy(mouseHandlerVegetable);
							}
			}
			else 
				if (dop instanceof DataOperationRefreshView) {
					this.repaint();
					this.revalidate();
				}
	}

	
	
}
