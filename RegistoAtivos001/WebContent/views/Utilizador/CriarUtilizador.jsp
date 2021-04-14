<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>SB Admin 2 - Register</title>
		<!-- Custom fonts for this template-->
		<link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		<link
			href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
			rel="stylesheet">
		<!-- Custom styles for this template-->
		<link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">
	</head>
	<body class="bg-gradient-primary">
		<div class="container">
			<div class="card o-hidden border-0 shadow-lg my-5">
				<div class="card-body p-0">
					<!-- Nested Row within Card Body -->
					<div class="row">
						<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
						<div class="col-lg-7">
							<div class="p-5">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
								</div>
								<form class="user needs-validation" method="post"
									action="${pageContext.request.contextPath}/SignUpServlet" novalidate>
									<div class="form-group row">
										<div class="col-sm-6 mb-3 mb-sm-0">
											<input type="text" class="form-control form-control-user" id="exampleFirstName"
												placeholder="First Name" name="primeiroNome">
											<div class="invalid-feedback">
												Campo obrigatório!
											</div>
											${messagePrimeiroNome}
										</div>
										<div class="col-sm-6">
											<input type="text" class="form-control form-control-user" id="exampleLastName"
												placeholder="Last Name" name="ultimoNome">
											<div class="invalid-feedback">
												Campo obrigatório!
											</div>
										</div>
										${messageUltimoNome}
									</div>
									<div class="form-group">
										<input type="email" class="form-control form-control-user" id="exampleInputEmail"
											placeholder="Email Address" name="email">
									</div>
									${messageEMail}
									${messageEmailInvalid}
									<div class="form-group">
										<input type="text" class="form-control form-control-user" id="exampleInputEmail"
											placeholder="Nuc" name="nuc">
									</div>
									${messageNuc}
									<div class="form-group row">
										<div class="col-sm-6 mb-3 mb-sm-0">
											<input type="password" class="form-control form-control-user"
												id="InputPassword" placeholder="Password" name="password">
											<div class="invalid-feedback">
												Campo obrigatório!
											</div>
										</div>
										<div class="col-sm-6">
											<input type="password" class="form-control form-control-user"
												id="RepeatPassword" placeholder="Confirmar Password" name="confirmarPassword">
											<div class="invalid-feedback">
												Campo obrigatório!
											</div>
										</div>
									</div>
									<input type="submit" class="btn btn-primary btn-user btn-block" value="Registar conta">
									<hr>
									<a href="index.html" class="btn btn-google btn-user btn-block">
									<i class="fas fa-unlock-alt fa-fw"> </i> Esqueceu-se da password?
									</a>
									<a href="LoginServlet" class="btn btn-facebook btn-user btn-block">
									<i class="fas fa-sign-in-alt"> </i> Já tem uma conta, faça Login
									</a>
								</form>
								<hr>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Bootstrap core JavaScript-->
		<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<!-- Core plugin JavaScript-->
		<script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>
		<!-- Custom scripts for all pages-->
		<script src="${pageContext.request.contextPath}/js/sb-admin-2.min.js"></script>
	</body>
</html>