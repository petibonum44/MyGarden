package org.ihm.plannings.garden;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.ihm.model.DataOperation;
import org.ihm.model.IDisplayView;
import org.ihm.model.MainController;
import org.ihm.plannings.garden.dataoperations.NewWallDataOperation;

public class PlanningGardenTable extends JTable implements IDisplayView{
	public static String PLANNINGGARDENTABLE="PlanningGardenTable";
	public PlanningGardenTable() {
		super(new SimpleTableModel());
		setName(PLANNINGGARDENTABLE);
		//enregistrement de la vue.
		MainController.getInstance().addView(this);
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
		if (dop instanceof NewWallDataOperation) {
			//récupération de la nouvelle valeur
			((AbstractTableModel)getModel()).fireTableDataChanged();
			
		}
	}

	
	
}
