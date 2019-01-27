package main.kotlin

import io.ktor.application.*
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.request.ApplicationRequest
import io.ktor.request.receiveText
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing

@Suppress("unused") // Referenced in application.conf
fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)

    val actionsApp = ConversationComponentsApp()

    routing {
        get("/"){
            call.respond("worked!")
        }
        post("/") {
            val jsonBody: String = call.receiveText()
            val headerMap = getHeaderMap(call.request)
            val jsonResponse = actionsApp.handleRequest(jsonBody, headerMap).get()
            call.respond(jsonResponse)
        }
    }
}

fun getHeaderMap(request: ApplicationRequest): Map<String, String> {
    val headers = request.headers
    val headerMap = HashMap<String, String>()
    headers.forEach { k, v -> headerMap[k] = v.toString() }
    return headerMap
}

