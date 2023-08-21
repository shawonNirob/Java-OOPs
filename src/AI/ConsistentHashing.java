package AI;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing {

    private final SortedMap < Integer, String > circle = new TreeMap < > ();
    private final int numberOfReplicas;

    public ConsistentHashing(int numberOfReplicas) {
        this.numberOfReplicas = numberOfReplicas;
    }

    public void addServer(String server) {
        for (int i = 0; i < numberOfReplicas; i++) {
            String virtualServer = server + " - " + i;
            int hash = getHash(virtualServer);
            circle.put(hash, virtualServer);
        }
    }

    public void removeServer(String server) {
        for (int i = 0; i < numberOfReplicas; i++) {
            String virtualServer = server + " - " + i;
            int hash = getHash(virtualServer);
            circle.remove(hash);
        }
    }

    public String getServer(String key) {
        if (circle.isEmpty()) {
            return null;
        }
        int hash = getHash(key);
        if (!circle.containsKey(hash)) {
            SortedMap < Integer, String > tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    private int getHash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] digest = md.digest();
            int hash = 0;
            for (int i = 0; i < 4; i++) {
                hash <<= 8;
                hash |= ((int) digest[i]) & 0xFF;
            }
            return hash;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing algorithm not available", e);
        }
    }

    public static void main(String[] args) {
        ConsistentHashing ch = new ConsistentHashing(3);
        ch.addServer("Server1");
        ch.addServer("Server2");
        ch.addServer("Server3");

        System.out.println("Key 'data1' is assigned to: " + ch.getServer("data1"));
        System.out.println("Key 'data2' is assigned to: " + ch.getServer("data2"));
    }
}
