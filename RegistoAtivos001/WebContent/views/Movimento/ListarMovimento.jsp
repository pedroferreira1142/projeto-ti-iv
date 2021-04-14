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
		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">Listagem de Movimentos</h1>
		<div class="row  g-3 align-items-center">
			<div class="col-10">
				<input class="form-control w-100" type="text"
					placeholder="Pesquisar um movimento" aria-label="Search" id="mySearchBox">
			</div>
			<div class="col-2">
				<button type="button" class="btn btn-primary btn-sm"><span data-feather="search"></span></button>
			</div>
		</div>
		<br>
		<!-- DataTale lista de artigos -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Movimentos</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-striped" id="dtMovimentos" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>Data Movimento</th>
								<th>Tipo Movimento</th>
								<th>Colaborador</th>
								<th>NUC</th>
								<th>Local</th>
								<th>Artigo</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaMovimento}" var="movimento">
								<tr>
									<td><a  
										href="${pageContext.request.contextPath}/TransactionViewServlet?idMovimento=${movimento.uid}" >
										${movimento.dataCriacao}</a>
									</td>
									<td>
										<c:forEach items="${listaTipoMovimento}" var="tipoMovimento">
											<c:if test = "${movimento.uidTipoMovimento == tipoMovimento.uid}">
												${tipoMovimento.item}
											</c:if>
										</c:forEach>
									</td>
									<td>${movimento.nomeColaborador}</td>
									<td>${movimento.colaboradorNuc}</td>
									<td>${movimento.localStock}</td>
									<td>
										<c:forEach items="${listaArtigo}" var="artigo">
											<c:if test = "${movimento.uidArtigo == artigo.uid}">
												${artigo.descricao}
											</c:if>
										</c:forEach>
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