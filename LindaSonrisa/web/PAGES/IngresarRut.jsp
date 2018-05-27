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
            <form class="form-inline"  method="post" action="/LindaSonrisa/loginConRut" onsubmit="return checkRutGenerico(txtRut.value, false);"  >
                <div class="form-group">
                    <c:if test="${cliente==null}">
                        <label for="rut">Ingrese su Rut</label>                    
                        <input type="text" name="txtRut" class="form-control" id="txtRut" onkeypress="return soloRUT(event)" 
                               onblur="checkRutGenerico(txtRut.value, false)"
                               placeholder="EJ: 19.123.456-k" autofocus="">
                    </c:if>
                    <c:if test="${cliente!=null}">
                        <label for="rut">Ingrese su Rut</label>                    
                        <input type="text" name="txtRut" maxlength="20" value="<c:out value="${cliente.getRut()}" />" disabled="" >
                        <br>
                        <label for="rut">Ingrese su contraseña</label>                    
                        <input type="password" name="txtPass" maxlength="20" class="form-control" id="txtPass" placeholder="" autofocus="">
                        <c:if test="${acceso==0}" ><span>Contraseña incorrecta</span></c:if>
                    </c:if>
                </div>
                <button type="submit" class="btn btn-primary">Continuar</button>
            </form>
        </body>
    </div>
</html>
