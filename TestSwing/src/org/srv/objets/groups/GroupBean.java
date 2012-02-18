package org.srv.objets.groups;

import java.util.List;

public class GroupBean {
	
	private String ucGroup;
	private String llGroup;
	private String ucGroupParent;
	private List<GroupBean> listChildGroup;
	private List<Object> listeChildElement;
	
	public String getUcGroup() {
		return ucGroup;
	}
	public void setUcGroup(String ucGroup) {
		this.ucGroup = ucGroup;
	}
	public String getLlGroup() {
		return llGroup;
	}
	public void setLlGroup(String llGroup) {
		this.llGroup = llGroup;
	}
	public String getUcGroupParent() {
		return ucGroupParent;
	}
	public void setUcGroupParent(String ucGroupParent) {
		this.ucGroupParent = ucGroupParent;
	}
	public List<GroupBean> getListChildGroup() {
		return listChildGroup;
	}
	public void setListChildGroup(List<GroupBean> listChildGroup) {
		this.listChildGroup = listChildGroup;
	}
	public List<Object> getListeChildElement() {
		return listeChildElement;
	}
	public void setListeChildElement(List<Object> listeChildElement) {
		this.listeChildElement = listeChildElement;
	}
	
	
}
