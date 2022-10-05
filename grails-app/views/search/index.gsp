<%@ page import="hotelcatalogue.Country" %>
<html>
<head>
    <title>Поиск</title>
    <asset:stylesheet src="bootstrap.css"/>
    <asset:javascript src="bootstrap.js"/>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav" style="font-size: 18px">
            <li class="nav-item">
                <a class="nav-link active" href="${request.contextPath}/">Поиск</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${request.contextPath}/hotel">Отели</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${request.contextPath}/country">Страны</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container-fluid">
    <h1 class="text-center my-4">Поиск</h1>

    <div>
        <g:form method="POST" action="results">
            <fieldset>
                <div class="row p-2">
                    <div class="col-6 text-right">Название отеля</div>
                    <div class="col-2"><g:textField name="hotelName" type="text"/></div>
                </div>
                <div class="row p-2">
                    <div class="col-6 text-right">Выберите страну</div>
                    <div class="col-2"><g:select class="form-control" name="country" required="true" from="${Country.list()}"
                                                 value="${Country.list().size() > 0 ? Country.list().first().name : ""}" optionValue="name"
                                                 optionKey="name"/></div>
                </div>
                <div class="row">
                    <div class="col-6 text-right"> <g:submitButton class="btn btn-primary" name="search" value="Найти"/></div>
                </div>
            </fieldset>

        </g:form>
    </div>
</div>
</body>
</html>