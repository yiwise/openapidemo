package com.yiwise;

import com.alibaba.fastjson.JSONObject;
import com.yiwise.model.CustomerPersonImportVO;
import com.yiwise.model.RobotCallJobPO;
import com.yiwise.util.HttpUrlConnectionUtils;

import java.time.LocalTime;
import java.util.*;

/**
 * 简单模型
 * @author : yangdehong
 * @date : 2018/9/30 12:03
 */
public class SimpleDemo {

    public static String APP_KEY = "ZbUDDjRzJonhvDCv";
    public static String APP_SECRET = "ZOPwAaRSShjkDapgXZVLFcDwysMZDmuM";

    public static final String TENANT_SIGN = "yangdehong";

    public static final String VERSION = "v1";

    public static final String URL = "https://openapi.tanyibot.com";
//    public static final String URL = "https://crm.yiwise.com";
//    public static final String URL = "http://127.0.0.1:8060";

    public static void main(String[] args) {
//        getTenant();
//        getPhoneList();
//        getDialogFlowList();

//        getJobs();
        getJobDetail();
//
//        getCallRecordInfoList();
//        callDetail();

//        createTask();
//        deleteTask();
//        updateTask();
//        pauseTask();
//        stopTask();

//        importTaskCustomer();
//        startTask();
//        updateTaskAiCount();
    }

    /**
     * 公司列表
     * @return
     */
    private static void getTenant() {
        String url = URL+"/apiOpen/v1/tenant/getTenant";
        Long timestamp = System.currentTimeMillis();
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }

    /**
     * 电话线列表
     * @return
     */
    private static void getPhoneList() {
        String url = URL+"/apiOpen/v1/phone/getPhoneList";
        Long timestamp = System.currentTimeMillis();
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }

    /**
     * 机器人话术列表
     * @return
     */
    private static void getDialogFlowList() {
        String url = URL+"/apiOpen/v1/dialogFlow/getDialogFlowList";
        Long timestamp = System.currentTimeMillis();
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }

    /**
     * 获取任务列表
     * @return
     */
    private static void getJobs() {
        String url = URL+"/apiOpen/v1/job/getJobs";
        Long timestamp = System.currentTimeMillis();
//        try {
//            url = url+"?name="+ URLEncoder.encode("测试","utf-8") +"&status=IN_PROCESS"+"&pageNum=1"+"&pageSize=20";
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }
    /**
     * 获取某个任务信息
     * @return
     */
    private static void getJobDetail() {
        String url = URL+"/apiOpen/v1/job/getJobDetail";
        Long timestamp = System.currentTimeMillis();
        url = url+"?robotCallJobId=2086";
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }
    /**
     * 获取已呼电话列表
     * @return
     */
    private static void getCallRecordInfoList() {
        String url = URL+"/apiOpen/v1/callRecord/getCallRecordInfoList";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("robotCallJobId", 28);
//        jsonObject.put("searchWords", "测试");
//        Set<String> dialStatusEnumSet = new HashSet<>();
//        dialStatusEnumSet.add("ANSWERED");
//        jsonObject.put("resultStatuses", dialStatusEnumSet);
//        Set<String> intentLevelsEnumSet = new HashSet<>();
//        intentLevelsEnumSet.add("A");
//        jsonObject.put("intentLevels", intentLevelsEnumSet);
//        jsonObject.put("dialogFlowId", 2);
//        jsonObject.put("pageNum", 1);
//        jsonObject.put("pageSize", 20);
//        System.out.println(jsonObject.toJSONString());
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }
    /**
     * 获取通话记录详情
     * @return
     */
    private static void callDetail() {
        String url = URL+"/apiOpen/v1/callRecord/callDetail";
        Long timestamp = System.currentTimeMillis();
        url = url+"?callRecordId=2457790";
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }
    /**
     * 创建任务
     * @return
     */
    private static void createTask()  {
        String url = URL+"/apiOpen/v1/job/create";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        RobotCallJobPO robotCallJobPO = new RobotCallJobPO();
        robotCallJobPO.setTenantId(73L);
        robotCallJobPO.setDialogFlowId(129L);
        robotCallJobPO.setName("测试名称1011-03");
        robotCallJobPO.setMode("MANUAL");
//        robotCallJobPO.setRobotCount(1);
        robotCallJobPO.setDailyStartTime(LocalTime.of(9, 0));
        robotCallJobPO.setDailyEndTime(LocalTime.of(20, 0));
        robotCallJobPO.setInactiveStartTime(LocalTime.of(12, 0));
        robotCallJobPO.setInactiveEndTime(LocalTime.of(13, 0));
        robotCallJobPO.setDescription("gthjoitjdjfdk");
        robotCallJobPO.setSmsTemplateId(1L);
        robotCallJobPO.setPhoneType("MOBILE");
        Set<String> wechatAlertLevel = new HashSet<>();
        robotCallJobPO.setWechatAlertLevel(wechatAlertLevel);
        Set<String> smsAlertLevel = new HashSet<>();
        smsAlertLevel.add("A");
        robotCallJobPO.setSmsAlertLevel(smsAlertLevel);
        Set<Long> alertUsers = new HashSet<>();
        robotCallJobPO.setAlertUsers(alertUsers);
        Set<Long> earlyWarning = new HashSet<>();
        robotCallJobPO.setEarlyWarningAlertUsers(earlyWarning);
        robotCallJobPO.setStartTime("2018-11-07 05:05:05");
        robotCallJobPO.setWechatSendMethod("SENDTOALL");
        jsonObject.put("concurrencyQuota", 1);
        jsonObject.put("robotCallJob", robotCallJobPO);
        List<Long> longStringBOS = new ArrayList<>();
        longStringBOS.add(22L);
        jsonObject.put("jobPhoneNumberIdList",longStringBOS);
//        System.out.println(jsonObject.toJSONString());
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }
    /**
     * 删除任务
     * @return
     */
    private static void deleteTask()  {
        String url = "https://robot.yiwise.com/apiOpen/v1/job/delete";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotCallJobId", 30);
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }
    /**
     * 开启任务
     * @return
     */
    private static void startTask()  {
        String url = URL+"/apiOpen/v1/job/start";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotCallJobId", 2086);
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }

    /**
     * 开启任务
     * @return
     */
    private static void pauseTask()  {
        String url = URL+"/apiOpen/v1/job/pause";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotCallJobId", 28);
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }

    /**
     * 开启任务
     * @return
     */
    private static void stopTask()  {
        String url = URL+"/apiOpen/v1/job/stop";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotCallJobId", 28);
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }

    /**
     * 向任务中导入客户
     * @return
     */
    private static void importTaskCustomer()  {
        String url = URL+"/apiOpen/v1/job/importCustomer";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        List<CustomerPersonImportVO> customerPersons = new ArrayList<>();
        CustomerPersonImportVO customerPersonImportVO = new CustomerPersonImportVO();
        customerPersonImportVO.setName("ydh");
        customerPersonImportVO.setPhoneNumber("18100185002");
        Map<String, String> properties = new HashMap<>();
        properties.put("变量", "jjj");
        customerPersonImportVO.setProperties(properties);
        customerPersons.add(customerPersonImportVO);
        jsonObject.put("robotCallJobId", 2086);
        jsonObject.put("customerPersons", customerPersons);
//        System.out.println(jsonObject.toJSONString());
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }

    /**
     * 修改任务并发数
     * @return
     */
    private static void updateTaskAiCount()  {
        String url = URL+"/apiOpen/v1/job/updateAiCount";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotCallJobId", 1054);
        jsonObject.put("robotCount", 1);
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }

}
