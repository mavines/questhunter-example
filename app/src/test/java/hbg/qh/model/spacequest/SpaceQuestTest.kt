package hbg.qh.model.spacequest

import hbg.qh.engine.updateState
import org.junit.Assert
import org.junit.Test

class SpaceQuestTest {
    @Test
    fun `Test Get Reward - Talk To the King`() {
        val initial = GameStateManager().initialState()
        val updatedState = updateState(initial, king)

        val updatedTalkToKing = updatedState.quests[TALK_TO_KING_ID]

        assert(updatedTalkToKing?.completed ?: false)

        val updatedTalkToHermit = updatedState.quests[TALK_TO_HERMIT_ID]

        assert(updatedTalkToHermit?.obtained ?: false)
    }

    @Test
    fun `Test Multi-Step Quest - Build Spear`() {
        val initial = GameStateManager().initialState()
        val talkedToKing = updateState(initial, king)

        assert(talkedToKing.quests[TALK_TO_KING_ID]?.completed ?: false)
        assert(talkedToKing.quests[TALK_TO_HERMIT_ID]?.obtained ?: false)

        val talkedToHermit = updateState(
            talkedToKing,
            hermit
        )

        assert(talkedToHermit.quests[TALK_TO_HERMIT_ID]?.completed ?: false)
        assert(talkedToHermit.quests[OBTAIN_SPEAR_ID]?.obtained ?: false)

        val foundOakBranch = updateState(
            talkedToHermit,
            oakBranch
        )

        assert(foundOakBranch.items[OAK_BRANCH_ID]?.obtained ?: false)

        val foundRock = updateState(
            foundOakBranch,
            sharpRock
        )

        assert(foundRock.items[SHARP_ROCK_ID]?.obtained ?: false)

        val talkedToArmorer = updateState(
            foundRock,
            armorer
        )

        assert(talkedToArmorer.items[SPEAR_ID]?.obtained ?: false)
    }

    @Test
    fun `Test Multi-Step Quest - Build Spear Out of Order`() {
        GameStateManager().initialState().let { gameState ->
            updateState(gameState, oakBranch).also {
                assert(it.items[OAK_BRANCH_ID]?.obtained ?: false)
            }
        }.let { gameState ->
            updateState(gameState, king).also {
                assert(it.quests[TALK_TO_KING_ID]?.completed ?: false)
                assert(it.quests[TALK_TO_HERMIT_ID]?.obtained ?: false)
            }
        }.let { gameState ->
            updateState(gameState, sharpRock).also {
                assert(it.items[SHARP_ROCK_ID]?.obtained ?: false)

            }
        }.let { gameState ->
            updateState(gameState, hermit).also {
                assert(it.quests[TALK_TO_HERMIT_ID]?.completed ?: false)
                assert(it.quests[OBTAIN_SPEAR_ID]?.obtained ?: false)
            }
        }.let { gameState ->
            updateState(gameState, armorer).also {
                assert(it.items[SPEAR_ID]?.obtained ?: false)
                assert(it.items[SHARP_ROCK_ID]?.obtained == false)
                assert(it.items[OAK_BRANCH_ID]?.obtained == false)

            }
        }
    }

    @Test
    fun `Test Multi-Step Quest - Build Spear Armorer Twice`() {
        GameStateManager().initialState().let { gameState ->
            updateState(gameState, oakBranch).also {
                assert(it.items[OAK_BRANCH_ID]?.obtained ?: false)
            }
        }.let { gameState ->
            updateState(gameState, armorer).also {
                Assert.assertFalse(it.items[SPEAR_ID]?.obtained ?: true)
            }
        }.let { gameState ->
            updateState(gameState, king).also {
                assert(it.quests[TALK_TO_KING_ID]?.completed ?: false)
                assert(it.quests[TALK_TO_HERMIT_ID]?.obtained ?: false)
            }
        }.let { gameState ->
            updateState(gameState, sharpRock).also {
                assert(it.items[SHARP_ROCK_ID]?.obtained ?: false)
            }
        }.let { gameState ->
            updateState(gameState, hermit).also {
                assert(it.quests[TALK_TO_HERMIT_ID]?.completed ?: false)
                assert(it.quests[OBTAIN_SPEAR_ID]?.obtained ?: false)
            }
        }.let { gameState ->
            updateState(gameState, armorer).also {
                assert(it.items[SPEAR_ID]?.obtained ?: false)
                assert(it.items[SHARP_ROCK_ID]?.obtained == false)
                assert(it.items[OAK_BRANCH_ID]?.obtained == false)
            }
        }
    }

}


