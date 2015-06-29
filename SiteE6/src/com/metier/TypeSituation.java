package com.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TypeSituation")
public class TypeSituation {
	@Id
	@Column(name="idType")
	private int idType;
	@Column(name="libelleType")
	private String libelleType;
	public int getIdType() {
		return idType;
	}
	public void setIdType(int idType) {
		this.idType = idType;
	}
	public String getLibelleType() {
		return libelleType;
	}
	public void setLibelleType(String libelleType) {
		this.libelleType = libelleType;
	}
	public TypeSituation(int idType, String libelleType) {
		super();
		this.idType = idType;
		this.libelleType = libelleType;
	}
	public TypeSituation() {
		super();
	}
	
}
