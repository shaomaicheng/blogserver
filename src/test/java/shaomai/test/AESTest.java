package shaomai.test;

import org.junit.Test;
import shaomai.AES;

import static org.junit.Assert.assertEquals;

public class AESTest {
    @Test
    public void aesEncryptTest() {
        final String key = "code------------";
        final String text = "chenglei";
        try {
            byte[] encryptResult = AES.encrypt(text, key);
            byte[] decryptResult = AES.decrypt(encryptResult, key);
            assertEquals(text, new String(decryptResult));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
