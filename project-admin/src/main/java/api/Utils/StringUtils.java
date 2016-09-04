package api.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtils {

    public static boolean isEmpty(String str) {
        if (null == str) return true;
        return "" == str.trim();
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}