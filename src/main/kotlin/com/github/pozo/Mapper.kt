package com.github.pozo

import kotlinx.serialization.Mapper
import kotlinx.serialization.Serializable

@Serializable
data class Person(
        val name: String,
        val age: Int
)

@Serializable
data class PersonDto(val name: String, val age: Int)

class PersonMapper {
    fun map(person: Person): PersonDto {
        val map: Map<String, Any> = Mapper.map(person)

        return Mapper.unmapNullable(map)
    }

    fun map(person: PersonDto): Person {
        val map: Map<String, Any> = Mapper.map(person)

        return Mapper.unmapNullable(map)
    }
}


fun main(args: Array<String>) {
    val firstPerson = Person("foo", 42)

    val mapper = PersonMapper()

    println(mapper.map(firstPerson))
}