package com.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="FicheSituation")
public class FicheSituation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idFiche")
	private int idFiche;
	@Column(name="libelleFiche")
	private String libelleFiche;
	@ManyToOne
	@JoinColumn(name="idType")
	private TypeSituation leType;
	@Column(name="organisation")
	private String organisation;
	@Column(name="environnement")
	private String environnement;
	@Column(name="besoin")
	private String besoin;
	@OneToMany(mappedBy="laFiche")
	private List<ListeActivite> listeActivite;
	@OneToMany(mappedBy="laFiche")
	private List<Documentation> listeDocumentation;
	public FicheSituation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Tache> getListeTacheDistinct(){
		List<Tache> listeT = new ArrayList<Tache>();
		for(ListeActivite list : listeActivite){
			for(ListeTache l : list.getListeTache()){
				if(!listeT.contains(l.getLatache())){
					listeT.add(l.getLatache());
				}
			}
		}
		
		return listeT;
	}
	
	public FicheSituation(int idFiche, String libelleFiche,
			TypeSituation leType, String organisation, String environnement,
			String besoin, List<ListeActivite> listeActivite,
			List<Documentation> listeDocumentation) {
		super();
		this.idFiche = idFiche;
		this.libelleFiche = libelleFiche;
		this.leType = leType;
		this.organisation = organisation;
		this.environnement = environnement;
		this.besoin = besoin;
		this.listeActivite = listeActivite;
		this.listeDocumentation = listeDocumentation;
	}
	
	public List<Documentation> getListeDocumentation() {
		return listeDocumentation;
	}
	public void setListeDocumentation(List<Documentation> listeDocumentation) {
		this.listeDocumentation = listeDocumentation;
	}
	public int getIdFiche() {
		return idFiche;
	}
	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}
	public String getLibelleFiche() {
		return libelleFiche;
	}
	public void setLibelleFiche(String libelleFiche) {
		this.libelleFiche = libelleFiche;
	}
	public TypeSituation getLeType() {
		return leType;
	}
	public void setLeType(TypeSituation leType) {
		this.leType = leType;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public String getEnvironnement() {
		return environnement;
	}
	public void setEnvironnement(String environnement) {
		this.environnement = environnement;
	}
	public String getBesoin() {
		return besoin;
	}
	public void setBesoin(String besoin) {
		this.besoin = besoin;
	}
	public List<ListeActivite> getListeActivite() {
		return listeActivite;
	}
	public void setListeActivite(List<ListeActivite> listeActivite) {
		this.listeActivite = listeActivite;
	}
	
	
}
