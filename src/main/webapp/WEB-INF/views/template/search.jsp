<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="search-publication">
	<c:if test="${empty search}">
		<jsp:useBean id="search" class="ipint.glp.controlleurs.forms.FormRecherche" scope="request"/>
	</c:if>
	<form:form modelAttribute="search" action="${pageContext.servletContext.contextPath }/publication">
		<div class="row collapse">
			<div class="small-4 columns">
				<form:input path="motCle" type="text" />
			</div>
			
			<div class="small-4 columns">
				<spring:message code="template.rechercher" var="submit"/>
				<input id="publication-submit" class="postfix button small" type="submit"
					value="${submit}"
				/>
			</div>
			
			<div class="small-4 columns">
				<form:select path="where">
					<option value="">tout le site</option>
					<option value="annonces-offres">annonces-offres</option>
					<option value="annonces-demandes">annonces-demandes</option>
					<option value="jobs">jobs</option>
					<option value="evenements">événements</option>
				</form:select>
			</div>
		</div>
	</form:form>
</div>