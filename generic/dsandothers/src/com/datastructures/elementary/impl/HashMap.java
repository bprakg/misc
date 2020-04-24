package com.datastructures.elementary.impl;

import com.datastructures.elementary.Map;

public class HashMap<K, V> implements Map<K, V> {
	private static int MAP_SIZE = 23;
	private LinkedListForMap<K, V>[] listArr = new LinkedListForMap[MAP_SIZE];

	public void put(K key, V value) {
		int hash = Math.abs(key.hashCode() % MAP_SIZE);
		System.out.println("hash for " + key + " is " + hash);
		if (listArr[hash] == null) {
			LinkedListForMap<K, V> ll = new LinkedListForMap<>();
			ll.add(key, value);
			listArr[hash] = ll;
		} else {
			listArr[hash].add(key, value);
		}
	}

	public V get(K key) {
		int hash = Math.abs(key.hashCode() % MAP_SIZE);
		if (listArr != null && listArr[hash] != null) {
			return listArr[hash].search(key);
		}
		return null;
	}
}
