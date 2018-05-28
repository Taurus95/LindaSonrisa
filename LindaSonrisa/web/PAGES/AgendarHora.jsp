

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Clinica Linda Sonrisa</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <link href="../js/jquery.datetimepicker.min.css" rel="stylesheet" type="text/css"/>
        <script src="../js/jquery.js" type="text/javascript"></script>
        <script src="../js/jquery.datetimepicker.full.js" type="text/javascript"></script>

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
                <input id="datetime" name="calendario" value="" />
                <script>
                    $("#datetime").datetimepicker({
                        step: 30
                    });

                </script>
            </div>
            <div class="col-sm-8">
                <h2>Horas Disponibles</h2>
                <table class="table-hover " border="1">
                    <thead>
                        <tr>
                            <th>Test</th>
                            <th>testing</th>
                            <th>test</th>
                            <th>testing</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>

            </div>
        </div>
    </div>

</html>
