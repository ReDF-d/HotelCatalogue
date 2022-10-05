<!DOCTYPE html>
<html>
<head>
    <title>${this.hotel.name}</title>
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
    <h1 class="text-center my-4">Отель</h1>

    <div>
        <table class="table">
            <tr class="p-3 text-center" style="font-size: 18px">
                <th>Название отеля</th>
                <th>Страна отеля</th>
                <th>Звёздность</th>
                <th>Сайт</th>
            </tr>
            <tr class="p-3 text-center">
                <td>${this.hotel.name}</td>
                <td><a href="/country/show/${this.hotel.country.id}">${this.hotel.country.name}</a></td>
                <td>${this.hotel.starRating}</td>
                <td>${this.hotel.siteAddress}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>