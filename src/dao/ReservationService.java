package dao;

import meserreurs.MonException;
import java.util.*;

import metier.*;
import persistance.*;
import utilitaires.FonctionsUtiles;

public class ReservationService {
    public List<Reservation> consulterListeReservations() throws MonException {
        String mysql = "SELECT * FROM reservation r " +
                "join adherent a on r.id_adherent = a.id_adherent " +
                "join oeuvrevente o on r.id_oeuvrevente = o.id_oeuvrevente " +
                "join proprietaire p on o.id_proprietaire = p.id_proprietaire";
        return consulterListeReservations(mysql);
    }

    private List<Reservation> consulterListeReservations(String mysql) throws MonException {
        List<Object> rs;
        List<Reservation> mesReservations = new ArrayList<>();
        int index = 0;
        try {
            rs = DialogueBd.lecture(mysql);
            while (index < rs.size()) {
                Reservation reservation = new Reservation();

                Date d = FonctionsUtiles.conversionChaineenDate(rs.get(index + 2).toString());
                reservation.setDate(d);

                // Adherent
                Adherent a = new Adherent();
                a.setIdAdherent(Integer.parseInt(rs.get(index + 4).toString()));
                a.setNomAdherent(rs.get(index + 5).toString());
                a.setPrenomAdherent(rs.get(index + 6).toString());
                a.setVilleAdherent(rs.get(index + 7).toString());
                reservation.setAdherent(a);

                // Oeuvre vente
                OeuvreVente o = new OeuvreVente();
                o.setIdOeuvrevente(Integer.parseInt(rs.get(index + 8).toString()));
                o.setTitreOeuvrevente(rs.get(index + 9).toString());
                o.setPrixOeuvrevente(Float.parseFloat(rs.get(index + 11).toString()));
                o.setEtatOeuvrevente(rs.get(index + 10).toString());

                // Proprietaire de l'oeuvre
                {
                    Proprietaire p = new Proprietaire();
                    p.setIdProprietaire(Integer.parseInt(rs.get(index + 13).toString()));
                    p.setNomProprietaire(rs.get(index + 14).toString());
                    p.setPrenomProprietaire(rs.get(index + 15).toString());
                    o.setProprietaire(p);
                }

                reservation.setOeuvreVente(o);

                index = index + 16;
                mesReservations.add(reservation);
            }

            return mesReservations;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

    public void insertReservation(Reservation reservation) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            Date d = reservation.getDate();
            String dateString = FonctionsUtiles.conversionDateenChaine(d);
            mysql = "insert into reservation(id_oeuvrevente,id_adherent,date_reservation,statut)  " +
                    "values ('"+ reservation.getOeuvreVente().getIdOeuvrevente() + "'" +
                    ", '" + reservation.getAdherent().getIdAdherent() + "'" +
                    ", '" + dateString + "'" +
                    ", 'confirmee')";

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
