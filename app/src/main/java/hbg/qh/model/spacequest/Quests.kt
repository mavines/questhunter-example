package hbg.qh.model.spacequest

import hbg.qh.model.*

const val FIND_SHARP_ROCK_ID = "findSharpRock"
const val FIND_OAK_BRANCH_ID = "findOakBranch"
const val OBTAIN_SPEAR_ID = "obtainSpear"
const val TALK_TO_HERMIT_ID = "talkToHermit"
const val TALK_TO_KING_ID = "talkToKing"
const val SLAY_DRAGON_ID = "slayDragon"

val findSharpRock = Quest(
    FIND_SHARP_ROCK_ID,
    "Find Sharp Space Rock",
    "Search the Space caves for a sharp rock.",
    { "" },
    listOf(encountering(SHARP_ROCK_ID)),
    listOf(gain(SHARP_ROCK_ID))
)


val findOakBranch = Quest(
    FIND_OAK_BRANCH_ID,
    "Find Oak Branch",
    "Search the nearby Space woods for a sturdy oak branch.",
    { "" },
    listOf(encountering(OAK_BRANCH_ID)),
    listOf(gain(OAK_BRANCH_ID))
)

val obtainSpear = Quest(
    OBTAIN_SPEAR_ID,
    "Obtain a Spear",
    """Slaying a Space dragon requires a weapon.
        |Take a sturdy Space Oak Branch and a Sharp Rock to the Armorer to craft one.
    """.trimMargin(),
    { "" },
    listOf(
        encountering(ARMORER_ID),
        completed(FIND_SHARP_ROCK_ID),
        completed(FIND_OAK_BRANCH_ID)
    )
    ,
    listOf(
        gain(SPEAR_ID),
        lose(SHARP_ROCK_ID),
        lose(OAK_BRANCH_ID)
    )
    ,
    listOf(
        findSharpRock,
        findOakBranch
    )
)


val talkToHermit = Quest(
    TALK_TO_HERMIT_ID,
    "Talk to the Space Hermit",
    "The Space Hermit can provide you with information for how to defeat the dragon.",
    { "" },
    listOf(
        encountering(HERMIT_ID),
        completed(TALK_TO_KING_ID)
    ),
    listOf(gain(OBTAIN_SPEAR_ID))
)

val talkToKing = Quest(
    TALK_TO_KING_ID,
    "Talk to the Space King",
    "Find the Space king in the Space palace",
    { "" },
    listOf(encountering(KING_ID)),
    listOf(
        gain(TALK_TO_HERMIT_ID),
        gain(SLAY_DRAGON_ID)
    ),
    obtained = true
)

val slayDragon = Quest(
    SLAY_DRAGON_ID,
    "Slay the Space Dragon",
    "Find the Space dragon and kill it with your spear (stick it with the pointy end).",
    { "" },
    listOf(encountering(DRAGON_HORN_ID),
        completed(OBTAIN_SPEAR_ID)),
    listOf(gain(DRAGON_HORN_ID))
)