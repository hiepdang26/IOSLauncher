package com.vhmsoft.launcherios26.core.utils

import java.util.ArrayList
import java.util.HashMap

class MultiHashMap<K, V> : HashMap<K, ArrayList<V>> {
    constructor()

    constructor(size: Int) : super(size)

    fun addToList(key: K, value: V) {
        val list = get(key)
        if (list == null) {
            put(key, arrayListOf(value))
        } else {
            list.add(value)
        }
    }

    public override fun clone(): MultiHashMap<K, V> {
        val map = MultiHashMap<K, V>(size)
        for ((key, value) in entries) {
            map[key] = ArrayList(value)
        }
        return map
    }
}
