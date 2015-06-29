package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metier.*;
import com.persistance.AccesData;
/**
 * Servlet implementation class VeilleTechno
 */
@WebServlet("/VeilleTechno")
public class VeilleTechno extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List<Article> listeArticle;
    private List<Categorie> listeCategorie;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VeilleTechno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action") != null){
			
			if(request.getParameter("action").equals("recherche")){
				String valeur = request.getParameter("valeur");
				response.setContentType("text/html");
				response.setHeader("Cache-Control", "no-cache");
				String reponse = "<p>Recherche : </p>" ;
				List<Article> listeArticleR = AccesData.getListeArticle(Integer.parseInt(request.getParameter("valeur")));
				reponse += "<p>Nombre de résultat : "+ listeArticleR.size();
				reponse += "<ul id='Article'>";
				for(Article a: listeArticleR){
					reponse += "<li><a id='"+ a.getIdArticle() + "' onclick='recupArticle(this.id)'><u>" + a.getIdArticle() + ". " + a.getLibelle() + "</u></a></li>";
				}

				reponse += "</ul>";
				System.out.println(reponse);
				response.getWriter().write(reponse);
			}

			if(request.getParameter("action").equals("getCategorie")){
				listeCategorie = AccesData.getListeCategorie();
				String retourCategorie = "";
				int i = 0;
				for(Categorie cat : listeCategorie){
					if(i == 0) {
						retourCategorie += cat.getIdCategorie() + "." + cat.getLibelle();
					}else
						retourCategorie += ";" + cat.getIdCategorie() + "." + cat.getLibelle();
					i++;
				}
				response.setContentType("text/xml");
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().write("<message>" + retourCategorie + "</message>");
				System.out.println("<message>" + retourCategorie + "</message>");
			}
			if(request.getParameter("action").equals("getUnArticle")){
				String valeur = request.getParameter("valeur");
				response.setContentType("text/html");
				response.setHeader("Cache-Control", "no-cache");
				String reponse = "";
				Article article = AccesData.getArticle(Integer.parseInt(request.getParameter("valeur")));

				reponse += "<h2><span class='image'><img src='./img/" + article.getLaCategorie().getLibelle() +".png' class='img-circle' alt='Cinque Terre' width='50' height='50' align='right'></span>&nbsp;" + article.getLibelle() + "</h2>";		

				reponse +="<table class='table'><tr><td><h6>Résumé :</h6>"+ article.getResume()+"</td></tr><tr><td><h6>Lien :</h6> <a href='"+ article.getHref() +"'>"+ article.getHref() +"</a></td>";
				reponse +="<tr><td><h6>Categorie :</h6> " + article.getLaCategorie().getLibelle() + "</td></tr>";
				reponse += "</br><hr></div>";
				System.out.println(reponse);
				response.getWriter().write(reponse);
			}
			if(request.getParameter("action").equals("deleteArticle")){
				String valeur = request.getParameter("valeur");
				boolean deleteArticle = AccesData.deleteArticle(AccesData.getArticle(Integer.parseInt(valeur)));
				System.out.println("deleteArticle " + deleteArticle);
			}
			if(request.getParameter("action").equals("updateArticle")){
				String valeur = request.getParameter("valeur");
				int id = Integer.parseInt(request.getParameter("id"));
				String attribut = request.getParameter("attribut");
				Article article = AccesData.getArticle(id);
				switch(attribut){
					case "Href" :
						article.setHref(valeur);
						break;
					case "Resume" :
						article.setResume(valeur);
						break;
					case "Titre" :
						article.setLibelle(valeur);
						break;
					case "Categorie" :
						article.setLaCategorie(AccesData.getCategorie(Integer.parseInt(valeur)));
						break;
				}
				boolean updateArticle = AccesData.updateArticle(article);
				System.out.println("updateArticle " + updateArticle);
			}
		}else{
			
			listeArticle = AccesData.getListeArticle();
			request.setAttribute("listeArticle", listeArticle);
			listeCategorie = AccesData.getListeCategorie();
			request.setAttribute("listeCategorie", listeCategorie);
			this.getServletContext().getRequestDispatcher("/vues/veilleTechno.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		if(request.getParameter("action")!="Ajouter"){
			Article article = new Article();
			article.setLibelle(request.getParameter("titre"));
			article.setHref(request.getParameter("href"));
			article.setResume(request.getParameter("resume"));
			article.setLaCategorie(AccesData.getCategorie(Integer.parseInt(request.getParameter("categorie"))));
			int note = Integer.parseInt(request.getParameter("note").substring(0,1));
			article.setNote(note);
			boolean ajoutArticle = AccesData.addArticle(article);
			System.out.println("Ajout Article : " + ajoutArticle);
			listeArticle = AccesData.getListeArticle();
			request.setAttribute("listeArticle", listeArticle);
			listeCategorie = AccesData.getListeCategorie();
			request.setAttribute("listeCategorie", listeCategorie);
			this.getServletContext().getRequestDispatcher("/vues/veilleTechno.jsp").forward(request, response);
		}
	}

}
