<%-- 
    Document   : SubirDocumentos
    Created on : 23-06-2018, 21:53:57
    Author     : andres
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <!-- Uncomment below if you prefer to use an image logo -->
                    <!-- <a href="#intro"><img src="img/logo.png" alt="" title=""></a> -->
                </div>

                <nav id="nav-menu-container">
                    <ul class="nav-menu">                                              
                        <li><a href="/LindaSonrisa/cancelar">Cancelar</a></li>
                    </ul>
                </nav><!-- #nav-menu-container -->
            </div>
        </header>
        <section id="intro">
            <div class="inform-text">
                <h2>Acreditacion de situacion economica!</h2>
                <div class="row">
                    <form  name="formulario" method="POST" action="/LindaSonrisa/nuevoCliente" >
                        <div>
                            <label for="finiquito" style="color:white">Finiquito:</label>
                            <input type="file" name="finiquito">
                        </div>
                        <div>
                            <label for="certificadoAFP" style="color:white">Certificado AFP:</label>
                            <input type="file" name="certificadoAFP">
                        </div>
                        <div>
                            <label for="liquidacion1" style="color:white">Liquidacion 1:</label>
                            <input type="file" name="liquidacion1">
                        </div>
                        <div>
                            <label for="liquidacion2" style="color:white">Liquidacion 2:</label>
                            <input type="file" name="liquidacion2">
                        </div>
                        <div>
                            <label for="liquidacion3" style="color:white">Liquidacion 3:</label>
                            <input type="file" name="liquidacion3" >
                        </div>
                        <br>
                        <a href="#" onclick="document.formulario.submit()" class="btn-get-started scrollto">Subir Documentos</a>
                        <br>
                        <a href="/LindaSonrisa/PAGES/EspecialidadDoctor.jsp" class="btn-get-started scrollto">Saltar</a>
                    </form> 
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