package shaomai.service;

import shaomai.exception.user.UserException;
import shaomai.model.p.User;
import shaomai.model.v.VUser;

public interface UserService {

    // 注册
    VUser signin(User user) throws UserException;

    // 登录
    VUser login(String username, String password) throws UserException;

    // 更新user 资料
    boolean updateUser(User user);

    // 根据user id获取用户 数据
    VUser queryUserInfoById(long id);
}
