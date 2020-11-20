<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Truck</title>
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
                        <div id='logo'>
                            <h2 class="text-info font-weight-light mb-5" style="margin-left: 12%;"> </i>NUEVO CAMION</h2>
                        </div>

                        <form action="truck" method="post" enctype="multipart/form-data">  
                            <input type="hidden" name="_method" value="post" />
                            <div class="form-group"><input name="image" class="form-control" type="file" accept="image/*"></div>
                            <div class="form-group"><input name="license" class="form-control" type="text" required="" placeholder="placa"></div>
                            <div class="form-group"><input name="type" class="form-control" type="text" required="" placeholder="tipo Camion"></div>
                            <div class="form-group"><input name="width" class="form-control" type="number" required="" placeholder="Ancho Carroceria"></div>
                            <div class="form-group"><input name="high" class="form-control" type="number" required="" placeholder="Alto Carroceria"></div>
                            <div class="form-group"><input name="long" class="form-control" type="number" required="" placeholder="Largo Carroceria"></div>
                            <div class="form-group"><input name="max" class="form-control" type="number" required="" placeholder="Peso maximo"></div>

                            <button class="btn btn-info mt-2" style="width:40%;" type="submit">Crear</button>
                            <button class="btn btn-info mt-2" style="width:40%;" type="reset">Cancelar</button>
                        </form>
                    </div>
                </div>
                <div class="col-lg-6 d-flex align-items-end" id="bg-block" style="background-image:url(&quot;assets/img/backgroundRegisterCa.png&quot;);background-size:cover;background-position:center center;">
                </div>
            </div>
        </div>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    </body>

</html>
