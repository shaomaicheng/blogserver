package shaomai.exception.user;

public class PasswordEncryptException extends Exception {
    public PasswordEncryptException() {
        this("密码加密错误");
    }

    public PasswordEncryptException(String message) {
        super(message);
    }
}
