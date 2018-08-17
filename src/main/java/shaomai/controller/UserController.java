package shaomai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shaomai.Log;
import shaomai.exception.Code;
import shaomai.exception.NumberIllegalException;
import shaomai.exception.user.NameIllegalException;
import shaomai.exception.user.PasswordIllegaException;
import shaomai.exception.user.UserException;
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


    /**
     * 更新用户的不必填信息
     * 包括： email、company、title（职称）、avatar、introduction
     * @param params
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Response<Boolean> updateUser(@RequestParam Map<String,String> params) {
        long id = Long.parseLong(params.get(ID));
        String email = params.get(EMAIL);
        String company = params.get(COMPANY);
        String title = params.get(TITLE);
        String introduction = params.get(INTRODUCTION);
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setCompany(company);
        user.setTitle(title);
        user.setIntroduction(introduction);
        boolean updateSuccess = userService.updateUser(user);
        return new Response<Boolean>(Code.OK_STATUS, updateSuccess ? "用户资料更新成功" : "用户资料更新失败", updateSuccess);
    }

    /**
     * 根据 userid 获取user info 并返回
     * @param id
     * @return
     */
    @RequestMapping(value = "/query/{id}", method = RequestMethod.POST)
    public Response<VUser> queryUserById(@PathVariable("id") long id) {
        VUser vUser = userService.queryUserInfoById(id);
        if (vUser == null) {
            throw new NullPointerException("用户信息获取失败");
        }
        return new Response<>(Code.OK_STATUS, "用户资料查询成功", vUser);
    }
}