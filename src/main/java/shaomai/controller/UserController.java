package shaomai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shaomai.Log;
import shaomai.exception.NumberIllegalException;
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

    /**
     * signin  注册接口，注册成功返回用户信息
     * @param params
     * @return
     */
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signin(@RequestParam Map<String, Object> params) throws NumberIllegalException {
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

        return "";
    }

    private boolean isNumberLegitimate(String number) {
        return TextUtil.isEmpty(number) && number.length() == 11;
    }
}