<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:layout>
	<jsp:body>
		<div class="container">
			<div class="col-md-7 col-lg-8">
				<br>
				<h4 class="mb-3">Mudar Password</h4>
				<form class="user needs-validation" method="post" 
					action="${pageContext.request.contextPath}/EditPasswordServlet" novalidate>
					<div class="form-group">
						<input type="password" class="form-control form-control-user" id="passwordAntiga"
							placeholder="Password antiga" name="passwordAntiga">
						<div class="invalid-feedback">
							Campo obrigatório!
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-6 mb-3 mb-sm-0">
							<input type="password" class="form-control form-control-user" id="password"
								placeholder="Nova password" name="password">
							<div class="invalid-feedback">
								Campo obrigatório!
							</div>
						</div>
						<div class="col-sm-6 mb-3 mb-sm-0">
							<input type="password" class="form-control form-control-user" id="confirmarPassword"
								placeholder="Confirmar password" name="confirmarPassword">
							<div class="invalid-feedback">
								Campo obrigatório!
							</div>
						</div>
					</div>
					${messageIsNull}
					<input type="submit"  class="btn btn-primary btn-user btn-block" value="Atualizar Password">
				</form>
			</div>
		</div>
		<script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
	</jsp:body>
</t:layout>