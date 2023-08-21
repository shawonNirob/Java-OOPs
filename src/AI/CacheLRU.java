package AI;

import java.util.*;

public class CacheLRU {
    public static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {
        int capacity = 3;
        LRUCache<Integer, String> lruCache = new LRUCache<>(capacity);

        lruCache.put(1, "One");
        lruCache.put(2, "Two");
        lruCache.put(3, "Three");

        System.out.println(lruCache);  // Output: {1=One, 2=Two, 3=Three}

        lruCache.get(2);  // Accessing 2, making it the most recently used

        lruCache.put(4, "Four");  // Adding a new entry, should remove the least recently used (1)

        System.out.println(lruCache);  // Output: {2=Two, 3=Three, 4=Four}
    }
}
