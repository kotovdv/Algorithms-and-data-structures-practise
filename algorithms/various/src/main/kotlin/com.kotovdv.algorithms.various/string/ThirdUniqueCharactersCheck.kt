package com.kotovdv.algorithms.various.string

class ThirdUniqueCharactersCheck : UniqueCharactersCheck {

    override fun checkCharactersUniqueness(inputString: String): Boolean {
        for (i in 0 until inputString.length) {
            for (j in 0 until inputString.length) {
                if (i == j) {
                    continue
                }

                if (inputString[i] == inputString[j]) {
                    return false
                }
            }
        }

        return true
    }
}