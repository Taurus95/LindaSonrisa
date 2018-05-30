<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="container well">
        <div class="jumbotron text-center" style="margin-bottom:0">
            <h1>Clinica Odontológica Linda Sonrisa</h1>
            <p>Agendar Consulta</p> 
        </div>

        <form class="form-inline"  method="post" action="/LindaSonrisa/loginConRut" onsubmit="return checkRutGenerico(txtRut.value, false);"  >
            <div class="container" style="margin-top:30px">
                <div class="row">
                    <div class="col-sm-4">
                        <c:if test="${cliente==null}">
                            <h1>Ingrese su rut</h1>                    
                            <input type="text" name="txtRut" class="form-control" id="txtRut" onkeypress="return soloRUT(event)" 
                                   onblur="checkRutGenerico(txtRut.value, false)"
                                   placeholder="EJ: 19.123.456-k" autofocus="">
                            <c:if test="${mes!=null}" ><span><c:out value="${mes}"/></span></c:if>
                        </c:if>
                        <c:if test="${cliente!=null}">
                            <label for="rut">Ingrese su Rut</label>                    
                            <input type="text" name="txtRut" maxlength="20" value="<c:out value="${cliente.getRut()}" />" disabled="" >
                            <label for="rut">Ingrese su contraseña</label>                    
                            <input type="password" name="txtPass" maxlength="20" class="form-control" id="txtPass" placeholder="" autofocus="">
                            <c:if test="${acceso==0}" ><span>Contraseña incorrecta</span></c:if>

                        </c:if>
                        <button type="submit" class="btn btn-primary">Continuar</button>    
                    </div>
                </div>        
            </div>
        </form>
    </div>
</html>
