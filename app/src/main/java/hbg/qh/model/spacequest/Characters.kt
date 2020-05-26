package hbg.qh.model.spacequest

import hbg.qh.model.GameCharacter

const val KING_ID = "king"
const val HERMIT_ID = "hermit"
const val ARMORER_ID = "armorer"
const val DRAGON_ID = "dragon"

val king = GameCharacter(KING_ID, "King", "A man dressed in royal clothing.",
    {
        when (completed(TALK_TO_HERMIT_ID)) {
            true -> """I'm sure the Hermit explained what you need to do."""
            else -> """Thank you for coming to help. My kingdom is being attacked by a dragon.
                |Find the Hermit in the woods, he can help you slay the dragon.
            """.trimMargin()
        }
    })
val hermit = GameCharacter(HERMIT_ID, "Hermit", "A strange person living in isolation.",
    {
        when {
            obtained(SPEAR_ID) -> {
                """Good work, you are ready to face the dragon."""
            }
            completed(TALK_TO_KING_ID) -> {
                """A Dragon, huh? I believe a spear will be in order.
                    |To craft one, find a sharp rock and an oak branch.
                    |Then speak to the Armorer, they can craft a spear for you.
                """.trimMargin()
            }
            else -> {
                "I'm not sure what I can do for you. Perhaps you should talk to the King."
            }
        }
    })
val armorer =
    GameCharacter(ARMORER_ID, "Armorer", "A sturdy person, covered in sweat and soot.",
        {
            when {
                obtained(SPEAR_ID) -> {
                    """Why yes, I can craft a spear from these items.
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

val dragon =
    GameCharacter(DRAGON_ID,
        "Dragon",
        "A fierce dragon soaring through the sky raining fire down upon the lands.",
        {
            when (obtained(SPEAR_ID)) {
                true -> {
                    """Congratulations! You have slain the dragon. The kingdom in saved!"""
                }
                else -> {
                    """You should probably find a weapon before trying to slay the dragon."""
                }
            }
        })