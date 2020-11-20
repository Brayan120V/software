<%-- 
    Document   : dashboard
    Created on : 12/11/2020, 09:06:48 PM
    Author     : brayan
--%>
<%@page import="model.Person"%>
<%
    Person person = (Person) request.getSession().getAttribute("person");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Profile</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/typicons/2.0.9/typicons.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
        <link rel="stylesheet" href="../assets/css/styles.min.css">
    </head>

    <body style="opacity: 1;background-image: url(&quot;../assets/img/408d9b011eb13f407bc659343477cf5c.jpg&quot;);background-size: cover;background-repeat: no-repeat;">
        <div>
            <nav class="navbar navbar-light navbar-expand-md navigation-clean" style="background-color: #cf6666;">
                <div class="container"><a class="navbar-brand" data-aos="fade-right" href="#" style="color: rgb(255,255,255);">TKRGO</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                    <div
                        class="collapse navbar-collapse" id="navcol-1">
                        <ul class="nav navbar-nav ml-auto">
                            <li class="nav-item" role="presentation"></li>
                            <li class="nav-item" role="presentation"></li>
                            <li class="nav-item" role="presentation"></li>
                            <li class="dropdown nav-item">
                                <a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#" style="color: rgb(255,255,255);">
                                    <i class="typcn typcn-cog-outline" style="color: rgb(255,255,255);"></i>
                                </a>
                                <div class="dropdown-menu" role="menu"
                                     style="background-color: #cf6666;">
                                    <a class="dropdown-item" role="presentation" href="#" style="color: rgb(255,255,255);">
                                        <i class="fa fa-user"></i>&nbsp;perfil</a>
                                    <a class="dropdown-item" role="presentation" href="#" style="color: rgb(255,255,255);">
                                    </a>
                                    <a
                                        class="dropdown-item" role="presentation" href="#" style="color: rgb(255,255,255);">
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <div class="container profile profile-view" id="profile" style="background-color: rgba(237,237,237,0.42);margin-top: 5%;">
            <iframe name="dummyframe" id="dummyframe" style="display: none;"></iframe>
            <form action="person" method="post" target="dummyframe">
                <input type="hidden" name="_method" value="put" />
                <div class="form-row profile-row">
                    <div class="col-md-4 offset-lg-0 relative" style="background-color: rgba(171,203,232,0.24);">
                        <div class="avatar">
                            <div class="pulse animated avatar-bg center" style="filter: blur(0px) brightness(97%) grayscale(0%) hue-rotate(0deg) invert(0%);height: 200px;width: 200px;">
                                <h1 class="display-1 text-lowercase text-center" data-aos="fade" data-aos-duration="1350" data-aos-delay="700" style="color: rgb(255,255,255);filter: blur(0px);font-size: 35PX;">PERFIL</h1>
                            </div>
                        </div><input type="file" class="form-control" name="avatar-file" accept="image/*" style="margin-top: 30px;filter: saturate(136%) sepia(0%);"></div>
                    <div class="col-md-8">
                        <div class="form-group">
                            <input id="name" class="form-control" type="text" autocomplete="on" name="name" style="margin: 15px;" placeholder="nombre" autofocus="" minlength="2" value="">
                            <input id="cardid" class="form-control" type="text" disabled="" name="cardid" style="margin: 15px;" >
                            <input id="phone" class="form-control" type="number" autocomplete="on" required=""  name="phone" style="margin: 15px;" placeholder="telefono" inputmode="tel" autofocus="" minlength="10">
                            <input id="password" class="form-control" type="password" autocomplete="off" required="" name="password" style="margin: 15px;" placeholder="contraseña" autofocus="" inputmode="url" minlength="4">
                        </div>

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
            <iframe name="dummyframe" id="dummyframe" style="display: none;"></iframe>
            <form action="person" method="post" >
                <input type="hidden" name="_method" value="delete" />
                <button class="btn btn-danger text-center form-btn" type="submit" style="background-color: #cf6666;margin-left: 72%;margin-top: 2%;max-width: 300px;width: 200px;">inactivar cuenta</button>
            </form>
            <iframe name="dummyframe" id="dummyframe" style="display: none;"></iframe>
            <form hidden="" action="person" target="dummyframe">
                <button id="findPerson" type="submit"></button>
            </form>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
        <script src="../assets/js/script.min.js"></script>
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
