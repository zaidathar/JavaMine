package utils;

import java.security.SecureRandom;

public class StringUtils {

    public static String generateRandomString(int length){
        StringBuilder sb = new StringBuilder();
        SecureRandom RANDOM = new SecureRandom();
        String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i=0; i< length; i++) {
            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }
    
}
