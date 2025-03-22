package com.custommon

import jakarta.persistence.*

@Entity
@Table
data class Custommon(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    val name: String,
    val description: String,
    val height: Double,
    val category: String,
    val weight: Double,
    val passiveAbility: String,

    @ElementCollection
    @CollectionTable(name = "custommon_sexes", joinColumns = [JoinColumn(name = "custommon_id")])
    @Enumerated(EnumType.STRING)
    val availableSexes: List<Sex>,

    @ElementCollection
    @CollectionTable(name = "custommon_types", joinColumns = [JoinColumn(name = "custommon_id")])
    @Enumerated(EnumType.STRING)
    val types: List<Type>
)