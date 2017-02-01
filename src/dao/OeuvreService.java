package dao;

import meserreurs.MonException;
import java.util.*;

import metier.*;
import persistance.*;

public class OeuvreService {
    public List<Oeuvrevente> consulterListeOeuvresVente() throws MonException {
        String mysql = "select * from oeuvrevente o join proprietaire p on o.id_proprietaire = p.id_proprietaire";
        return consulterListeOeuvresVente(mysql);
    }

    private List<Oeuvrevente> consulterListeOeuvresVente(String mysql) throws MonException {
        List<Object> rs;
        List<Oeuvrevente> mesOeuvres = new ArrayList<>();
        int index = 0;
        try {
            rs = DialogueBd.lecture(mysql);
            while (index < rs.size()) {
                Oeuvrevente oeuvre = new Oeuvrevente();

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

    public void insertOeuvreVente(Oeuvrevente uneOeuvre) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "insert into oeuvrevente(titre_oeuvrevente,etat_oeuvrevente,prix_oeuvrevente,id_proprietaire)  " +
                    "values ('"+ uneOeuvre.getTitreOeuvrevente();
            mysql += "'" + ",'" + uneOeuvre.getEtatOeuvrevente() + "','" + uneOeuvre.getPrixOeuvrevente();
            mysql +=  "'" + ",'" + uneOeuvre.getProprietaire().getIdProprietaire() + "')";

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        }
    }
}
