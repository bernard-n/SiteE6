package com.persistance;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metier.*;
import com.util.HibernateSession;

public class AccesData {
private static Session session = (Session) HibernateSession.getSession();
//Technologie
	public static List<Technologie> getListeTechnologie() 	{
		return session.createQuery("from Technologie").list();
	}
	public static Technologie getTechnologie(int idTechnologie) 	{
		return (Technologie) session.get(Technologie.class, idTechnologie);
	}
	public static boolean addTechnologie(Technologie t) 	{
		Transaction trans = session.beginTransaction();
		session.save(t);
		trans.commit();
		//session.disconnect();
		return true;
	}
	public static boolean deleteTechnologie(Technologie t) 	{
		Transaction trans = session.beginTransaction();
		session.delete(t);
		trans.commit();
		return true;
	}
	public static boolean updateTechnologie(Technologie t) 	{
		Transaction trans = session.beginTransaction();
		session.update(t);
		trans.commit();
		return true;
	}
//TypeTechnologie
	public static List<TypeTechnologie> getListeTypeTechnologie() 	{
		return session.createQuery("from TypeTechnologie").list();
	}
	public static TypeTechnologie getTypeTechnologie(int idTypeTechnologie) 	{
		return (TypeTechnologie) session.get(TypeTechnologie.class, idTypeTechnologie);
	}
	public static boolean addTypeTechnologie(TypeTechnologie t) 	{
		Transaction trans = session.beginTransaction();
		session.save(t);
		trans.commit();
		//session.disconnect();
		return true;
	}
	public static boolean deleteTypeTechnologie(TypeTechnologie t) 	{
		Transaction trans = session.beginTransaction();
		session.delete(t);
		trans.commit();
		return true;
	}
	public static boolean updateTypeTechnologie(TypeTechnologie t) 	{
		Transaction trans = session.beginTransaction();
		session.update(t);
		trans.commit();
		return true;
	}
	//Categorie
	public static List<Categorie> getListeCategorie() 	{
		return session.createQuery("from Categorie").list();
	}
	public static Categorie getCategorie(int idCategorie) 	{
		return (Categorie) session.get(Categorie.class, idCategorie);
	}
	public static boolean addCategorie(Categorie t) 	{
		Transaction trans = session.beginTransaction();
		session.save(t);
		trans.commit();
		//session.disconnect();
		return true;
	}
	public static boolean deleteCategorie(Categorie t) 	{
		Transaction trans = session.beginTransaction();
		session.delete(t);
		trans.commit();
		return true;
	}
	public static boolean updateCategorie(Categorie t) 	{
		Transaction trans = session.beginTransaction();
		session.update(t);
		trans.commit();
		return true;
	}
	//Article
	public static List<Article> getListeArticle() 	{
		return session.createQuery("from Article").list();
	}
	public static List<Article> getListeArticle(int idCategorie) 	{
		return session.createQuery("from Article where idCategorie=" + idCategorie).list();
	}
	public static Article getArticle(int idArticle) 	{
		return (Article) session.get(Article.class, idArticle);
	}
	public static boolean addArticle(Article t) 	{
		Transaction trans = session.beginTransaction();
		session.save(t);
		trans.commit();
//		session.disconnect();
//		session.close();
		return true;
	}
	public static boolean deleteArticle(Article t) 	{
		Transaction trans = session.beginTransaction();
		session.delete(t);
		trans.commit();
		return true;
	}
	public static boolean updateArticle(Article t) 	{
		Transaction trans = session.beginTransaction();
		session.update(t);
		trans.commit();
		return true;
	}
	//Documentation
	public static List<Documentation> getListeDocumentation() 	{
		return session.createQuery("from Documentation").list();
	}
	public static Documentation getDocumentation(int idDocumentation) 	{
		return (Documentation) session.get(Documentation.class, idDocumentation);
	}
	public static boolean addDocumentation(Documentation t) 	{
		Transaction trans = session.beginTransaction();
		session.save(t);
		trans.commit();
		//session.disconnect();
		return true;
	}
	public static boolean deleteDocumentation(Documentation t) 	{
		Transaction trans = session.beginTransaction();
		session.delete(t);
		trans.commit();
		return true;
	}
	public static boolean updateDocumentation(Documentation t) 	{
		Transaction trans = session.beginTransaction();
		session.update(t);
		trans.commit();
		return true;
	}
	//Etat
	public static List<Etat> getListeEtat() 	{
		return session.createQuery("from Etat").list();
	}
	public static Etat getEtat(int idEtat) 	{
		return (Etat) session.get(Etat.class, idEtat);
	}
	public static boolean addEtat(Etat t) 	{
		Transaction trans = session.beginTransaction();
		session.save(t);
		trans.commit();
		//session.disconnect();
		return true;
	}
	public static boolean deleteEtat(Etat t) 	{
		Transaction trans = session.beginTransaction();
		session.delete(t);
		trans.commit();
		return true;
	}
	public static boolean updateActivite(Etat t) 	{
		Transaction trans = session.beginTransaction();
		session.update(t);
		trans.commit();
		return true;
	}
	//TypeSituation
	public static List<TypeSituation> getListeTypeSituation() 	{
		return session.createQuery("from TypeSituation").list();
	}
	public static List<TypeSituation> getListeTypeSituation(String lib) 	{
		return session.createQuery("from TypeSituation where libelleType LIKE '"+lib+"%'").list();
	}
	public static TypeSituation getTypeSituation(int idTypeSituation) 	{
		return (TypeSituation) session.get(TypeSituation.class, idTypeSituation);
	}
	public static boolean addTypeSituation(TypeSituation t) 	{
		Transaction trans = session.beginTransaction();
		session.save(t);
		trans.commit();
		return true;
	}
	public static boolean deleteTypeSituation(TypeSituation t) 	{
		Transaction trans = session.beginTransaction();
		session.delete(t);
		trans.commit();
		return true;
	}
	public static boolean updateTypeSituation(TypeSituation t) 	{
		Transaction trans = session.beginTransaction();
		session.update(t);
		trans.commit();
		return true;
	}
	//Tache
	public static List<Tache> getListeTache() 	{
		return session.createQuery("from Tache").list();
	}
	public static Tache getTache(int idTache) 	{
		return (Tache) session.get(Tache.class, idTache);
	}
	public static boolean addTache(Tache t) 	{
		Transaction trans = session.beginTransaction();
		session.save(t);
		trans.commit();
		return true;
	}
	public static boolean deleteTache(Tache t) 	{
		Transaction trans = session.beginTransaction();
		session.delete(t);
		trans.commit();
		return true;
	}
	public static boolean updateTache(Tache t) 	{
		Transaction trans = session.beginTransaction();
		session.update(t);
		trans.commit();
		return true;
	}
	//Activite
	public static List<Activite> getListeActivite() 	{
		return session.createQuery("from Activite").list();
	}
	public static Activite getActivite(String idActivite) 	{
		return (Activite) session.get(Activite.class, idActivite);
	}
	public static boolean addActivite(Activite t) 	{
		Transaction trans = session.beginTransaction();
		session.save(t);
		trans.commit();
		return true;
	}
	public static boolean deleteActivite(Activite t) 	{
		Transaction trans = session.beginTransaction();
		session.delete(t);
		trans.commit();
		return true;
	}
	public static boolean updateActivite(Activite t) 	{
		Transaction trans = session.beginTransaction();
		session.update(t);
		trans.commit();
		return true;
	}
	//Competence
	public static List<Competence> getListeCompetence() 	{
		return session.createQuery("from Competence").list();
	}
	public static List<Competence> getListeCompetence(String lib) 	{
		return session.createQuery("from Competence where libelleCompetence LIKE '"+lib+"%'").list();
	}
	public static Competence getCompetence(String idCompetence) 	{
		return (Competence) session.get(Competence.class, idCompetence);
	}
	public static boolean addCompetence(Competence t) 	{
		Transaction trans = session.beginTransaction();
		session.save(t);
		trans.commit();
		return true;
	}
	public static boolean deleteCompetence(Competence t) 	{
		Transaction trans = session.beginTransaction();
		session.delete(t);
		trans.commit();
		return true;
	}
	public static boolean updateCompetence(Competence t) 	{
		Transaction trans = session.beginTransaction();
		session.update(t);
		trans.commit();
		return true;
	}
	//ListeActivite
	public static List<ListeActivite> getListeListeActivite() 	{
		return session.createQuery("from ListeActivite").list();
	}
	public static ListeActivite getListeActivite(int idListeActivite) 	{
		return (ListeActivite) session.get(ListeActivite.class, idListeActivite);
	}
	public static boolean addListeActivite(ListeActivite t) 	{
		Transaction trans = session.beginTransaction();
		session.save(t);
		trans.commit();
		return true;
	}
	public static boolean deleteListeActivite(ListeActivite t) 	{
		Transaction trans = session.beginTransaction();
		session.delete(t);
		trans.commit();
		return true;
	}
	public static boolean updateListeActivite(ListeActivite t) 	{
		Transaction trans = session.beginTransaction();
		session.update(t);
		trans.commit();
		return true;
	}
	//ListeTache
	public static List<ListeTache> getListeListeTache() 	{
		return session.createQuery("from ListeTache").list();
	}
	public static ListeTache getListeTache(int idListeTache) 	{
		return (ListeTache) session.get(ListeTache.class, idListeTache);
	}
	public static boolean addListeTache2(ListeTache t) 	{
		Query query = session.createSQLQuery("INSERT INTO ListeTache (idTache, idListeActivite,idEtat) VALUES (:valor1, :valor2, :key)");
		query.setParameter("valor1", t.getIdTache());
		query.setParameter("valor2", t.getIdListeActivite());
		query.setParameter("key", t.getEtat().getIdEtat());
		
		query.executeUpdate();
		return true;
	}
	public static boolean addListeTache(ListeTache t) 	{
		Transaction trans = session.beginTransaction();
		session.save(t);
		trans.commit();
		return true;
	}
	public static boolean deleteListeTache(ListeTache t) 	{
		Transaction trans = session.beginTransaction();
		session.delete(t);
		trans.commit();
		return true;
	}
	public static boolean updateListeTache(ListeTache t) 	{
		Transaction trans = session.beginTransaction();
		session.update(t);
		trans.commit();
		return true;
	}
//	//ListeCompetence
//	public static List<ListeCompetence> getListeListeCompetence() 	{
//		return session.createQuery("from ListeCompetence").list();
//	}
//	public static ListeCompetence getListeCompetence(int idListeCompetence) 	{
//		return (ListeCompetence) session.get(ListeCompetence.class, idListeCompetence);
//	}
//	public static boolean addListeCompetence(ListeCompetence t) 	{
//		Transaction trans = session.beginTransaction();
//		session.save(t);
//		trans.commit();
//		return true;
//	}
//	public static boolean deleteListeCompetence(ListeCompetence t) 	{
//		Transaction trans = session.beginTransaction();
//		session.delete(t);
//		trans.commit();
//		return true;
//	}
//	public static boolean updateListeCompetence(ListeCompetence t) 	{
//		Transaction trans = session.beginTransaction();
//		session.update(t);
//		trans.commit();
//		return true;
//	}
	//FicheSituation
	public static List<FicheSituation> getListeFicheSituation() 	{
		return session.createQuery("from FicheSituation").list();
	}
	public static List<FicheSituation> getListeFicheSituationByType(int id) 	{
		return session.createQuery("from FicheSituation where idType=" +id).list();
	}
	public static List<FicheSituation> getListeFicheSituationByCompetence(String id) 	{
		return session.createQuery("from ListeCompetence where idCompetence=" +id).list();
	}
	public static FicheSituation getFicheSituation(int idFicheSituation) 	{
		return (FicheSituation) session.get(FicheSituation.class, idFicheSituation);
	}
	public static boolean addFicheSituation(FicheSituation t) 	{
		Transaction trans = session.beginTransaction();
		session.save(t);
		trans.commit();
		return true;
	}
	public static boolean deleteFicheSituation(FicheSituation t) 	{
		Transaction trans = session.beginTransaction();
		session.delete(t);
		trans.commit();
		return true;
	}
	public static boolean updateFicheSituation(FicheSituation t) 	{
		Transaction trans = session.beginTransaction();
		session.update(t);
		trans.commit();
		return true;
	}
}
