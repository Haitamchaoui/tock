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

package ai.tock.bot.orchestration.bot.primary

import ai.tock.bot.connector.ConnectorType
import ai.tock.bot.definition.Intent
import ai.tock.bot.definition.StoryDefinition
import ai.tock.bot.engine.BotBus
import ai.tock.bot.orchestration.shared.OrchestrationData
import ai.tock.bot.orchestration.shared.OrchestrationTargetedBot

data class PrimaryBotConfiguration(
    val startOrchestrationIntentList : List<Intent> = emptyList(),
    val stopOrchestrationIntentList : List<Intent> = emptyList(),
    val noOrchestrationIntentList : List<Intent> = emptyList(),
    val comebackStory : StoryDefinition,
    private val eligibleTargetBotsByConnector: Map<ConnectorType, List<OrchestrationTargetedBot>> = emptyMap(),
    private val dataProvider : OrchestrationDataProvider = DefaultOrchestrationDataProvider()
) {
    fun getEligibleTargetBots(connectorType: ConnectorType) : List<OrchestrationTargetedBot> = eligibleTargetBotsByConnector[connectorType] ?: emptyList()

    fun getOrchestrationData(bus : BotBus) : OrchestrationData? = dataProvider.provideOrchestrationData(bus)
}