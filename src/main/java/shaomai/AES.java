package shaomai;


import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * AES 工具类
 */
public class AES {
    public static final String KEY_ALGORITHM = "AES";
    public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    public static final Charset UTF8 = Charset.forName("UTF-8");

    public static byte[] encrypt(String data, String key) throws Exception{
        return encrypt(data.getBytes(UTF8), key.getBytes(UTF8));
    }

    public static byte[] encrypt(String data, byte[] key) throws Exception{
        return encrypt(data.getBytes(UTF8), key);
    }

    public static byte[] encrypt(byte[] data, String key) throws Exception{
        return encrypt(data, key.getBytes(UTF8));
    }

    /**
     * AES 加密
     * @param data
     * @param key
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] encrypt(byte[] data, byte[] key)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Key k = genSecretKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, k);
        return cipher.doFinal(data);
    }


    public static byte[] decrypt(String data, String key) throws Exception {
        return decrypt(data.getBytes(UTF8), key.getBytes(UTF8));
    }

    public static byte[] decrypt(String data, byte[] key) throws Exception {
        return decrypt(data.getBytes(UTF8), key);
    }

    public static byte[] decrypt(byte[] data, String key) throws Exception {
        return decrypt(data, key.getBytes(UTF8));
    }


    /**
     * AES 解密
     * @param data
     * @param key
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] decrypt(byte[] data, byte[] key)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Key k = genSecretKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, k);
        return cipher.doFinal(data);
    }


    public static Key genSecretKey(byte[] key) {
        if(key.length==16 || key.length==24 || key.length==32){
            return new SecretKeySpec(key, KEY_ALGORITHM);
        }
        throw new IllegalArgumentException("AES only supports key sizes of 16, 24 or 32 bytes");
    }

}
