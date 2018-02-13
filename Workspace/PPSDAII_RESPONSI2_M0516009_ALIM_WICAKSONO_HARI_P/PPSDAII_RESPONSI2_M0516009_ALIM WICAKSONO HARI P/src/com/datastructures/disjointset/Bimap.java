package com.datastructures.disjointset;
import java.util.HashMap;

public class Bimap<K, V> {
	
	public Bimap() {
		keyToVal = new HashMap<>();
		valToKey = new HashMap<>();
	}

    private HashMap<K, V> keyToVal;
    private HashMap<V, K> valToKey;
	
    public void put(K key, V value) throws Exception {
        if (!keyToVal.containsKey(key) && !valToKey.containsKey(value)) {
            keyToVal.put(key, value);
            valToKey.put(value, key);
        } else {
        	throw new Exception();
        }
    }
    
    public V getValue(K key) {
    	return keyToVal.get(key);
    }
    
    public K getKey(V value) {
    	return valToKey.get(value);
    }
    
    public void clear() {
    	keyToVal.clear();
    	valToKey.clear();
    }
    
    public boolean containsKey(K key) {
    	return keyToVal.containsKey(key);
    }
    
    public boolean containsValue(V value) {
    	return valToKey.containsKey(value);
    }
    
    public boolean isEmpty() {
    	return keyToVal.isEmpty() && valToKey.isEmpty();
    }
}