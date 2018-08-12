package shaomai.exception;

import java.util.HashMap;
import java.util.Map;

import static shaomai.Code.COMMON_ERROR_CODE;

public class ExceptionManager {


    private static Map<Class<? extends Exception>, Integer> errors = new HashMap<>();

    public static void registerException(Class<? extends Exception> exceptionClazz, Integer errorCode) {
        if (!errors.containsKey(exceptionClazz)) {
            errors.put(exceptionClazz, errorCode);
        }
    }

    public static int dispatch(Exception e) {
        Class<? extends Exception> exceptionName = e.getClass();
        // if this exception contain, use it's error code
        return errors.getOrDefault(exceptionName, COMMON_ERROR_CODE);
    }
}