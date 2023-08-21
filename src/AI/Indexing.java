package AI;

import java.util.HashMap;
import java.util.Map;

public class Indexing {
    public static class Database {
        private Map<String, String> data;
        private Map<String, Integer> index;

        public Database() {
            data = new HashMap<>();
            index = new HashMap<>();
        }

        public void insert(String key, String value) {
            data.put(key, value);
            index.put(key, key.hashCode());
        }

        public String get(String key){
            if (!index.containsKey(key)) {
                System.out.println("Key not found.");
                return null;
            }

            int hashCode = index.get(key);
            return data.get(key);
        }
    }

    public static void main(String[] args) {
         Database database = new Database();

         database.insert("key1", "value1");
         database.insert("key2", "value2");
         database.insert("key3", "value3");

         System.out.println("Value for key 'key2': " + database.get("key2"));
         System.out.println("Value for key 'key4': " + database.get("key4"));
    }
}
