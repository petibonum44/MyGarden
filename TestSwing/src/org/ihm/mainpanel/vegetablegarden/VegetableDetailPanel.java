package org.ihm.mainpanel.vegetablegarden;

import java.awt.Dimension;

import javax.swing.JSplitPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import org.ihm.details.vegetablelight.VegetableDetailLight;
import org.ihm.treeview.VegetableTreeView;
import org.srv.objets.groups.GroupBean;
import org.srv.objets.vegetables.VegetableBean;

public class VegetableDetailPanel extends JSplitPane {
	VegetableTreeView tree;
	VegetableDetailLight detail;
	public VegetableDetailPanel() {
		super();
//		setLayout(new );
		setPreferredSize(new Dimension(500,400));
		
		TreeNode node = buildRoot();
		tree = new VegetableTreeView(node);
		detail = new VegetableDetailLight();
		setLeftComponent(tree);
		setRightComponent(detail);
		setOrientation(VERTICAL_SPLIT);
		 setResizeWeight(0.5);
	     setOneTouchExpandable(true);
	     setContinuousLayout(true);
	     setDividerLocation(300);
	}
	
	/**
	 * http://www.jardinpotager.com/espacelegume.htm
	 * @return
	 */
	private TreeNode buildRoot() {
		GroupBean grpRoot = new GroupBean();
		grpRoot.setUcGroup("ROOT");
		grpRoot.setLlGroup("Racine");
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(grpRoot);
		// construction de quelques legumes
		// tomates
		VegetableBean tomate = new VegetableBean();
		tomate.setLlVegetable("tomates");
		tomate.setUcVegetable("TOM");
		tomate.setDistInterLigne(0.8);
		tomate.setDistPlants(0.5);
		DefaultMutableTreeNode nodeTomate = new DefaultMutableTreeNode(tomate);
		node.add(nodeTomate);
		// poivrons
		VegetableBean poivrons = new VegetableBean();
		poivrons.setLlVegetable("Poivrons");
		poivrons.setUcVegetable("POI");
		poivrons.setDistInterLigne(0.4);
		poivrons.setDistPlants(0.4);
		DefaultMutableTreeNode nodePoivrons = new DefaultMutableTreeNode(poivrons);
		node.add(nodePoivrons);
		// melons 
		VegetableBean melons = new VegetableBean();
		melons.setLlVegetable("Melons");
		melons.setUcVegetable("MEL");
		melons.setDistInterLigne(0.8);
		melons.setDistPlants(0.8);
		DefaultMutableTreeNode nodeMelons = new DefaultMutableTreeNode(melons);
		node.add(nodeMelons);
		addVegetable(node, "P d T", "PDT", 0.6, 0.3);
		addVegetable(node, "Carottes", "CA", 0.15, 0.05);
		addVegetable(node, "Haricots", "HA", 0.30, 0.05);
		addVegetable(node, "Poireaux", "PO", 0.30, 0.05);
		addVegetable(node, "Courgettes", "CO", 0.60, 0.6);
		addVegetable(node, "Céléri", "CO", 0.20, 0.2);
		
		
		
		return node;
	}
	
	private DefaultMutableTreeNode addVegetable(DefaultMutableTreeNode node,String ll,String uc,Double interLigne,Double interPlants) {
		// melons 
				VegetableBean melons = new VegetableBean();
				melons.setLlVegetable(ll);
				melons.setUcVegetable(uc);
				melons.setDistInterLigne(interLigne);
				melons.setDistPlants(interPlants);
				DefaultMutableTreeNode nodeMelons = new DefaultMutableTreeNode(melons);
				node.add(nodeMelons);
				return node;
				
	}
}
