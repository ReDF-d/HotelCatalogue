<!DOCTYPE html>
<html>
<head>
    <title>Справочник стран</title>
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
                <a class="nav-link" href="${request.contextPath}/hotel">Отели</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${request.contextPath}/country">Страны</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container-fluid">
    <h1 class="text-center my-4">Справочник стран</h1>

    <div>
        <table class="table">
            <tr style="font-size: 18px" class="p-3 text-center">
                <th class="align-middle">Название</th>
                <th class="align-middle">Столица</th>
                <th class="align-middle">Действия</th>
                <td><g:link class="btn btn-primary" action="create">Добавить страну</g:link></td>
            </tr>
            <g:each in="${countryList}">
                <tr class="p-3 text-center">
                    <td><a href="../country/show/${it.id}">${it.name}</a></td>
                    <td>${it.capital}</td>
                    <td class="d-flex justify-content-center">
                        <g:form action="update" params="[id: it.id]" method="get">
                            <fieldset style="border: none">
                                <input class="btn btn-primary mr-2" type="submit" value="Редактировать"/>
                            </fieldset>
                        </g:form>
                        <g:form resource="${it}" method="DELETE">
                            <fieldset style="border: none">
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