

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Clinica Linda Sonrisa</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
        <script src="../js/validacionesRut.js" type="text/javascript"></script>
        <style>

            body{
                background: #31D6D5;
            }

        </style>
    </head>
    <body>
        <div class="container well">
            <div class="jumbotron text-center" style="margin-bottom:0">
                <h1>Clinica Odontológica Linda Sonrisa</h1>
                <p>Registro Cliente</p> 
            </div> 
            <form action="LindaSonrisa/nuevoCliente" method="POST" onsubmit="return checkRutGenerico(txtRut.value, false);">
                <form>
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="validationServer01">Rut</label>
                            <input type="text" name="txtRut" onkeypress="return soloRUT(event)" 
                                   onblur="checkRutGenerico(txtRut.value, false) class ="form-control is-valid" id="validationServer01" placeholder="13.123.456-K"  required>

                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationServer02">Nombre</label>
                            <input type="text" name="txtNombre" class="form-control is-valid" id="validationServer02" placeholder="Jose Vega"  required>

                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationServer03">Correo</label>
                            <input type="text" name="txtCorreo" class="form-control is-valid" id="validationServer03" placeholder="JoseVega@correo.cl"  required>

                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="validationServer04">Sexo</label>
                            <input type="text" name="cmbSexo" class="form-control is-invalid" id="validationServer04" placeholder="Sexo" required>

                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="validationServer05">Dirección</label>
                            <input type="text" name="txtDireccion" class="form-control is-invalid" id="validationServer05" placeholder="Calle Viva #123, Santiago" required>

                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationServer06">Telefono</label>
                            <input type="text" name="txtTelefono" class="form-control is-invalid" id="validationServer06" placeholder="Zip" required>

                        </div>
                        <div class="col-md-4 mb-3">
                            <label>Fecha Nacimiento</label>
                            <div class="col-md-4 mb-2">
                                <input type="Date" name="calNacimiento" required>
                            </div>    
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="validationServer07">Contraseña</label>
                            <input type="password" name="txtContrasenia" class="form-control is-invalid" id="validationServer07"  required>                            
                        </div>

                        <div class="col-md-4 mb-3">
                            <label>Certificados (opcional)</label>
                            <div class="col-md-6 mb-2">
                                <input id="archivo" class="file" type="file" multiple=true>
                            </div>    
                        </div>
                    </div>    

                    <button class="btn btn-primary" name="btnRegistrarCliente " type="submit">REGISTRAR</button>
                </form> 
            </form>
        </div>    
    </body>
</html>
