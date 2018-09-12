package shaomai.filter;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TokenConfiger {

    private long tokenValidityTime = 7 * 24 * 60 * 60 * 1000L; // token 有效期 7天

    private List<String> noVerifPathList = new ArrayList<>();

    public TokenConfiger() {
        noVerifPathList.add("/");
        noVerifPathList.add("/*.ico");
        noVerifPathList.add("/user/login");
        noVerifPathList.add("/user/insert");
        noVerifPathList.add("/kttest");
        noVerifPathList.add("/favicon.ico");
    }

    boolean tokenOverdue(String time) {
        long realTime = Long.valueOf(time);
        long currentTime = System.currentTimeMillis();
        // 没过期
        return currentTime - realTime > tokenValidityTime;
    }

    boolean inWhiteList(String path) {
        for (String itemPath : noVerifPathList) {
            if (path.equals(itemPath)) {
                return true;
            }
        }
        return false;
    }
}
