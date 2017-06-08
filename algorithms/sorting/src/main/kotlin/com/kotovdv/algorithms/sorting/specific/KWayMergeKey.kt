package com.kotovdv.algorithms.sorting.specific;

class KWayMergeKey<T : Comparable<T>>(val associatedArray: Array<T>, val index: Int) : Comparable<KWayMergeKey<T>> {

    fun getValue(): T {
        return associatedArray[index]
    }

    override fun compareTo(other: KWayMergeKey<T>): Int {
        return this.associatedArray[index].compareTo(other.associatedArray[other.index])
    }

    override fun toString(): String {
        return "KWayMergeKey(associatedArray=$associatedArray, index=$index)"
    }
}