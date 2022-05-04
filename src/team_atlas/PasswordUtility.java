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
 * A password utility class.
 * Used to generate salts and hashed passwords using the 'PBKDF2WithHmacSHA512' algorithm.
 *
 * @author Dominik Deak
 */
public class PasswordUtility {

    private static final Random RANDOM = new SecureRandom();
    /**
     * The character set used for salt generation.
     */
    private static final String CHARACTER_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    /**
     * The length of the generated salt.
     */
    private static final int SALT_LENGTH = 99;
    /**
     * The length of the encoded key spec.
     */
    private static final int KEY_LENGTH = 256;
    /**
     * The number of iterations when generating a key spec.
     */
    private static final int ITERATIONS = 100;

    /**
     * Generates a hashed password with a salt by decoding a Base64 bytearray.
     *
     * @param password The password to be hashed
     * @param salt     The salt to be using during hashing
     * @return A hashed password
     */
    static String generatePassWithSalt(String password, String salt) {
        byte[] hashedPassword = hash(password.toCharArray(), salt.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    /**
     * Generates a salt of a given length using a given character set.
     *
     * @return A salt in the form of a string
     */
    static String generateSalt() {
        StringBuilder salt = new StringBuilder(SALT_LENGTH);
        for (int i = 0; i < SALT_LENGTH; i++) {
            salt.append(CHARACTER_SET.charAt(RANDOM.nextInt(CHARACTER_SET.length())));
        }
        return new String(salt);
    }

    /**
     * Hashes a password with a salt, using the 'PBKDF2WithHmacSHA512' algorithm.
     *
     * @param password The password to be hashed
     * @param salt     The salt to be using during hashing
     * @return A Base64 encoded byte array
     */
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
