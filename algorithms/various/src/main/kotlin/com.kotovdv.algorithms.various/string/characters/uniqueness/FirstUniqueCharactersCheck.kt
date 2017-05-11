package com.kotovdv.algorithms.various.string.characters.uniqueness

class FirstUniqueCharactersCheck : UniqueCharactersCheck {

    override fun checkCharactersUniqueness(inputString: String): Boolean {
        val uniqueCharacters: MutableSet<Char> = HashSet()
        for (currentCharacter in inputString) {
            uniqueCharacters.add(currentCharacter)
        }

        return uniqueCharacters.size == inputString.length
    }
}