
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="service" scope="page" class="DAO_IMP.ServicioDaoImp" />
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
        <div class="container" style="margin-top:30px">
            <c:if test="${dentistas==null}">
                <div class="dropdown">
                    <h1>Seleccione especialidad</h1>
                    <button class="btn btn-secondary dropdown-toggle" type="button" name="btnEspecialidad" id="dropdownEspecialidad" data-toggle="dropdown" aria-extended="true">
                        Especialidad...
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownEspecialidad">
                        <c:forEach var="var" items="${service.listar()}">
                            <form action="/LindaSonrisa/buscarDentistas" method="POST">
                                <input type="hidden" value="${var.nombre}" name="especialidad">
                                <button class="dropdown-item" type="submit" ><c:out value="${var.nombre}"/></button>
                            </form>
                        </c:forEach>
                    </div>
                </div>
            </c:if>
            <br>
            <c:if test="${dentistas!=null}" >
                <div class="dropdown">
                    <h1>Seleccione dentista</h1>
                    <button class="btn btn-secondary dropdown-toggle" type="button" name="btnDoctor" id="dropdownDentista" data-toggle="dropdown" aria-extended="true"  >
                        Dentista...
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownDentista">
                        <c:forEach var="den" items="${dentistas}">
                            <form action="/LindaSonrisa/buscarHoras" method="POST">
                                <input type="hidden" value="${den.rut}" name="rutDentista">
                                <button class="dropdown-item" type="submit" ><c:out value="${den.nombre}"/></button>
                            </form>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

        </div>
    </div>    
</html>
