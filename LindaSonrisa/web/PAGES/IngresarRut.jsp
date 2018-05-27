<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/estilo.css" rel="stylesheet" type="text/css"/>
        <script src="../js/validacionesRut.js" type="text/javascript"></script>
    </head>
    <div class="container well">
        <h1 class="text-center">Agenda Consulta</h1>
        <body>
            <form class="form-inline"  method="post" onsubmit="return checkRutGenerico(rutEmpresa.value, false);"  >
                <div class="form-group">
                    <c:if test="${cliente==null}">
                        <label for="rut">Ingrese su Rut</label>                    
                        <input type="text" name="txtRut" class="form-control" id="rut" onkeypress="return soloRUT(event)" 
                               onblur="checkRutGenerico(rutEmpresa.value, false)"
                               placeholder="EJ: 19.123.456-k" autofocus="">
                    </c:if>
                    <c:if test="${cliente!=null}">
                        <label for="rut">Ingrese su Rut</label>                    
                        <input type="text" name="txtRut" maxlength="20" value="<c:out value="${cliente.getRut()}" />" disabled="" >
                        <label for="rut">Ingrese su contraseña</label>                    
                        <input type="password" name="txtRut" maxlength="20" class="form-control" id="pass" placeholder="" autofocus="">
                    </c:if>

                </div>
                <button type="submit" class="btn btn-primary">Continuar</button>
            </form>
        </body>
    </div>
</html>
