package hotelcatalogue

import dto.CountryDto
import grails.gorm.transactions.Transactional

@Transactional
class CountryService {

    def get(id) {
        Country.get(id)
    }

    def list() {
        Country.list()
    }

    Country save(CountryDto countryDto) {
        Country country = createCountryFromDto(countryDto)
        if (!country.errors.hasErrors()) {
            country.save()
        }
        return country
    }

    def createCountryFromDto(CountryDto countryDto) {
        Country country
        if (countryDto.id != null)
            country = Country.findById(countryDto.id)
        else
            country = new Country()

        if (countryDto.name.length() == 0 || countryDto.name.length() > 255)
            country.errors.reject("country.name.length", "Название страны должно иметь длину от 1 до 255 символов")

        Country existingCountry = Country.findByNameIlike(countryDto.name)
        if (existingCountry != null && existingCountry.id != country.id && existingCountry.name.equalsIgnoreCase(countryDto.name))
            country.errors.reject("country.name.alreadyExists", "Страна с таким названием уже существует")

        if ((countryDto.capital.length() == 0 || countryDto.capital.length() > 128))
            country.errors.reject("country.capital.length", "Название столицы должно иметь от 1 до 128 символов")

        if (!country.errors.hasErrors()) {
            country.name = countryDto.name
            country.capital = countryDto.capital
        }
        return country
    }

    def delete(id) {
        Country.get(id).delete()
    }
}
