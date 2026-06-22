package com.cloudx.ios17.core.utils

import android.util.LongSparseArray

class LongArrayMap<E> : LongSparseArray<E>(), Iterable<E> {
    fun containsKey(key: Long): Boolean = indexOfKey(key) >= 0

    fun isEmpty(): Boolean = size() <= 0

    @Suppress("UNCHECKED_CAST")
    public override fun clone(): LongArrayMap<E> = super.clone() as LongArrayMap<E>

    override fun iterator(): Iterator<E> = ValueIterator()

    inner class ValueIterator : Iterator<E> {
        private var mNextIndex = 0

        override fun hasNext(): Boolean = mNextIndex < size()

        override fun next(): E = valueAt(mNextIndex++)
    }
}
