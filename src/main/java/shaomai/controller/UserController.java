package shaomai.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * user controller
 *  负责 用户相关
 */
@RestController
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * signin  注册接口，注册成功返回用户信息
     * @param params
     * @return
     */
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signin(@RequestParam Map<String, Object> params) {
        if (params.containsKey("number")) {
            String number = (String) params.get("number");
            logger.info("/signin;  number: " + number);
        }
        return "";
    }
}
