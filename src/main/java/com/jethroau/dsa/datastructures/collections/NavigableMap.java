package com.jethroau.dsa.datastructures.collections;

/**
 * A SortedMap extended with navigation methods returning the closest matches for given search targets.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public interface NavigableMap<K, V> extends SortedMap<K, V> {
    Entry<K, V> lowerEntry(K key);
    K lowerKey(K key);
    Entry<K, V> floorEntry(K key);
    K floorKey(K key);
    Entry<K, V> ceilingEntry(K key);
    K ceilingKey(K key);
    Entry<K, V> higherEntry(K key);
    K higherKey(K key);
    Entry<K, V> firstEntry();
    Entry<K, V> lastEntry();
    Entry<K, V> pollFirstEntry();
    Entry<K, V> pollLastEntry();
    NavigableMap<K, V> descendingMap();
    NavigableSet<K> navigableKeySet();
    NavigableSet<K> descendingKeySet();
}
