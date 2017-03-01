<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="part/header.jsp" />
<jsp:include page="part/nav.jsp" />
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
<jsp:include page="part/footer.jsp" />
