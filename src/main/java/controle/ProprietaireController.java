package controle;

import dao.ProprietaireService;
import meserreurs.MonException;

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
    private static final String MODIFIER_PAGE_PROPRIETAIRE = "modifierPageProprietaire";
    private static final String MODIFIER_ACTION_PROPRIETAIRE = "modifierActionProprietaire";
    private static final String ERROR_KEY = "messageErreur";
    private static final String ERROR_PAGE = "/erreur.jsp";

    public ProprietaireController() {
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
        else {
            String messageErreur = "[" + actionName + "] n'est pas une action valide.";
            request.setAttribute(ERROR_KEY, messageErreur);
        }

        // Redirection vers la page jsp appropriee
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
        dispatcher.forward(request, response);
    }
}
