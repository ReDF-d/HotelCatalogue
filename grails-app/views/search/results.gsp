<html>
<head>
    <title>Поиск</title>
    <asset:stylesheet src="bootstrap.css"/>
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

    <h1 class="text-center my-4">Результаты</h1>
    <g:if test="${results.empty}">
        <h2 class="text-center my-4">По Вашему запросу ничего не найдено</h2>
        <div class="text-center"><a class="btn btn-primary" href="${request.contextPath}/">Новый поиск</a></div>
    </g:if>
    <g:else>
        <div class="row p-3">
            <div class="col ml-5"><p>Найдено ${results.size()} результатов</p></div>
            <div class="col text-right mr-5"><a class="btn btn-primary" href="${request.contextPath}/">Новый поиск</a></div>
        </div>
        <table class="table">
            <tr class="p-3 text-center" style="font-size: 18px">
                <th>Звёздность</th>
                <th>Название</th>
                <th>Сайт</th>
            </tr>
            <g:each in="${results}">
                <tr class="p-3 text-center">
                    <td>${it.starRating}</td>
                    <td>${it.name}</td>
                <td>
                    <g:if test="${it.siteAddress != null}">
                        <a href="${it.siteAddress}" target="_blank">Перейти на сайт</a>
                    </g:if>
                </td>
                </tr>
            </g:each>
        </table>
    </g:else>
</div>
</body>
</html>