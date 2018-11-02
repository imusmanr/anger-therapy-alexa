package com.imusmanr.alexa.angertherapy.handlers

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.IntentRequest
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.intentName
import java.util.*

class AnswerIntentHandler : RequestHandler {

    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(intentName("AnswerIntent"))
    }

    override fun handle(input: HandlerInput): Optional<Response> {

        val intentRequest = input.requestEnvelope.request as IntentRequest
        val emotion = intentRequest.intent.slots["Answer"]?.getValue()

        val speechText: String
        when (emotion) {
            "disappointed" -> {
                println("Got disappointed.")
                speechText = "I'm sorry to hear that. But don't worry, this is a common emotion. Let me explain... " +
                        "Disappointment is caused by the non-fulfillment of one's hopes or expectations. So the best way to" +
                        "overcome this is by remembering that you, yourself, are in control of your expectations. No one else. " +
                        "Is there anything else you're feeling too?"
            }

            "angry" -> {
                println("Got angry.")
                speechText = "I'm still working on this one. " +
                        "Is there anything else you're feeling too?"
            }

            else -> {
                println("Got NOTHING!")
                speechText = "I did not quite understand that. Try giving the adjective for that emotion."
            }
        }

        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard("Anger Therapy: $emotion", speechText)
                .withReprompt(speechText)
                .build()
    }
}