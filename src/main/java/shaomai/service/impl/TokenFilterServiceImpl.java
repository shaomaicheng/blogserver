package shaomai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shaomai.dao.UserDao;
import shaomai.model.p.User;
import shaomai.service.TokenFilterService;
import shaomai.service.logic.TokenGenerater;
import shaomai.utils.TextUtil;


@Service
public class TokenFilterServiceImpl implements TokenFilterService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private TokenGenerater tokenGenerater;
    /**
     * 验证token
     * @param userId
     * @return
     */
    public boolean verifToken(String userId, String time, String token) {
        User user = user(userId);

        String password = user.getPassword();

        String quickToken = tokenGenerater.generateToken(userId, time, password);
        // token 验证通过
        return !TextUtil.isEmpty(token) && token.equals(quickToken);
    }

    @Override
    public String generateToken(String userId, String currentTime) {
        User user = user(userId);

        String password = user.getPassword();
        return tokenGenerater.generateToken(userId, currentTime, password);
    }


    private User user(String userId) {
        long id = Long.parseLong(userId);
        return userDao.queryUserById(id);
    }
}
