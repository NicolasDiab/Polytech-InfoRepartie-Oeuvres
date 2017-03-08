package dao;

import exceptions.MonException;
import java.util.*;

import metier.*;
import repositories.*;

public class AdherentService {
    public void insertAdherent(Adherent unAdherent) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "insert into adherent  (nom_adherent,prenom_adherent,ville_adherent)  " + "values ('"
                    + unAdherent.getNomAdherent();
            mysql += "'" + ",'" + unAdherent.getPrenomAdherent() + "','" + unAdherent.getVilleAdherent() + "')";

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        }
    }

    public Adherent obtenirAdherent(int numero) throws MonException {
        String mysql = "select * from adherent where id_adherent=" + numero;
        List<Adherent> mesAdh = consulterListeAdherents(mysql);
        if (mesAdh.isEmpty())
            return null;
        else {
            return mesAdh.get(0);
        }
    }

    public void modifierAdherent(Adherent adherent) throws MonException {
        String mysql = "update adherent set nom_adherent='" + adherent.getNomAdherent() + "', " +
                "prenom_adherent='" + adherent.getPrenomAdherent() + "', ville_adherent='"+ adherent.getVilleAdherent()
                +"' where id_adherent=" + adherent.getIdAdherent();
        DialogueBd dialogueBd = DialogueBd.getInstance();
        dialogueBd.execute(mysql);
    }

    public List<Adherent> consulterListeAdherents() throws MonException {
        String mysql = "select * from adherent";
        return consulterListeAdherents(mysql);
    }

    private List<Adherent> consulterListeAdherents(String mysql) throws MonException {
        List<Object> rs;
        List<Adherent> mesAdherents = new ArrayList<Adherent>();
        int index = 0;
        try {
            DialogueBd unDialogueBd = DialogueBd.getInstance();
            rs = DialogueBd.lecture(mysql);
            while (index < rs.size()) {
                // On cr�e un stage
                Adherent unA = new Adherent();
                // il faut redecouper la liste pour retrouver les lignes
                unA.setIdAdherent(Integer.parseInt(rs.get(index + 0).toString()));
                unA.setNomAdherent(rs.get(index + 1).toString());
                unA.setPrenomAdherent(rs.get(index + 2).toString());
                unA.setVilleAdherent(rs.get(index + 3).toString());
                // On incr�mente tous les 3 champs
                index = index + 4;
                mesAdherents.add(unA);
            }

            return mesAdherents;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }
}
