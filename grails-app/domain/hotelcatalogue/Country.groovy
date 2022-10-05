package hotelcatalogue

class Country {
    String name
    String capital
    static hasMany = [hotels: Hotel]

    static constraints = {
        name unique: true, size: 1..255
        capital size: 1..128
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Country country = (Country) o

        if (capital != country.capital) return false
        return  (name != country.name)
    }

    int hashCode() {
        int result
        result = name.hashCode()
        return  31 * result + capital.hashCode()
    }
}
