package org.ihm.treeview;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class VegetableTreeModel implements TreeModel {

	/**
	 * Méthode qui renvoie le noeud de base
	 */
	@Override
	public Object getRoot() {
		
		return null;
	}

	/**
	 * Methode qui renvoie le fils se trouvant à l'index "index" de la liste des noeud fils
	 */
	@Override
	public Object getChild(Object parent, int index) {
		
		return null;
	}

	/**
	 * Methode qui renvoie le nombre de fils d'un noeud
	 */
	@Override
	public int getChildCount(Object parent) {
	
		return 0;
	}

	/**
	 * Methode qui indique si il s'agit du dernier noeud de la hierarchie
	 */
	@Override
	public boolean isLeaf(Object node) {
	
		return false;
	}

	/** 
	 * 
	 */
	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		

	}

	/**
	 *  Recherche l'index du noeud child dans le parent.
	 */
	@Override
	public int getIndexOfChild(Object parent, Object child) {
		
		return 0;
	}

	/**
	 * Ajout d'un listener
	 */
	@Override
	public void addTreeModelListener(TreeModelListener l) {
	

	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		
	}

}
