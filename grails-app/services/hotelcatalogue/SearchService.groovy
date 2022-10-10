package hotelcatalogue

import dto.SearchDto
import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class SearchService {

    def search(SearchDto searchDto, GrailsParameterMap params) {
        def criteria = Hotel.createCriteria()
        return criteria.list() {
            if (!(searchDto.hotelName == null))
                ilike("name", "%" + searchDto.hotelName + "%")
            eq("country", Country.findByNameIlike(searchDto.country))
            maxResults(params.max as int)
            firstResult(params.offset as int)
            order("starRating", "desc")
            order("name", "asc")
        }
    }

    def searchTotalCount(SearchDto searchDto) {
        searchDto.hotelName != null ?
                Hotel.countByNameIlikeAndCountry("%" + searchDto.hotelName +"%", Country.findByNameIlike(searchDto.country))
                : Hotel.countByCountry(Country.findByNameIlike(searchDto.country))
    }
}
