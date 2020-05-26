package hbg.qh.model.spacequest

import hbg.qh.model.*

const val FIND_SHARP_ROCK_ID = "findSharpRock"
const val FIND_OAK_BRANCH_ID = "findOakBranch"
const val OBTAIN_SPEAR_ID = "obtainSpear"
const val TALK_TO_HERMIT_ID = "talkToHermit"
const val TALK_TO_KING_ID = "talkToKing"
const val SLAY_DRAGON_ID = "slayDragon"

val findSharpRock = Quest(
    id = FIND_SHARP_ROCK_ID,
    name = "Find Sharp Space Rock",
    description = "Search the Space caves for a sharp rock.",
    contextText = { "" },
    criteria = listOf(encountering(SHARP_ROCK_ID)),
    results = listOf(gain(SHARP_ROCK_ID))
)


val findOakBranch = Quest(
    id = FIND_OAK_BRANCH_ID,
    name = "Find Oak Branch",
    description = "Search the nearby Space woods for a sturdy oak branch.",
    contextText = { "" },
    criteria = listOf(encountering(OAK_BRANCH_ID)),
    results = listOf(gain(OAK_BRANCH_ID))
)

val obtainSpear = Quest(
    id = OBTAIN_SPEAR_ID,
    name = "Obtain a Spear",
    description = """Slaying a Space dragon requires a weapon.
        |Take a sturdy Space Oak Branch and a Sharp Rock to the Armorer to craft one.
    """.trimMargin(),
    contextText = { "" },
    criteria = listOf(
        encountering(ARMORER_ID),
        completed(FIND_SHARP_ROCK_ID),
        completed(FIND_OAK_BRANCH_ID)
    )
    ,
    results = listOf(
        gain(SPEAR_ID),
        lose(SHARP_ROCK_ID),
        lose(OAK_BRANCH_ID)
    )
    ,
    steps = listOf(
        findSharpRock,
        findOakBranch
    )
)


val talkToHermit = Quest(
    id = TALK_TO_HERMIT_ID,
    name = "Talk to the Space Hermit",
    description = "The Space Hermit can provide you with information for how to defeat the dragon.",
    contextText = { "" },
    criteria = listOf(
        encountering(HERMIT_ID),
        completed(TALK_TO_KING_ID)
    ),
    results = listOf(gain(OBTAIN_SPEAR_ID))
)

val talkToKing = Quest(
    id =TALK_TO_KING_ID,
    name = "Talk to the Space King",
    description = "Find the Space king in the Space palace",
    contextText = { "" },
    criteria = listOf(encountering(KING_ID)),
    results = listOf(
        gain(TALK_TO_HERMIT_ID),
        gain(SLAY_DRAGON_ID)
    ),
    obtained = true
)

val slayDragon = Quest(
    id = SLAY_DRAGON_ID,
    name = "Slay the Space Dragon",
    description = "Find the Space dragon and kill it with your spear (stick it with the pointy end).",
    contextText = { "" },
    criteria = listOf(encountering(DRAGON_HORN_ID),
        completed(OBTAIN_SPEAR_ID)),
    results = listOf(gain(DRAGON_HORN_ID))
)