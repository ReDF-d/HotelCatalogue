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

    def update(HotelDto hotelDto) {
        if (request.method == "GET") {
            Hotel hotel = Hotel.get(Long.parseLong(params.id))
            return render(view: "update", model: [hotel: hotel])
        }
        List<String> errorList = hotelService.save(hotelDto)
        Hotel hotel = Hotel.get(Long.parseLong(params.id))
        if (errorList.empty)
            redirect action: "index", method: "GET"
        else
            [errorList: errorList, hotel: hotel]
    }

    def create(HotelDto hotel) {
        if (request.method == "GET") {
            return render(view: "create", model: [errorList: Collections.emptyList()])
        }
        List<String> errorList = hotelService.save(hotel)
        if (errorList.empty)
            redirect action: "index", method: "GET"
        else
            [errorList: errorList]
    }

    def delete(Long id) {
        hotelService.delete(id)
        redirect action: "index", method: "GET"
    }
}
