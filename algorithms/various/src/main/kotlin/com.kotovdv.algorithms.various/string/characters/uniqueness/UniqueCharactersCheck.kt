package com.kotovdv.algorithms.various.string.characters.uniqueness

interface UniqueCharactersCheck {

    /**
     * Determines whether input string has all unique characters
     *
     * @return true if all characters are unique/false otherwise
     */
    fun checkCharactersUniqueness(inputString: String): Boolean
}