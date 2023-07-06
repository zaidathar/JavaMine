package com.zaidathar.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class EncryptionUtils {
    public static String encrypt(String plainText, String secreteKey,  String algorithm) throws Exception
    {
        Key key = new SecretKeySpec(secreteKey.getBytes(), algorithm);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }

    public static String decrypt(String encryptedText, String secreteKey,  String algorithm) throws Exception
    {
        Key key = new SecretKeySpec(secreteKey.getBytes(), algorithm);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = Base64.getDecoder().decode(encryptedText);
        byte[] decValue = cipher.doFinal(decodedValue);
        return new String(decValue);
    }
}
