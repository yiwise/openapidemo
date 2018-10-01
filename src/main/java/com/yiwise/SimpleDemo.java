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
//        String result = getCompanyList();
//        String result = getPhoneList();
//        String result = getRobotList();
//        String result = getTasks();
//        String result = getTaskById();
//        String result = getCallRecordInfoList();
        String result = callDetail();
        System.out.println(result);
    }

    /**
     * 公司列表
     * @return
     * @throws UnsupportedEncodingException
     */
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

    /**
     * 电话线列表
     * @return
     * @throws UnsupportedEncodingException
     */
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

    /**
     * 机器人列表
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String getRobotList() throws UnsupportedEncodingException {
        String url = "http://localhost:8060/openApi/v1/company/getRobots?";
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

    /**
     * 获取任务列表
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String getTasks() throws UnsupportedEncodingException {
        String url = "http://localhost:8060/openApi/v1/task/getTasks?";
        TreeMap<String,  Object> req = new TreeMap<>();
        req.put("name", "dialog");
        req.put("status", "TERMINATE");
        req.put("pageNum", 1);
        req.put("pageSize", 20);
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
    /**
     * 获取某个任务信息
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String getTaskById() throws UnsupportedEncodingException {
        String url = "http://localhost:8060/openApi/v1/task/getTaskDetail?";
        TreeMap<String,  Object> req = new TreeMap<>();
        req.put("robotCallJobId", 3);
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
    /**
     * 获取通话记录
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String getCallRecordInfoList() throws UnsupportedEncodingException {
        String url = "http://localhost:8060/openApi/v1/task/getCallRecordInfoList?";
        TreeMap<String,  Object> req = new TreeMap<>();
        req.put("robotCallJobId", 3);
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
    /**
     * 获取通话记录
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String callDetail() throws UnsupportedEncodingException {
        String url = "http://localhost:8060/openApi/v1/task/callDetail?";
        TreeMap<String,  Object> req = new TreeMap<>();
        req.put("callRecordId", 1);
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
