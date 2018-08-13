package shaomai.exception.user;

public class NameIllegalException extends Exception {
    public NameIllegalException() {
        this("用户名非法");
    }

    public NameIllegalException(String message) {
        super(message);
    }
}
