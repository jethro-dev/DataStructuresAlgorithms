package com.jethroau.dsa.datastructures.collections;

import java.util.Comparator;
import java.util.Set;

/**
 * A Map that further provides a total ordering on its keys.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public interface SortedMap<K, V> extends Map<K, V> {
    Comparator<? super K> comparator();
    SortedMap<K, V> subMap(K fromKey, K toKey);
    SortedMap<K, V> headMap(K toKey);
    SortedMap<K, V> tailMap(K fromKey);
    K firstKey();
    K lastKey();
    Set<K> keySet();
    Collection<V> values();
    Set<Entry<K, V>> entrySet();
}
