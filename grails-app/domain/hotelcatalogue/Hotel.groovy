package hotelcatalogue

class Hotel {

    String name
    static belongsTo = [country: Country]
    int starRating
    String siteAddress

    static constraints = {
        name size: 1..255
        siteAddress unique:true, nullable: true
    }


}
