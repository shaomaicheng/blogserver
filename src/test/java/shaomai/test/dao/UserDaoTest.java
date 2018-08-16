package shaomai.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import shaomai.Application;
import shaomai.dao.UserDao;
import shaomai.model.p.User;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    @Rollback
    public void signTest() {
        User user = new User();
        user.setEmail("1241616455@qq.com");
        user.setLevel(1);
        user.setNumber("18216728528");
        user.setName("程磊");
        user.setPassword("123456");

        int insertResult = userDao.insert(user);
        assertEquals(insertResult, 1);
    }

    @Test
    @Rollback
    public void loginTest() {

        User user = new User();
        user.setEmail("1241616455@qq.com");
        user.setLevel(1);
        user.setNumber("18216728528");
        user.setName("程磊");
        user.setPassword("123456");

        int insertResult = userDao.insert(user);
        assertEquals(insertResult, 1);

        String username = "程磊";
        String password = "123456";

        User resUser = userDao.login(username, password);
        assertEquals(resUser.getName(), "程磊");
        assertEquals(resUser.getPassword(), "123456");
    }
}
