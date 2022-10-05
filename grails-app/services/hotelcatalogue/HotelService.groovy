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

    List<String> save(HotelDto hotelDto) {
        List<String> errors = new ArrayList<>()
        Hotel hotel = createHotelFromDto(hotelDto, errors)

        if (errors.empty) {
            hotel.save()
            return Collections.emptyList()
        }
        return errors
    }


    def save(Hotel hotel) {
        hotel.save()
    }

    def delete(id) {
        Hotel.get(id).delete()
    }

    def createHotelFromDto(HotelDto hotelDto, List<String> errors) {
        Hotel hotel
        if (hotelDto.id != null)
            hotel = Hotel.findById(hotelDto.id)
        else
            hotel = new Hotel()

        if (hotelDto.name.length() == 0 || hotelDto.name.length() > 255)
            errors.add("Название отеля должно быть от 1 до 255 символов")

        Hotel existingAddress = Hotel.findBySiteAddress(hotelDto.siteAddress)
        if (hotelDto.siteAddress != null && existingAddress != null && existingAddress.id != hotel.id) {
            errors.add("Сайт с таким адресом уже существует")
        }

        Pattern urlPattern = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")
        if (hotelDto.siteAddress != null && !urlPattern.matcher(hotelDto.siteAddress).matches())
            errors.add("Неверный адрес сайта")

        Country country = Country.findByNameIlike(hotelDto.country)
        if (country == null)
            errors.add("Страна не существует")

        Hotel existingHotel = Hotel.findByNameIlike(hotelDto.name)
        if (existingHotel != null && hotel.id != existingHotel.id && existingHotel.country == country)
            errors.add("Такой отель уже есть в этой стране")

        if (!errors.empty)
            return new Hotel()
        hotel.name = hotelDto.name
        hotel.country = country
        hotel.starRating = hotelDto.starRating
        hotel.siteAddress = hotelDto.siteAddress != null ? hotelDto.siteAddress : null
        return hotel
    }
}
