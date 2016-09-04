package api.Utils;

import java.util.Collection;

/**
 * Created by xiejiahao on 2016/9/4.
 */
public class CollectionUtils {
    public static boolean isEmpty(Collection collection){
        return null == collection || 0 == collection.size();
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }
}
