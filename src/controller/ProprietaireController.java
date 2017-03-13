package controller;

import dao.ProprietaireService;
import exceptions.MonException;
import metier.Proprietaire;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author GregoirePiat <gregoire.piat@outlook.fr>
 */
@WebServlet("/ProprietaireController")
public class ProprietaireController extends BaseController {


    public ProprietaireController() {
        super();
        this.get("list", "listAction");
        this.get("delete", "deleteAction");
        this.get("add", "addAction");
        this.post("add", "postAddAction");
        this.get("update", "updateAction");
        this.post("update", "postUpdateAction");
    }

    public void listAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProprietaireService proprietaireService = new ProprietaireService();
            request.setAttribute("mesProprietaires", proprietaireService.consulterListeProprietaires());
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.render("/listerProprietaire.jsp", request, response);
    }

    public void deleteAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProprietaireService proprietaireService = new ProprietaireService();
            proprietaireService.supprimerProprietaire(Integer.parseInt(request.getParameter("proprietaireNum")));
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.render("/index.jsp", request, response);
    }

    public void addAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.render("/ajouterProprietaire.jsp", request, response);
    }

    public void postAddAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Proprietaire unProprietaire = new Proprietaire();
            unProprietaire.setNomProprietaire(request.getParameter("txtnom"));
            unProprietaire.setPrenomProprietaire(request.getParameter("txtprenom"));
            ProprietaireService proprietaireService = new ProprietaireService();
            proprietaireService.insertProprietaire(unProprietaire);
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.render("/index.jsp", request, response);
    }

    public void updateAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int proprietaireNum = Integer.parseInt(request.getParameter("proprietaireNum"));

        ProprietaireService svc = new ProprietaireService();
        try {
            request.setAttribute("proprietaire", svc.obtenirProprietaire(proprietaireNum));
        } catch (MonException e) {
            e.printStackTrace();
        }
        this.render("/modifierProprietaire.jsp", request, response);
    }

    public void postUpdateAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Proprietaire proprietaire = new Proprietaire();
            proprietaire.setIdProprietaire(Integer.parseInt(request.getParameter("txtId")));
            proprietaire.setNomProprietaire(request.getParameter("txtNom"));

            System.out.println("Parameter -- " + request.getParameter("txtId"));
            System.out.println("Parameter -- " + request.getParameter("txtPrenom"));
            System.out.println("Parameter -- " + request.getParameter("txtNom"));

            proprietaire.setPrenomProprietaire(request.getParameter("txtPrenom"));
            ProprietaireService proprietaireService = new ProprietaireService();
            proprietaireService.modifierProprietaire(proprietaire);
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.render("/index.jsp", request, response);
    }
}
