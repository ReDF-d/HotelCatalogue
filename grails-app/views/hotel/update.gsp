<%@ page import="hotelcatalogue.Country" %>
<!DOCTYPE html>
<html>
<head>
    <title>Редактировать отель</title>
    <asset:stylesheet src="application.css"/>
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
                <a class="nav-link" href="${request.contextPath}/">Поиск</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="${request.contextPath}/hotel">Отели</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${request.contextPath}/country">Страны</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container-fluid">
    <h1 class="text-center my-4">Редактировать отель</h1>

    <div>
        <g:each in="${errorList}">
            <p class="text-center" style="color: red; font-weight: bold; font-size: 17px">${it.defaultMessage}</p>
        </g:each>
        <g:form resource="${this.hotel}" method="POST" action="update">
            <fieldset>
                <div class="row p-2">
                    <div class="text-right col-6">Название отеля</div>

                    <div class="col-2">
                        <g:textField class="form-control" name="name" required="true" type="text"
                                     value="${hotel.name}"/></div>
                </div>

                <div class="row p-2">
                    <div class="text-right col-6">Страна отеля</div>

                    <div class="col-2"><g:select class="form-control" name="country" required="true"
                                                 from="${Country.list()}"
                                                 value="${hotel.country.name}" optionValue="name"
                                                 optionKey="name"/></div>
                </div>

                <div class="row p-2">
                    <div class="text-right col-6">Звёздность</div>

                    <div class="col-2"><g:select class="form-control" name="starRating" required="true" from="${1..5}"
                                                 value="${hotel.starRating}"/></div>
                </div>

                <div class="row p-2">
                    <div class="text-right col-6">Адрес сайта</div>

                    <div class="col-2"><g:textField class="form-control" name="siteAddress"
                                                    value="${hotel.siteAddress}"/></div>
                </div>

                <div class="row p-2">
                    <div class="col-6 text-right"><g:submitButton class="btn btn-primary ml-5" name="update"
                                                                  value="Обновить"/></div>
                </div>
            </fieldset>
        </g:form>
    </div>
</div>
</body>
</html>