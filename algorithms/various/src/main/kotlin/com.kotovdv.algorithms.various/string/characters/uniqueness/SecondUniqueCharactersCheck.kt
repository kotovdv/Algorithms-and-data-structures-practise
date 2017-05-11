package com.kotovdv.algorithms.various.string.characters.uniqueness

class SecondUniqueCharactersCheck : UniqueCharactersCheck {

    /**
     * This implementation will only work for limited amount of characters (up to 64) placed in the one sequence
     *
     * In this case we expect to work with the following range
     * ['A' (65) , 'z' (122)] - which is 58 values and our storage has enough capacity to carry them
     */
    override fun checkCharactersUniqueness(inputString: String): Boolean {
        //Our storage, which can hold up to 64 values
        var storage: Long = 0

        val startingPosition = 'A'
        for (currentChar in inputString) {
            val valuePosition = currentChar - startingPosition
            //Apply xor in the position for new character
            //If position was previously filled - we will end up with 0
            //If not - with 1
            storage = (storage xor (1L shl valuePosition))

            //If on the previous step resulting position became 0 - we've met this character before
            if (((storage shr valuePosition) and 1L) == 0L) {
                return false
            }
        }

        return true
    }
}