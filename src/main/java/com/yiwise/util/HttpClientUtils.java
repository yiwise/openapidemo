package com.yiwise.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.annotation.Resource;


public class HttpClientUtils {

        private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

        public static String doGet(String urlStr, String appKey, String appSecret, String tenantSign, String version, String timestamp) {
            try {
                HttpClient client = HttpClients.createDefault();

                HttpGet request = new HttpGet(urlStr);
                request.setHeader("appKey", appKey);
                request.setHeader("version", version);
                request.setHeader("timestamp", timestamp);
                String signature = SignUtils.sign(appKey, appSecret, tenantSign, version, timestamp);
                request.setHeader("signature", signature);
                HttpResponse response = client.execute(request);

                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

                    String strResult = EntityUtils.toString(response.getEntity());
                    return strResult;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    /**
     * post请求(用于key-value格式的参数)
     * @param urlStr
     * @param params
     * @return
     */
    public static String doPost(String urlStr, Map params, String appKey, String appSecret, String tenantSign, String version, String timestamp){

        BufferedReader in = null;
        try {

            HttpClient client = HttpClients.createDefault();

            String charSet = "UTF-8";
            HttpPost request = new HttpPost();
            request.setHeader("appKey", appKey);
            request.setHeader("version", version);
            request.setHeader("timestamp", timestamp);
            String signature = SignUtils.sign(appKey, appSecret, tenantSign, version, timestamp);
            request.setHeader("signature", signature);
            request.setURI(new URI(urlStr));
            //设置参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String value = String.valueOf(params.get(name));
                nvps.add(new BasicNameValuePair(name, value));

            }
            request.setEntity(new UrlEncodedFormEntity(nvps,charSet));

            HttpResponse response = client.execute(request);
            int code = response.getStatusLine().getStatusCode();
            if(code == 200){ //请求成功
                in = new BufferedReader(new InputStreamReader(response.getEntity()
                        .getContent(),"utf-8"));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }
                in.close();
                return sb.toString();
            }
            else{ //
                System.out.println("状态码：" + code);
                return null;
            }
        }
        catch(Exception e){
            e.printStackTrace();

            return null;
        }
    }

    /**
     * post请求（用于请求json格式的参数）
     * @param urlStr
     * @param params
     * @return
     */
    public static String doPost(String urlStr, String params, String appKey, String appSecret, String tenantSign, String version, String timestamp) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(urlStr);// 创建httpPost
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("appKey", appKey);
        httpPost.setHeader("version", version);
        httpPost.setHeader("timestamp", timestamp);
        String signature = SignUtils.sign(appKey, appSecret, tenantSign, version, timestamp);
        httpPost.setHeader("signature", signature);
        String charSet = "UTF-8";
        StringEntity entity = new StringEntity(params, charSet);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;

        try {

            response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                return jsonString;
            }
            else{
                logger.error("请求返回:"+state+"("+urlStr+")");
            }
        }
        finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static JSONObject doPatch(String urlStr, JSONObject jsonObject, String appKey, String appSecret, String tenantSign, String version, String timestamp) {
        JSONObject resultObj = null;
        HttpClient httpClient = HttpClients.createDefault();
        HttpPatch httpPatch = new HttpPatch(urlStr);
        String charSet = "UTF-8";
        try{
        httpPatch.setHeader("Content-type", "application/json");
        httpPatch.setHeader("Charset", charSet);
        httpPatch.setHeader("Accept", "application/json");
        httpPatch.setHeader("Accept-Charset", charSet);
        httpPatch.setHeader("appKey", appKey);
        httpPatch.setHeader("version", version);
        httpPatch.setHeader("timestamp", timestamp);
        String signature = SignUtils.sign(appKey, appSecret, tenantSign, version, timestamp);
        httpPatch.setHeader("signature", signature);
        try {
            if (jsonObject != null){
                StringEntity entity = new StringEntity(jsonObject.toString(),charSet);
                httpPatch.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPatch);
            resultObj = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return resultObj;
    }

}




