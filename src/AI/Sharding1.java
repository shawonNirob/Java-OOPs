package AI;

import java.util.HashMap;
import java.util.Map;
public class Sharding1{
    public static class Shard {
        private Map<String, String> data;

        public Shard() {
            data = new HashMap<>();
        }

        public void put(String key, String value) {
            data.put(key, value);
        }

        public String get(String key) {
            return data.get(key);
        }
    }
    public static class Sharding {
        private Shard[] shards;

        public Sharding(int numShards) {
            shards = new Shard[numShards];
            for (int i = 0; i < numShards; i++) {
                shards[i] = new Shard();
            }
        }

        public void put(String key, String value){
            int shardIndex = calculateShardIndex(key);
            shards[shardIndex].put(key, value);
        }

        public String get(String key) {
            int shardIndex = calculateShardIndex(key);
            return shards[shardIndex].get(key);
        }

        private int calculateShardIndex(String key) {
            return Math.abs(key.hashCode()) % shards.length;
        }
    }
    public static void main(String[] args){
        int numShards = 3;
        Sharding sharding = new Sharding(numShards);

        sharding.put("key1", "value1");
        sharding.put("key2", "value2");
        sharding.put("key3", "value3");

        System.out.println("Value for key 'key1': " + sharding.get("key1"));
        System.out.println("Value for key 'key2': " + sharding.get("key2"));
        System.out.println("Value for key 'key3': " + sharding.get("key3"));
    }
}
