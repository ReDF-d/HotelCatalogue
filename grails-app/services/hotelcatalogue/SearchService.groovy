package hotelcatalogue

import dto.SearchDto
import grails.gorm.transactions.Transactional

@Transactional
class SearchService {

    List<Hotel> search(SearchDto searchDto) {
        def criteria = Hotel.createCriteria()
        return criteria.list {
            if(!(searchDto.hotelName == null))
                ilike("name", "%" + searchDto.hotelName + "%")
                and {
                    eq("country", Country.findByNameIlike(searchDto.country))
                }
            order("starRating", "desc")
            order("name", "asc")
        }
    }
}
