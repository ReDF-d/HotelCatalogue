package hotelcatalogue

import dto.HotelDto

class HotelController {

    def hotelService

    def index() {
        respond hotelService.list()
    }

    def show(Long id) {
        respond hotelService.get(id)
    }

    def edit() {
        Hotel hotel = Hotel.get(Long.parseLong(params.id))
        return render(view: "update", model: [hotel: hotel])
    }

    def update(HotelDto hotelDto) {
        Hotel hotel = hotelService.save(hotelDto)
        if (!hotel.errors.hasErrors())
            redirect action: "index", method: "GET"
        else
            [errorList: hotel.errors.allErrors, hotel: hotel]
    }

    def create() {
        return render(view: "create")
    }

    def save(HotelDto hotelDto) {
        Hotel hotel = hotelService.save(hotelDto)
        if (!hotel.errors.hasErrors())
            redirect action: "index", method: "GET"
        else
            render(view:"create", model:[errorList: hotel.errors.allErrors])
    }

    def delete(Long id) {
        hotelService.delete(id)
        redirect action: "index", method: "GET"
    }
}
