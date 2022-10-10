package hotelcatalogue

import dto.SearchDto

class SearchController {

    SearchService searchService

    def index() {
        return render(view: "index")
    }

    def results(SearchDto searchDto) {
        def results = searchService.search(searchDto, params)
        def total = searchService.searchTotalCount(searchDto)
        return render(view: "results", model: [results: results, total: total],
                params: [hotelName: searchDto.hotelName, country: searchDto.country, max: params.max, offset: params.offset])
    }

    def paginateResults() {
        def searchDto = new SearchDto(params.hotelName, params.country)
        return results(searchDto)
    }
}
