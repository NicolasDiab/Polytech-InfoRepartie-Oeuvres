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
public class OeuvreController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String ACTION_TYPE = "action";
    private static final String LISTER_OEUVRE_VENTE = "listerOeuvreVente";
    private static final String AJOUTER_OEUVRE_VENTE = "ajouterOeuvreVente";
    private static final String INSERER_OEUVRE_VENTE = "insererOeuvreVente";
    private static final String ERROR_KEY = "messageErreur";
    private static final String ERROR_PAGE = "/erreur.jsp";

    public OeuvreController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        processusTraiteRequete(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        processusTraiteRequete(request, response);
    }

    protected void processusTraiteRequete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String actionName = request.getParameter(ACTION_TYPE);
        String destinationPage = ERROR_PAGE;
        // execute l'action

        if (LISTER_OEUVRE_VENTE.equals(actionName)) {
            try {
                OeuvreService oeuvreService = new OeuvreService();
                request.setAttribute("mesOeuvresVente", oeuvreService.consulterListeOeuvresVente());
            } catch (MonException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            destinationPage = "/listerOeuvreVente.jsp";
        }
        else if (AJOUTER_OEUVRE_VENTE.equals(actionName)) {
            // Récupère la liste des propriétaires (pour la clé étrangère)
            try {
                ProprietaireService proprietaireService = new ProprietaireService();
                request.setAttribute("mesProprietaires", proprietaireService.consulterListeProprietaires());
            } catch (MonException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            destinationPage = "/ajouterOeuvreVente.jsp";
        }
        else if (INSERER_OEUVRE_VENTE.equals(actionName)) {
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
