package dao;

import exceptions.MonException;
import java.util.*;

import metier.*;
import repositories.*;

public class OeuvreService {
    public OeuvreVente obtenirOeuvreVente(int numero) throws MonException {
        String mysql = "select * from oeuvrevente o join proprietaire p on o.id_proprietaire = p.id_proprietaire" +
                " where id_oeuvrevente=" + numero;
        List<OeuvreVente> mesOeuvresVente = consulterListeOeuvresVente(mysql);
        if (mesOeuvresVente.isEmpty())
            return null;
        else {
            return mesOeuvresVente.get(0);
        }
    }

    public List<OeuvreVente> consulterListeOeuvresVente() throws MonException {
        String mysql = "select * from oeuvrevente o join proprietaire p on o.id_proprietaire = p.id_proprietaire";
        return consulterListeOeuvresVente(mysql);
    }

    private List<OeuvreVente> consulterListeOeuvresVente(String mysql) throws MonException {
        List<Object> rs;
        List<OeuvreVente> mesOeuvres = new ArrayList<>();
        int index = 0;
        try {
            rs = DialogueBd.lecture(mysql);
            while (index < rs.size()) {
                OeuvreVente oeuvre = new OeuvreVente();

                oeuvre.setIdOeuvrevente(Integer.parseInt(rs.get(index + 0).toString()));
                oeuvre.setTitreOeuvrevente(rs.get(index + 1).toString());
                oeuvre.setEtatOeuvrevente(rs.get(index + 2).toString());
                oeuvre.setPrixOeuvrevente(Float.parseFloat(rs.get(index + 3).toString()));

                Proprietaire p = new Proprietaire();
                p.setIdProprietaire(Integer.parseInt(rs.get(index + 4).toString()));
                p.setNomProprietaire(rs.get(index + 6).toString());
                p.setPrenomProprietaire(rs.get(index + 7).toString());

                oeuvre.setProprietaire(p);

                index = index + 8;
                mesOeuvres.add(oeuvre);
            }

            return mesOeuvres;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

    public void insertOeuvreVente(OeuvreVente uneOeuvre) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "insert into oeuvrevente(titre_oeuvrevente,etat_oeuvrevente,prix_oeuvrevente,id_proprietaire)  " +
                    "values ('"+ uneOeuvre.getTitreOeuvrevente() +
                    "'" + ",'L','" + uneOeuvre.getPrixOeuvrevente() +
                    "'" + ",'" + uneOeuvre.getProprietaire().getIdProprietaire() + "')";

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        }
    }

    public OeuvreVente modifierOeuvreVente(OeuvreVente oeuvreVente) throws MonException {
        System.out.println("Etat OeuvreVente " + oeuvreVente.getEtatOeuvrevente());
        String mysql = "update oeuvrevente set titre_oeuvrevente='" + oeuvreVente.getTitreOeuvrevente() + "', " +
                "etat_oeuvrevente='" + oeuvreVente.getEtatOeuvrevente() + "', prix_oeuvrevente="
                + oeuvreVente.getPrixOeuvrevente() + ", id_proprietaire='"
                + oeuvreVente.getProprietaire().getIdProprietaire() + "' where id_oeuvrevente=" + oeuvreVente.getIdOeuvrevente();
        DialogueBd dialogueBd = DialogueBd.getInstance();
        dialogueBd.execute(mysql);

        return oeuvreVente;
    }

    public void supprimerOeuvreVente(int numero) throws MonException {
        String mysql = "delete from oeuvrevente where id_oeuvrevente=" + numero;
        DialogueBd dialogueBd = DialogueBd.getInstance();
        dialogueBd.execute(mysql);
    }
}
