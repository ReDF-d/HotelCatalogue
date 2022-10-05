<!DOCTYPE html>
<html>
<head>
    <title>Добавить страну</title>
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
                <a class="nav-link" href="${request.contextPath}/hotel">Отели</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${request.contextPath}/country">Страны</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container-fluid">
    <h1 class="text-center my-4">Добавить страну</h1>

    <div>
        <g:each in="${errorList}">
            <p class="text-center" style="color: red; font-size: 17px; font-weight: bold">${it}</p>
        </g:each>
        <g:form resource="${this.country}" method="POST" action="create">
            <fieldset>
                <div class="row p-2">
                    <div class="text-right col-6"><span>Название страны</span></div>

                    <div class="col-2"><g:textField class="form-control" required="true" name="name"/></div>
                </div>

                <div class="row p-2">
                    <div class="text-right col-6"><span>Столица</span></div>

                    <div class="col-2"><g:textField class="form-control" required="true" name="capital"/></div>
                </div>

                <div class="row">
                    <div class="col-6 text-right"><g:submitButton class="btn btn-primary ml-5" value="Добавить"
                                                                  name="create"/></div>
                </div>
            </fieldset>
        </g:form>
    </div>
</div>
</body>
</html>