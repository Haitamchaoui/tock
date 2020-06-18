/*
 * Copyright (C) 2017/2020 e-voyageurs technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ai.tock.bot.orchestration.shared


// i/o between orchestrator and secondary bot

interface OrchestrationResponse

open class EligibilityOrchestrationResponse(
    val targetBot: OrchestrationTargetedBot,
    val botResponse: SecondaryBotEligibilityResponse
) : OrchestrationResponse

open class AvailableOrchestrationResponse(
    val targetBot: OrchestrationTargetedBot,
    val botResponse: SecondaryBotAvailableResponse
) : OrchestrationResponse

open class NoOrchestrationResponse(
    val status : NoOrchestrationStatus
) : OrchestrationResponse