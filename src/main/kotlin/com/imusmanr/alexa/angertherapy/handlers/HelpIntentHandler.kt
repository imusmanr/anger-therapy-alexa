package com.imusmanr.alexa.angertherapy.handlers

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.intentName
import java.util.*

class HelpIntentHandler : RequestHandler {
    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(intentName("AMAZON.HelpIntent"))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        val speechText = "I am here to help you overcome anger. The way this works is, " +
                "you tell me how what you're feeling, and I try to help you understand that and calm down. " +
                "Whenever you're ready, say Begin to get started."
        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard("Anger Therapy: Help", speechText)
                .withReprompt(speechText)
                .build()
    }
}