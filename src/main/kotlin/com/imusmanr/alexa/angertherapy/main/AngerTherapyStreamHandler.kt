package com.imusmanr.alexa.angertherapy.main

import com.amazon.ask.Skill
import com.amazon.ask.SkillStreamHandler
import com.amazon.ask.Skills
import com.imusmanr.alexa.angertherapy.handlers.*

/**
 * ARN of Lambda: arn:aws:lambda:us-west-2:652488451386:function:HelloWorld
 */
class AngerTherapyStreamHandler : SkillStreamHandler(getSkill()) {

    companion object {
        fun getSkill(): Skill = Skills.standard()
                .addRequestHandlers(
                        CancelAndStopIntentHandler(),
                        HelpIntentHandler(),
                        LaunchRequestHandler(),
                        SessionEndedRequestHandler(),
                        BeginIntentHandler(),
                        AnswerIntentHandler()
                )
                .withSkillId("amzn1.ask.skill.19b099c3-daa3-49ca-ae7a-acf2f731fe68")
                .build()
    }
}
