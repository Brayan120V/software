<%@page import="model.Truck"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Space"%>
<%
    Space space = (Space) request.getSession().getAttribute("space");
    ArrayList<Truck> trucks = (ArrayList<Truck>) request.getSession().getAttribute("trucks");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>editar espacio</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/typicons/2.0.9/typicons.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrapLoginRegister.css">
        <link rel="stylesheet" href="assets/css/LoginRegisterPage.css">
        <link rel="stylesheet" href="assets/css/styles.min.css">
    </head>

    <div>
        <nav class="navbar navbar-light navbar-expand-md navigation-clean" style="background-color: #cf6666;">
            <div class="container"><a class="navbar-brand" data-aos="fade-right" href="#" style="color: rgb(255,255,255);">TKRGO</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div
                    class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item" role="presentation"></li>
                        <li class="nav-item" role="presentation"></li>
                        <li class="nav-item" role="presentation"></li>
                        <li class="dropdown nav-item"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#" style="color: rgb(255,255,255);"><i class="typcn typcn-cog-outline" style="color: rgb(255,255,255);"></i></a>
                            <div class="dropdown-menu" role="menu"
                                 role="menu" style="background-color: #cf6666;"><a class="dropdown-item" role="presentation" href="#" style="color: rgb(255,255,255);"><i class="fa fa-user"></i>&nbsp;perfil</a><a class="dropdown-item" role="presentation" href="#" style="color: rgb(255,255,255);"><i class="fa fa-truck"></i>&nbsp;mis camiones</a>
                                <a
                                    class="dropdown-item" role="presentation" href="#" style="color: rgb(255,255,255);"><i class="fa fa-archive"></i>&nbsp;mis espacios</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>



    <div id="simpleLogin"></div>
    <div class="container-fluid">
        <div class="row mh-100vh">
            <div class="col-10 col-sm-8 col-md-6 col-lg-6 offset-1 offset-sm-2 offset-md-3 offset-lg-0 align-self-center d-lg-flex align-items-lg-center align-self-lg-stretch bg-white p-5 rounded rounded-lg-0 my-5 my-lg-0" id="login-block">

                <div class="m-auto w-lg-75 w-xl-50" style="margin-bottom: 60%; "> 
                    <h3 style="margin-left: 20%; margin-bottom: 10%;">editar espacio</h3>  
                    <form action="space" method="post"> 
                        <input type="hidden" name="_method" value="put" />
                        <div class="slidecontainer">
                            <label class="titleFormCarga">volumen</label>
                            <input  class="slidecontainer" name="volume" type="range" min="1" max="200" value="${space.volume}" class="slider" id="myRange">
                            <label id="volume" class="sliderValue">${space.volume} m cubicos</label>
                        </div>

                        <div class="slidecontainer">
                            <label  class="titleFormCarga">Peso</label>
                            <input  class="slidecontainer" name="weight" type="range" min="1" max="200" value="${space.weight}" class="slider" id="myRange">
                            <label id="weight" class="sliderValue">${space.weight} kg</label>
                        </div>

                        <div class="slidecontainer">
                            <label class="titleFormCarga">valor</label>
                            <input  class="slidecontainer" name="value" type="range" min="1" max="200" value="${space.value}" class="slider" id="myRange">
                            <label id="value" class="sliderValue">${space.value} pesos</label>
                        </div>

                        <div class="form-group">
                            <select name="citydeparture"  class="form-control"  type="text" required=""  inputmode="text" >
                                <option value="1">Tunja</option>
                                <option value="2">Cali</option>
                                <option value="3">Duitama</option>
                                <option value="1001">Bucaramanga</option>
                                <option value="200">Paipa</option>
                                <option value="201">Pesca</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <select name="cityarrival"  class="form-control"  type="text" required=""  inputmode="text" >
                                <option value="1">Tunja</option>
                                <option value="2">Cali</option>
                                <option value="3">Duitama</option>
                                <option value="1001">Bucaramanga</option>
                                <option value="200">Paipa</option>
                                <option value="201">Pesca</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="titleFormCarga">fecha de salida</label>
                            <input class="form-control" name="datedeparture" type="date" required="" placeholder="fecha de partida" value="${space.dateDeparture}">
                        </div>
                        <div class="form-group">
                            <label class="titleFormCarga">fecha de llegada</label>
                            <input class="form-control" name="datearrival" type="date" required="" placeholder="fecha de llegada" value="${space.dateArrival}">
                        </div>
                        <div>
                            <button class="btn btn-info mt-2" style="width:40%;" type="submit">guardar</button>
                            <button class="btn btn-info mt-2" style="width:40%;" type="reset">cancelar</button>

                        </div>
                    </form>
                    <form action="space" method="post" >
                        <input type="hidden" name="_method" value="delete" />
                        <button class="btn btn-info mt-2" style="width:40%;" type="submit">eliminar espacio</button>
                    </form>
                </div>
            </div>
            <div class="col-lg-6 d-flex align-items-end" id="bg-block" style="background-image:url(&quot;assets/img/cargaImg.png&quot;);background-size:cover;background-position:center center;">
            </div>
        </div>
    </div>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
    <script src="assets/js/script.min.js"></script>
</body>

<script>

</script>
</html>
