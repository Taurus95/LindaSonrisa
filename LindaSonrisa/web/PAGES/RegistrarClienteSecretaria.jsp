<%-- 
    Document   : RegistrarClienteSecretaria
    Created on : 22-06-2018, 19:00:59
    Author     : andres
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
        <c:if test="${ms!=null}">
            <script>alert(${ms});</script>
            ${ms=null}
        </c:if>
        <header id="header">
            <div class="container">

                <div id="logo" class="pull-left">
                    <h1><a href="/LindaSonrisa/PAGES/HomeSecretaria.jsp" class="scrollto">Linda Sonrisa</a></h1>
                </div>

                <nav id="nav-menu-container">
                    <ul class="nav-menu">                                              
                        <li><a href="/LindaSonrisa/PAGES/HomeSecretaria.jsp">Cancelar</a></li>
                    </ul>
                </nav><!-- #nav-menu-container -->
            </div>
        </header>
        <section id="intro">
            <form class="login100-form validate-form" name="formulario" enctype="multipart/form-data"
                  method="POST" action="/LindaSonrisa/registrarClienteSecretaria" >
                <div class="inform-text">
                    <h2>Registrar cliente</h2>
                    <div class="row">
                        <div class="col-sm-6">
                            <input type="text" name="txtRut" class="form-control" 
                                   placeholder="Ingrese tu rut" required="" id="txtRut"
                                   onkeypress="return soloRUT(event)" 
                                   onblur="checkRutGenerico(txtRut.value, false)"  />
                            <br>
                            <input type="text" name="txtNombre" class="form-control input100" id="name" placeholder="Nombre"/>
                            <br>
                            <input type="email" class="form-control" name="txtCorreo" id="email" placeholder="Correo" required=""/>
                            <br>
                            <input type="text" name="txtDireccion" class="form-control"  id="direccion" placeholder="Dirección" required="" />
                            <br>
                            <input type="text" name="txtTelefono" onkeydown="" class="form-control" id="telefono" placeholder="Teléfono" required=""/>
                            <br>
                            <label style="color:white">Finiquito:</label>
                            <input type="file" name="finiquito">
                            <br>
                            <label style="color:white">Certificado AFP:</label>
                            <input type="file" name="certificadoAFP">
                        </div>
                        <div class="col-sm-6">
                            <input type="date" class="form-control" name="calNacimiento"
                                   id="calNacimiento" onclick="maxDatetoday()" required="">
                            <br>
                            <select name="cmbSexo" class="form-control" required="" >
                                <option selected="" value="0" disabled="" >Sexo Biologico</option>
                                <option value="F">Femenino</option>
                                <option value="M" >Masculino</option>
                            </select>
                            <br>
                            <input type="password" class="form-control" name="txtContrasenia" id="txtContrasenia" required="" placeholder="Contraseña">
                            <br>
                            <input type="password" class="form-control" name="txtconfirmPass" id="txtconfirmPass" onkeyup="comprobarPass()" required=""
                                   placeholder="Repetir contraseña">
                            <br>
                            <label style="color:white">Liquidacion 1:</label>
                            <input type="file" name="liquidacion1">
                            <br>
                            <label style="color:white">Liquidacion 2:</label>
                            <input type="file" name="liquidacion2">
                            <br>
                            <label style="color:white">Liquidacion 3:</label>
                            <input type="file" name="liquidacion3">

                        </div>
                        <div class="container" align="center">
                            <a href="#" onclick="validateForm()" class="btn-get-started scrollto">Registrar</a>
                        </div>
                    </div>
                </div>
            </form> 
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
