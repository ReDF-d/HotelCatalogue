package hotelcatalogue

class Country {
    String name
    String capital
    static hasMany = [hotels: Hotel]

    static constraints = {
        name unique: true, size: 1..255
        capital size: 1..128
    }
}
