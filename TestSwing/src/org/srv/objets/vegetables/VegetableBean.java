package org.srv.objets.vegetables;

public class VegetableBean implements Cloneable {

	private String ucVegetable;
	private String llVegetable;
	private String ucGroupe;
	
	private Double distInterLigne;
	private Double distPlants;
	
	public VegetableBean(String ucVegetable, String llVegetable,
			String ucGroupe, Double distInterLigne, Double distPlants) {
		super();
		this.ucVegetable = ucVegetable;
		this.llVegetable = llVegetable;
		this.ucGroupe = ucGroupe;
		this.distInterLigne = distInterLigne;
		this.distPlants = distPlants;
	}
	
	public VegetableBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUcVegetable() {
		return ucVegetable;
	}
	public void setUcVegetable(String ucVegetable) {
		this.ucVegetable = ucVegetable;
	}
	public String getLlVegetable() {
		return llVegetable;
	}
	public void setLlVegetable(String llVegetable) {
		this.llVegetable = llVegetable;
	}
	public String getUcGroupe() {
		return ucGroupe;
	}
	public void setUcGroupe(String ucGroupe) {
		this.ucGroupe = ucGroupe;
	}
	public Double getDistInterLigne() {
		return distInterLigne;
	}
	public void setDistInterLigne(Double distInterLigne) {
		this.distInterLigne = distInterLigne;
	}
	public Double getDistPlants() {
		return distPlants;
	}
	public void setDistPlants(Double distPlants) {
		this.distPlants = distPlants;
	}
	@Override
	public VegetableBean clone()  {
		VegetableBean vege = new VegetableBean(ucVegetable, llVegetable, ucGroupe, distInterLigne, distPlants);
		return vege;
	}
	
}
