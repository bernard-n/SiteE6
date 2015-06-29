package com.metier;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Documentation")
public class Documentation {
	@Id
	@Column(name="idDocumentation")
	private int idDocumentation;
	@Column(name="titre")
	private String titre;
	@Column(name="href")
	private String href;
	@ManyToOne
	@JoinColumn(name="idFiche")
	private FicheSituation laFiche;
	
	public Documentation(int idDocumentation, String titre, String href,
			FicheSituation laFiche) {
		super();
		this.idDocumentation = idDocumentation;
		this.titre = titre;
		this.href = href;
		this.laFiche = laFiche;
	}
	public Documentation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FicheSituation getLaFiche() {
		return laFiche;
	}
	public void setLaFiche(FicheSituation laFiche) {
		this.laFiche = laFiche;
	}
	public int getIdDocumentation() {
		return idDocumentation;
	}
	public void setIdDocumentation(int idDocumentation) {
		this.idDocumentation = idDocumentation;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	
}
