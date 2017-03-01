<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Expo : Médiathèque De POLYTECH</title>
</head>

<body>
	<p align="center"></p>
	<p align="center">
		Médiathèque de POLYTECH
	</p>
	<p align="center">
		Gestion de l'exposition 2016
	</p>
	<p align="left">
		Sélectionnez la fonctionnalité voulue:
	</p>
	<ul>
		<li><a href="AdherentController?action=ajouterAdherent">Ajout Adhérent</a></li>
		<li><a href="AdherentController?action=listerAdherent">lister les adhérents</a></li>

		<li><a href="ProprietaireController?action=listerProprietaire">lister les propriétaires</a></li>

		<li><a href="OeuvreController?action=listerOeuvreVente">lister les oeuvres vente</a></li>
		<li><a href="OeuvreController?action=ajouterOeuvreVente">Ajouter une oeuvre vente</a></li>

		<li><a href="ReservationController?action=listerReservation">lister les réservations</a></li>
		<li><a href="ReservationController?action=ajouterReservation">Ajouter une réservation</a></li>
	</ul>
</body>
</html>