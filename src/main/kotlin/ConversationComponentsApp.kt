package main.kotlin

import com.google.actions.api.ActionRequest
import com.google.actions.api.ActionResponse
import com.google.actions.api.DialogflowApp
import com.google.actions.api.ForIntent
import com.google.api.services.actions_fulfillment.v2.model.SimpleResponse

class ConversationComponentsApp : DialogflowApp() {

    @Suppress("unused")
    @ForIntent("Default Welcome Intent")
    fun welcome(request: ActionRequest): ActionResponse {
        val responseBuilder = getResponseBuilder(request)
        responseBuilder
            .add(SimpleResponse()
                .setDisplayText("純情Action!")
                .setTextToSpeech("純情Action!Action!"))
        return responseBuilder.build()
    }
}
