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

    def create() {
        return render(view: "create")
    }

    def save(CountryDto countryDto) {
        Country country = countryService.save(countryDto)
        if (!country.errors.hasErrors())
            redirect action: "index", method: "GET"
        else
            render(view: "create", model:[errorList: country.errors.allErrors])
    }

    def delete(Long id) {
        countryService.delete(id)
        redirect action: "index", method: "GET"
    }

    def edit() {
        Country country = Country.get(Long.parseLong(params.id))
        return render(view: "update", model: [country: country])
    }

    def update(CountryDto countryDto) {
        Country country = countryService.save(countryDto)
        if (!country.errors.hasErrors())
            redirect action: "index", method: "GET"
        else
            [errorList: country.errors.allErrors, country: country]
    }
}
