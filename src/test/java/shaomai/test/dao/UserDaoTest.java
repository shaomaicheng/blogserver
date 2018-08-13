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
    public void insertTest() {
        User user = new User();
        user.setEmail("1241616455@qq.com");
        user.setLevel(1);
        user.setNumber("18216728528");
        user.setName("程磊");
        user.setPassword("123456");

        int insertResult = userDao.insert(user);
        assertEquals(insertResult, 1);
    }
}
