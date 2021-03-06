<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="part/header.jsp" />
<jsp:include page="part/nav.jsp" />
<h1 class="text-center">
	Listing des	Propriétaires
</h1>

<table class="table table-striped table-hover">
	<thead>
	<tr>
		<th>Id</th>
		<th>Nom</th>
		<th>Prénom</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${mesProprietaires}" var="item">
		<tr>
			<td>${item.idProprietaire}</td>
			<td>${item.nomProprietaire}</td>
			<td>${item.prenomProprietaire}</td>
			<td>
				<a href="ProprietaireController?action=update&proprietaireNum=${item.idProprietaire}"><font
						face="Arial">Modifier</font></a>
				<a href="ProprietaireController?action=delete&proprietaireNum=${item.idProprietaire}">Suppimer</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<a href="/ProprietaireController?action=add" class="btn btn-danger">Ajouter proprietaire</a>
<a href="/" class="btn btn-primary">Retour à l'accueil</a>

<jsp:include page="part/footer.jsp" />
