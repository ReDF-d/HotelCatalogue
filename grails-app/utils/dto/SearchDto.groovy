package dto

class SearchDto {

    SearchDto() {

    }

    SearchDto(String hotelName, String country) {
        this.hotelName = hotelName
        this.country = country
    }

    String hotelName
    String country
}
