<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="models.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:layout>
	<jsp:body>
		<!-- Cartões de informações -->
		<div class="row">
			<!-- Artigos Criados -->
			<div class="col-xl-4 col-md-6 mb-4">
				<div class="card border-left-primary shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
									Artigos Criados
								</div>
								<div class="h5 mb-0 font-weight-bold text-gray-800">${countRegistosArtigo}</div>
							</div>
							<div class="col-auto">
								<i class="fas fa-laptop fa-2x text-gray-300"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Movimentos Atribuíios -->
			<div class="col-xl-4 col-md-6 mb-4">
				<div class="card border-left-success shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
									Movimentos Atribuídos
								</div>
								<div class="h5 mb-0 font-weight-bold text-gray-800">${countRegistosMovimento}</div>
							</div>
							<div class="col-auto">
								<i class="far fa-list-alt fa-2x text-gray-300"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Utilizadores criados -->
			<div class="col-xl-4 col-md-6 mb-4">
				<div class="card border-left-warning shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
									Utilizadores
								</div>
								<div class="h5 mb-0 font-weight-bold text-gray-800">${countRegistosUtilizador}</div>
							</div>
							<div class="col-auto">
								<i class="fas fa-user-alt fa-2x text-gray-300"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="card shadow mb-4">
			<!-- Ultimos artigos -->
			<div
				class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
				<h6 class="m-0 font-weight-bold text-primary">Últimos Artigos</h6>
				<div class="dropdown no-arrow">
					<a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
					</a>
					<div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
						aria-labelledby="dropdownMenuLink">
						<div class="dropdown-header">Artigos:</div>
						<a class="dropdown-item" href="#">Listagem</a>
						<a class="dropdown-item" href="#">Criar</a>
					</div>
				</div>
			</div>
			<!-- Card Body -->
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-striped" id="dtArtigosDashboard" width="100%" cellspacing="0">
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
							<c:forEach items="${listaArtigosRecentes}" var="artigo">
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
		
		<div class="card shadow mb-4">
			<!-- Card Header - Dropdown -->
			<div
				class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
				<h6 class="m-0 font-weight-bold text-primary">Últimos Movimentos</h6>
				<div class="dropdown no-arrow">
					<a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
					</a>
					<div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
						aria-labelledby="dropdownMenuLink">
						<div class="dropdown-header">Movimentos:</div>
						<a class="dropdown-item" href="#">Ver Listagem</a>
					</div>
				</div>
			</div>
			<!-- Card Body -->
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-striped" id="dtMovimentosDash" width="100%" cellspacing="0">
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
							<c:forEach items="${listaMovimentoRecentes}" var="movimento">
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