package shaomai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shaomai.Log;
import shaomai.exception.Code;
import shaomai.exception.NumberIllegalException;
import shaomai.exception.user.NameIllegalException;
import shaomai.exception.user.UserException;
import shaomai.exception.user.PasswordIllegaException;
import shaomai.model.Response;
import shaomai.model.p.User;
import shaomai.model.v.VUser;
import shaomai.service.UserService;
import shaomai.utils.TextUtil;

import java.util.Map;

import static shaomai.utils.Constant.*;
import static shaomai.utils.ParseParamsUtil.parseIntParams;
import static shaomai.utils.ParseParamsUtil.parseStringParams;

/**
 * user controller
 *  负责 用户相关
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Log logger;

    @Autowired
    private UserService userService;

    /**
     * login 登录接口
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response<VUser> login(@RequestParam("username")String username, @RequestParam("password")String password)
            throws NameIllegalException, PasswordIllegaException, UserException {
        if (TextUtil.isEmpty(username)) {
            throw new NameIllegalException();
        }

        if (TextUtil.isEmpty(password)) {
            throw new PasswordIllegaException();
        }

        VUser vUser = userService.login(username, password);
        if (vUser == null) {
            throw new NullPointerException("登录失败");
        } else {
            return new Response<>(Code.OK_STATUS, "登录成功", vUser);
        }
    }

    /**
     * insert  注册接口，注册成功返回用户信息
     * @param params
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Response<VUser> signin(@RequestParam Map<String, Object> params)
            throws NumberIllegalException, NameIllegalException, PasswordIllegaException, UserException {
        // get http params
        String number = parseStringParams(params, NUMBER);
        String email = parseStringParams(params, EMAIL);
        int level = parseIntParams(params, LEVEL);
        String name = parseStringParams(params, NAME);
        String password = parseStringParams(params, PASSWORD);
        String company = parseStringParams(params, COMPANY);
        String title = parseStringParams(params, TITLE);
        String avatar = parseStringParams(params, AVATAR);
        String introduction = parseStringParams(params, INTRODUCTION);

        if (!isNumberLegitimate(number)) {
            throw new NumberIllegalException();
        }

        if (TextUtil.isEmpty(name)) {
            throw new NameIllegalException();
        }

        if (TextUtil.isEmpty(password)) {
            throw new PasswordIllegaException();
        }

        User user = new User();

        user.setNumber(number);
        user.setEmail(email);
        user.setLevel(level);
        user.setCompany(company);
        user.setTitle(title);
        user.setAvatar(avatar);
        user.setIntroduction(introduction);


        VUser vUser = null;
        try {
            vUser = userService.signin(user);
        } catch (Exception e) {
            logger.error("服务端注册密码加密错误");
            throw new UserException("注册失败");
        }

        if (vUser == null) {
            throw new NullPointerException("注册失败");
        }
        return new Response<>(Code.OK_STATUS, "注册成功", vUser);
    }

    private boolean isNumberLegitimate(String number) {
        return number.equals("") || number.length() == 11;
    }

}