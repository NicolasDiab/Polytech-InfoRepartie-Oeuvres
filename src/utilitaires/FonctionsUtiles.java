package utilitaires;

import java.text.SimpleDateFormat;
import java.util.*;

public class FonctionsUtiles {
    // /
    // / Conversion d'une date en chaine
    // /
    public static String DateToString(Date dt, String modeleEntree)  {

        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern(modeleEntree);
        Calendar myC = GregorianCalendar.getInstance();
        myC.setTime(dt);
        String retour = "";
        retour += String.valueOf(myC.get(Calendar.YEAR))+ "-";
        retour +=String.valueOf(myC.get(Calendar.MONTH)+1) + "-";
        retour +=String.valueOf( myC.get(Calendar.DAY_OF_MONTH)) + " ";
        retour +=String.valueOf(myC.get(Calendar.HOUR_OF_DAY))+ ":";
        retour +=String.valueOf( myC.get(Calendar.MINUTE)) + ":";
        retour += String.valueOf(myC.get(Calendar.SECOND));
        return retour;
    }

    public static String conversionDateenChaine(Date unedate, String modele)
        // le modlet est une combinaison de MM dd yyyy avec / ou
        // exemple dd/MM/yyyy
            throws Exception {
        String datesortie = "";
        // on dfinit un format de sortie
        SimpleDateFormat defFormat = new SimpleDateFormat(modele);
        datesortie = defFormat.format(unedate);
        return datesortie;
    }

    public static Date conversionChaineenDate(String unedate, String unformat)
            throws Exception {
        Date datesortie;
        // on definit un format de sortie
        String formatDefault = "dd/MM/yyyy";
        SimpleDateFormat defFormat = new SimpleDateFormat(unformat == null || unformat == "" ? formatDefault : unformat);
        datesortie = defFormat.parse(unedate);
        return datesortie;
    }

    public static Date conversionChaineenDate(String unedate)
            throws Exception {
        String formatDefault = "dd/MM/yyyy";
        return conversionChaineenDate(unedate, formatDefault);
    }
}