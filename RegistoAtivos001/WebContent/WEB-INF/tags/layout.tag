<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<link href="${pageContext.request.contextPath}/css/form-validation.css" rel="stylesheet">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
		<link href="https://cdn.datatables.net/searchpanes/1.2.1/css/searchPanes.dataTables.min.css" rel="stylesheet">
		<link href="https://cdn.datatables.net/select/1.3.3/css/select.dataTables.min.css" rel="stylesheet">
		
		
		<title>Registo de Movimentos</title>
		<!-- Custom fonts for this template-->
		<link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		<link
			href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
			rel="stylesheet">
		<!-- Custom styles for this template-->
		<link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">
	</head>
	<body id="page-top">
		<!-- Page Wrapper -->
		<div id="wrapper">
			<!-- Sidebar -->
			<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
				<!-- Sidebar - Brand -->
				<a class="sidebar-brand d-flex align-items-center justify-content-center"
					href="${pageContext.request.contextPath}/DashboardServlet">
					<div class="sidebar-brand-icon rotate-n-15">
						<i class="fas fa-tools"></i>
					</div>
					<div class="sidebar-brand-text mx-3">Plataforma de Ativos</div>
				</a>
				<!-- Divider -->
				<hr class="sidebar-divider my-0">
				<!-- Nav Item - Dashboard -->
				<li class="nav-item active">
					<a class="nav-link" href="${pageContext.request.contextPath}/DashboardServlet">
					<i class="fas fa-fw fa-tachometer-alt"></i>
					<span>Página Inicial</span></a>
				</li>
				<!-- Divider -->
				<hr class="sidebar-divider">
				<!-- Heading -->
				<div class="sidebar-heading">
					Interface
				</div>
				<!-- Nav Item - Pages Collapse Menu -->
				<li class="nav-item">
					<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
						aria-expanded="true" aria-controls="collapseTwo">
					<i class="fas fa-fw fa-table"></i>
					<span>Artigo</span>
					</a>
					<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
						<div class="bg-white py-2 collapse-inner rounded">
							<h6 class="collapse-header">Menu de Artigos:</h6>
							<a class="collapse-item" href="${pageContext.request.contextPath}/ItemCreateServlet">Criar</a>
							<a class="collapse-item" href="${pageContext.request.contextPath}/ItemListServlet">Listar</a>
						</div>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/TransactionViewListServlet">
					<i class="fas fa-fw fa-table"></i>
					<span>Movimentos</span>
					</a>
				</li>
				<!-- Nav Item - Utilities Collapse Menu -->
				<c:if test="${user.tipo == 1 }">
					<li class="nav-item">
						<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
							aria-expanded="true" aria-controls="collapseUtilities" href="${pageContext.request.contextPath}/index.jsp">
						<i class="fas fa-fw fa-wrench"></i>
						<span>Back Office</span>
						</a>
						<div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
							data-parent="#accordionSidebar">
							<div class="bg-white py-2 collapse-inner rounded">
								<h6 class="collapse-header">Administração da página:</h6>
								<a class="collapse-item" href="${pageContext.request.contextPath}/UserListServlet">
									Utilizadores</a>
								<a class="collapse-item" href="${pageContext.request.contextPath}/BOSelectListEditorServlet" >
									Conteúdo</a>
							</div>
						</div>
					</li>
				</c:if>
				<!-- Divider -->
				<hr class="sidebar-divider d-none d-md-block">
				<!-- Sidebar Toggler (Sidebar) -->
				<div class="text-center d-none d-md-inline">
					<button class="rounded-circle border-0" id="sidebarToggle"></button>
				</div>
			</ul>
			<!-- End of Sidebar -->
			<!-- Content Wrapper -->
			<div id="content-wrapper" class="d-flex flex-column">
				<!-- Main Content -->
				<div id="content">
					<!-- Topbar -->
					<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
						<!-- Sidebar Toggle (Topbar) -->
						<button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
						</button>
						<!-- Topbar Navbar -->
						<ul class="navbar-nav ml-auto">
							<!-- Nav Item - Search Dropdown (Visible Only XS) -->
							<li class="nav-item dropdown no-arrow d-sm-none">
								<a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
									data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<i class="fas fa-search fa-fw"></i>
								</a>
								<!-- Dropdown - Messages -->
								<div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
									aria-labelledby="searchDropdown">
									<form class="form-inline mr-auto w-100 navbar-search">
										<div class="input-group">
											<input type="text" class="form-control bg-light border-0 small"
												placeholder="Search for..." aria-label="Search"
												aria-describedby="basic-addon2">
											<div class="input-group-append">
												<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
												</button>
											</div>
										</div>
									</form>
								</div>
							</li>
							<div class="topbar-divider d-none d-sm-block"></div>
							<!-- Nav Item - User Information -->
							<li class="nav-item dropdown no-arrow">
								<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
									data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									<span class="mr-2 d-none d-lg-inline text-gray-600 small">
								
								<% 
									if(session.getAttribute("user") == null)
									{
										// Utilizador não fez login
										%>
								Convidado
								<%
									}
									else
									{
										// Utilizador está logado
										%>
								${user.primeiroNome} ${user.ultimoNome}
								<%
									}			
									%>
									</span>
									<img class="img-profile rounded-circle"
									src="img/undraw_profile.svg">
								</a>
								<!-- Dropdown - User Information -->
								<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
									aria-labelledby="userDropdown">
									<a class="dropdown-item" href="${pageContext.request.contextPath}/EditUserServlet">
									<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
									Perfil
									</a>
									<a class="dropdown-item" href="${pageContext.request.contextPath}/EditPasswordServlet">
									<i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
									Definições
									</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
									<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
									</a>
								</div>
							</li>
						</ul>
					</nav>
					<!-- End of Topbar -->
					
					<!-- Begin Page Content -->
					<div class="container-fluid">
						<jsp:doBody/>
					</div>
					<!-- /.container-fluid -->
				</div>
				
				<!-- End of Main Content -->
				<!-- Footer -->
				<footer class="sticky-footer bg-white">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright &copy; ITSector 2021</span>
						</div>
					</div>
				</footer>
				<!-- End of Footer -->
			</div>
			<!-- End of Content Wrapper -->
		</div>
		<!-- End of Page Wrapper -->
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top">
		<i class="fas fa-angle-up"></i>
		</a>
		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Tem a certeza que pretende sair?</h5>
						<button class="close" type="button" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">Pressione "Logout" se desejar terminar a sessão.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
						<a class="btn btn-primary" href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
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
		<!-- Page level plugins -->
		<script src="${pageContext.request.contextPath}/vendor/chart.js/Chart.min.js"></script>
		<!-- Page level custom scripts -->
		<script src="${pageContext.request.contextPath}/js/demo/chart-area-demo.js"></script>
		<script src="${pageContext.request.contextPath}/js/demo/chart-pie-demo.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
			integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
			integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
			crossorigin="anonymous"></script>
		<script src="${pageContext.request.contextPath}/js/dashboard.js"></script>
		<!--  <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>-->
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap5.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/searchpanes/1.2.1/js/dataTables.searchPanes.min.js"></script>
		<script type="text/javascript" src="//code.highcharts.com/highcharts.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/select/1.3.3/js/dataTables.select.min.js"></script>		
		<script>
			$(document).ready(function () {
			 $('#dtListarUtilizadores').DataTable();                
			 $('table.dtListarConteudo').DataTable();
			 $('#dtArtigosDashboard').DataTable({
			 	"paging":   false,	
		        "ordering": false,
		        "info":     false,
		        "searching": false
			 });
			 $('#dtMovimentosDash').DataTable({
				 "paging":   false,	
		        "ordering": false,
		        "info":     false,
		        "searching": false
			 });
			 $('#dtMovimentos').DataTable();
			 // Create DataTable
			    var table = $('#dtBasicExample').DataTable({
			   	 dom: 'lrtiPp', //lfPrtp
			  		 language: {
			  		        search: "_INPUT_",            // Removes the 'Search' field label
			  		        searchPlaceholder: "Pesquisar um Artigo",   // Placeholder for the search box
			      		     searchPanes: {
			      	            layout: 'columns-6'
			      	        },
			                columnDefs: [
			                    {
			                        searchPanes: {
			                            show: true
			                        },
			                        targets: [3, 4, 5]
			                    }
			                ]
			  		    },
			  		  scrollX: true
			   	 
			    });
			    
			       // Create the chart with initial data
			       var container = $('<div/>').insertAfter(table.table().container());
			    
			       var chart = Highcharts.chart(container[0], {
			           chart: {
			               type: 'pie',
			           },
			           title: {
			               text: 'Análise por Marca',
			           },
			           series: [
			               {
			                   data: chartData(table),
			               },
			           ],
			       });
			    
			       // On each draw, update the data in the chart
			       table.on('draw', function () {
			           chart.series[0].setData(chartData(table));
			       });
			       
			       // caixa de pesquisa
			       $('#mySearchBox').keyup(function(){  
			           table.search($(this).val()).draw();   // this  is for customized searchbox with datatable search feature.
			      })
			                      
			                    
			   });
			    
			
			// Pesquisar assim que clica no tecla enter
			var input = document.getElementById("mySearchText");
			input.addEventListener("keyup", function(event) {
			  if (event.keyCode == 13) {
			   event.preventDefault();
			   input.click();
			  }
			}); 
			
			   function chartData(table) {
			       var counts = {};
			    
			       // Count the number of entries for each position
			       table
			           .column(1, { search: 'applied' })
			           .data()
			           .each(function (val) {
			               if (counts[val]) {
			                   counts[val] += 1;
			               } else {
			                   counts[val] = 1;
			               }
			           });
			    
			       // And map it to the format highcharts uses
			       return $.map(counts, function (val, key) {
			           return {
			               name: key,
			               y: val,
			           };
			       });
			       
			   }
			   
			   // Selecionar Tipo de movimento
			   function funcSelectItemTipoMovimento(ele) {  
			document.getElementById("tipoMovimentoOld").value = ele.text;
			document.getElementById("uidTipoMovimento").value = ele.dataset.uid;
			}
			   
				// Selecionar Tipo de Artigo
			   function funcSelectItemTipoArtigo(ele) {  
			document.getElementById("tipoArtigoOld").value = ele.text;
			document.getElementById("uidTipoArtigo").value = ele.dataset.uid; //data-uid="tipoArtigo.uid"
			}
			
			// Selecionar Estado
			   function funcSelectItemEstado(ele) {  
			document.getElementById("estadoOld").value = ele.text;
			document.getElementById("uidEstado").value = ele.dataset.uid;
			}
			   
			   // Confirmação do delete do Tipo de movimento
			   function confirmDeleleTipoMovimento(ele)
			   {
			   	var r = confirm("Tem a certeza que pretende apagar o item?");
			   	if (r == true) {
			
			   	 ele.parentElement.action = "${pageContext.request.contextPath}/BODeleteTipoMovimentoServlet?idTipoMovimento="+ele.value;
			   	}
			   }
			   
			   function confirmDeleleTipoArtigo(ele)
			   {
			   	var r = confirm("Tem a certeza que pretende apagar o item?");
			   	if (r == true) {
			   	 ele.parentElement.action = "${pageContext.request.contextPath}/BODeleteTipoArtigoServlet?idTipoArtigo="+ele.value;
			   	}
			   }
			   
			   function confirmDeleleEstado(ele)
			   {
			   	var r = confirm("Tem a certeza que pretende apagar o item?");
			   	if (r == true) {
			   		ele.parentElement.action = "${pageContext.request.contextPath}/BODeleteListEstadoServlet?idEstado="+ele.value;
			   	}
			   }
			   
			
			   // Redireciona para a página de pesquisa do artigo
			   function pesquisarArtigo(ele) {
			   	ele.parentElement.submit();                	
			   }
			   
			   
			   
			   
		</script>
	</body>
</html>