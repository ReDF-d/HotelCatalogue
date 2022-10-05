package hotelcatalogue

class BootStrap {

    def init = { servletContext ->
        Country russia = new Country(name: "Россия", capital: "Москва").save()
        Country usa = new Country(name: "США", capital: "Вашингтон").save()
        Country china = new Country(name: "Китай", capital: "Пекин").save()
        new Hotel(name: "Park Hotel", country: russia, starRating: 4, siteAddress: "https://parkhotel.com").save()
        new Hotel(name: "Калина", country: russia, starRating: 3, siteAddress: "https://kalina-resort.ru").save()
        new Hotel(name: "Royal Hotel", country: usa, starRating: 5, siteAddress: "https://royalhotel.com").save()
        new Hotel(name: "Шанхай", country: china, starRating: 3).save()
    }
    def destroy = {
    }
}
