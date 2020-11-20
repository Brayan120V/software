<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Register</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrapLoginRegister.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Alfa+Slab+One">
        <link rel="stylesheet" href="assets/css/LoginRegisterPage.css">

    </head>
    <body>
        <div id="simpleLogin"></div>
        <div class="container-fluid">
            <div class="row mh-100vh">
                <div class="col-10 col-sm-8 col-md-6 col-lg-6 offset-1 offset-sm-2 offset-md-3 offset-lg-0 align-self-center d-lg-flex align-items-lg-center align-self-lg-stretch bg-white p-5 rounded rounded-lg-0 my-5 my-lg-0" id="login-block">

                    <div class="m-auto w-lg-75 w-xl-50" style="margin-bottom: 60%; "> 
                        <div id='logo' ">
                            <img src="assets/img/caminero.png" style="height: 90px; width: 90px; margin-left: 36%; ">
                            <h2 class="text-info font-weight-light mb-5" style="margin-left: 29%;"> </i>REGISTRO</h2>
                        </div>

                        <form action="person" method="post"> 
                            <input hidden="" name="_method" value="post"></input>
                            <div class="form-group"><select name="role"  class="form-control"  type="text" required=""  inputmode="text" >
                                    <option value="transporter">Transportador</option>
                                    <option value="client">Cliente</option>
                                </select></div>  
                            <div class="form-group"><input class="form-control" type="text" required="" name="name" placeholder="nombre"></div>
                            <div class="form-group"><input class="form-control" type="number" required="" name="cardid" placeholder="cedula"></div>
                            <div class="form-group"><input class="form-control" type="number" required="" name="phone" placeholder="telefono"></div>
                            <div class="form-group"><input class="form-control" type="password" required="" name="password" placeholder="contraseña"></div>
                            <div><input type="checkbox" required=""><i class="terminosYcondiciones">terminos y condiciones</i></div>
                            <button class="btn btn-info mt-2" style="width:40%;" type="submit">crear</button>
                        </form>
                    </div>
                </div>
                <div class="col-lg-6 d-flex align-items-end" id="bg-block" style="background-image:url(&quot;assets/img/backgroundRegisterUS.png&quot;);background-size:cover;background-position:center center;">
                </div>
            </div>
        </div>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>