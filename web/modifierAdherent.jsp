<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modifier un  adhérent</title>
</head>
<script type="text/javascript" src="js/foncControle.js"></script>


<body>
<H1> Modifier un adhérent </H1>

<DIV align="center">
    <FORM  name='identification' method="post" action="AdherentController?action=modifierActionAdherent" onsubmit="return teste()">
        <P align="left"><FONT face="Arial" color="#004080"></FONT>
            <FONT face="Arial" color="#004080"> <BR>&nbsp;  &nbsp;  &nbsp; Nom de l'adherent : </FONT>
            <INPUT type="text" name="txtNom" value="${adherent.nomAdherent}"  id ="nom"> <BR>
            <FONT face="Arial" color="#004080">
                <BR>Prénom de l'adherent : </FONT>
            <INPUT type="text" name="txtPrenom"  id ="prenom" value="${adherent.prenomAdherent}"  > <BR>

            <FONT face="Arial" color="#004080"> <BR>&nbsp;  &nbsp;  &nbsp; Ville de l'adherent :</FONT>
            <INPUT type="text" name="txtVille" id ="ville" value="${adherent.villeAdherent}">
            <FONT face="Arial" color="#004080">	<BR></FONT><BR>


            <INPUT type="hidden" name="txtId" value="${adherent.idAdherent}">
            <!-- Boutons Ajouter -->

            <INPUT type="submit" name="bt"  value="Valider" >
            <FONT face="Arial" color="#004080"></FONT>
            &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        </P></FORM>
</DIV>
<BR>

<a href="AdherentController?action=listerAdherent"><font
        face="Arial">Retour</font></a>
</body>
</html>