package org.ihm.treeview;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import org.ihm.mainpanel.vegetablegarden.VegetableDetailPanel;
import org.srv.objets.groups.GroupBean;
import org.srv.objets.vegetables.VegetableBean;

public class VegetableTreeCellRenderer extends DefaultTreeCellRenderer {

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		
		Component cp =  super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
				row, hasFocus);
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
		
		if (node.getUserObject() instanceof GroupBean) {
			((JLabel)cp).setText(((GroupBean)node.getUserObject()).getLlGroup());
		}
		else
			if (node.getUserObject() instanceof VegetableBean) {
				((JLabel)cp).setText(((VegetableBean)node.getUserObject()).getLlVegetable());
			}
			
		return cp;
	}

}
