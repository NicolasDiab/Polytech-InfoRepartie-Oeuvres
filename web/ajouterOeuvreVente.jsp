<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ajouter une oeuvre vente</title>
</head>
<script type="text/javascript" src="js/foncControle.js"></script>


<body>
<h1> Ajout d'une oeuvre vente </h1>

<A href="index.jsp">Retour Accueil</A>

<div align="center">
    <form  name='identification' method="post" action="OeuvreController?action=insererOeuvreVente" onsubmit="return teste()">
        <P align="left">
            <label>Titre de l'oeuvre :
                <input type="text" name="titre">
            </label>

            <label>Prix de l'oeuvre :
                <input type="number" name="prix">
            </label>

            <label>Propriétaire :
                <select name="proprietaireNum">
                    <c:forEach items="${mesProprietaires}" var="item">
                        <option value="${item.idProprietaire}">${item.nomProprietaire} ${item.prenomProprietaire}</option>
                    </c:forEach>
                </select>
            </label>



            <input type="submit" name="bt"  value="Ajouter" >
        </P>
    </form>
</div>

</body>
</html>