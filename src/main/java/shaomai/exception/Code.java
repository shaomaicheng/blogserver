package shaomai.exception;

public interface Code {
    int UPLOAD_FAIL = 1001;
    int ART_SELECT_ERROR_CODE = 1002;
    int NUMBER_ILLEGAL_ERROR_CODE = 1003; //电话号码非法
    int TOKEN_INVALIED = 7000; // token无效


    int COMMON_ERROR_CODE = 0; // 统一的业务错误码
    int OK_STATUS = -1;
}
