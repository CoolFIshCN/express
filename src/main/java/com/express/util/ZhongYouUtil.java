package com.express.util;

import java.security.MessageDigest;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ZhongYouUtil {

    /**
     * 众邮签名生成
     * @param timestamp
     * @param version
     * @param method
     * @param paramJson
     * @param accessToken
     * @param appKey
     * @param appSecret
     * @return
     * @throws Exception
     */
    public static String buildSign(String timestamp, String version, String method ,
                             String paramJson , String accessToken ,
                             String appKey, String appSecret) {
        //第一步，按照顺序填充参数
        Map<String, String> map = new TreeMap();
        map.put("timestamp", timestamp);
        map.put("v", version);
        map.put("method", method);
        map.put("param_json", paramJson);
        map.put("access_token", accessToken);
        map.put("app_key", appKey);

        StringBuilder sb = new StringBuilder(appSecret);
        //按照规则拼成字符串
        for (Map.Entry entry : map.entrySet()) {
            String name = (String) entry.getKey();
            String value = (String) entry.getValue();
            sb.append(name).append(value);
        }
        sb.append(appSecret);
        //MD5
        String md5 = null;
        try {
            md5 = md5(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5;
    }

    public static String md5(String source) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest(source.getBytes("utf-8"));
        return byte2hex(bytes);
    }

    private static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }

    /**
     * 组装url
     * @return
     */
    public static String buildUrl(String frontUrl,Map<String,String> urlMap){
        StringBuilder sb = new StringBuilder(frontUrl);

        Set<Map.Entry<String, String>> entrySet = urlMap.entrySet();

        if (null != entrySet && entrySet.size()>0){
            sb.append("?");
        }

        for (Map.Entry<String, String> entry : entrySet) {
            int index = 0;

            if (index == 0){
                sb.append(entry.getKey()).append("=").append(entry.getValue());
            }
            sb.append("&").append(entry.getKey()).append("=").append(entry.getValue());
            index++;
        }


        return sb.toString();
    }
}
