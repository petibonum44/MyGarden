package org.ihm.treeview.draganddrop;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.awt.event.InputEvent;

import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;

import org.srv.objets.vegetables.VegetableBean;

public class VegetableTreeDataTransferHandler extends TransferHandler {

	@Override
	protected Transferable createTransferable(JComponent arg0) {
		 DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                 ((JTree)arg0).getLastSelectedPathComponent();
		 if (node.getUserObject() instanceof VegetableBean) {
			 return new VegetableTransfer((VegetableBean)node.getUserObject());
		 }
		return super.createTransferable(arg0);
	}
	public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
  }
	@Override
	public void exportAsDrag(JComponent comp, InputEvent e, int action) {

		super.exportAsDrag(comp, e, action);
	}
	@Override
	protected void exportDone(JComponent source, Transferable data, int action) {
		// TODO Auto-generated method stub
		super.exportDone(source, data, action);
	}
	@Override
	public void exportToClipboard(JComponent comp, Clipboard clip, int action)
			throws IllegalStateException {
		// TODO Auto-generated method stub
		super.exportToClipboard(comp, clip, action);
	}

}
