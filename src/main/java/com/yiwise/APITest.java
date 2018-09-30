package com.yiwise;

import com.yiwise.util.HttpUrlConnectionUtils;
import com.yiwise.util.SignUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class APITest {

    static String TEST_URL = "http://localhost:8060/openApi/v1/linkTest/testPost";
    static String TEST_URL2 = "http://localhost:8060/openApi/v1/linkTest/testGet?";
    static String TEST_KEY = "yangdehong";
    static String TEST_SEC = "123456";

    public static void main(String[] args) throws UnsupportedEncodingException {
        String result = HttpUrlConnectionUtils.doPost(TEST_URL, getReqParam(), TEST_KEY, TEST_SEC);
        System.out.println(result);
        String result2 = HttpUrlConnectionUtils.doGet(TEST_URL2, getReqParam(), TEST_KEY, TEST_SEC);
        System.out.println(result2);
    }

    private static String getReqParam() throws UnsupportedEncodingException {
        TreeMap<String, String> req = new TreeMap<>();
        req.put("userName", "json");
        req.put("age", "10");
        req.put("m", "zhongan.repair.query");
        req.put("timestamp", "" + System.currentTimeMillis());
        req.put("signature", SignUtils.sign(req));

        StringBuilder param = new StringBuilder();
        for (Iterator<Map.Entry<String, String>> it = req.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, String> e = it.next();
            param.append(e.getKey()).append("=").append(URLEncoder.encode(e.getValue(), "UTF-8")).append("&");
        }
        return param.toString();
    }

}
