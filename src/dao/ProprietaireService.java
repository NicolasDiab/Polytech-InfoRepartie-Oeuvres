package dao;

import meserreurs.MonException;
import metier.Adherent;
import metier.Proprietaire;
import persistance.DialogueBd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GregoirePiat <gregoire.piat@outlook.fr>
 */
public class ProprietaireService {

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
}
