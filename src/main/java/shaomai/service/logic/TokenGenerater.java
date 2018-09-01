package shaomai.service.logic;


import org.springframework.stereotype.Component;
import shaomai.utils.CookieUtils;
import shaomai.utils.MD5Utils;

import javax.servlet.http.HttpServletResponse;

import static shaomai.constant.CookieConstant.*;

@Component
public class TokenGenerater {

    public String generateToken(String username, String time, String password) {
        return MD5Utils.md5(username + time + password);
    }


    public void setCookie(HttpServletResponse response, String token,String userId, String time) {
        CookieUtils.setCookie(TOKEN, token, response);
        CookieUtils.setCookie(USER_ID, userId, response);
        CookieUtils.setCookie(USER_TIME, time, response);
    }
}
