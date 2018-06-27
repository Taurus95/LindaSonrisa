<%-- 
    Document   : ConsultasSecretaria
    Created on : 22-06-2018, 18:59:22
    Author     : andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>LINDA SONRISA</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Favicons -->
        <link href="../img/favicon.png" rel="icon">
        <link href="../img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="../https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700|Open+Sans:300,300i,400,400i,700,700i" rel="stylesheet">

        <!-- Bootstrap CSS File -->
        <link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Libraries CSS Files -->
        <link href="../lib/animate/animate.min.css" rel="stylesheet">
        <link href="../lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="../lib/ionicons/css/ionicons.min.css" rel="stylesheet">
        <link href="../lib/magnific-popup/magnific-popup.css" rel="stylesheet">

        <!-- Main Stylesheet File -->
        <link href="../css/style.css" rel="stylesheet">       

    </head>
    <body>
        <header id="header">
            <div class="container">
                <div id="logo" class="pull-left">
                    <h1><a  href="/LindaSonrisa/cancelarFlujoConsulta" class="scrollto">Linda Sonrisa</a></h1>
                    <h3 style="color: white">${trabajador.getNombre()}</h3>
                    <!-- Uncomment below if you prefer to use an image logo -->
                    <!-- <a href="#intro"><img src="img/logo.png" alt="" title=""></a> -->
                </div>
                <nav id="nav-menu-container">
                    <ul class="nav-menu">   
                        <li><a href="/LindaSonrisa/PAGES/ConsultasSecretaria.jsp">Consultas</a></li>
                        <li><a href="/LindaSonrisa/PAGES/RegistrarClienteSecretaria.jsp">Registro Clientes</a></li>
                        <li><a href="/LindaSonrisa/PAGES/AgendarConsultaSecretaria.jsp">Agendar Consulta</a></li>
                        <li><a href="/LindaSonrisa/PAGES/InformesSecretaria.jsp">Informes</a></li>
                        <li><a href="/LindaSonrisa/cancelar">Cerrar sesion</a></li>
                    </ul>
                </nav><!-- #nav-menu-container -->
            </div>
        </header>
        <section id="intro">
            <form role="form" class="contactForm" name="formulario" method="POST" action="/LindaSonrisa/BuscarHorasPorDia" >
                <div class="intro-text">
                    <h2>Filtros</h2>
                    <div class="form-group col-lg-3">
                        <input id="dateDia" onclick="minDatetoday()" onchange="hiddeMessageError()" class="form-control" type="date" name="dateDia" value="" />
                        <span  id="error"></span><br>
                        <a href="#" class="btn-get-started scrollto" onclick="notWeekend()" >Buscar</a>
                    </div>
                </div>
            </form> 
        </section><!-- #intro -->
        <c:if test="${horasDisponibles!=null}">
            <section id="about" class="section-bg">
                <div class="container-fluid">
                    <div class="section-header">
                        <h3 class="section-title">Buscar consultas</h3>
                        <span class="section-divider"></span>
                        <p class="section-description">
                            <a href="#intro">Consultas encontradas...</a>
                        </p>
                        <div class="container" align="center" >
                            <table class="table-responsive-md table">
                                <thead>
                                    <tr>
                                        <th scope="col">Dia</th>
                                        <th scope="col">Hora</th>
                                        <th scope="col">Doctor</th>
                                        <th scope="col">Estado</th>
                                        <th scope="col">Accion</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="horaDisponible" items="${horasDisponibles}">
                                        <tr> 
                                            <td><c:out value="${fecha}" /></td>
                                            <td><c:out value="${horaDisponible.hora}:" /><c:if test="${horaDisponible.minutos==0}" >00</c:if>
                                                <c:if test="${horaDisponible.minutos==30}">30</c:if></td>
                                            <td><c:out value="${horaDisponible.doctor}"/></td>
                                            <td><c:out value="${horaDisponible.estado}"/></td>
                                            <c:if test="${horaDisponible.estado=='Disponible'}">
                                                <td><form method="POST" action="/LindaSonrisa/registrarConsulta">
                                                        <input type="hidden" name="hora" value="${horaDisponible.hora}" >
                                                        <input type="hidden" name="minutos" value="${horaDisponible.minutos}" >
                                                        <input type="submit" value="Pedir">
                                                    </form>
                                                </td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </section>
        </c:if>
    </body>
    <!-- JavaScript Libraries -->
    <script src="../lib/jquery/jquery.min.js"></script>
    <script src="../lib/jquery/jquery-migrate.min.js"></script>
    <script src="../lib/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="../lib/easing/easing.min.js"></script>
    <script src="../lib/wow/wow.min.js"></script>
    <script src="../lib/superfish/hoverIntent.js"></script>
    <script src="../lib/superfish/superfish.min.js"></script>
    <script src="../lib/magnific-popup/magnific-popup.min.js"></script>
    <script src="../lib/bootstrap/js/validacionesRut.js" type="text/javascript"></script>

    <!-- Contact Form JavaScript File -->
    <script src="../contactform/contactform.js"></script>

    <!-- Template Main Javascript File -->
    <script src="../js/main.js"></script>
</html>
