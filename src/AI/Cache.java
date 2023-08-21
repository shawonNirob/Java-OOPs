package AI;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Cache<K, V> {
    private final int capacity;
    private final Map<K, V> cacheMap;
    private final LinkedList<K> accessOrder;

    public Cache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.accessOrder = new LinkedList<>();
    }

    public V get(K key){
        if(cacheMap.containsKey(key)){
            accessOrder.remove(key);
            accessOrder.addFirst(key);
            return cacheMap.get(key);
        }
        return null;
    }

    public void put(K key, V value) {
        if (cacheMap.size() >= capacity) {
            K leastUsedKey = accessOrder.removeLast();
            cacheMap.remove(leastUsedKey);
        }

        cacheMap.put(key, value);
        accessOrder.remove(key);
        accessOrder.addFirst(key);
    }

    public int size() {
        return cacheMap.size();
    }

    public static void main(String[] args) {
        Cache<String, Integer> cache = new Cache<>(3);

        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3);

        System.out.println("Cache size: " + cache.size());
        System.out.println("Value for key 'b': " + cache.get("b"));

        cache.put("d", 4);

        System.out.println("Cache size after adding 'd': " + cache.size());
        System.out.println("Value for key 'a' (should be null): " + cache.get("a"));
    }
}

