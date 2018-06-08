<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta</title>
    </head>
    <body>
        <c:if test="${consulta!=null}">
            <div class="container">
                <h1>Informacion Consulta</h1>
                <table class="table-dark">
                    <tbody>
                        <tr>
                            <td>Servicio: </td>
                            <td><c:out value="${consulta.idServicio}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Fecha: </td>
                            <td><c:out value="${consulta.fecha}"></c:out></td>
                            </tr>
                            <tr>
                                <td>Hora:</td>
                                <td>
                                <c:out value="${consulta.hora}:" /><c:if test="${consulta.minuto==0}" >00</c:if>
                                <c:if test="${consulta.minuto==31}">31</c:if>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <form action="/LindaSonrisa/cancelarConsulta" method="POST">
                    <input type="hidden" value="${consulta.idConsulta}" name="idConsulta" >
                <input type="submit" value="Cancelar">
            </form>
        </c:if>
    </body>
</html>
