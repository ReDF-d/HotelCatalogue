package hotelcatalogue

import dto.HotelDto
import grails.gorm.transactions.Transactional

import java.util.regex.Pattern

@Transactional
class HotelService {

    def get(id) {
        Hotel.get(id)
    }

    def list() {
        Hotel.list()
    }

    Hotel save(HotelDto hotelDto) {
        Hotel hotel = createHotelFromDto(hotelDto)
        if (!hotel.errors.hasErrors()) {
            hotel.save()
        }
        return hotel
    }


    def save(Hotel hotel) {
        hotel.save()
    }

    def delete(id) {
        Hotel.get(id).delete()
    }

    def createHotelFromDto(HotelDto hotelDto) {
        Hotel hotel
        if (hotelDto.id != null)
            hotel = Hotel.findById(hotelDto.id)
        else
            hotel = new Hotel()

        if (hotelDto.name.length() == 0 || hotelDto.name.length() > 255)
            hotel.errors.reject("hotel.name.length","Название отеля должно быть от 1 до 255 символов")

        Hotel existingAddress = Hotel.findBySiteAddress(hotelDto.siteAddress)
        if (hotelDto.siteAddress != null && existingAddress != null && existingAddress.id != hotel.id) {
            hotel.errors.reject("hotel.siteAddress.alreadyExists","Сайт с таким адресом уже существует")
        }

        Pattern urlPattern = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")
        if (hotelDto.siteAddress != null && !urlPattern.matcher(hotelDto.siteAddress).matches())
            hotel.errors.reject("hotel.siteAddress.invalidFormat", "Неверный адрес сайта")

        Country country = Country.findByNameIlike(hotelDto.country)
        if (country == null)
            hotel.errors.reject("hotel.country.notExists","Страна не существует")

        Hotel existingHotel = Hotel.findByNameIlike(hotelDto.name)
        if (existingHotel != null && hotel.id != existingHotel.id && existingHotel.country.name == country.name)
            hotel.errors.reject("hotel.alreadyExists", "Такой отель уже есть в этой стране")

        if (!hotel.errors.hasErrors()) {
            hotel.name = hotelDto.name
            hotel.country = country
            hotel.starRating = hotelDto.starRating
            hotel.siteAddress = hotelDto.siteAddress != null ? hotelDto.siteAddress : null
        }
        return hotel
    }
}
