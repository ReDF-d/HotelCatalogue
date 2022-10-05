package hotelcatalogue

import dto.CountryDto

class CountryController {

    def countryService

    def index() {
        respond countryService.list()
    }

    def show(Long id) {
        respond countryService.get(id)
    }

    def create(CountryDto country) {
        if (request.method == "GET") {
            return render(view: "create", model: [errorList: Collections.emptyList()])
        }
        List<String> errorList = countryService.save(country)
        if (errorList.empty)
            redirect action: "index", method: "GET"
        else
            [errorList: errorList]
    }

    def delete(Long id) {
        countryService.delete(id)
        redirect action: "index", method: "GET"
    }

    def update(CountryDto countryDto) {
        if (request.method == "GET") {
            Country country = Country.get(Long.parseLong(params.id))
            return render(view: "update", model: [country: country])
        }
        List<String> errorList = countryService.save(countryDto)
        Country country = Country.get(Long.parseLong(params.id))
        if (errorList.empty)
            redirect action: "index", method: "GET"
        else
            [errorList: errorList, country: country]
    }
}
