package shaomai.service.logic;


import org.springframework.stereotype.Component;

@Component
public class TokenGenerater {

    public String generateToken(String username, long currentTime, String password) {
        StringBuilder sb = new StringBuilder();
        return sb.append(username)
                .append(String.valueOf(currentTime))
                .append(password)
                .toString();
    }
}
