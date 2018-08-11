package shaomai.utils;

import java.util.Map;

public class ParseParamsUtil {
    /**
     * 解析参数
     * @param params 参数集合
     * @param param 参数
     * @return
     */
    public static Object parseParams(Map<String, Object> params,  String param) {
        return params.getOrDefault(param, null);
    }
}
