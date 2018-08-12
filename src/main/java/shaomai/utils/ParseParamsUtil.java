package shaomai.utils;

import java.util.Map;

public class ParseParamsUtil {
    /**
     * 解析对象参数
     * @param params 参数集合
     * @param param 参数
     * @return
     */
    public static Object parseObjParams(Map<String, Object> params,  String param) {
        return params.getOrDefault(param, null);
    }

    /**
     * 解析 int 型参数
     * @param params
     * @param param
     * @return
     */
    public static int parseIntParams(Map<String, Object> params, String param) {
        return (int) params.getOrDefault(param, -1);
    }

    public static long parseLongParams(Map<String, Object> params, String param) {
        return (long) params.getOrDefault(param, -1);
    }

    public static float parseFloatParams(Map<String, Object> params, String param) {
        return (float) params.getOrDefault(param, -1.0f);
    }

    public static double parseDoubleParams(Map<String, Object> params, String param) {
        return (double) params.getOrDefault(param, -1.0f);
    }

    public static boolean parseBooleanParams(Map<String, Object> params, String param) {
        return (boolean) params.getOrDefault(param, false);
    }

    public static String parseStringParams(Map<String, Object> params, String param) {
        return (String) params.getOrDefault(param, "");
    }
}
