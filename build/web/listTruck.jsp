<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Truck"%>
<%
    ArrayList<Truck> trucks = (ArrayList<Truck>) request.getSession().getAttribute("trucks");
    String cardid = (String) request.getSession().getAttribute("cardid");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>mis Camiones</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/typicons/2.0.9/typicons.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">

        <link rel="stylesheet" href="assets/css/styles.min.css">
        <link rel="stylesheet" href="assets/css/targets.css">

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

        <section id="seccionPost">
            <div class="Title">
                <h1>Mis Camiones</h1>
            </div>
            <br>
            <c:if test="${(sessionScope.trucks == null) || (sessionScope.trucks.size() == 0)}">
                <div class="TitleDontPost">
                    <h1>No hay camiones registrados</h1>
                </div> 
            </c:if>
            <a href="registerTruck.jsp">
                <button class="btn btn-danger text-center form-btn"  style="background-color: #cf6666;margin-left: 44%;margin-top: 2%;max-width: 300px;width: 200px;">Crear camión</button>
            </a> 
            <hr> 
            <c:if test="${sessionScope.trucks!=null}">
                <div class="cards">
                    <c:forEach var="truck" items="${sessionScope.trucks}">
                        <form action="truck" method="get">
                            <input hidden="true" name="method" value="unit"></input>
                            <input id="inp" hidden="true" name="option" value="${truck.licensePlate}"></input>
                            <div id="card" class="card">
                                <div class="card__image-holder">
                                    <img class="card__image" src="${truck.photo}" alt="wave" />
                                </div>
                                <div class="card-title">
                                    <small>${truck.licensePlate}</small>
                                </div>
                            </div>
                            <button hidden="true" id="findTruck" type="submit"></button>
                        </form>
                    </c:forEach>
                </div>
            </c:if>

        </section>
        <iframe name="dummyframe" id="dummyframe" style="display: none;"></iframe>
        <form hidden="" action="truck" target="dummyframe">
            <input hidden="true" name="method" value="all"></input>
            <button id="findTrucks" type="submit"></button>
        </form>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
        <script src="assets/js/script.min.js"></script>
        <script src="assets/js/targets.js"></script>
    </body>

    <script>
        var button = document.getElementById("findTrucks");
        button.click();
        button.click();

        var cards = document.querySelectorAll("#card");

        for (var i = 0; i < cards.length; i++) {
            console.log(cards[i]);
            cards[i].onclick = function (e) {
                console.log(e.path[2].innerText);
                var car = document.getElementById("findTruck");
                var inp = document.getElementById("inp");
                inp.value = e.path[2].innerText;
                car.click();
            };
        }

    </script>
</html>
