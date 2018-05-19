package com.superwind.test5wechat.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {
    private JsonUtil(){}

    private static final ObjectMapper mapper = new CustomNullValueMapper();

    static {
//        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mapper.getSerializerProvider().setNullKeySerializer(NullSerializer.instance);
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private static ObjectMapper getObjectMapper() {
        return mapper;
    }

    /**
     * 转换对象为JSON
     *
     * @param obj 待转换对象
     * @return JSON字符串
     */
    public static String toJSON(Object obj) {
        try {
            return getObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            log.debug("Fail at toJSON: ", e);
        }
        return "";
    }

    /**
     * 从JSON转换为对象
     *
     * @param <T>     转换的Java类型
     * @param jsonStr JSON字符串
     * @param type    指定类型
     * @return 转换后的对象
     */
    public static <T> T fromJSON(String jsonStr, Class<T> type) {
        T result = null;
        try {
            result = getObjectMapper().readValue(jsonStr, type);
        } catch (Exception e) {
            log.error("Fail at fromJSON: ", e);
        }
        return result;
    }

    /**
     * 从JSON转换为对象
     *
     * @param jsonStr  JSON字符串
     * @param javaType 指定类型
     * @return 转换后的对象
     */
    public static <T> T fromJSON(String jsonStr, JavaType javaType) {
        T result = null;
        try {
            result = getObjectMapper().readValue(jsonStr, javaType);
        } catch (Exception e) {
            log.debug("Fail at fromJSON: ", e);
        }
        return result;
    }
    /**
     * 从JSON转换为对象
     *
     * @param jsonStr  JSON字符串
     * @param typeReference 指定类型
     * @return 转换后的对象
     */
    public static <T> T fromJSON(String jsonStr, TypeReference typeReference) {
        T result = null;
        try {
            result = getObjectMapper().readValue(jsonStr, typeReference);
        } catch (Exception e) {
            log.debug("Fail at fromJSON: ", e);
        }
        return result;
    }

    /**
     * 从bean.toString()中获取某个key的值
     * @param key
     * @return
     */
    public static String getValueFromToString(final String source,final String key){
        String destStr = "";
        if (-1 != source.indexOf(key+"=")){
            destStr = source.substring(source.indexOf(key+"=")+key.length()+1,source.length());

            if (-1 != destStr.indexOf(",")){
                destStr = destStr.substring(0,destStr.indexOf(","));
            }
        }

        return destStr;
    }

}
