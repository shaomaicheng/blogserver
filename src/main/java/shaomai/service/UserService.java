package shaomai.service;

import shaomai.exception.user.UserException;
import shaomai.model.p.User;
import shaomai.model.v.VUser;

public interface UserService {

    // 注册
    VUser signin(User user) throws Exception;

    // 登录
    VUser login(String username, String password) throws UserException;
}
