package models;

import models.DBConverter.DBTable;

public class ItemLista {
	
	// Atributes
	@DBTable(nomeColuna ="id")
	private String uid;
	
	@DBTable(nomeColuna ="item")
	private String item;
	
	
	//Getters and Setters
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	
}
