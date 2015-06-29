package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;

import java.util.*;

import com.metier.*;
import com.persistance.AccesData;
import com.util.Email;
/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private List<Activite> listeActivite;//
      private List<Competence> listeCompetence;//
      private List<Etat> listeEtat;//
      private List<Tache> listeTache;//
      private List<FicheSituation> listeFiche;//
      private List<ListeActivite> listeListeActivite;
      private List<ListeTache> listeListeTache;
      private List<TypeSituation> listeType;//
      private List<Technologie> listeTechno;
      private List<TypeTechnologie> listeTypeTechno;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("action"));
		if(request.getParameter("action") != null){
			String action = request.getParameter("action");
			switch(action){
				case "sendMail" :
					String nom = request.getParameter("nom");
					String titre = request.getParameter("titre");
					String message = request.getParameter("message");
				try {
					Email.SendMail(nom, titre, message);
				} catch (EmailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case "addType":
					TypeSituation type = new TypeSituation();
					type.setLibelleType(request.getParameter("libelleType"));
					boolean addType = AccesData.addTypeSituation(type);
					System.out.println("AddType :" + addType);
					break;
				case "addEtat":
					Etat etat = new Etat();
					etat.setLibelleEtat(request.getParameter("libelleEtat"));
					boolean addEtat = AccesData.addEtat(etat);
					System.out.println("AddEtat :" + addEtat);
					break;
				case "addTache" :
					Tache tache = new Tache();
					tache.setLibelleTache(request.getParameter("libelleTache"));
					boolean addTache = AccesData.addTache(tache);
					System.out.println("AddTache :" + addTache);
					break;
				case "addCompetence" :
					String idActivite = request.getParameter("idActivite");
					String idCompetence = request.getParameter("idCompetence");
					String libelleCompetence = request.getParameter("libelleCompetence");
					Activite activite = AccesData.getActivite(idActivite);
					Competence competence = new Competence();
					competence.setIdCompetence(idCompetence);
					competence.setLibelleCompetence(libelleCompetence);
					competence.setLaActivite(activite);
					boolean addCompetence = AccesData.addCompetence(competence);
					System.out.println(addCompetence);
					break;
				case "addActivite" :
					String libelleActivite = request.getParameter("libelleActivite");
					String idActivite1 = request.getParameter("idActivite");
					Activite activite1 = new Activite();
					activite1.setIdActivite(idActivite1);
					activite1.setLibelleActivite(libelleActivite);
					boolean addActivite = AccesData.addActivite(activite1);
					System.out.println("addActivite" + addActivite);
					break;
				case "addListeActivite" :
					int idFiche = Integer.parseInt(request.getParameter("idFiche"));
					FicheSituation fiche = AccesData.getFicheSituation(idFiche);
					idActivite = request.getParameter("idActivite");
					activite = AccesData.getActivite(idActivite);
					
					ListeActivite liste = new ListeActivite();
					liste.setLaActivite(activite);
					liste.setLaFiche(fiche);
					
					boolean addListeActivite = AccesData.addListeActivite(liste);
					System.out.println("addListeActivite" + addListeActivite);

					String[] tListeCompetence = request.getParameter("listeCompetence").split(";");
					List<Competence> listeCompetence = new ArrayList<Competence>();
					for(String s : tListeCompetence)
					{
						Competence competence1 = AccesData.getCompetence(s);
						listeCompetence.add(competence1);
					}
					String[] tListeTache = request.getParameter("listeTache").split(";");
					List<ListeTache> listeTache = new ArrayList<ListeTache>();
					for(String s : tListeTache)
					{
						ListeTache lisTach = new ListeTache();
						lisTach.setLatache(AccesData.getTache(Integer.parseInt(s)));
						lisTach.setListeActivite(liste);
						lisTach.setEtat(AccesData.getEtat(0));
						lisTach.setIdTache(Integer.parseInt(s));
						lisTach.setIdListeActivite(AccesData.getListeListeActivite().get(AccesData.getListeListeActivite().size()-1).getIdListeActivite());
						System.out.println(lisTach.toString());
						AccesData.addListeTache(lisTach);
						
						listeTache.add(lisTach);
					}
					liste.setListeCompetence(listeCompetence);
					liste.setListeTache(listeTache);
					boolean updateListeActivite = AccesData.updateListeActivite(liste);
					System.out.println(updateListeActivite);
					break;
			}
			
		}
		
		listeEtat = AccesData.getListeEtat();
		request.setAttribute("listeEtat", listeEtat);
		listeActivite = AccesData.getListeActivite();
		request.setAttribute("listeActivite", listeActivite);
		listeCompetence = AccesData.getListeCompetence();
		request.setAttribute("listeCompetence", listeCompetence);
		listeTache = AccesData.getListeTache();
		request.setAttribute("listeTache", listeTache);
		listeFiche = AccesData.getListeFicheSituation();
		request.setAttribute("listeFiche", listeFiche);
		listeListeActivite = AccesData.getListeListeActivite();
		request.setAttribute("listeListeActivite", listeListeActivite);
		listeListeTache = AccesData.getListeListeTache();
		request.setAttribute("listeListeTache", listeListeTache);
		listeType = AccesData.getListeTypeSituation();
		request.setAttribute("listeType", listeType);
		listeTechno = AccesData.getListeTechnologie();
		request.setAttribute("listeTechno", listeTechno);
		listeTypeTechno = AccesData.getListeTypeTechnologie();
		request.setAttribute("listeTypeTechno", listeTypeTechno);
		System.out.println("taille listeTechno : " + listeTechno.size() + "taille listeTypeTechno : " + listeTypeTechno.size());
		this.getServletContext().getRequestDispatcher("/vues/index.jsp").forward(request, response);	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
