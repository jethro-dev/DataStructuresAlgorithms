package com.jethroau.dsa.datastructures.collections;

import java.util.Set;

/**
 * An object that maps keys to values. A map cannot contain duplicate keys; each key can map to at most one value.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public interface Map<K, V> {

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map
     */
    int size();

    /**
     * Returns {@code true} if this map contains no key-value mappings.
     *
     * @return {@code true} if this map contains no key-value mappings
     */
    boolean isEmpty();

    /**
     * Returns {@code true} if this map contains a mapping for the specified key.
     *
     * @param key key whose presence in this map is to be tested
     * @return {@code true} if this map contains a mapping for the specified key
     */
    boolean containsKey(Object key);

    /**
     * Returns {@code true} if this map maps one or more keys to the specified value.
     *
     * @param value value whose presence in this map is to be tested
     * @return {@code true} if this map maps one or more keys to the specified value
     */
    boolean containsValue(Object value);

    /**
     * Returns the value to which the specified key is mapped, or {@code null} if this map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or {@code null} if this map contains no mapping for the key
     */
    V get(Object key);

    /**
     * Associates the specified value with the specified key in this map (optional operation).
     * If the map previously contained a mapping for the key, the old value is replaced by the specified value.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with key, or {@code null} if there was no mapping for key.
     */
    V put(K key, V value);

    /**
     * Removes the mapping for a key from this map if it is present (optional operation).
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with key, or {@code null} if there was no mapping for key.
     */
    V remove(Object key);

    /**
     * Returns a {@link Set} view of the keys contained in this map.
     *
     * @return a set view of the keys contained in this map
     */
    Set<K> keySet();

    /**
     * Returns a {@link Collection} view of the values contained in this map.
     *
     * @return a collection view of the values contained in this map
     */
    Collection<V> values();

    /**
     * Returns a {@link Set} view of the mappings contained in this map.
     *
     * @return a set view of the mappings contained in this map
     */
    Set<Entry<K, V>> entrySet();

    /**
     * A map entry (key-value pair).
     */
    interface Entry<K, V> {
        /**
         * Returns the key corresponding to this entry.
         *
         * @return the key corresponding to this entry
         */
        K getKey();

        /**
         * Returns the value corresponding to this entry.
         *
         * @return the value corresponding to this entry
         */
        V getValue();

        /**
         * Replaces the value corresponding to this entry with the specified value (optional operation).
         *
         * @param value new value to be stored in this entry
         * @return the old value corresponding to the entry
         */
        V setValue(V value);

        /**
         * Compares the specified object with this entry for equality.
         *
         * @param o object to be compared for equality with this map entry
         * @return {@code true} if the specified object is equal to this map entry
         */
        boolean equals(Object o);

        /**
         * Returns the hash code value for this map entry.
         *
         * @return the hash code value for this map entry
         */
        int hashCode();
    }
}
