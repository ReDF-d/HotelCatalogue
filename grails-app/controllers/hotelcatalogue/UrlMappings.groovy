package hotelcatalogue

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        get "/"(controller: 'Search', action: 'index')
        get "/search"(controller: 'Search', action: 'index')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
