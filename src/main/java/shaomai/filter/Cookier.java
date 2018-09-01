package shaomai.filter;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;

@Component
public class Cookier {
    public Cookie addCookie(String name, String value) {
        Cookie cookie = new Cookie(name.trim(), value.trim());
        cookie.setMaxAge(7 * 24 * 30 * 60);
        cookie.setPath("/");
        return cookie;
    }
}
