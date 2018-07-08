<%-- 
    Document   : DetalleConsultaSecretaria
    Created on : 23-06-2018, 16:58:46
    Author     : andres
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="service" scope="page" class="DAO_IMP.ServicioDaoImp" />
<jsp:useBean id="dentista" scope="page" class="DAO_IMP.TrabajadorDaoImp" />
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
                    <h1><a href="/LindaSonrisa/cancelarFlujoConsulta" class="scrollto">Linda Sonrisa</a></h1>
                    <h3 style="color: white">${trabajador.getNombre()}</h3>
                    <!-- Uncomment below if you prefer to use an image logo -->
                    <!-- <a href="#intro"><img src="img/logo.png" alt="" title=""></a> -->
                </div>

                <nav id="nav-menu-container">
                    <ul class="nav-menu">                                              
                        <li><a href="/LindaSonrisa/cancelarFlujoConsulta">Salir</a></li>
                    </ul>
                </nav><!-- #nav-menu-container -->
            </div>
        </header>

        <section id="intro">
            <div class="contactForm">
                <div class="inform-text">
                    <h2>Detalle de consulta</h2>
                    <div class="col-lg-4">
                        <table class="table table-bordered" aling="center">
                            <tbody>
                                <tr>
                                    <td><h5 style="color:white">Dentista: </h5></td>
                                    <td><h5 style="color:white"><c:out value="${dentista.buscarNombre(consulta.rutTrabajador)}"/></h5></td>
                                    <td><h5 style="color:white">Paciente: </h5></td>
                                    <td><h5 style="color:white"><c:out value="${cliente.buscarNombre(consulta.rutCliente)}"/></h5></td>
                                </tr>
                                <tr>
                                    <td><h5 style="color:white">Servicio : </h5></td>
                                    <td><h5 style="color:white"><c:out value="${service.buscarNombre(consulta.idServicio)}"/></h5></td>
                                    <td><h5 style="color:white">Precio : </h5></td>
                                    <td><h5 style="color:white"><c:out value="${service.buscarPrecio(consulta.idServicio)}"/></h5></td>
                                </tr>
                                <tr>
                                    <td><h5 style="color:white">Dia:</h5></td>
                                    <td><h5 style="color:white"><c:out value="${consulta.fecha}"></c:out></h5></td>
                                        <td style="color:white"><h5>Hora:</h5></td>
                                        <td style="color:white"><h5><c:out value="${consulta.hora}:" /><c:if test="${consulta.minuto==0}" >00</c:if>
                                            <c:if test="${consulta.minuto==30}">30</c:if></h5></td>
                                    </tr>
                                    <tr>
                                        <td><h5 style="color:white">Estado:</h5></td>
                                        <td><h5 style="color:white"><c:out value="${consulta.estado}"/></h5></td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="row"> 
                            <div class="col-lg-6">
                                <form name="formulario" action="/LindaSonrisa/cancelarConsulta" method="POST" >
                                    <input type="hidden" value="${consulta.idConsulta}" name="idConsulta" >
                                    <a href="#" class="btn-get-started scrollto" onclick="confirmCancelar()">Cancelar</a>
                                </form>
                            </div>
                            <div class="col-lg-6">
                                <form name="boletaForm" action="/LindaSonrisa/boletaConsulta" method="POST" >
                                    <label for="descuento" style="color:white">Descuento:</label>
                                    <input type="number" value="0" required="" name="descuento" >
                                    <a href="#" class="btn-get-started scrollto" onclick="descuentoForm()" >Boleta</a>
                                </form>
                            </div>
                        </div>
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
