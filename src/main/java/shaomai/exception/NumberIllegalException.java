package shaomai.exception;

public class NumberIllegalException extends Exception {
    public NumberIllegalException() {
        this("电话号码参数非法");
    }

    public NumberIllegalException(String message) {
        super(message);
    }
}
