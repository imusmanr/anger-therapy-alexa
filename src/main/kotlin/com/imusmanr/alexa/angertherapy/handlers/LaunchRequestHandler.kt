package com.imusmanr.alexa.angertherapy.handlers

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.LaunchRequest
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.requestType
import java.util.*

class LaunchRequestHandler : RequestHandler {
    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(requestType<LaunchRequest>(LaunchRequest::class.java))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        val speechText = "Welcome to Anger Therapy, a platform for overcoming anger. Whenever you're ready, say Begin, " +
                "to get started."
            return input.responseBuilder
                    .withSpeech(speechText)
                    .withSimpleCard("Anger Therapy", speechText)
                    .withReprompt(speechText)
                    .build()
    }
}