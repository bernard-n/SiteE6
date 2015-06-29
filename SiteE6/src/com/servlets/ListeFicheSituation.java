package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metier.*;
import com.persistance.AccesData;

/**
 * Servlet implementation class ListeFicheSituation
 */
@WebServlet("/ListeFicheSituation")
public class ListeFicheSituation extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private List<FicheSituation> listeFiche;
      private List<Etat> listeEtat;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeFicheSituation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("valeur") != null){
			String valeur = request.getParameter("valeur");
			response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-cache");
			String reponse = "<p>Recherche : " + valeur + "</p>" ;
			if(request.getParameter("action").equals("recupUnFiche")){
				FicheSituation f = AccesData.getFicheSituation(Integer.parseInt(valeur));
				reponse = "<li><h3>" + f.getIdFiche() + " - " + f.getLibelleFiche() + "</h3>";
				reponse += "<table class='tableauFiche'>";
				reponse += "<tr><th>Organisation </th></tr><tr>";
				reponse += "<td>" + f.getOrganisation() + "</td></tr><tr><th>Besoin</th></tr><tr>";
				reponse += "<td>" + f.getBesoin() + "</td>";
				reponse += "</tr><tr><th>Environnement</th></tr><tr>";
				reponse += "<td>" + f.getEnvironnement() + "</td>";
				reponse += "</tr><tr><th>Tâches réalisées</th></tr><tr><td><ul>";
				int i = 0;
				for(Tache t : f.getListeTacheDistinct()){
					i++;
					reponse += "<li>" + i + ". " + t.getLibelleTache() + "</li>";
				}
				reponse += "</ul></td></tr></table></br></br>";
				reponse += "<table class='tableauFiche'><tr><td colspan='8'>Activités et compétences </th></tr>";	
				reponse += "<tr><th>Activité </th><th>Compétences </th>";
				listeEtat = AccesData.getListeEtat();
				for(Etat etat : listeEtat){
					reponse += "<th>" + etat.getLibelleEtat() + "</th>";
				}
				reponse += "</tr>";
				for(ListeActivite l : f.getListeActivite()){
					reponse += "<tr><th>" + l.getLaActivite().getIdActivite() +" - " + l.getLaActivite().getLibelleActivite() + "</th><th>";
					for(Competence c : l.getListeCompetence()){
						reponse += c.getIdCompetence() + "  " + c.getLibelleCompetence() + "</br>";
					}
					reponse += "</th>";
					for(Etat e : listeEtat){
						reponse += "<th>" + l.getListeTache(e) + "</th>";
					}
				}
					reponse += "</tr></table></li></br><h3>Liste des docs</h3>";
					reponse += "<select id='selectDoc" + f.getIdFiche()  + "'>";
					for(Documentation d : f.getListeDocumentation()){
						reponse += "<option value='" + d.getHref()  + "'>" + d.getTitre() + "</option>";
					}
				
					reponse += "</select></br>";
					reponse += "<button onclick ='doc(selectDoc" + f.getIdFiche() + ".value);'>Lien vers la doc</button>";				
//				    reponse += "<div id='light' class='white_content'><iframe id='pdf' width='99%' height='99%'></iframe></div>";
//				    reponse += "<div id='fade' class='black_overlay' onclick ='document.getElementById(light).style.display='none';document.getElementById(fade).style.display=none></div>";
					reponse += "</br></br><hr>";
					System.out.println("recupUnFiche : " + reponse);
					response.getWriter().write(reponse);
			}
			if(request.getParameter("action").equals("type")){
				List<TypeSituation> listeType = AccesData.getListeTypeSituation(valeur);
				reponse += "<p>Nombre de résultat : "+ listeType.size();
				reponse += "<ul id='Type'>";
				for(TypeSituation t: listeType){
					reponse += "<li><a id='"+ t.getIdType() + "' onclick='recupFiches(Type.id,this.id)'><u>" + t.getIdType() + ". " + t.getLibelleType() + "</u></a></li>";
				}
				reponse += "</ul>";
				System.out.println("type : " + reponse);
				response.getWriter().write(reponse);
			}else if(request.getParameter("action").equals("competence")){
				List<Competence> listeCompetence = AccesData.getListeCompetence(valeur);
				reponse += "<p>Nombre de résultat : "+ listeCompetence.size();
				reponse += "<ul id='Competence'>";
				for(Competence c: listeCompetence){
					reponse += "<li><a  id='"+ c.getIdCompetence() + "' onclick='recupFiches(Competence.id,this.id)'><u>" + c.getIdCompetence() + ". " + c.getLibelleCompetence() + "</u></a></li>";
				}
				reponse += "</ul>";
				System.out.println("compete : " + reponse);
				response.getWriter().write(reponse);
			}

			
		}else if(request.getParameter("id") != null){
			String id = request.getParameter("id");
			response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-cache");
			String reponse = "";
			List<FicheSituation> listeFicheS = new ArrayList<FicheSituation>();
			if(request.getParameter("action").equals("Type")){
				listeFicheS = AccesData.getListeFicheSituationByType(Integer.parseInt(id));
			}else{
				listeFicheS = AccesData.getListeFicheSituationByCompetence(id);
			}
			reponse += "<ul><p>Nombre de fiche de situation :" + listeFicheS.size() + "</p>";
			for(FicheSituation f : listeFicheS){
				reponse += "<li id='" + f.getIdFiche() + "' onclick='recupUnFiche(this.id)'>" + f.getIdFiche() + " - " + f.getLibelleFiche();
			}
			reponse += "</ul>";
			response.getWriter().write(reponse);
		}
		else{
			listeFiche = AccesData.getListeFicheSituation();
			request.setAttribute("listeFiche", listeFiche);
			listeEtat = AccesData.getListeEtat();
			request.setAttribute("listeEtat", listeEtat);
			request.setAttribute("doc", "test");
			this.getServletContext().getRequestDispatcher("/vues/listeFicheSituation.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
