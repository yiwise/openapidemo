package com.yiwise;

import com.yiwise.util.HttpUrlConnectionUtils;
import com.yiwise.util.SignUtils;

import java.io.UnsupportedEncodingException;

/**
 * 简单模型
 * @author : yangdehong
 * @date : 2018/9/30 12:03
 */
public class SimpleDemo {

    public static String APP_KEY = "yangdehong";
    public static String APP_SECRET = "123456";

    public static final String TENANT_SIGN = "yiwise";

    public static final String VERSION = "v1";

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
        String url = "http://localhost:8060/openApi/v1/company/getCompanies";
        Long timestamp = System.currentTimeMillis();
        String signature = SignUtils.sign(APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        url = url+"?signature=" + signature;
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }

    /**
     * 电话线列表
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String getPhoneList() throws UnsupportedEncodingException {
        String url = "http://localhost:8060/openApi/v1/company/getPhones";
        Long timestamp = System.currentTimeMillis();
        String signature = SignUtils.sign(APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        url = url+"?signature=" + signature;
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }

    /**
     * 机器人列表
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String getRobotList() throws UnsupportedEncodingException {
        String url = "http://localhost:8060/openApi/v1/company/getRobots";
        Long timestamp = System.currentTimeMillis();
        String signature = SignUtils.sign(APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        url = url+"?signature=" + signature;
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }

    /**
     * 获取任务列表
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String getTasks() throws UnsupportedEncodingException {
        String url = "http://localhost:8060/openApi/v1/task/getTasks";
        Long timestamp = System.currentTimeMillis();
        String signature = SignUtils.sign(APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        url = url+"?signature="+signature+"&name=dialog"+"&status=TERMINATE"+"&pageNum=1"+"&pageSize=20";
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }
    /**
     * 获取某个任务信息
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String getTaskById() throws UnsupportedEncodingException {
        String url = "http://localhost:8060/openApi/v1/task/getTaskDetail";
        Long timestamp = System.currentTimeMillis();
        String signature = SignUtils.sign(APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        url = url+"?signature="+signature+"&robotCallJobId=3";
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }
    /**
     * 获取通话记录
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String getCallRecordInfoList() throws UnsupportedEncodingException {
        String url = "http://localhost:8060/openApi/v1/task/getCallRecordInfoList";
        Long timestamp = System.currentTimeMillis();
        String signature = SignUtils.sign(APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        url = url+"?signature="+signature+"&robotCallJobId=3";
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }
    /**
     * 获取通话记录
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String callDetail() throws UnsupportedEncodingException {
        String url = "http://localhost:8060/openApi/v1/task/callDetail";
        Long timestamp = System.currentTimeMillis();
        String signature = SignUtils.sign(APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        url = url+"?signature="+signature+"&callRecordId=1";
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }

}
