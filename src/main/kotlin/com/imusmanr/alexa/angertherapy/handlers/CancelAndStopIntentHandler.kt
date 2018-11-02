package com.imusmanr.alexa.angertherapy.handlers

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.intentName
import java.util.*

class CancelAndStopIntentHandler : RequestHandler {
    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(intentName("AMAZON.StopIntent").or(intentName("AMAZON.CancelIntent")))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        val speechText = "Talk to you next time!"
        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard("Anger Therapy: Cancel", speechText)
                .build()
    }
}