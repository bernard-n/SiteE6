package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metier.Activite;
import com.metier.Competence;
import com.persistance.AccesData;

/**
 * Servlet implementation class ArbreCompetence
 */
@WebServlet("/ArbreCompetence")
public class ArbreCompetence extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List<Activite> listeActivite;//
    private List<Competence> listeCompetence;//
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArbreCompetence() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idActivite") != null){
			String idActivite = request.getParameter("idActivite");
			response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-cache");
			String reponse = "";
			List<Competence> liste = AccesData.getActivite(idActivite).getListeCompetence();
			for(Competence c : liste){
				reponse += "<li>" + c.getIdCompetence() + " - " + c.getLibelleCompetence() + "</li>";
			}
			System.out.println(reponse);
			response.getWriter().write(reponse);
		}else if(request.getParameter("action") != null){
			String action = request.getParameter("action");
			if(action.equals("Plier")){
				response.setContentType("text/html");
				response.setHeader("Cache-Control", "no-cache");
				String reponse = "<ul>";
				List<Activite> liste = AccesData.getListeActivite();
				for(Activite a : liste){
					reponse += "<div id='Activite" + a.getIdActivite() + "' onmouseover='In(this.id)' onmouseout='Out(this.id)'>";
					reponse += "<li id='" + a.getIdActivite() + "' onclick='Detail(this.id)'>" + a.getIdActivite() + " - " + a.getLibelleActivite() + "<ul><div id='Competence" + a.getIdActivite() + "'></div></ul></li>";
					reponse += "</div>";
				}
				reponse += "</ul>";
				System.out.println(reponse);
				response.getWriter().write(reponse);
			}else
			{
				response.setContentType("text/html");
				response.setHeader("Cache-Control", "no-cache");
				String reponse = "<ul>";
				List<Activite> liste = AccesData.getListeActivite();
				for(Activite a : liste){
					reponse += "<div id='Activite" + a.getIdActivite() + "' onmouseover='In(this.id)' onmouseout='Out(this.id)'>";
					reponse += "<li id='" + a.getIdActivite() + "' onclick='Detail(this.id)'>" + a.getIdActivite() + " - " + a.getLibelleActivite() + "<ul><div id='Competence" + a.getIdActivite() + "'>";
					for(Competence c : a.getListeCompetence()){
						reponse += "<li>" + c.getIdCompetence() + "-" + c.getLibelleCompetence() + "</li>";
					}
					reponse += "</div></ul></li>";
					reponse += "</div>";
				}
				reponse += "</ul>";

				System.out.println(reponse);
				response.getWriter().write(reponse);
			}
			
		}
		else{
			listeActivite = AccesData.getListeActivite();
			request.setAttribute("listeActivite", listeActivite);
			listeCompetence = AccesData.getListeCompetence();
			request.setAttribute("listeCompetence", listeCompetence);
			this.getServletContext().getRequestDispatcher("/vues/arbreCompetence.jsp").forward(request, response);		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
