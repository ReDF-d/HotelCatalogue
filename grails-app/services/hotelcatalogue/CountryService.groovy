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

    List<String> save(CountryDto countryDto) {
        List<String> errors = new ArrayList<>()
        Country country = createCountryFromDto(countryDto, errors)
        if (errors.empty) {
            country.save()
            return Collections.emptyList()
        }
        return errors
    }

    def createCountryFromDto(CountryDto countryDto, errors) {
        Country country
        if (countryDto.id != null)
            country = Country.findById(countryDto.id)
        else
            country = new Country()

        if (countryDto.name.length() == 0 || countryDto.name.length() > 255)
            errors.add("Название страны должно иметь длину от 1 до 255 символов")

        Country existingCountry = Country.findByNameIlike(countryDto.name)
        if (existingCountry != null && existingCountry.id != country.id && existingCountry.name.equalsIgnoreCase(countryDto.name))
            errors.add("Страна с таким названием уже существует")

        if ((countryDto.capital.length() == 0 || countryDto.capital.length() > 128))
            errors.add("Название столицы должно иметь от 1 до 128 символов")

        if (!errors.empty)
            return new Country()

        country.name = countryDto.name
        country.capital = countryDto.capital
        return country
    }

    def delete(id) {
        Country.get(id).delete()
    }
}
