<%-- 
    Document   : dashboard
    Created on : 19/11/2020, 05:42:43 PM
    Author     : brayan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>lobbyTransportador</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/typicons/2.0.9/typicons.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">

        <link rel="stylesheet" href="../assets/css/styles.min.css">
        <link rel="stylesheet" href="../assets/css/targets.css">

    </head>

    <body>
        <div>
            <nav class="navbar navbar-light navbar-expand-md navigation-clean" style="background-color: #cf6666;">
                <div class="container"><a class="navbar-brand" data-aos="fade-right" data-aos-duration="950" data-aos-delay="550" href="#" style="color: rgb(255,255,255);">TKRGO</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                    <div
                        class="collapse navbar-collapse" id="navcol-1">
                        <ul class="nav navbar-nav ml-auto">
                            <li class="nav-item" role="presentation"></li>
                            <li class="nav-item" role="presentation"></li>
                            <li class="nav-item" role="presentation"></li>
                            <li class="dropdown show nav-item">
                                <a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="true" href="#" style="color: rgb(255,255,255);">
                                    <i class="typcn typcn-cog-outline" style="color: rgb(255,255,255);"></i>
                                </a>
                                <div class="dropdown-menu show"
                                     role="menu" style="background-color: #cf6666;">
                                    <a class="dropdown-item" role="presentation" href="#" style="color: rgb(255,255,255);">
                                        <i class="fa fa-user"></i>&nbsp;perfil
                                    </a>
                                    <a class="dropdown-item" role="presentation" href="../camion/updateTruck.jsp" style="color: rgb(255,255,255);">
                                        <i class="fa fa-truck"></i>&nbsp;mis camiones
                                    </a>
                                    <a class="dropdown-item" role="presentation" href="#" style="color: rgb(255,255,255);">
                                        <i class="fa fa-archive"></i>&nbsp;mis espacios
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>

        <section id="seccionPost">
            <div class="Title">
                <h1>no hay espacios registrados</h1>
            </div>
            <br>
            <hr>

            <div class="cards">

                <div class="card">
                    <div class="card__image-holder">
                        <img class="card__image" src="https://source.unsplash.com/300x225/?wave" alt="wave" />
                    </div>
                    <div class="card-title">
                        <h2 style="color:#E0206F">
                            NUEVO <small>ESPACIO EN CAMION</small>
                        </h2>
                    </div>
                    <div class="card-flap flap1">
                        <div class="card-description">
                            PLACA : adskdas 
                        </div>
                    </div>
                </div>

                <div class="card">
                    <div class="card__image-holder">
                        <img class="card__image" src="https://source.unsplash.com/300x225/?beach" alt="beach" />
                    </div>
                    <div class="card-title">
                        <h2 style="color:#E0206F">
                            NUEVO <small>ESPACIO EN CAMION</small>
                        </h2>
                    </div>
                    <div class="card-flap flap1">
                        <div class="card-description">
                            PLACA : adskdas 
                        </div>
                    </div>
                </div>

                <div class="card">
                    <div class="card__image-holder">
                        <img class="card__image" src="https://source.unsplash.com/300x225/?mountain" alt="mountain" />
                    </div>
                    <div class="card-title">
                        <h2 style="color:#E0206F">
                            NUEVO <small>ESPACIO EN CAMION</small>
                        </h2>
                    </div>
                </div>
        </section>
        <iframe name="dummyframe" id="dummyframe" style="display: none;"></iframe>
        <form hidden="" action="person" target="dummyframe">
            <button id="findPerson" type="submit"></button>
        </form>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
        <script src="../assets/js/script.min.js"></script>
        <script src="../assets/js/targets.js"></script>
    </body>

    <script>
        var button = document.getElementById("findPerson");
        button.click();

        var name = '${person.getName()}';
        var cardid = '${person.getCardid()}';
        var password = '${person.getPassword()}';
        var phone = '${person.getPhone()}';

        var inputName = document.getElementById("name");
        var inputCardid = document.getElementById("cardid");
        var inputPassword = document.getElementById("password");
        var inputPhone = document.getElementById("phone");

        inputName.value = name;
        inputCardid.value = cardid;
        inputPassword.value = password;
        inputPhone.value = phone;

        console.log(inputName.value);
    </script>
</html>