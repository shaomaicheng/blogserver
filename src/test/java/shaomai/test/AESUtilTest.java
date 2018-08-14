package shaomai.test;

import org.junit.Test;
import shaomai.AESUtil;

public class AESUtilTest {
    @Test
    public void aesEncryptTest() {
        try {
            String encryptResult = AESUtil.encrypt("950829", "mistong");
            System.out.println(encryptResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
