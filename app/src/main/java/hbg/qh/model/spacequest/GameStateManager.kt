package hbg.qh.model.spacequest

import hbg.qh.model.GameState
import hbg.qh.model.IGameStateManager
import hbg.qh.model.Thing

class GameStateManager : IGameStateManager {
    private val spaceStartingState = GameState(
        TALK_TO_KING_ID,
        mapOf(
            TALK_TO_KING_ID to talkToKing,
            TALK_TO_HERMIT_ID to talkToHermit,

            FIND_OAK_BRANCH_ID to findOakBranch,
            FIND_SHARP_ROCK_ID to findSharpRock,
            OBTAIN_SPEAR_ID to obtainSpear,
            SLAY_DRAGON_ID to slayDragon,

            KING_ID to king,
            HERMIT_ID to hermit,
            ARMORER_ID to armorer,
            DRAGON_ID to dragon,

            SHARP_ROCK_ID to sharpRock,
            OAK_BRANCH_ID to oakBranch,
            SPEAR_ID to spear,
            DRAGON_HORN_ID to dragonHorn
        )
    )

    override fun initialState(): GameState = spaceStartingState;
    override fun saveFileName(): String = "SPACE_QUEST_SAVE"
    override fun tagToThing(tag: String): Thing = tagToThing[tag] ?: throw Exception("Unknown Thing: $tag")
    override val name: String = "Space Quest"
    override val iconResource: Int = R.drawable.ic_star_border_yellow_32dp

}
