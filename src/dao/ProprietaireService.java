package dao;

import exceptions.MonException;
import metier.Proprietaire;
import repositories.DialogueBd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GregoirePiat <gregoire.piat@outlook.fr>
 */
public class ProprietaireService {
    public Proprietaire obtenirProprietaire(int numero) throws MonException {
        String mysql = "select * from proprietaire where id_proprietaire=" + numero;
        List<Proprietaire> proprietaires = consulterListeProprietaires(mysql);
        if (proprietaires.isEmpty())
            return null;
        else {
            return proprietaires.get(0);
        }
    }

    public List<Proprietaire> consulterListeProprietaires() throws MonException {
        String mysql = "select * from proprietaire";
        return consulterListeProprietaires(mysql);
    }

    private List<Proprietaire> consulterListeProprietaires(String mysql) throws MonException {
        List<Object> rs;
        List<Proprietaire> mesProprietaires = new ArrayList<Proprietaire>();
        int index = 0;
        try {
            DialogueBd unDialogueBd = DialogueBd.getInstance();
            rs = DialogueBd.lecture(mysql);
            while (index < rs.size()) {
                // On cr�e un stage
                Proprietaire unP = new Proprietaire();
                // il faut redecouper la liste pour retrouver les lignes
                unP.setIdProprietaire(Integer.parseInt(rs.get(index).toString()));
                unP.setNomProprietaire(rs.get(index + 1).toString());
                unP.setPrenomProprietaire(rs.get(index + 2).toString());
                // On incr�mente tous les 3 champs
                index = index + 3;
                mesProprietaires.add(unP);
            }

            return mesProprietaires;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

    public void insertProprietaire(Proprietaire unProprietaire) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "insert into proprietaire  (nom_proprietaire,prenom_proprietaire)  " + "values ('"
                    + unProprietaire.getNomProprietaire();
            mysql += "'" + ",'" + unProprietaire.getPrenomProprietaire() + "')";

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        }
    }


    public void modifierProprietaire(Proprietaire proprietaire) throws MonException {
        String mysql = "update proprietaire set nom_proprietaire='" + proprietaire.getNomProprietaire() + "', " +
                "prenom_proprietaire='" + proprietaire.getPrenomProprietaire() + "' where id_proprietaire=" + proprietaire.getIdProprietaire();
        DialogueBd dialogueBd = DialogueBd.getInstance();
        dialogueBd.execute(mysql);
    }

    public void supprimerProprietaire(int numero) throws MonException {
        String mysql = "delete from proprietaire where id_proprietaire=" + numero;
        DialogueBd dialogueBd = DialogueBd.getInstance();
        dialogueBd.execute(mysql);
    }
}
