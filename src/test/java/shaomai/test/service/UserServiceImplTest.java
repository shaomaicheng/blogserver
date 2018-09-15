package shaomai.test.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import shaomai.service.impl.UserServiceImpl;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

//    public static void main(String[] args) {
//        System.out.println(Pattern.matches("1[0-9]{10}", "12345678901"));
//    }

    private UserServiceImpl mockService;

    @Before
    public void init() {
        mockService = Mockito.spy(UserServiceImpl.class);
    }

    @Test
    public void isNumTest() {
        String test1 = "12345678901";
        System.out.println(mockService.isNum(test1));
        assertTrue(mockService.isNum(test1));
        String test2 = "123";
        System.out.println(mockService.isNum(test2));
        assertFalse(mockService.isNum(test2));
    }
}
