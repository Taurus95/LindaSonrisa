
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
            <div class="dropdown">
                <h1>Seleccione especialidad y dentista</h1>
                <button class="btn btn-secondary dropdown-toggle" type="button" name="btnEspecialidad" id="dropdownEspecialidad" data-toggle="dropdown" aria-extended="true">
                    Especialidad...
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownEspecialidad">
                    <button class="dropdown-item" type="button">Especialidad 1</button>
                    <button class="dropdown-item" type="button">Especialidad 2</button>
                    <button class="dropdown-item" type="button">Especialidad 3</button>
                </div>

                <button class="btn btn-secondary dropdown-toggle" type="button" name="btnDoctor" id="dropdownDentista" data-toggle="dropdown" aria-extended="true"  >
                    Dentista...
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownDentista">
                    <button class="dropdown-item" type="button">Dentista 1</button>
                    <button class="dropdown-item" type="button">Dentista 2</button>
                    <button class="dropdown-item" type="button">Dentista 3</button>
                </div>
                <button type="submit" class="btn btn-primary">Continuar</button>
            </div>
                
        </div>

    </div>    
</html>
