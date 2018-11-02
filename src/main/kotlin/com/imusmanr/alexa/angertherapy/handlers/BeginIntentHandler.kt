package com.imusmanr.alexa.angertherapy.handlers

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.intentName
import java.util.*

class BeginIntentHandler : RequestHandler {
    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(intentName("HelloWorldIntent"))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        val speechText = "Hello, let's get started. Why don't you tell me what is the negative emotion " +
                "you're most feeling at this moment?"
        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard("Anger Therapy: ", speechText)
                .withReprompt(speechText)
                .build()
    }
}