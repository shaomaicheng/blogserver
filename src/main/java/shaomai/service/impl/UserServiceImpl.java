package shaomai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shaomai.dao.UserDao;
import shaomai.model.p.User;
import shaomai.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void signin(User user) {
        userDao.insert(user);
    }
}
