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
    lateinit var resistances: List<Type>

    companion object {
        fun initializeWeaknesses() {
            NORMAL.weaknesses = listOf(FIGHTING)
            NORMAL.resistances = emptyList()

            FIRE.weaknesses = listOf(WATER, GROUND, ROCK)
            FIRE.resistances = listOf(FIRE, GRASS, ICE, BUG, STEEL, FAIRY)

            WATER.weaknesses = listOf(ELECTRIC, GRASS)
            WATER.resistances = listOf(FIRE, WATER, ICE, STEEL)

            GRASS.weaknesses = listOf(FIRE, ICE, POISON, FLYING, BUG)
            GRASS.resistances = listOf(WATER, GRASS, ELECTRIC, GROUND)

            ELECTRIC.weaknesses = listOf(GROUND)
            ELECTRIC.resistances = listOf(ELECTRIC, FLYING, STEEL)

            ICE.weaknesses = listOf(FIRE, FIGHTING, ROCK, STEEL)
            ICE.resistances = listOf(ICE)

            FIGHTING.weaknesses = listOf(FLYING, PSYCHIC, FAIRY)
            FIGHTING.resistances = listOf(BUG, ROCK, DARK)

            POISON.weaknesses = listOf(GROUND, PSYCHIC)
            POISON.resistances = listOf(GRASS, FIGHTING, POISON, BUG, FAIRY)

            GROUND.weaknesses = listOf(WATER, GRASS, ICE)
            GROUND.resistances = listOf(POISON, ROCK)

            FLYING.weaknesses = listOf(ELECTRIC, ROCK, ICE)
            FLYING.resistances = listOf(GRASS, FIGHTING, BUG)

            PSYCHIC.weaknesses = listOf(BUG, GHOST, DARK)
            PSYCHIC.resistances = listOf(FIGHTING, PSYCHIC)

            BUG.weaknesses = listOf(FIRE, FLYING, ROCK)
            BUG.resistances = listOf(GRASS, FIGHTING, GROUND)

            ROCK.weaknesses = listOf(WATER, GRASS, FIGHTING, GROUND, STEEL)
            ROCK.resistances = listOf(NORMAL, FIRE, POISON, FLYING)

            GHOST.weaknesses = listOf(GHOST, DARK)
            GHOST.resistances = listOf(POISON, BUG)

            DRAGON.weaknesses = listOf(ICE, DRAGON, FAIRY)
            DRAGON.resistances = listOf(FIRE, WATER, ELECTRIC, GRASS)

            DARK.weaknesses = listOf(FIGHTING, BUG, FAIRY)
            DARK.resistances = listOf(GHOST, DARK)

            STEEL.weaknesses = listOf(FIRE, FIGHTING, GROUND)
            STEEL.resistances = listOf(NORMAL, GRASS, ICE, FLYING, PSYCHIC, BUG, ROCK, DRAGON, STEEL, FAIRY)

            FAIRY.weaknesses = listOf(POISON, STEEL)
            FAIRY.resistances = listOf(FIGHTING, BUG, DARK)
        }

        fun getWeaknesses(types: List<Type>): List<Type> {
            val allWeaknesses = types.flatMap { it.weaknesses }.toMutableSet()
            val allResistances = types.flatMap { it.resistances }.toSet()

            allWeaknesses.removeAll(allResistances)

            return allWeaknesses.toList()
        }
    }
}
