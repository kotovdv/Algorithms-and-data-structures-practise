package com.kotovdv.algorithms.various.string.reverse


class CharArrayReversal {

    /**
     * Reversal happens for all characters besides last one, assuming that last one is a null character
     *
     *  "*"      ->  "*"
     *  "a*"     ->  "a*"
     *  "ab*"    ->  "ba*"
     *  "abc*"   ->  "cba*"
     *  "abcd*"  ->  "dcba*"
     *  "abcde*" ->  "edcba*"
     */
    fun reverse(charArray: CharArray) {
        val size = charArray.size
        if (size <= 2) {
            return
        }

        var i = 0
        var j = size - 2
        while (i <= j) {
            charArray.swap(i, j)
            i++
            j--
        }
    }

}

private fun CharArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}
