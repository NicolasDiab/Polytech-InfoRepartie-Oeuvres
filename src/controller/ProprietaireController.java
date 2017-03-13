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
public class ProprietaireController extends HttpServlet{

    private static final long serialVersionUID = 1L;
    private static final String ACTION_TYPE = "action";
    private static final String LISTER_PROPRIETAIRE = "listerProprietaire";
    private static final String AJOUTER_PROPRIETAIRE = "ajouterProprietaire";
    private static final String INSERER_PROPRIETAIRE = "insererProprietaire";
    private static final String SUPPRIMER_PROPRIETAIRE = "supprimerProprietaire";
    private static final String MODIFIER_PAGE_PROPRIETAIRE = "modifierPageProprietaire";
    private static final String MODIFIER_ACTION_PROPRIETAIRE = "modifierActionProprietaire";
    private static final String ERROR_KEY = "messageErreur";
    private static final String ERROR_PAGE = "/erreur.jsp";

    public ProprietaireController() {
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
        if (LISTER_PROPRIETAIRE.equals(actionName)) {
            try {
                ProprietaireService proprietaireService = new ProprietaireService();
                request.setAttribute("mesProprietaires", proprietaireService.consulterListeProprietaires());
            } catch (MonException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            destinationPage = "/listerProprietaire.jsp";
        }
        else if (AJOUTER_PROPRIETAIRE.equals(actionName)) {
            destinationPage = "/ajouterProprietaire.jsp";
        }
        else if (INSERER_PROPRIETAIRE.equals(actionName)) {
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
            destinationPage = "/index.jsp";
        }
        else if (MODIFIER_PAGE_PROPRIETAIRE.equals(actionName)) {
            int proprietaireNum = Integer.parseInt(request.getParameter("proprietaireNum"));

            ProprietaireService svc = new ProprietaireService();
            try {
                request.setAttribute("proprietaire", svc.obtenirProprietaire(proprietaireNum));
            } catch (MonException e) {
                e.printStackTrace();
            }

            destinationPage = "/modifierProprietaire.jsp";
        }
        else if (MODIFIER_ACTION_PROPRIETAIRE.equals(actionName)) {
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
            destinationPage = "/index.jsp";
        }
        else if (SUPPRIMER_PROPRIETAIRE.equals(actionName)) {
            try {
                ProprietaireService proprietaireService = new ProprietaireService();
                proprietaireService.supprimerProprietaire(Integer.parseInt(request.getParameter("proprietaireNum")));
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
