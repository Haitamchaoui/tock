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

import ai.tock.bot.engine.user.PlayerId
import ai.tock.bot.orchestration.shared.OrchestrationMetaData
import ai.tock.bot.orchestration.shared.OrchestrationTargetedBot
import ai.tock.bot.orchestration.shared.SecondaryBotAction
import ai.tock.shared.booleanProperty
import org.litote.kmongo.Id
import org.litote.kmongo.newId

/**
 * Is it orchestration enabled? Default to false - use tock_orchestration property to enable.
 */
val orchestrationEnabled = booleanProperty("tock_orchestration", false)

enum class OrchestrationStatus { ACTIVE, CLOSED }

data class Orchestration(
    val id: Id<Orchestration> = newId(),
    val playerId: PlayerId,
    val targetMetadata: OrchestrationMetaData,
    val targetBot: OrchestrationTargetedBot,
    var status: OrchestrationStatus = OrchestrationStatus.ACTIVE,
    val history: MutableList<SecondaryBotAction> = mutableListOf()
) {
    fun update(action: SecondaryBotAction) = history.add(action)
}