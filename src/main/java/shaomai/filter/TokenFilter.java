package shaomai.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import shaomai.Log;
import shaomai.constant.CookieConstant;
import shaomai.exception.TokenException;
import shaomai.service.TokenFilterService;
import shaomai.utils.CookieUtils;
import shaomai.utils.TextUtil;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static shaomai.constant.CookieConstant.TOKEN;
import static shaomai.constant.CookieConstant.USER_TIME;


public class TokenFilter implements Filter {

    @Autowired
    private Log logger;

    @Autowired
    TokenConfiger tokenConfiger;

    @Autowired
    TokenFilterService tokenFilterService;

    @Autowired
    Cookier cookier;

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) {

        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());
        logger.debug("TokenFilter init");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException, TokenException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String path = request.getServletPath();
        boolean needVerifToken = !tokenConfiger.inBlackList(path); // 是否需要验证

        Cookie[] cookies = request.getCookies();

        String userId = "";
        String time = "0";
        String token = "";

        if (needVerifToken && cookies != null) {
            for (Cookie cookie : cookies) {
                // 遍历cookie
                if (cookie.getName().equals(CookieConstant.USER_ID)) {
                    // user-id
                    userId = cookie.getValue();
                    if (TextUtil.isEmpty(userId)) {
                        throw new TokenException();
                    }
                }

                if (cookie.getName().equals(USER_TIME)) {
                    // user-time
                    time = cookie.getValue();
                    if (TextUtil.isEmpty(time)) {
                        throw new TokenException();
                    }
                }

                if (cookie.getName().equals(CookieConstant.TOKEN)) {
                    // token
                    token = cookie.getValue();
                    if (TextUtil.isEmpty(token)) {
                        throw new TokenException();
                    }
                }
            }
        }

        // 验证 token
        if (needVerifToken) {
            verifToken(time, userId, token);
            if (cookies != null) {
                refreshToken(cookies, userId, (HttpServletResponse)servletResponse);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void verifToken(String time, String userId, String token) {
        // 根据时间判断是否失效

        if (tokenConfiger.tokenOverdue(time)) {
            // token失效
            throw new TokenException("token过期");
        }

        // 验证token
        boolean tokenVerif = tokenFilterService.verifToken(userId, time, token);
        if (!tokenVerif) {
            // token失效
            throw new TokenException("token失效！");
        }
    }

    private void refreshToken(Cookie[] cookies, String userId, HttpServletResponse response) {
        long currentTime = System.currentTimeMillis();
        boolean setUserTime = false;
        boolean setUserToken = false;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(USER_TIME)) {
                CookieUtils.updateCookie(cookie, String.valueOf(currentTime), response);
                setUserTime = true;
            }
            if (cookie.getName().equals(TOKEN)) {
                CookieUtils.updateCookie(cookie, tokenFilterService.generateToken(userId, String.valueOf(currentTime)), response);
                setUserToken = true;
            }
        }

        if (!setUserTime) {
            CookieUtils.setCookie(USER_TIME, String.valueOf(currentTime), response);
        }

        if (!setUserToken) {
            CookieUtils.setCookie(TOKEN, tokenFilterService.generateToken(userId, String.valueOf(currentTime)), response);
        }

    }

    @Override
    public void destroy() {
    }
}
