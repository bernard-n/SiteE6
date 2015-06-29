package com.metier;

import javax.persistence.Embeddable;

@Embeddable
public class ListeTachePK implements java.io.Serializable{
	private int idTache;
	private int idListeActivite;
	public ListeTachePK(int idTache, int idListeActivite) {
		super();
		this.idTache = idTache;
		this.idListeActivite = idListeActivite;
	}
	public ListeTachePK() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdTache() {
		return idTache;
	}
	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}
	public int getIdListeActivite() {
		return idListeActivite;
	}
	public void setIdListeActivite(int idListeActivite) {
		this.idListeActivite = idListeActivite;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idListeActivite;
		result = prime * result + idTache;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListeTachePK other = (ListeTachePK) obj;
		if (idListeActivite != other.idListeActivite)
			return false;
		if (idTache != other.idTache)
			return false;
		return true;
	}
	
}
