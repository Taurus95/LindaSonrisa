

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
  .fakeimg {
      height: 200px;
      background: #007bff;
  }
  body{
    background: #31D6D5;
  }
  </style>
</head>
<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>Clinica Odontológica Linda Sonrisa</h1>
  <p><marquee>Sonríele a la vida!</marquee></p> 
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark ">
  <a class="navbar-brand" href="#">INICIO</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
          <a class="nav-link" href="test.jsp">Servicios</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Quienes somos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Preguntas Frequentes</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Contáctanos</a>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">  
      <li class="nav-item">
          <a type="submit" class="btn btn-primary" name="btnReservaHora" href="IngresarRut.jsp">RESERVAR HORA</a>
      </li>     
    </ul>
  </div>  
</nav>



<div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-4">
      <h2>Linda Sonrisa</h2>
      <h5>Foto</h5>
      <div class="fakeimg">Fake Image</div>
      <p>Ofrecemos los mejores servicios</p>
      <h3>Links de interes</h3>
      <p>Cosas de la clinica</p>
      <ul class="nav nav-pills flex-column">
        <li class="nav-item">
          <a class="nav-link active" href="#">Active</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#">Disabled</a>
        </li>
      </ul>
      <hr class="d-sm-none">
    </div>
    <div class="col-sm-8">
      <h2>CLINICA LINDA SONRISA</h2>
      <h5>Mayo 2018</h5>
      <div class="fakeimg">Fake Image</div>
      <p>Somos la mejor clinica de chile</p>
      <p>Texot explicando porque somos la mejor clinica de chile </p>
      <br>
      <h2>Nuestro equipo</h2>
      <h5>Los mejores profesionales a tu disposición</h5>
      <div class="fakeimg">Fake Image</div>
      <p>Garantia de calidad</p>
      <p>Saquese las muelas con nosotros </p>
    </div>
  </div>
</div>

<div class="jumbotron text-center" style="margin-bottom:0">
  <p>Clínica Linda Sonrisa™ todos los derechos reservados</p>
</div>


</html>