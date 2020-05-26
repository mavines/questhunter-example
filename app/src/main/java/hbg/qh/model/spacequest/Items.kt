package hbg.qh.model.spacequest

import hbg.qh.model.Item

const val SHARP_ROCK_ID = "sharpRock"
const val OAK_BRANCH_ID = "oakBranch"

const val SPEAR_ID = "spear"
const val DRAGON_HORN_ID = "dragonHorn"

val sharpRock = Item(
    id = SHARP_ROCK_ID,
    name = "Sharp Space Rock",
    description = "A strong, jagged rock.",
    iconResource = R.drawable.ic_android_black_24dp)

val oakBranch = Item(
    id = OAK_BRANCH_ID,
    name = "Space Oak Branch",
    description = "A sturdy oak branch.",
    iconResource = R.drawable.ic_android_black_24dp )

val spear = Item(
    id = SPEAR_ID,
    name = "Space Spear",
    description = "A deadly spear.",
    iconResource = R.drawable.ic_android_black_24dp)

val dragonHorn = Item(
    id = DRAGON_HORN_ID,
    name = "Space Dragon Horn",
    description = "A horn from a dragon.",
    iconResource = R.drawable.ic_android_black_24dp)