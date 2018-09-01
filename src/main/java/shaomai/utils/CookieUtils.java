package shaomai.utils;

import shaomai.constant.CookieConstant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import static shaomai.constant.CookieConstant.EXPIR_TIME;

public class CookieUtils {

    public static void setCookie(String name, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(name.trim(), value.trim());
        cookie.setMaxAge(CookieConstant.EXPIR_TIME);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static void updateCookie(Cookie cookie, String value, HttpServletResponse response) {
        cookie.setValue(value.trim());
        cookie.setPath("/");
        cookie.setMaxAge(EXPIR_TIME);
        response.addCookie(cookie);
    }
}
