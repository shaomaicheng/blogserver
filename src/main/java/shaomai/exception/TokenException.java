package shaomai.exception;

import java.io.IOException;

public class TokenException extends RuntimeException {

    public TokenException() {
        this("token无效");
    }

    public TokenException(String message) {
        super(message);
    }
}
