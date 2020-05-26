package hbg.qh.model.spacequest

import hbg.qh.model.GameCharacter
import hbg.qh.model.completed

const val KING_ID = "king"
const val HERMIT_ID = "hermit"
const val ARMORER_ID = "armorer"
const val DRAGON_ID = "dragon"

val king = GameCharacter(
    id = KING_ID,
    name = "Space King",
    description = "A man dressed in royal space clothing.",
    contextText = {
        when (completed(TALK_TO_HERMIT_ID)) {
            true -> """I'm sure the Space Hermit explained what you need to do."""
            else -> """Thank you for coming to help. My space kingdom is being attacked by a space dragon.
                |Find the Space Hermit in the woods, he can help you slay the space dragon.
            """.trimMargin()
        }
    })

val hermit = GameCharacter(
    id = HERMIT_ID,
    name = "Space Hermit",
    description = "A strange space person living in isolation.",
    contextText = {
        when {
            obtained(SPEAR_ID) -> {
                """Good work, you are ready to face the space dragon."""
            }
            completed(TALK_TO_KING_ID) -> {
                """A Space Dragon, huh? I believe a space spear will be in order.
                    |To craft one, find a sharp space rock and an oak space branch.
                    |Then speak to the Space Armorer, they can craft a space spear for you.
                """.trimMargin()
            }
            else -> {
                "I'm not sure what I can do for you. Perhaps you should talk to the Space King."
            }
        }
    })

val armorer = GameCharacter(
    id = ARMORER_ID,
    name = "Space Armorer",
    description = "A sturdy person, covered in sweat and soot.",
    contextText = {
        when {
            obtained(SPEAR_ID) -> {
                """Why yes, I can craft a space spear from these items.
                        |Here you are.
                    """.trimMargin()
            }
            obtained(OBTAIN_SPEAR_ID) -> {
                """I need more items than this."""
            }
            else -> {
                """If you need something crafted, bring me the required items."""
            }
        }
    })

val dragon = GameCharacter(
    id = DRAGON_ID,
    name = "Space Dragon",
    description = "A fierce space dragon soaring through the sky raining fire down upon the lands.",
    contextText = {
        when (obtained(SPEAR_ID)) {
            true -> {
                """Congratulations! You have slain the space dragon. The space kingdom in saved!"""
            }
            else -> {
                """You should probably find a weapon before trying to slay the space dragon."""
            }
        }
    })