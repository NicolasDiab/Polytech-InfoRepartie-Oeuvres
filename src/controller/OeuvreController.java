package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OeuvreService;
import dao.ProprietaireService;
import exceptions.*;
import metier.OeuvreVente;
import metier.Proprietaire;

@WebServlet("/OeuvreController")
public class OeuvreController extends BaseController {

    public OeuvreController() {
        super();
        this.get("list", "listAction");
        this.get("add", "addAction");
        this.post("add", "postAddAction");
        this.get("update", "updateAction");
        this.post("update", "postUpdateAction");
    }

    public void listAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            OeuvreService oeuvreService = new OeuvreService();
            request.setAttribute("mesOeuvresVente", oeuvreService.consulterListeOeuvresVente());
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.render("/listerOeuvreVente.jsp", request, response);
    }

    public void addAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupère la liste des propriétaires (pour la clé étrangère)
        try {
            ProprietaireService proprietaireService = new ProprietaireService();
            request.setAttribute("mesProprietaires", proprietaireService.consulterListeProprietaires());
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.render("/ajouterOeuvreVente.jsp", request, response);
    }

    public void postAddAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupère la liste des propriétaires (pour la clé étrangère)
        try {
            OeuvreVente oeuvreVente = new OeuvreVente();
            oeuvreVente.setTitreOeuvrevente(request.getParameter("titre"));
            oeuvreVente.setPrixOeuvrevente(Float.parseFloat(request.getParameter("prix")));

            // récupération du propriétaire
            int propNum = Integer.parseInt(request.getParameter("proprietaireNum"));

            ProprietaireService proprietaireService = new ProprietaireService();
            Proprietaire p = proprietaireService.obtenirProprietaire(propNum);

            oeuvreVente.setProprietaire(p);

            // ajout effectif
            OeuvreService oeuvreService = new OeuvreService();
            oeuvreService.insertOeuvreVente(oeuvreVente);
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.render("/index.jsp", request, response);
    }

    public void updateAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int oeuvreNum = Integer.parseInt(request.getParameter("idOeuvrevente"));

        OeuvreService svc = new OeuvreService();
        try {
            request.setAttribute("oeuvreVente", svc.obtenirOeuvreVente(oeuvreNum));
        } catch (MonException e) {
            e.printStackTrace();
        }
        System.out.println("OOKOKOKOKOKOKO");
        this.render("/modifierOeuvreVente.jsp", request, response);

    }

    public void postUpdateAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        OeuvreVente oeuvreVente = new OeuvreVente();
        oeuvreVente.setTitreOeuvrevente(request.getParameter("titre"));
        oeuvreVente.setPrixOeuvrevente(Float.parseFloat(request.getParameter("prix")));
        oeuvreVente.setIdOeuvrevente(Integer.parseInt(request.getParameter("oeuvreVenteNum")));
        oeuvreVente.setEtatOeuvrevente(request.getParameter("etat"));

        // récupération du propriétaire
        int propNum = Integer.parseInt(request.getParameter("proprietaireNum"));

        try {
            System.out.print("YALLAH");
            ProprietaireService proprietaireService = new ProprietaireService();
            Proprietaire p = proprietaireService.obtenirProprietaire(propNum);
            oeuvreVente.setProprietaire(p);

            OeuvreService svc = new OeuvreService();
            request.setAttribute("mesOeuvresVente", svc.modifierOeuvreVente(oeuvreVente));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        this.render("/listerOeuvreVente.jsp", request, response);
    }
}
