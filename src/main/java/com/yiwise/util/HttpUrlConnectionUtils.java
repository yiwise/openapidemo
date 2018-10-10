package com.yiwise.util;

import org.apache.commons.io.IOUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * http链接工具
 * @author : yangdehong
 * @date : 2018/9/30 10:30
 */
public class HttpUrlConnectionUtils {

    public static String doGet(String urlStr, String appKey, String appSecret, String tenantSign, String version, String timestamp) {
        URL url = null;
        HttpURLConnection connection = null;
        try {
            url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            connection.setRequestProperty("appKey", appKey);
            connection.setRequestProperty("appSecret", appSecret);
            connection.setRequestProperty("tenantSign", tenantSign);
            connection.setRequestProperty("version", version);
            connection.setRequestProperty("timestamp", timestamp);
            String signature = SignUtils.sign(appKey, appSecret, tenantSign, version, timestamp);
            connection.setRequestProperty("signature", signature);
            connection.setUseCaches(false);
            connection.connect();

            // 回调的结果
            int responseCode = connection.getResponseCode();
            // 结果
            String result = "";
            if (responseCode!=200) {
                result = IOUtils.toString(connection.getErrorStream());
            } else {
                result = IOUtils.toString(connection.getInputStream());
            }

            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return null;
    }

    public static String doPost(String urlStr, String content, String appKey, String appSecret, String tenantSign, String version, String timestamp) {
        URL url = null;
        HttpURLConnection connection = null;
        try {
            url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            connection.setRequestProperty("appKey", appKey);
            connection.setRequestProperty("appSecret", appSecret);
            connection.setRequestProperty("tenantSign", tenantSign);
            connection.setRequestProperty("version", version);
            connection.setRequestProperty("timestamp", timestamp);
            String signature = SignUtils.sign(appKey, appSecret, tenantSign, version, timestamp);
            connection.setRequestProperty("signature", signature);
            connection.setUseCaches(false);
            connection.connect();


            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(content.getBytes("UTF-8"));
            out.flush();
            out.close();

            // 回调的结果
            int responseCode = connection.getResponseCode();
            // 结果
            String result = "";
            if (responseCode!=200) {
                result = IOUtils.toString(connection.getErrorStream());
            } else {
                result = IOUtils.toString(connection.getInputStream());
            }

            return result;
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return null;
    }

}
