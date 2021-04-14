<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="models.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:layout>
	<jsp:body>
		<br>
		<!-- DataTale lista de artigos -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Utilizadores</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table id="dtListarUtilizadores" class="table table-striped" width="100%">
						<thead>
							<tr>
								<th>Nome</th>
								<th>E-mail</th>
								<th>Data Criação</th>
								<th>Nuc</th>
								<th>Tipo de Conta</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaUtilizadores}" var="utilizador">
								<tr>
									<td>${utilizador.primeiroNome} ${utilizador.ultimoNome}</td>
									<td>${utilizador.eMail}</td>
									<td>${utilizador.dataCriacao}</td>
									<td>${utilizador.nuc}</td>
									<td>
										<c:choose>
											<c:when test = "${utilizador.tipo == 1}">
												Administrador
											</c:when>
											<c:when test = "${utilizador.tipo == 0}">
												Regular
											</c:when>
										</c:choose>
									</td>
									<td><a href="${pageContext.request.contextPath}/BOUserEditServlet?eMailUtilizador=${utilizador.eMail}"
										class="link-dark rounded nav-link"> <span
										data-feather="tool"></span> Administrar
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</jsp:body>
</t:layout>