package controller;

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
import dao.ReservationService;
import exceptions.*;
import metier.Adherent;
import metier.OeuvreVente;
import metier.Reservation;
import utils.FonctionsUtiles;

@WebServlet("/ReservationController")
public class ReservationController extends BaseController {

    private static final String SUPPRIMER_RESERVATION = "delete";
    private static final String ERROR_KEY = "messageErreur";
    private static final String ERROR_PAGE = "/erreur.jsp";

    public ReservationController() {
        super();
        this.get("list", "listAction");
        this.get("delete", "deleteAction");
        this.get("add", "addAction");
        this.post("add", "postAddAction");
        this.get("update", "updateAction");
        this.post("update", "postUpdateAction");
    }

    public void listAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            ReservationService reservationService = new ReservationService();
            request.setAttribute("mesReservations", reservationService.consulterListeReservations());
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.render("/listerReservation.jsp",request,response);
    }

    public void addAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            AdherentService adherentService = new AdherentService();
            request.setAttribute("mesAdherents", adherentService.consulterListeAdherents());

            OeuvreService oeuvreService = new OeuvreService();
            request.setAttribute("mesOeuvresVente", oeuvreService.consulterListeOeuvresVente());
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.render("/ajouterReservation.jsp",request,response);
    }
    public void postAddAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            Reservation reservation = new Reservation();

            Date d = FonctionsUtiles.conversionChaineenDate(request.getParameter("date"));
            reservation.setDate(d);

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
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.render("/index.jsp",request,response);
    }

    public void updateAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int adherentNum = Integer.parseInt(request.getParameter("adherentNum"));
        int oeuvreVenteNum = Integer.parseInt(request.getParameter("oeuvreVenteNum"));

        ReservationService svc = new ReservationService();
        try {
            Reservation r = svc.obtenirReservation(oeuvreVenteNum, adherentNum);
            request.setAttribute("reservation", r);
        } catch (MonException e) {
            e.printStackTrace();
        }

        this.render("/modifierReservation.jsp",request,response);
    }

    public void postUpdateAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            Reservation reservation = new Reservation();

            // Récupération de l'adhérent et de l'oeuvre vente
            AdherentService svcAdherent = new AdherentService();
            OeuvreService svcOeuvre = new OeuvreService();

            int aNum = Integer.parseInt(request.getParameter("adherentNum"));
            Adherent a = svcAdherent.obtenirAdherent(aNum);
            reservation.setAdherent(a);
            OeuvreVente ov = svcOeuvre.obtenirOeuvreVente(Integer.parseInt(request.getParameter("oeuvreVenteNum")));
            reservation.setOeuvreVente(ov);

            // Remplissage des autres infos (modifiées)
            Date d = FonctionsUtiles.conversionChaineenDate(request.getParameter("date"));
            reservation.setDate(d);
            reservation.setStatut(request.getParameter("statut"));

            ReservationService svcReservation = new ReservationService();
            svcReservation.modifierReservation(reservation);
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.render("/index.jsp",request,response);
    }

    public void deleteAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            ReservationService svcReservation = new ReservationService();
            Reservation r = svcReservation.obtenirReservation(
                    Integer.parseInt(request.getParameter("oeuvreVenteNum")),
                    Integer.parseInt(request.getParameter("adherentNum"))
            );
            svcReservation.supprimerReservation(r);
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.render("/index.jsp",request,response);
    }

}
