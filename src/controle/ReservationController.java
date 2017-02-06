package controle;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdherentService;
import dao.OeuvreService;
import dao.ProprietaireService;
import dao.ReservationService;
import meserreurs.*;
import metier.Adherent;
import metier.OeuvreVente;
import metier.Proprietaire;
import metier.Reservation;
import utilitaires.FonctionsUtiles;

@WebServlet("/ReservationController")
public class ReservationController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String ACTION_TYPE = "action";
    private static final String LISTER_RESERVATIONS = "listerReservations";
    private static final String AJOUTER_RESERVATION = "ajouterReservation";
    private static final String INSERER_RESERVATION = "insererReservation";
    private static final String ERROR_KEY = "messageErreur";
    private static final String ERROR_PAGE = "/erreur.jsp";

    public ReservationController() {
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

        if (LISTER_RESERVATIONS.equals(actionName)) {
            try {
                ReservationService reservationService = new ReservationService();
                request.setAttribute("mesReservations", reservationService.consulterListeReservations());
            } catch (MonException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            destinationPage = "/listerReservations.jsp";
        }
        else if (AJOUTER_RESERVATION.equals(actionName)) {
            // Récupère la liste des adhérents et des oeuvres (pour les clés étrangères)
            try {
                AdherentService adherentService = new AdherentService();
                request.setAttribute("mesAdherents", adherentService.consulterListeAdherents());

                OeuvreService oeuvreService = new OeuvreService();
                request.setAttribute("mesOeuvresVente", oeuvreService.consulterListeOeuvresVente());
            } catch (MonException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            destinationPage = "/ajouterReservation.jsp";
        }
        else if (INSERER_RESERVATION.equals(actionName)) {
            try {
                Reservation reservation = new Reservation();

               // Date d = FonctionsUtiles.conversionChaineenDate(request.getParameter("date"));
                //reservation.setDate(d);

                // récupération de l'adhérent
                int adherentNum = Integer.parseInt(request.getParameter("adherentNum"));
                AdherentService adherentService = new AdherentService();
                Adherent a = adherentService.obtenirAdherent(adherentNum);
                reservation.setAdherent(a);

                // récupération de l'oeuvre vente
                int oeuvreNum = Integer.parseInt(request.getParameter("oeuvreVenteNum"));
                OeuvreService oeuvreService = new OeuvreService();

                OeuvreVente o = oeuvreService.obtenirOeuvreVente(oeuvreNum);
                reservation.setOeuvreVente(o);

                // ajout effectif
                ReservationService reservationService = new ReservationService();
                reservationService.insertReservation(reservation);
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
