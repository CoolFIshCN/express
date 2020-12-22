package com.express.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Obj转换工具类
 */
public class ObjectConvertUtil {

    /**
     * Obj转ListMap 重载一
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static List<Map<String,Object>> objConvertListMap(Object obj) throws IllegalAccessException {
        List<Map<String,Object>> result = new ArrayList<>();
        if (obj instanceof List<?>){
            for (Object o : (List<?>) obj) {
                Map<String,Object> map = new HashMap<>(16);
                Class<?> clazz = o.getClass();
                for (Field field : clazz.getDeclaredFields()) {
                    field.setAccessible(true);
                    String key = field.getName();
                    Object value = field.get(key);
                    if (value == null){
                        value = "";
                    }
                    map.put(key,value);
                }
                result.add(map);
            }
            return result;
        }
        return null;
    }

    /**
     * Obj转ListMap 重载二
     * @param obj
     * @param vClass
     * @param <V>
     * @return
     * @throws IllegalAccessException
     */
    public static <V> List<Map<String,V>> objConvertListMap(Object obj, Class<V> vClass) throws IllegalAccessException {
        List<Map<String, V>> result = new ArrayList<>();
        if (obj instanceof List<?>) {
            for (Object o : (List<?>) obj) {
                Map<String, V> map = new HashMap<>(16);
                Class<?> oClass = o.getClass();
                for (Field field : oClass.getDeclaredFields()) {
                    field.setAccessible(true);
                    String key = field.getName();
                    Object value = field.get(key);
                    if (value == null) {
                        value = "";
                    }
                    map.put(key, vClass.cast(value));
                }
                result.add(map);
            }
            return result;
        }
        return null;
    }


}
