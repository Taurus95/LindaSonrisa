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
                    <h1><a href="#intro" class="scrollto">Linda Sonrisa</a></h1>
                    <!-- Uncomment below if you prefer to use an image logo -->
                    <!-- <a href="#intro"><img src="img/logo.png" alt="" title=""></a> -->
                </div>

                <nav id="nav-menu-container">
                    <ul class="nav-menu">                                              
                        <li><a href="../index.html">Cancelar</a></li>
                    </ul>
                </nav><!-- #nav-menu-container -->
            </div>
        </header>
        <!--<form role="form" class="contactForm" method="POST" action="/LindaSonrisa/nuevoCliente" onsubmit="return checkRutGenerico(txtRut.value, false);">
            <section id="intro">
                <div class="row">    
                    <div class="intro-text">
                        <h2>Registro Nuevo Cliente</h2>
                        <div class="form-group col-lg-3">
                            <input type="text" name="txtRut" class="form-control" placeholder="Rut" id="txtRut" onkeypress="return soloRUT(event)" onblur="checkRutGenerico(txtRut.value, false)"  />                            
                        </div>
                        <div class="form-group col-lg-3">
                            <input type="text" name="txtNombre" class="form-control" placeholder="Nombre" />
                        </div>
                        <div class="form-group col-lg-3">
                            <input type="text" name="txtCorreo" class="form-control" placeholder="Correo" />
                        </div>
                        <div class="form-group col-lg-3">
                            <input type="text" name="cmbSexo" class="form-control" placeholder="Sexo Biológico" />
                        </div>
                        <select name="sexo">
                            <option></option>
                            <option></option>
                        </select>
                    </div>
                </div>>  

                <!--<div class="product-screens">



                </div>-->

        <!--    </section><!-- #intro -->
        <!--</form> -->
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        <div class="limiter">
            <div class="container-registro">
                <div class="wrap-registro">
                    <form class="login100-form validate-form p-l-55 p-r-55 p-t-160" method="POST" action="./registrarUserFile.php">
                        <span class="login100-form-title">
                            Formulario de registro
                        </span>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="wrap-input100 validate-input" data-validate = "Porfavor ingresa tu rut" >
                                    <input class="input100" type="text" id="txtRut" name="txtRut" placeholder="Rut" onkeypress="return soloRUT(event)"
                                           onblur="checkRutGenerico(txtRut.value, false)" >
                                    <span class="focus-input100"></span>
                                </div>
                                <br>
                                <div class="wrap-input100 validate-input" data-validate = "Porfavor ingresa tu nombre" >
                                    <input class="input100" type="text" name="txtNombre" placeholder="Nombres" >
                                    <span class="focus-input100"></span>
                                </div>
                                <br>
                                <div class="wrap-input100 validate-input" data-validate = "Porfavor ingresa tu apellido" >
                                    <input class="input100" type="text" name="txtApellidoP" placeholder="Apellido paterno">
                                    <span class="focus-input100"></span>
                                </div>
                                <br>
                                <div class="wrap-input100 validate-input" data-validate = "Porfavor ingresa tu apellido">
                                    <input class="input100" type="text" name="txtApellidoM" placeholder="Apellido materno" >
                                    <span class="focus-input100"></span>
                                </div>
                                <br>
                                <div class="wrap-input100 validate-input" data-validate = "Porfavor ingresa tu fecha de nacimiento">
                                    <input class="input100" type="text" onfocus="(this.type = 'date')" onblur="(this.type = 'text')"
                                           name="dateFechaN"  placeholder="Fecha nacimiento" >
                                    <span class="focus-input100"></span>
                                </div>
                                <br>
                                <div class="wrap-input100 validate-input" data-validate = "Porfavor indica tu sexo biologico">
                                    <span>Porfavor indica tu sexo biologico:</span>
                                    <div class="radio">
                                        <label style="font-size: 1em">
                                            <input type="radio" name="sexo" value="hombre" checked="">
                                            <span class="cr"><i class="cr-icon fa fa-circle"></i></span>
                                            Hombre
                                        </label>
                                        <label style="font-size: 1em">
                                            <input type="radio" name="sexo" value="mujer">
                                            <span class="cr"><i class="cr-icon fa fa-circle"></i></span>
                                            Mujer
                                        </label>
                                    </div>
                                </div>
                                <br>
                            </div>
                            <div class="col-sm-6" >

                                <div class="wrap-input100 validate-input" data-validate = "Porfavor ingresa tu telefono">
                                    <input class="input100" type="number" name="numTelefono" placeholder="Numero de telefono"
                                           onkeypress="return soloNum(event)">
                                    <span class="focus-input100"></span>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="wrap-input100 validate-input" data-validate = "Porfavor ingresa tu direccion">
                                            <input class="input100" type="text" name="txtDireccion" placeholder="Direccion" >
                                            <span class="focus-input100"></span>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <select class="custom-select input100" name="comuna" required="">
                                            <option value="0" selected>Comuna</option>
                                            <option value="Cerrillos">Cerrillos</option>
                                            <option value="Cerro Navia">Cerro Navia</option>
                                            <option value="Conchalí">Conchalí</option>
                                            <option value="El Bosque">El Bosque</option>
                                            <option value="Estación Central">Estación Central</option>
                                            <option value="Huechuraba">Huechuraba</option>
                                            <option value="Independencia">Independencia</option>
                                            <option value="La Cisterna">La Cisterna</option>
                                            <option value="La Florida">La Florida</option>
                                            <option value="La Granja">La Granja</option>
                                            <option value="La Pintana">La Pintana</option>
                                            <option value="La Reina">La Reina</option>
                                            <option value="Las Condes">Las Condes</option>
                                            <option value="Lo Barnechea">Lo Barnechea</option>
                                            <option value="Lo Espejo">Lo Espejo</option>
                                            <option value="Lo Prado">Lo Prado</option>
                                            <option value="Macul">Macul</option>
                                            <option value="Maipú">Maipú</option>
                                            <option value="Ñuñoa">Ñuñoa</option>
                                            <option value="Padre Hurtado">Padre Hurtado</option>
                                            <option value="Pedro Aguirre Cerda">Pedro Aguirre Cerda</option>
                                            <option value="Peñalolén">Peñalolén</option>
                                            <option value="Providencia">Providencia</option>
                                            <option value="Pudahuel">Pudahuel</option>
                                            <option value="Puente Alto">Puente Alto</option>
                                            <option value="Quilicura">Quilicura</option>
                                            <option value="Quinta Normal">Quinta Normal</option>
                                            <option value="Recoleta">Recoleta</option>
                                            <option value="Renca">Renca</option>
                                            <option value="San Bernardo">San Bernardo</option>
                                            <option value="San Joaquín">San Joaquín</option>
                                            <option value="San Miguel">San Miguel</option>
                                            <option value="San Ramón">San Ramón</option>
                                            <option value="Santiago">Santiago</option>
                                            <option value="Vitacura">Vitacura</option>
                                        </select>
                                    </div>
                                </div>

                                <br>
                                <div class="wrap-input100 validate-input" data-validate = "Porfavor ingresa tu correo">
                                    <input class="input100" type="email" name="txtCorreo" placeholder="Correo electronico" >
                                    <span class="focus-input100"></span>
                                </div>
                                <br>
                                <div class="wrap-input100 validate-input" data-validate = "Porfavor ingresa tu contraseña">
                                    <input class="input100" type="password" name="txtPass" placeholder="Contraseña" >
                                    <span class="focus-input100"></span>
                                </div>
                                <br>
                                <div class="wrap-input100 validate-input" data-validate = "Las contraseñas no coinciden" >
                                    <input class="input100" type="password" name="txtRepPass" placeholder="Repetir contraseña" >
                                    <span class="focus-input100"></span>
                                </div>
                                <br>
                            </div>
                        </div>
                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn">
                                Registrarme
                            </button>
                        </div>
                        <br>
                    </form>
                </div>
            </div>
        </div>
        
        
        
        
        
        


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
