

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Clinica Linda Sonrisa</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../js/jquery.datetimepicker.min.css" rel="stylesheet" type="text/css"/>

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
    </div>

    <div class="container" style="margin-top:30px">
        <div class="row">
            <div class="col-sm-4">
                <h2>Seleccione una fecha</h2>
                <form method="POST" action="/LindaSonrisa/BuscarHorasPorDia">
                    <input id="dateDia" type="date" name="dateDia" value="" />
                    <input type="submit" class="btn btn-primary" value="Buscar"/>
                </form>
            </div>
            <c:if test="${horasDisponibles!=null}">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Dia</th>
                            <th scope="col">Hora</th>
                            <th scope="col">Doctor</th>
                            <th scope="col">Estado</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="hora" items="horasDisponibles">
                            <tr>
                                <th scope="row">1</th>
                                <td>><c:out value="${fecha}" /></td>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>

</html>
