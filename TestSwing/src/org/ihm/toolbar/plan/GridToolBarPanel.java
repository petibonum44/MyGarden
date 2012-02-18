package org.ihm.toolbar.plan;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;

import org.common.utils.GlobalOptions;
import org.ihm.model.ClientRequest;
import org.ihm.model.DataOperation;
import org.ihm.model.IDisplayView;
import org.ihm.model.MainController;
import org.ihm.toolbar.event.EventChangementZoom;

public class GridToolBarPanel extends JPanel implements ChangeListener,IDisplayView,MouseListener,MouseMotionListener{
	private JSlider spinner = null;
	private PlanButtonCommandsPanel  buttonsPanel = null;

	public static String GRIDTOOLBARPANELNAME = "GridToolBarPanel";
	public GridToolBarPanel() {
		super();
		setLayout(new MigLayout());	
		setName(GRIDTOOLBARPANELNAME);
		setSize(new Dimension(100,300));
	
		buildComponents();
		
		
		ajoutActionSlider();
//		ajoutActionButtonDraw();
		MainController.getInstance().addView(this);
		setOpaque(false);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
	}
	private void buildComponents() {
		spinner = new JSlider(JSlider.VERTICAL);
		buttonsPanel = new PlanButtonCommandsPanel();

	    
		this.add(buttonsPanel,"wrap");
		this.add(spinner,"center");
	}
	
	@Override
	public void doDataOperations(List<DataOperation> listeDataOperation) {
	
	}
	@Override
	public void doDataOperation(DataOperation dop) {
		
	}
	
	/** 
	 * Ajoput d'un listener sur le slider
	 */
	private void ajoutActionSlider() {
		spinner.setMaximum(100);
		spinner.setMinimum(10);
		spinner.setValue(50);
		spinner.addChangeListener(this);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// on envoie un évènement au controller
		int value = spinner.getValue();
		ClientRequest cr = new ClientRequest();
		cr.setEvent(new EventChangementZoom(value));
		MainController.getInstance().performRequest(cr);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (GlobalOptions.debug) {
			GlobalOptions.print("Mouse cliked", this.getName());
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	private int previousX = -1;
	private int previousY = -1;
	@Override
	public void mouseReleased(MouseEvent e) {
		previousX=-1;previousY=-1;
	}
	/**
	 * Déplacement du composant
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		
		Point previous = getLocation(); 
		if (previousX==-1) {
			previousX = e.getXOnScreen();
			previousY= e.getYOnScreen();
		}
		else {
			int deltaX =-previousX+e.getXOnScreen();
			int deltaY = e.getYOnScreen()-previousY;
			setLocation(previous.x+deltaX,previous.y+deltaY);
			
			previousX = e.getXOnScreen();
			previousY= e.getYOnScreen();
		}
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
