package shaomai.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import shaomai.exception.ExceptionManager;
import shaomai.model.Response;

@ControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public Response<String> errorResponse(Exception e) {
        return new Response<>(ExceptionManager.dispatch(e), e.getMessage(), e.getMessage());
    }
}
