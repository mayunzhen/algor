package com.example.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.security.MessageDigest;

public class JsonUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public JsonUtil() {
    }

    public static String toJson(Object object) throws Exception {
        try {
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException var2) {
            throw new Exception(var2);
        }
    }

    public static <T> T fromJson(String s, Class<?> clasz) throws Exception {
        try {
            return MAPPER.readValue(s, (Class<T>) clasz);
        } catch (Exception var3) {
            throw new Exception(var3);
        }
    }

    public static <T> T fromJson(String s, TypeReference ref) throws Exception {
        try {
            return MAPPER.readValue(s, ref);
        } catch (Exception var3) {
            throw new Exception(var3);
        }
    }

    static {
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static void main(String[] args) throws Exception{
        String suffix = "app_redisweb#profile";

        String bb = MD5("abc");


        String configCacheKeyPrefix = "config_cache_key_"+bb;
        System.out.println(bb);
    }
    public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
}

