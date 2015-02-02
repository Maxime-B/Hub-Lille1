<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="global">
	<tiles:putAttribute name="title">Nouvelle cat�gorie
	</tiles:putAttribute>
	<tiles:putAttribute name="main">
		<form action="creationCategorie">
			Nom de la cat�gorie : <input type="text" name="nomCategorie" />
			<table>
				<tr>
					<th>Nom du champ</th>
					<th>Limite</th>
					<th>Type</th>
					<th>Obligatoire</th>
					<th>Choix</th>
				</tr>
				<c:forEach items="${champs}" var="item">
					<tr>
						<td>${item.libelle}</td>
						<td>${item.limite}</td>
						<td>${item.typeChamp}</td>
						<td>${item.obligatoire}</td>
						<td><input type="checkbox" value="${item.libelle}"
							onClick="test(this)" /></td>
					</tr>
				</c:forEach>
			</table>
			<a href="nouveauChamp">Ajouter un nouveau champ</a>
			<div id="champsChoisi">
				<ul id="sortable">
				</ul>
			</div>
			<br> <input type="submit" value="Valider" />
		</form>

	</tiles:putAttribute>
	<tiles:putAttribute name="js">

		<script src="<c:url value="/ressources/js/jquery-1.11.2.js"/>"></script>
		<script
			src="<c:url value="http://code.jquery.com/ui/1.11.2/jquery-ui.js"/>"></script>
		<script src="<c:url value="/ressources/js/creerCategorie.js"/>"></script>
		<script>
			$(function() {
				$("#sortable").sortable();
				$("#sortable").disableSelection();
			});
		</script>
	</tiles:putAttribute>
	<tiles:putAttribute name="css">
		<link rel="stylesheet"
			href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
	</tiles:putAttribute>
</tiles:insertDefinition>
