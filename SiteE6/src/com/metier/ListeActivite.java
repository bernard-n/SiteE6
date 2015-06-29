package com.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="ListeActivite")
public class ListeActivite {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idListeActivite")
	private int idListeActivite;
	@ManyToOne
	@JoinColumn(name="idFiche")
	private FicheSituation laFiche;
	@ManyToOne
	@JoinColumn(name="idActivite")
	private Activite laActivite;
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="ListeCompetence", 
            joinColumns={@JoinColumn(name="idListeActivite")}, 
            inverseJoinColumns={@JoinColumn(name="idCompetence")})
	private List<Competence> listeCompetence;
	@OneToMany(mappedBy="listeActivite")
	private List<ListeTache> listeTache;
	public ListeActivite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getListeTache(Etat etat){
		List<Tache> listeTach = new ArrayList<Tache>();
		String resultat = "";
		int i = 0;
		for(ListeTache l : listeTache){
			i++;
			if(!listeTache.contains(l.getLatache())){
				//System.out.println(l.getLatache().getLibelleTache() + " :  " + l.getEtat().equals(etat) + " - " + i);
				if(l.getEtat().equals(etat)){
					listeTach.add(l.getLatache());
					
					if(resultat.equals("")){
						resultat += l.getLatache().getNumTache();
					}else
						resultat += ", " + l.getLatache().getNumTache();

				}
			}
		}
		//System.out.println("-------\n-------\n");
		return resultat;
	}
	public ListeActivite(int idListeActivite, FicheSituation laFiche,
			Activite laActivite, List<Competence> listeCompetence,
			List<ListeTache> listeTache) {
		super();
		this.idListeActivite = idListeActivite;
		this.laFiche = laFiche;
		this.laActivite = laActivite;
		this.listeCompetence = listeCompetence;
		this.listeTache = listeTache;
	}
	
	public int getIdListeActivite() {
		return idListeActivite;
	}
	public void setIdListeActivite(int idListeActivite) {
		this.idListeActivite = idListeActivite;
	}
	public FicheSituation getLaFiche() {
		return laFiche;
	}
	public void setLaFiche(FicheSituation laFiche) {
		this.laFiche = laFiche;
	}
	public Activite getLaActivite() {
		return laActivite;
	}
	public void setLaActivite(Activite laActivite) {
		this.laActivite = laActivite;
	}
	public List<Competence> getListeCompetence() {
		return listeCompetence;
	}
	public void setListeCompetence(List<Competence> listeCompetence) {
		this.listeCompetence = listeCompetence;
	}
	public List<ListeTache> getListeTache() {
		return listeTache;
	}
	public void setListeTache(List<ListeTache> listeTache) {
		this.listeTache = listeTache;
	}
	
}
