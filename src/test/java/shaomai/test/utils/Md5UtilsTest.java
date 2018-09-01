package shaomai.test.utils;


import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import shaomai.utils.MD5Utils;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4ClassRunner.class)
public class Md5UtilsTest {


    @Test
    public void md5Test() {
        String password = "chenglei";
        String md5Result = MD5Utils.md5(password);
        assertEquals("5059cb54d07d987253d878d857846f2a", md5Result);
    }
}
