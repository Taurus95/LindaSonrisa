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
                    <h1><a href="../index.html" class="scrollto">Linda Sonrisa</a></h1>
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
        <section id="intro">
            <form role="form" name="formulario" method="POST" action="/LindaSonrisa/nuevoCliente" >
                <div class="intro-text">
                    <h2>Registrate!</h2>
                    <div class="row">
                        <div class="col-sm-6">
                            <input type="text" name="txtNombre" class="form-control" id="name" placeholder="Nombre" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                            <br>
                            <input type="email" class="form-control" name="txtCorreo" id="email" placeholder="Correo" data-rule="email" data-msg="Please enter a valid email" />
                            <br>
                            <input type="text" name="txtDireccion" class="form-control"  id="direccion" placeholder="Dirección" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
                            <br>
                            <input type="text" name="txtTelefono" class="form-control" id="telefono" placeholder="Teléfono" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                        </div>
                        <div class="col-sm-6">
                            <input type="date" class="form-control" name="calNacimiento" required="">
                            <br>
                            <select name="cmbSexo" class="form-control" required="" >
                                <option selected="" value="0" disabled="" >Sexo Biologico</option>
                                <option value="F">Femenino</option>
                                <option value="M" >Masculino</option>
                            </select>
                            <br>
                            <input type="password" class="form-control" name="txtContrasenia" required="" placeholder="Contraseña">
                            <br>
                            <input type="password" class="form-control" name="txtconfirmPass" required="" placeholder="Repetir contraseña">
                        </div>
                        <div class="container" align="center">
                            <div class="row">
                                <div class="col-sm-6">
                                    <a href="#" onclick="document.formulario.submit()" class="btn-get-started scrollto">Registrarme</a>
                                </div>
                                <div class="col-sm-6">
                                    <a href="#" onclick="document.formulario.submit()" class="btn-get-started scrollto">Registrarme y Acreditar situacion</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form> 
        </section>

        <!--<section id="intro" class="section-bg">
                        <div class="container-fluid" >
                            <div class="section-header">
                                <h3 class="section-title">Registrate como cliente</h3>
                                <span class="section-divider"></span>
                                <p class="section-description">
                                    <a href="#">Completa el formulario para poder agendar una consulta</a>
                                </p>
                                <div class="container" align="center" >
                                    <div class="form-group col-lg-6">
                                        <input type="text" name="txtNombre" class="form-control" id="name" placeholder="Nombre" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                                        <div class="validation"></div>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <input type="email" class="form-control" name="email" id="email" placeholder="Correo" data-rule="email" data-msg="Please enter a valid email" />
                                        <div class="validation"></div>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <input type="text" name="txtDireccion" class="form-control"  id="direccion" placeholder="Dirección" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
                                        <div class="validation"></div>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <input type="text" name="txtTelefono" class="form-control" id="telefono" placeholder="Teléfono" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                                        <div class="validation"></div>
                                    </div>
                                    <div class="form-group col-lg-6">                                           
                                        <select name="cmbSexo" class="form-control" >
                                            <option>Femenino</option>
                                            <option>Masculino</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-lg-6">
                                        <input type="date" class="form-control" name="calNacimieno" required="">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="intro-text">
        <!--<h2>Registro Cliente</h2> 
        <div class="form-row">
            <div class="form-group col-lg-6">
                <input type="text" name="txtNombre" class="form-control" id="name" placeholder="Nombre" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                <div class="validation"></div>
            </div>
            <div class="form-group col-lg-6">
                <input type="email" class="form-control" name="email" id="email" placeholder="Correo" data-rule="email" data-msg="Please enter a valid email" />
                <div class="validation"></div>
            </div>
            <div class="form-group col-lg-6">
                <input type="text" name="txtDireccion" class="form-control"  id="direccion" placeholder="Dirección" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
                <div class="validation"></div>
            </div>
            <div class="form-group col-lg-6">
                <input type="text" name="txtTelefono" class="form-control" id="telefono" placeholder="Teléfono" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                <div class="validation"></div>
            </div>
            <div class="form-group col-lg-6">                                           
                <select name="cmbSexo" class="form-control" >
                    <option>Femenino</option>
                    <option>Masculino</option>
                </select>
            </div>
            <div class="form-group col-lg-6">
                <input type="date" class="form-control" name="calNacimieno" required="">
            </div>
        </div>
        <div class="form-row">
        </div>
        <div class="from-row">
            <div class="form-group col-auto">
                <input type="text" name="txtTelefono" required="" placeholder="Teléfono">
            </div>
            <div>
                <input type="file"  multiple="" >
            </div>
        </div>

        <div class="text-center">
            <button type="submit" title="Registar">Registrar</button>
        </div>



    </div>
</section>
        <!--</form> 
        <div class="container">
            <section id="contact">
                <div class="container">
                    <div class="row ">                

                        <div class="col-lg-5 col-md-8">
                            <div class="form">

                                <form action="" method="post" role="form" class="contactForm">
                                    <div class="form-row">
                                        <div class="form-group col-lg-6">
                                            <input type="text" name="txtNombre" class="form-control" id="name" placeholder="Nombre" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                                            <div class="validation"></div>
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <input type="email" class="form-control" name="email" id="email" placeholder="Correo" data-rule="email" data-msg="Please enter a valid email" />
                                            <div class="validation"></div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="txtDireccion" id="subject" placeholder="Dirección" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
                                        <div class="validation"></div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-lg-3">                                           
                                            <select name="cmbSexo" >
                                                <option>Femenino</option>
                                                <option>Masculino</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-lg-3">
                                            <input type="date" name="calNacimieno" required="">
                                        </div>
                                        
                                    </div>
                                    <div class="from-row">
                                        <div class="form-group col-auto">
                                            <input type="text" name="txtTelefono" required="" placeholder="Teléfono">
                                        </div>
                                        <div>
                                            <input type="file"  multiple="" >
                                        </div>
                                    </div>

                                    <div class="text-center">
                                        <button type="submit" title="Registar">Registrar</button>
                                    </div>
                                </form>
                            </div>
                        </div>

                    </div>

                </div>
            </section>
        </div>
        
        -->

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
