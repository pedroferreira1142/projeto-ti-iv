<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
      <link href="${pageContext.request.contextPath}/css/form-validation.css" rel="stylesheet">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    
<main class="form-signin text-center">
  <form method="post" action="LoginServlet">
    <img src="img/it-logo.jpg" alt="" class="mb-4" style="border-radius:30%">
    <h1 class="h3 mb-3 fw-normal">Por favor autentique-se</h1>

    <div class="form-floating">
      <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="email">
      <label for="floatingInput">Endereço e-mail</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
      <label for="floatingPassword">Password</label>
    </div>

    <div class="checkbox mb-3">

    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">Entrar</button>
    <a href="${pageContext.request.contextPath}/SignUpServlet">Não tem conta? Crie uma.</a>
    <p class="mt-5 mb-3 text-muted">&copy; 2021</p>
  </form>
</main>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
    
  </body>
</html>
