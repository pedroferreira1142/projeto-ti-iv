<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:layout>
	<jsp:body>
		<div class="container">
			<div class="col-md-7 col-lg-8">
						<br>
						<h4 class="mb-3">Editar Informações da conta</h4>
						<div class="card-body">
							<form class="user needs-validation" method="post" 
								action="${pageContext.request.contextPath}/EditUserServlet" novalidate>
								
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user" id="primeiroNome"
											placeholder="Último Nome" name="primeiroNome" value="${user.primeiroNome}">
										<div class="invalid-feedback">
											Campo obrigatório!
										</div>
									</div>
									${messageIsNull}
									
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user" id="ultimoNome"
											placeholder="Último Nome" name="ultimoNome" value="${user.ultimoNome}">
										<div class="invalid-feedback">
											Campo obrigatório!
										</div>
									</div>
									${messageIsNull}
								</div>
								
								<div class="form-group row">
									<div class="col-sm-6">
										<input type="email" class="form-control form-control-user" id="eMail"
											placeholder="Endereço de e-mail" name="eMail" value="${user.eMail}">
										<div class="invalid-feedback">
											Campo obrigatório!
										</div>
									</div>
									${messageIsNull}
									${messageEmailInvalid}
									
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user" id="nuc"
											placeholder="Número de colaborador" name="nuc" value="${user.nuc}">
										<div class="invalid-feedback">
											Campo obrigatório!
										</div>
									</div>
									${messageIsNull}
								</div>
								
								<input type="submit"  class="btn btn-primary btn-user btn-block" value="Atualizar Conta">
							</form>
							<hr>
						</div>
					</div>
		</div>
		<script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
	</jsp:body>
</t:layout>