package com.ruoyi.goods.base.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * JacksonUtil工具类
 */
public class JacksonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JacksonUtil.class);

    private final static ObjectMapper OBJECT_MAPPER;

    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        OBJECT_MAPPER.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        OBJECT_MAPPER.registerModule(new SimpleModule("module", new Version(1, 0, 0, null, null, null))
                .addSerializer(Double.class, new DoubleSerializer())
                .addSerializer(double.class, new DoubleSerializer()));
    }

    public static class DoubleSerializer extends JsonSerializer<Double> {

        private static final ThreadLocal<DecimalFormat> DF_LOCAL = ThreadLocal
                .withInitial(() -> new DecimalFormat("0.########"));

        @Override
        public void serialize(Double value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                throws IOException {
            DecimalFormat df = DF_LOCAL.get();
            jsonGenerator.writeString(df.format(value));
        }
    }

    /**
     * 转换为 JSON 字符串
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public static String obj2json(Object obj) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(obj);
    }

    /**
     *
     * @param obj
     * @return
     */
    public static String tryObj2json(Object obj) {
        try {
            return obj2json(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error("obj2json error", e);
        }
        return null;
    }

    /**
     * 转换为 JavaBean
     *
     * @param jsonString
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> T json2pojo(String jsonString, Class<T> clazz) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(jsonString, clazz);
    }
    public static <T> T json2pojo(File file, Class<T> clazz) throws IOException {
        return OBJECT_MAPPER.readValue(file, clazz);
    }

    public static <T> T map2Pojo2(Map<String, ?> map, Class<T> clazz) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            T newInstance = clazz.newInstance();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String propertyName = propertyDescriptor.getName();
                if (map.containsKey(propertyName)) {
                    propertyDescriptor.getWriteMethod().invoke(newInstance, map.get(propertyName));
                }
            }
            return newInstance;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 将 JSON 数组转换为集合
     *
     * @param jsonArrayStr
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz) throws Exception {
        return OBJECT_MAPPER.readValue(jsonArrayStr, getCollectionType(ArrayList.class, clazz));
    }
    public static <T> List<T> json2list(File jsonArrayStr, Class<T> clazz) throws Exception {
        return OBJECT_MAPPER.readValue(jsonArrayStr, getCollectionType(ArrayList.class, clazz));
    }

    /**
     * 获取泛型的 Collection Type
     *
     * @param collectionClass 泛型的Collection
     * @param elementClasses  元素类
     * @return JavaType Java类型
     * @since 1.0
     */
    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return OBJECT_MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
