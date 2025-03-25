package com.custommon

enum class Type {
    NORMAL,
    FIRE,
    WATER,
    GRASS,
    ELECTRIC,
    ICE,
    FIGHTING,
    POISON,
    GROUND,
    FLYING,
    PSYCHIC,
    BUG,
    ROCK,
    GHOST,
    DRAGON,
    DARK,
    STEEL,
    FAIRY;

    lateinit var weaknesses: List<Type>

    companion object {
        fun initializeWeaknesses() {
            NORMAL.weaknesses = listOf(FIGHTING)
            FIRE.weaknesses = listOf(WATER, GROUND, ROCK)
            WATER.weaknesses = listOf(ELECTRIC, GRASS)
            GRASS.weaknesses = listOf(FIRE, ICE, POISON, FLYING, BUG)
            ELECTRIC.weaknesses = listOf(GROUND)
            ICE.weaknesses = listOf(FIRE, FIGHTING, ROCK, STEEL)
            FIGHTING.weaknesses = listOf(FLYING, PSYCHIC, FAIRY)
            POISON.weaknesses = listOf(GROUND, PSYCHIC)
            GROUND.weaknesses = listOf(WATER, GRASS, ICE)
            FLYING.weaknesses = listOf(ELECTRIC, ROCK, ICE)
            PSYCHIC.weaknesses = listOf(BUG, GHOST, DARK)
            BUG.weaknesses = listOf(FIRE, FLYING, ROCK)
            ROCK.weaknesses = listOf(WATER, GRASS, FIGHTING, GROUND, STEEL)
            GHOST.weaknesses = listOf(GHOST, DARK)
            DRAGON.weaknesses = listOf(ICE, DRAGON, FAIRY)
            DARK.weaknesses = listOf(FIGHTING, BUG, FAIRY)
            STEEL.weaknesses = listOf(FIRE, FIGHTING, GROUND)
            FAIRY.weaknesses = listOf(POISON, STEEL)
        }

        fun getWeaknesses(types: List<Type>): List<Type> {
            return types.flatMap { it.weaknesses }.distinct()
        }
    }
}
