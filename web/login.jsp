<%-- 
    Document   : login
    Created on : 18/11/2020, 11:50:10 PM
    Author     : brayan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Login</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrapLoginRegister.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Alfa+Slab+One">
        <link rel="stylesheet" href="assets/css/LoginRegisterPage.css">  
    </head>
    <body>
        <div id="simpleLogin"></div>
        <div class="container-fluid">
            <div class="row mh-100vh">
                <div class="col-10 col-sm-8 col-md-6 col-lg-6 offset-1 offset-sm-2 offset-md-3 offset-lg-0 align-self-center d-lg-flex align-items-lg-center align-self-lg-stretch bg-white p-5 rounded rounded-lg-0 my-5 my-lg-0" id="login-block">

                    <div class="m-auto w-lg-75 w-xl-50">
                        <div id='logo'>
                            <img src="assets/img/logo.png" style="height: 300px; width: 400px;">
                        </div>
                        <h2 class="text-info font-weight-light mb-5"></i>Iniciar Sesion</h2>
                        <form action="login" method="post"> 
                            <div class="form-group"><input name="cardid" class="form-control" type="number" required=""  placeholder="cédula"></div>
                            <div class="form-group"><input name="password" class="form-control" type="password" required="" placeholder="contraseña"></div>
                            <button class="btn btn-info mt-2" type="submit">INGRESAR</button>
                        </form>
                    </div>
                </div>
                <div class="col-lg-6 d-flex align-items-end" id="bg-block" style="background-image:url(&quot;assets/img/backgroundRegisterCamion.png&quot;);background-size:cover;background-position:center center;">
                </div>
            </div>
        </div>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    </body>

</html>