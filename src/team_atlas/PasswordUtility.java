package team_atlas;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

/**
 * Password utility class.
 * @author Dominik Deak
 */
public class PasswordUtility {

    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET_AND_NUMBERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int ITERATIONS = 100;
    private static final int KEY_LENGTH = 256;
    private static final int SALT_LENGTH = 99;

    static String generatePassWithSalt(String password, String salt) {
        byte[] hashedPassword = hash(password.toCharArray(), salt.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    static String generateSalt() {
        StringBuilder salt = new StringBuilder(SALT_LENGTH);
        for (int i = 0; i < SALT_LENGTH; i++) {
            salt.append(ALPHABET_AND_NUMBERS.charAt(RANDOM.nextInt(ALPHABET_AND_NUMBERS.length())));
        }
        return new String(salt);
    }

    static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec keySpec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            return keyFactory.generateSecret(keySpec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException exception) {
            throw new AssertionError("Error while hashing a password: " + exception.getMessage(), exception);
        } finally {
            keySpec.clearPassword();
            System.gc();
        }
    }
}