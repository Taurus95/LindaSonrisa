<%-- 
    Document   : InformesSecretaria
    Created on : 23-06-2018, 14:23:05
    Author     : andres
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="service" scope="page" class="DAO_IMP.ServicioDaoImp" />
<jsp:useBean id="dentista" scope="page" class="DAO_IMP.TrabajadorDaoImp" />
<!DOCTYPE html>
<c:if test="${sec!=1}" >
    <c:redirect url="../cancelar" ></c:redirect>
</c:if>
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
        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700|Open+Sans:300,300i,400,400i,700,700i" rel="stylesheet">

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
                    <h3 style="color: white">${trabajador.getNombre()}</h3>
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
            <div class="contactForm">
                <div class="inform-text">
                    <h2>Informes</h2>
                    <div class="form-group col-lg-4">
                        
                    </div>
                </div>
            </div>
        </section><!-- #intro -->



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
