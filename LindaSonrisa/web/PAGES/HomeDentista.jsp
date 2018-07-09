<%-- 
    Document   : HomeDentista
    Created on : 15-06-2018, 11:05:47
    Author     : andres
--%>

<%@page import="DAO_IMP.ClienteDaoImp"%>
<%@page import="DTO.ClienteDto"%>
<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="consulta" scope="page" class="DAO_IMP.ConsultaDaoImp" />
<jsp:useBean id="cliente" scope="page" class="DAO_IMP.ClienteDaoImp" />
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Clinica Odontológica LINDA SONRISA</title>
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
                    <h1><a href="/LindaSonrisa/cancelar" class="scrollto">Linda Sonrisa</a></h1>
                    <!-- Uncomment below if you prefer to use an image logo -->
                    <!-- <a href="#intro"><img src="img/logo.png" alt="" title=""></a> -->
                </div>

                <nav id="nav-menu-container">
                    <ul class="nav-menu">                                              
                        <li><a href="/LindaSonrisa/cancelar">Salir</a></li>
                    </ul>
                </nav><!-- #nav-menu-container -->
            </div>
        </header>
        <section id="intro">
            <div class="intro-text">
                <h2>Bienvenid@ <c:out value="${trabajador.getNombre()}" /></h2>
                <p>Que tengas un exelente dia...</p>
                <a href="/LindaSonrisa/PAGES/HomeDentista.jsp#about " class="btn-get-started scrollto">Mis pacientes</a>
                <a href="/LindaSonrisa/PAGES/ActualizarDatosSecretaria.jsp " class="btn-get-started scrollto">Actualiza tus datos personales</a>
            </div>
        </section>
        <section id="about" >
            <div class="container-fluid">
                <div class="section-header">
                    <h3 class="section-title">Tus consultas del dia</h3>
                    <span class="section-divider"></span>
                    <p class="section-description">
                        <a href="#intro">Inicio</a>
                    </p>
                    <div class="container" align="center" >
                        <table class="table-responsive-md table">
                            <thead>
                                <tr>
                                    <th scope="col">Hora</th>
                                    <th scope="col">Paciente</th>
                                    <th scope="col">Telefono</th>
                                    <th scope="col">Correo</th>
                                    <th scope="col">Estado consulta</th>                                        
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                                %>
                                <c:forEach var="aux" items="${consulta.listarPorDiaDoctor(trabajador.getRut(), date )}">
                                    <tr> 
                                        <c:set var="paciente" value="${cliente.buscarConRut(aux.rutCliente)}" ></c:set>
                                        <td><c:out value="${aux.hora}:" /><c:if test="${aux.minutos==0}" >00</c:if>
                                            <c:if test="${aux.minutos==30}">30</c:if></td>
                                        <td><c:out value="${paciente.nombre}" /></td>
                                        <td><c:out value="${paciente.telefono}" /></td>
                                        <td><c:out value="${paciente.correo}" /></td>
                                        <td><c:out value="${aux.estado}" /></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>

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
    </body>    
</html>