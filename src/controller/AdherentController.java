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
public class AdherentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String ACTION_TYPE = "action";
    private static final String LISTER_ADHERENT = "listerAdherent";
    private static final String AJOUTER_ADHERENT = "ajouterAdherent";
    private static final String INSERER_ADHERENT = "insererAdherent";
    private static final String MODIFIER_PAGE_ADHERENT = "modifierPageAdherent";
    private static final String MODIFIER_ACTION_ADHERENT = "modifierActionAdherent";
    private static final String ERROR_KEY = "messageErreur";
    private static final String ERROR_PAGE = "/erreur.jsp";

    public AdherentController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processusTraiteRequete(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processusTraiteRequete(request, response);
    }



    protected void processusTraiteRequete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String actionName = request.getParameter(ACTION_TYPE);
        String destinationPage = ERROR_PAGE;
        // execute l'action
        if (LISTER_ADHERENT.equals(actionName)) {
            try {
                AdherentService adherentService = new AdherentService();
                request.setAttribute("mesAdherents", adherentService.consulterListeAdherents());
            } catch (MonException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            destinationPage = "/listerAdherent.jsp";
        }
        else if (AJOUTER_ADHERENT.equals(actionName)) {
            destinationPage = "/ajouterAdherent.jsp";
        }
        else if (INSERER_ADHERENT.equals(actionName)) {
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
            destinationPage = "/index.jsp";
        }
        else if (MODIFIER_PAGE_ADHERENT.equals(actionName)) {
            int adherentNum = Integer.parseInt(request.getParameter("adherentNum"));

            AdherentService svc = new AdherentService();
            try {
                request.setAttribute("adherent", svc.obtenirAdherent(adherentNum));
            } catch (MonException e) {
                e.printStackTrace();
            }

            destinationPage = "/modifierAdherent.jsp";
        }
        else if (MODIFIER_ACTION_ADHERENT.equals(actionName)) {
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
            destinationPage = "/index.jsp";
        }
        else {
            String messageErreur = "[" + actionName + "] n'est pas une action valide.";
            request.setAttribute(ERROR_KEY, messageErreur);
        }

        // Redirection vers la page jsp appropriee
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
        dispatcher.forward(request, response);
    }
}