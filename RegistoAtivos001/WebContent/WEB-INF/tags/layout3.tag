<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>

<html>
	<head>
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- <BOOTSTRAP & JQUERY> -->
	
		
		
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	<link
		href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
		rel="stylesheet" id="bootstrap-css">
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->
<!-- </BOOTSTRAP & JQUERY> -->

<style type="text/css">
body{
    color: #1a202c;
    text-align: left;
    background-color: #e2e8f0;    
}
.main-body {
    padding: 15px;
}

.nav-link {
    color: #4a5568;
}
.card {
    box-shadow: 0 1px 3px 0 rgba(0,0,0,.1), 0 1px 2px 0 rgba(0,0,0,.06);
}

.card {
    position: relative;
    display: flex;
    flex-direction: column;
    min-width: 0;
    word-wrap: break-word;
    background-color: #fff;
    background-clip: border-box;
    border: 0 solid rgba(0,0,0,.125);
    border-radius: .25rem;
}

.card-body {
    flex: 1 1 auto;
    min-height: 1px;
    padding: 1rem;
}

.gutters-sm {
    margin-right: -8px;
    margin-left: -8px;
}

.gutters-sm>.col, .gutters-sm>[class*=col-] {
    padding-right: 8px;
    padding-left: 8px;
}
.mb-3, .my-3 {
    margin-bottom: 1rem!important;
}

.bg-gray-300 {
    background-color: #e2e8f0;
}
.h-100 {
    height: 100%!important;
}
.shadow-none {
    box-shadow: none!important;
}
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
	
	</head>
	
	<body>
		
		<!-- <PAGE HEADER> -->
		<div id="pageheader">
			<jsp:invoke fragment="header" />
			
		<!-- <NAVIGATION MENU> -->
		<nav class="navbar navbar-expand-md bg-dark navbar-dark">
			<a class="navbar-brand" href="index.jsp">Plataforma Ativos</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="#">Página Inicial</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Movimentos</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Artigos</a></li>
					<li class="dropdown nav-item">
					<a href="#" class="dropdown-toggle nav-link"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li class="nav-item"><a href="#" class="nav-link">Action</a></li>
							<li class="nav-item"><a href="#" class="nav-link">Another action</a></li>
							<li class="nav-item"><a href="#" class="nav-link">Something else here</a></li>
						</ul>
					</li>
				</ul>

				<ul class="nav navbar-nav ml-auto">
					<li class="nav-item">
						<% 
							if(session.getAttribute("user") == null)
							{
								// Utilizador não fez login
								%><a class="nav-link" href="SignUpServlet">Sign Up</a><%
							}
							else
							{
								// Utilizador está logado
								%><a class="nav-link" href="ViewUserServlet">${user.primeiroNome} ${user.ultimoNome}</a><%
							}			
						%>	
					</li>
					<li class="nav-item">
						<% 
							if(null == session.getAttribute("user"))
							{
								// Utilizador não fez login
								%><a class="nav-link" href="login.jsp">Login</a><%
							}
							else
							{
								// Utilizador está logado
								%><a class="nav-link" href="LogoutServlet">Logout</a><%
							}			
						%>
					</li>
				</ul>
			</div>
		</nav>
		<!-- </NAVIGATION MENU> -->
			
		</div>
		<!-- </PAGE HEADER> -->
		
		<!-- <PAGE BODY> -->
		<div id="body">
			<jsp:doBody />
		</div>
		<!-- </PAGE BODY> -->
		
		<!-- <PAGE FOOTER> -->
		<div id="pagefooter">
			<jsp:invoke fragment="footer" />
			
		</div>
		<!-- </PAGE FOOTER> -->
		
		
	</body>

</html>