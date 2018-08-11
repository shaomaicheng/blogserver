package shaomai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shaomai.Log;

import java.util.Map;

import static shaomai.utils.Constant.*;
import static shaomai.utils.ParseParamsUtil.parseParams;

/**
 * user controller
 *  负责 用户相关
 */
@RestController
@RequestMapping("/user")
public class UserController {
 
    @Autowired
    private Log logger;

    /**
     * signin  注册接口，注册成功返回用户信息
     * @param params
     * @return
     */
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signin(@RequestParam Map<String, Object> params) {
        // get http params
//        String number = (String) parseParams(params, NUMBER);
//        String email = (String) parseParams(params, EMAIL);
//        int level = (int) parseParams(params, LEVEL);
//        String name = (String) parseParams(params, NAME);
//        String password = (String) parseParams(params, PASSWORD);
//        String company = (String) parseParams(params, COMPANY);
//        String title = (String) parseParams(params, TITLE);
//        String avatar = (String) parseParams(params, AVATAR);
//        String introduction = (String) parseParams(params, INTRODUCTION);

        logger.info("/signIn");

        return "";
    }
}