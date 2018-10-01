package com.yiwise;

import com.yiwise.util.HttpUrlConnectionUtils;
import com.yiwise.util.SignUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 简单模型
 * @author : yangdehong
 * @date : 2018/9/30 12:03
 */
public class SimpleDemo {

    public static String APP_KEY = "yangdehong";
    public static String APP_SECRET = "123456";

    public static final String TENANT_SIGN = "yiwise";

    public static void main(String[] args) throws UnsupportedEncodingException {
        String result = getCompanyList();
//        String result = getPhoneList();
        System.out.println(result);
    }

    private static String getCompanyList() throws UnsupportedEncodingException {
        String url = "http://localhost:8060/openApi/v1/company/getCompanies?";
        TreeMap<String,  Object> req = new TreeMap<>();
        req.put("timestamp", System.currentTimeMillis());
        req.put("signature", SignUtils.sign(req, TENANT_SIGN));

        StringBuilder param = new StringBuilder();
        for (Iterator<Map.Entry<String, Object>> it = req.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Object> e = it.next();
            param.append(e.getKey()).append("=").append(URLEncoder.encode(e.getValue().toString(), "UTF-8")).append("&");
        }
        String result = HttpUrlConnectionUtils.doGet(url, param.toString(), APP_KEY, APP_SECRET, TENANT_SIGN);
        return result;
    }
    private static String getPhoneList() throws UnsupportedEncodingException {
        String url = "http://localhost:8060/openApi/v1/company/getPhones?";
        TreeMap<String,  Object> req = new TreeMap<>();
        req.put("timestamp", System.currentTimeMillis());
        req.put("signature", SignUtils.sign(req, TENANT_SIGN));

        StringBuilder param = new StringBuilder();
        for (Iterator<Map.Entry<String, Object>> it = req.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Object> e = it.next();
            param.append(e.getKey()).append("=").append(URLEncoder.encode(e.getValue().toString(), "UTF-8")).append("&");
        }
        String result = HttpUrlConnectionUtils.doGet(url, param.toString(), APP_KEY, APP_SECRET, TENANT_SIGN);
        return result;
    }

}
