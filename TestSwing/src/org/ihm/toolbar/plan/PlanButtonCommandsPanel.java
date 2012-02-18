package org.ihm.toolbar.plan;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.common.utils.icons.IconsCst;
import org.common.utils.icons.IconsUtils;
import org.ihm.model.DataOperation;
import org.ihm.model.IDisplayView;
import org.ihm.model.MainController;

public class PlanButtonCommandsPanel extends JPanel implements IDisplayView {
	public static String PLANBUTTONCOMMANDPANEL = "PLANBUTTONCOMMANDPANEL";
	
	private NagivationToolBarButton buttonDraw = null;
	private NagivationToolBarButton buttonMove = null;

	private NagivationToolBarButton buttonSelect = null;
	private NagivationToolBarButton buttonDelete = null;
	private ImageIcon iconMove = null;
	private ImageIcon iconDraw = null;
	private ImageIcon iconSelect = null;
	private ImageIcon iconDelete = null;
	public PlanButtonCommandsPanel() {
		super();
		setName(PLANBUTTONCOMMANDPANEL);
		MainController.getInstance().addView(this);
		buildIcons();
		buildPanel();
	}

		private void buildPanel() {
		    /* Construction des boutons */
			// Boutons de dessin
			buttonDraw = new NagivationToolBarButton("Start",iconDraw);
			buttonDraw.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e)
	            {
	               ToolBarPlanModel.getInstance().setNexMode(ToolBarPlanModeCst.MODE_DRAW);
	            }
	        }); 
		    // bouton de déplacement
			buttonMove = new NagivationToolBarButton("Move",iconMove);
			buttonMove.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e)
	            {
	               ToolBarPlanModel.getInstance().setNexMode(ToolBarPlanModeCst.MODE_MOVE);
	            }
	        }); 
			// Boutons de dessin
			buttonSelect= new NagivationToolBarButton("Select",iconSelect);
			buttonSelect.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e)
	            {
	               ToolBarPlanModel.getInstance().setNexMode(ToolBarPlanModeCst.MODE_SELECT);
	            }
	        });
		    // bouton de déplacement
			buttonDelete = new NagivationToolBarButton("Delete",iconDelete);
			buttonDelete.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e)
	            {
	               ToolBarPlanModel.getInstance().setNexMode(ToolBarPlanModeCst.MODE_VEGETABLE);
	            }
	        });		
			setLayout(new MigLayout());
			setPreferredSize(new Dimension(40,20));
		    setOpaque(false);
		    add(buttonMove);
		    add(buttonSelect,"wrap");
		    
		    add(buttonDraw);
		    add(buttonDelete);
		}
		private void buildIcons() {
			iconMove = IconsUtils.createSmallImageIcon(IconsCst.MOVE);
			iconDraw = IconsUtils.createSmallImageIcon(IconsCst.START_DRAW);
			iconSelect = IconsUtils.createSmallImageIcon(IconsCst.SELECT);
			iconDelete = IconsUtils.createSmallImageIcon(IconsCst.DELETE);
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
			if (dop instanceof DataOperationModificationMode) {
				//récupération de la nouvelle valeur
				String mode = ((DataOperationModificationMode) dop).getMode();
				buttonDraw.setSelected(false);
				buttonMove.setSelected(false);
				buttonSelect.setSelected(false);
				buttonDelete.setSelected(false);
				if (ToolBarPlanModeCst.MODE_DRAW.equals(mode)) {
					buttonDraw.setSelected(true);
				}
				else if (ToolBarPlanModeCst.MODE_MOVE.equals(mode))
				{
					buttonMove.setSelected(true);
				}
				else if (ToolBarPlanModeCst.MODE_SELECT.equals(mode))
				{
					buttonSelect.setSelected(true);
				}
				else if (ToolBarPlanModeCst.MODE_VEGETABLE.equals(mode))
				{
					buttonDelete.setSelected(true);
				}
				
				this.repaint();
				this.revalidate();
				
			}
			
		}
		
}
