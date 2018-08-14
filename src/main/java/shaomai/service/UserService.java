package shaomai.service;

import shaomai.model.p.User;
import shaomai.model.v.VUser;

public interface UserService {

    // 注册
    VUser signin(User user) throws Exception;
}
