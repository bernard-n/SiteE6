package com.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Article")
public class Article {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idArticle")
	private int idArticle;
	@Column(name="libelle")
	private String libelle;
	@Column(name="resume")
	private String resume;
	@Column(name="href")
	private String href;
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie laCategorie;
	@Column(name="note")
	private int note;
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(int idArticle, String libelle, String resume, String href,
			Categorie laCategorie,int note) {
		super();
		this.idArticle = idArticle;
		this.libelle = libelle;
		this.resume = resume;
		this.href = href;
		this.laCategorie = laCategorie;
		this.note = note;
	}
	
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Categorie getLaCategorie() {
		return laCategorie;
	}
	public void setLaCategorie(Categorie laCategorie) {
		this.laCategorie = laCategorie;
	}
	
}
