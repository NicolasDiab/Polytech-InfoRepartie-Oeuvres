package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdherentService;
import metier.*;
import exceptions.*;

@WebServlet("/AdherentController")
public class AdherentController extends BaseController {


    public AdherentController() {
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
            AdherentService adherentService = new AdherentService();
            request.setAttribute("mesAdherents", adherentService.consulterListeAdherents());
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.render("/listerAdherent.jsp", request, response);
    }

    public void deleteAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AdherentService adherentService = new AdherentService();
            adherentService.supprimerAdherent(Integer.parseInt(request.getParameter("adherentNum")));
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.render("/index.jsp", request, response);
    }

    public void addAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.render("/ajouterAdherent.jsp", request, response);
    }

    public void postAddAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Adherent unAdherent = new Adherent();
            unAdherent.setNomAdherent(request.getParameter("txtnom"));
            unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
            unAdherent.setVilleAdherent(request.getParameter("txtville"));
            AdherentService adherentService = new AdherentService();
            adherentService.insertAdherent(unAdherent);
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.render("/index.jsp", request, response);
    }

    public void updateAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int adherentNum = Integer.parseInt(request.getParameter("adherentNum"));

        AdherentService svc = new AdherentService();
        try {
            request.setAttribute("adherent", svc.obtenirAdherent(adherentNum));
        } catch (MonException e) {
            e.printStackTrace();
        }
        this.render("/modifierAdherent.jsp", request, response);
    }

    public void postUpdateAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Adherent adherent = new Adherent();
            adherent.setIdAdherent(Integer.parseInt(request.getParameter("txtId")));
            adherent.setNomAdherent(request.getParameter("txtNom"));
            adherent.setPrenomAdherent(request.getParameter("txtPrenom"));
            adherent.setVilleAdherent(request.getParameter("txtVille"));
            AdherentService adherentService = new AdherentService();
            adherentService.modifierAdherent(adherent);
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.render("/index.jsp", request, response);
    }
}