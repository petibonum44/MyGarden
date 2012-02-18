package org.ihm.treeview.draganddrop;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.srv.objets.vegetables.VegetableBean;

public class VegetableTransfer implements Transferable {
	public final static DataFlavor VEGETABLE_FLAVOR;
	static { 
		try {
			///		Création du type MIME associé à la classe
			String vegetableFlavorMimeType =
					DataFlavor.javaJVMLocalObjectMimeType
					+ ";class=" + VegetableTransfer.class.getName();
			//		Création du format de données
			VEGETABLE_FLAVOR = new DataFlavor(vegetableFlavorMimeType); 
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException(ex);
		}
	}
	/**
     * Levegetable à transférer.
     */
    private VegetableBean vegetable;
    
    /**
     * @param p
     */
    public VegetableTransfer(VegetableBean p) {
    	vegetable= p.clone();
    }


    /**
     * La liste des flavor supportées, pour que les cibles potentielles sachent si elles 
     * peuvent recevoir la donnée.
     *. */ 
    public DataFlavor[] getTransferDataFlavors() {
    	return new DataFlavor [] {VEGETABLE_FLAVOR};
    } 
    
    /** * Dit si nous acceptons de retourner une flavor particulière. */ 
    public boolean isDataFlavorSupported(DataFlavor flavor) {  
    	return VEGETABLE_FLAVOR.equals(flavor); 
    	} 
  

    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException { 
    	/*if (PersonneFlavorFactory.getPersonneFlavor().equals(flavor)) return vegetable; 
    	else */
    		if (VEGETABLE_FLAVOR.equals(flavor)) { 
    		return vegetable; } 
    			else throw new UnsupportedFlavorException(flavor); 
    	} 
}
