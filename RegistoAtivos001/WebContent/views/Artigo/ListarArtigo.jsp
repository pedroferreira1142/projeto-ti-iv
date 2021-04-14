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
		<h1 class="h3 mb-2 text-gray-800">Listagem de Artigos</h1>
		<div class="row  g-3 align-items-center">
			<div class="col-10">
				<input class="form-control w-100" type="text"
					placeholder="Pesquisar um artigo" aria-label="Search" id="mySearchBox">
			</div>
			<div class="col-2">
				<button type="button" class="btn btn-primary btn-sm"><span data-feather="search"></span></button>
			</div>
		</div>
		<br>
		<!-- DataTale lista de artigos -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Artigos</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-striped" id="dtBasicExample" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>Descricao</th>
								<th>Marca</th>
								<th>Tipo Artigo</th>
								<th>Estado</th>
								<th>Local Stock</th>
								<th>Imobilizado</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaArtigos}" var="artigo">
								<tr>
									<td><a  href="${pageContext.request.contextPath}/ItemViewServlet?idArtigo=${artigo.uid}" >${artigo.descricao}</a></td>
									<td>${artigo.marca}</td>
									<td>
										<c:forEach items="${listaTipoArtigos}" var="tipoArtigo">
											<c:if test = "${artigo.fkIdTipoArtigo == tipoArtigo.uid}">
												${tipoArtigo.item}
											</c:if>
										</c:forEach>
									</td>
									<td>
										<c:forEach items="${listaEstados}" var="estado">
											<c:if test = "${artigo.fkIdEstado == estado.uid}">
												${estado.item}
											</c:if>
										</c:forEach>
									</td>
									<td>${artigo.localStock}</td>
									<td>${artigo.numImobilizado}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</jsp:body>
</t:layout>