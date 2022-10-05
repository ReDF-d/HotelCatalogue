package hotelcatalogue

import dto.SearchDto

class SearchController {

    SearchService searchService

    def index() {
        return render(view: "index")
    }

    def results(SearchDto searchDto) {
        List<Hotel> results = searchService.search(searchDto)
        return render (view:"results", model:[results: results])
    }
}
