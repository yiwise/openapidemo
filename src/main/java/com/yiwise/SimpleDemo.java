package com.yiwise;

import com.alibaba.fastjson.JSONObject;
import com.yiwise.util.HttpUrlConnectionUtils;

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

    public static void main(String[] args) {
//        String result = getCompanyList();
//        String result = getPhoneList();
//        String result = getRobotList();
//        String result = getTasks();
//        String result = getTaskById();
//        String result = getCallRecordInfoList();
//        String result = callDetail();
//        String result = createTask();
//        String result = deleteTask();
//        String result = updateTask();
//        String result = startTask();
//        String result = pauseTask();
        String result = stopTask();
        System.out.println(result);
    }

    /**
     * 公司列表
     * @return
     */
    private static String getCompanyList() {
        String url = "http://localhost:8060/openApi/v1/company/getCompanies";
        Long timestamp = System.currentTimeMillis();
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }

    /**
     * 电话线列表
     * @return
     */
    private static String getPhoneList() {
        String url = "http://localhost:8060/openApi/v1/company/getPhones";
        Long timestamp = System.currentTimeMillis();
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }

    /**
     * 机器人列表
     * @return
     */
    private static String getRobotList() {
        String url = "http://localhost:8060/openApi/v1/company/getRobots";
        Long timestamp = System.currentTimeMillis();
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }

    /**
     * 获取任务列表
     * @return
     */
    private static String getTasks() {
        String url = "http://localhost:8060/openApi/v1/task/getTasks";
        Long timestamp = System.currentTimeMillis();
        url = url+"?name=dialog"+"&status=TERMINATE"+"&pageNum=1"+"&pageSize=20";
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }
    /**
     * 获取某个任务信息
     * @return
     */
    private static String getTaskById() {
        String url = "http://localhost:8060/openApi/v1/task/getTaskDetail";
        Long timestamp = System.currentTimeMillis();
        url = url+"?robotCallJobId=3";
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }
    /**
     * 获取通话记录
     * @return
     */
    private static String getCallRecordInfoList() {
        String url = "http://localhost:8060/openApi/v1/task/getCallRecordInfoList";
        Long timestamp = System.currentTimeMillis();
        url = url+"?robotCallJobId=3";
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }
    /**
     * 获取通话记录详情
     * @return
     */
    private static String callDetail() {
        String url = "http://localhost:8060/openApi/v1/task/callDetail";
        Long timestamp = System.currentTimeMillis();
        url = url+"?callRecordId=1";
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }
    /**
     * 创建任务
     * @return
     */
    private static String createTask()  {
        String url = "http://localhost:8060/openApi/v1/task/create";
        Long timestamp = System.currentTimeMillis();
        String params = "{\n" +
                "\t\"robotCallJob\": {\n" +
                "\t\t\"tenantId\": 1,\n" +
                "\t\t\"dialogFlowId\": 2,\n" +
                "\t\t\"name\": \"测试名称\",\n" +
                "\t\t\"mode\": \"AUTO\",\n" +
                "\t\t\"robotCount\": 2,\n" +
                "\t\t\"dailyStartTime\": \"09:00\",\n" +
                "\t\t\"dailyEndTime\": \"21:00\",\n" +
                "\t\t\"inactiveStartTime\": \"12:00\",\n" +
                "\t\t\"inactiveEndTime\": \"13:00\",\n" +
                "\t\t\"description\": \"任务描述信息\",\n" +
                "\t\t\"smsTemplateId\": 1,\n" +
                "\t\t\"phoneType\": \"UNFIXED_CALL\",\n" +
                "\t\t\"wechatAlertLevel\": [\n" +
                "\t\t\t\"A\",\n" +
                "\t\t\t\"B\"\n" +
                "\t\t],\n" +
                "\t\t\"smsAlertLevel\": [\"A\",\"B\"],\n" +
                "\t\t\"alertUsers\": [\n" +
                "\t\t\t1,\n" +
                "\t\t\t5\n" +
                "\t\t],\n" +
                "\t\t\"earlyWarningAlertUsers\": [1, 2],\n" +
                "\t\t\"startTime\": \"2017-11-21 04:32:56\",\n" +
                "\t\t\"wechatSendMethod\": \"SENDTOALL\"\n" +
                "\t},\n" +
                "\t\"jobTasksFileUrl\": \"http://www.baidu.com\",\n" +
                "\t\"jobPhoneNumberList\": [{\n" +
                "\t\t\"key\": 1\n" +
                "\t}]\n" +
                "}";
        String result = HttpUrlConnectionUtils.doPost(url, params, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }
    /**
     * 删除任务
     * @return
     */
    private static String deleteTask()  {
        String url = "http://localhost:8060/openApi/v1/task/delete";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotCallJobId", 15);
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }
    /**
     * 修改任务
     * @return
     */
    private static String updateTask()  {
        String url = "http://localhost:8060/openApi/v1/task/create";
        Long timestamp = System.currentTimeMillis();
        String params = "{\n" +
                "\t\"robotCallJob\": {\n" +
                "\t\t\"robotCallJobId\": 2,\n" +
                "\t\t\"name\": \"测试2\",\n" +
                "\t\t\"mode\": \"AUTO\",\n" +
                "\t\t\"dailyStartTime\": \"09:00\",\n" +
                "\t\t\"dailyEndTime\": \"21:00\",\n" +
                "\t\t\"inactiveStartTime\": \"12:00\",\n" +
                "\t\t\"inactiveEndTime\": \"13:00\",\n" +
                "\t\t\"description\": \"任务描述信息\",\n" +
                "\t\t\"smsTemplateId\": 1,\n" +
                "\t\t\"robotCount\": 2,\n" +
                "\t\t\"wechatAlertLevel\": [\n" +
                "\t\t\t\"A\",\n" +
                "\t\t\t\"B\"\n" +
                "\t\t],\n" +
                "\t\t\"smsAlertLevel\": [],\n" +
                "\t\t\"alertUsers\": [\n" +
                "\t\t\t1,\n" +
                "\t\t\t5\n" +
                "\t\t],\n" +
                "\t\t\"startTime\": \"2017-11-21 04:32:56\"\n" +
                "\t},\n" +
                "\t\"jobPhoneNumberList\": [\n" +
                "\t\t1\n" +
                "\t]\n" +
                "}";
        String result = HttpUrlConnectionUtils.doPost(url, params, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }
    /**
     * 开启任务
     * @return
     */
    private static String startTask()  {
        String url = "http://localhost:8060/openApi/v1/task/start";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotCallJobId", 10);
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }

    /**
     * 开启任务
     * @return
     */
    private static String pauseTask()  {
        String url = "http://localhost:8060/openApi/v1/task/pause";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotCallJobId", 10);
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }

    /**
     * 开启任务
     * @return
     */
    private static String stopTask()  {
        String url = "http://localhost:8060/openApi/v1/task/stop";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotCallJobId", 10);
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }

}
