package org.ihm.treeview;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.ihm.treeview.draganddrop.VegetableTreeDataTransferHandler;


public class VegetableTreeView extends JTree {

	public VegetableTreeView(TreeNode root) {
		super(new DefaultTreeModel(root));
		setCellRenderer(new VegetableTreeCellRenderer());
		setTransferHandler(new VegetableTreeDataTransferHandler());
		setDragEnabled(true);
	}

	@Override
	public TreePath[] getSelectionPaths() {
		// TODO Auto-generated method stub
		return super.getSelectionPaths();
	}

	
}
