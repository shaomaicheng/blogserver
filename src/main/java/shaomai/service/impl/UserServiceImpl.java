package shaomai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shaomai.dao.UserDao;
import shaomai.exception.user.UserException;
import shaomai.model.p.User;
import shaomai.model.v.VUser;
import shaomai.repository.UserRepository;
import shaomai.service.UserService;
import shaomai.service.logic.TokenGenerater;
import shaomai.utils.TextUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    private static final String KEY = "chenglei@@@@@@@@";

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenGenerater tokenGenerater;

    @Override
    public VUser signin(User user) throws UserException {
        String password = user.getPassword();
        // 加密
        user.setPassword(password);

        int insertResult = userDao.insert(user);
        if (insertResult == 1) {
            // user 注册进数据库
            VUser vUser = userRepository.convertVO(user);
            return vUser;

        }
        return null;
    }

    @Override
    public VUser login(String username, String password) throws UserException {
        try {
//            password = new String(AES.encrypt(password, KEY));
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserException("登录失败");
        }
        // 查询数据库
        User user = userDao.login(username, password);

        if (user != null) {
            return userRepository.convertVO(user);
        } else {
            return null;
        }
    }

    /**
     * 更新 user 资料
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        int result = userDao.updateUser(user);
        return result == 1;
    }

    /**
     * 根据 id 查询user
     * @param id
     * @return
     */
    @Override
    public VUser queryUserInfoById(long id) {
        User user = userDao.queryUserById(id);

        return userRepository.convertVO(user);
    }

    @Override
    public boolean judgeIsExitByPhoneNumber(String phoneNumber) {
        User user = userDao.queryUserByPhoneNumber(phoneNumber);
        return user != null;
    }

    public boolean isNumberLegitimate(String number) {
        return !TextUtil.isEmpty(number) && number.length() == 11 && isNum(number);
    }

    public boolean isNum(String number) {
        return Pattern.matches("1[0-9]{10}", number);
    }

}
