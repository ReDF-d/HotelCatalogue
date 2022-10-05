<!DOCTYPE html>
<html>
<head>
    <title>Справочник отелей</title>
    <asset:javascript src="bootstrap.js"/>
    <asset:stylesheet src="application.css"/>
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
    <h1 class="text-center my-4">Справочник отелей</h1>

    <div>
        <table class="table">
            <tr class="p-3 text-center" style="font-size: 18px">
                <th class="align-middle">Название отеля</th>
                <th class="align-middle">Страна отеля</th>
                <th class="align-middle">Звёздность</th>
                <th class="align-middle">Сайт</th>
                <th class="align-middle">Действие</th>
                <td><g:link class="btn btn-primary" action="create">Добавить отель</g:link></td>
            </tr>
            <g:each in="${hotelList}">
                <tr class="p-3 text-center">
                    <td><a href="../hotel/show/${it.id}">${it.name}</a></td>
                    <td><a href="../country/show/${it.country.id}">${it.country.name}</a></td>
                    <td>${it.starRating}</td>
                    <td><a href="${it.siteAddress}" target="_blank">${it.siteAddress}</a></td>
                    <td class="d-flex justify-content-center">
                        <g:form action="update" params="[id: it.id]" method="get">
                            <fieldset>
                                <input class="btn btn-primary mr-2" type="submit" value="Редактировать"/>
                            </fieldset>
                        </g:form>
                        <g:form resource="${it}" method="DELETE">
                            <fieldset>
                                <input class="btn btn-danger" type="submit" value="Удалить"/>
                            </fieldset>
                        </g:form>
                    </td>
                    <td></td>
                </tr>
            </g:each>
        </table>
    </div>
</div>
</body>
</html>