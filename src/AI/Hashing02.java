package AI;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing02 {

    public static String generateSHA256Hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());


            StringBuilder hexString = new StringBuilder();
            for (byte hashByte: hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String input = "Brave Man!";
        String sha256Hash = generateSHA256Hash(input);

        System.out.println("Input: " + input);
        System.out.println("SHA-256 Hash: " + sha256Hash);
    }
}
