package shaomai.exception.user;

public class PasswordIllegaException extends Exception {
    public PasswordIllegaException() {
        this("密码参数不合法");
    }

    public PasswordIllegaException(String message) {
        super(message);
    }
}
