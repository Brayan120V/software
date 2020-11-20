<%-- 
    Document   : updateTruck
    Created on : 19/11/2020, 07:55:05 PM
    Author     : brayan
--%>
<%@page import="model.Truck"%>
<%
    Truck truck = (Truck) request.getSession().getAttribute("truck");
    String cardid = (String) request.getSession().getAttribute("cardid");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Perfil Camion</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/typicons/2.0.9/typicons.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
        <link rel="stylesheet" href="assets/css/styles.min.css">
    </head>

    <body >
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
                                <div class="dropdown-menu show"
                                     role="menu" style="background-color: #cf6666;">
                                    <a class="dropdown-item" role="presentation" href="profile.jsp" style="color: rgb(255,255,255);">
                                        <i class="fa fa-user"></i>&nbsp;perfil
                                    </a>
                                    <a class="dropdown-item" role="presentation" href="listTruck.jsp" style="color: rgb(255,255,255);">
                                        <i class="fa fa-truck"></i>&nbsp;mis camiones
                                    </a>
                                    <a class="dropdown-item" role="presentation" href="listSpace.jsp" style="color: rgb(255,255,255);">
                                        <i class="fa fa-archive"></i>&nbsp;mis espacios
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <div class="container profile profile-view" id="profile" style="background-color: rgba(237,237,237,0.42);margin-top: 5%;">
            <div class="row">
                <div class="col-md-12 alert-col relative">
                    <div class="alert alert-info text-center absolue center" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button><span>Profile save with success</span></div>
                </div>
            </div>
            <form action="truck" method="post">
                <input type="hidden" name="_method" value="put" />
                <div class="form-row profile-row">
                    <div class="col-md-4 offset-lg-0 relative" style="background-color: rgba(171,203,232,0.24);">
                        <div class="avatar">
                            <div class="pulse animated avatar-bg center" style="filter: blur(0px) brightness(97%) grayscale(0%) hue-rotate(0deg) invert(0%);height: 200px;width: 200px;">
                            </div>
                            <h1 class="display-1 text-lowercase text-center" data-aos="fade" data-aos-duration="1350" data-aos-delay="700" style="color: rgb(255,255,255);filter: blur(0px);font-size: 35PX;">doble Troque</h1>
                        </div>
                        <input type="file" class="form-control" name="avatar-file" accept="image/*" style="margin-top: 30px;filter: saturate(136%) sepia(0%);">
                    </div>
                    <div class="col-md-8">
                        <div class="form-group">
                            <input class="form-control" id="license" type="text" disabled="true" name="license" style="margin: 15px;" placeholder="placa" minlength="2">
                            <input class="form-control" id="type" type="text" autocomplete="on" required="" name="type" style="margin: 15px;" placeholder="tipo de camion" autofocus="" minlength="2">
                            <input class="form-control" id="width" type="number" autocomplete="on" required="" name="width" style="margin: 15px;" placeholder="ancho de carroceria" inputmode="tel" autofocus="" minlength="1">
                            <input class="form-control" id="high" type="number" autocomplete="on" required="" name="high" style="margin: 15px;" placeholder="alto de carroceria" inputmode="tel" autofocus="" minlength="1">
                            <input class="form-control" id="long" type="number" autocomplete="on" required="" name="long" style="margin: 15px;" placeholder="largo de carroceria" inputmode="tel" autofocus="" minlength="1">
                            <input class="form-control" id="max" type="number" autocomplete="off" required="" name="max" style="margin: 15px;" placeholder="peso maximo" autofocus="" inputmode="url" minlength="4">
                        </div>
                        <iframe name="dummyframe" id="dummyframe" style="display: none;"></iframe>

                        <hr>
                        <div class="form-row">
                            <div class="col-md-12 content-right">
                                <button class="btn btn-primary form-btn" type="submit" style="background-color: #cf6666;">guardar</button>
                                <button class="btn btn-danger form-btn" type="reset" style="background-color: #cf6666;">cancelar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <form action="truck" method="post" >
                <input type="hidden" name="_method" value="delete" />
                <button class="btn btn-danger text-center form-btn" type="submit" style="background-color: #cf6666;margin-left: 72%;margin-top: 2%;max-width: 300px;width: 200px;">inactivar</button>
            </form>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
        <script src="assets/js/script.min.js"></script>
    </body>
    <script>


        var license = '${truck.getLicensePlate()}';
        var type = '${truck.getType()}';
        var width = '${truck.getWidthBodywork()}';
        var high = '${truck.getHighBodywork()}';
        var long = '${truck.getLongBodywork()}';
        var max = '${truck.getMaxWeight()}';

        console.log(license);
        var inputLicense = document.getElementById("license");
        var inputType = document.getElementById("type");
        var inputWidth = document.getElementById("width");
        var inputHigh = document.getElementById("high");
        var inputLong = document.getElementById("long");
        var inputMax = document.getElementById("max");

        inputLicense.value = license;
        inputType.value = type;
        inputWidth.value = width;
        inputHigh.value = high;
        inputLong.value = long;
        inputMax.value = max;

    </script>
</html>
