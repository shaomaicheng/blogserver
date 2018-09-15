package shaomai.utils;

import java.util.regex.Pattern;

public class FilterUtils {

    /**
     * path是否可以匹配上itempath
     * @param path
     * @param itemPath  正则表示一些解构一致的url path
     * @return
     */
    public static boolean matchUrl(String path, String itemPath) {
        return Pattern.matches(itemPath, path);
    }
}
