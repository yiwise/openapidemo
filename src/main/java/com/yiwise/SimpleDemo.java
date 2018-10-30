package com.yiwise;

import com.alibaba.fastjson.JSONObject;
import com.yiwise.model.CustomerPersonImportVO;
import com.yiwise.model.LongStringBO;
import com.yiwise.model.RobotCallJobPO;
import com.yiwise.util.HttpUrlConnectionUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * 简单模型
 * @author : yangdehong
 * @date : 2018/9/30 12:03
 */
public class SimpleDemo {

    public static String APP_KEY = "gvlfIPLJTMEAHgyM";
    public static String APP_SECRET = "TuPngoiRCvpxYdOHcQOsWYvaLGhATNiW";

    public static final String TENANT_SIGN = "zhongna";

    public static final String VERSION = "v1";

    public static final String URL = "https://crm.tanyibot.com";
//    public static final String URL = "http://127.0.0.1:8060";

    public static void main(String[] args) {
        getCompanyList();
//        getPhoneList();
//        getRobotList();
//        getTasks();
//        getTaskById();
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
    private static void getCompanyList() {
        String url = URL+"/apiOpen/v1/tenant/getTenants";
        Long timestamp = System.currentTimeMillis();
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }

    /**
     * 电话线列表
     * @return
     */
    private static void getPhoneList() {
        String url = URL+"/apiOpen/v1/tenant/getPhones";
        Long timestamp = System.currentTimeMillis();
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }

    /**
     * 机器人列表
     * @return
     */
    private static void getRobotList() {
        String url = URL+"/apiOpen/v1/tenant/getRobots";
        Long timestamp = System.currentTimeMillis();
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }

    /**
     * 获取任务列表
     * @return
     */
    private static void getTasks() {
        String url = URL+"/apiOpen/v1/task/getTasks";
        Long timestamp = System.currentTimeMillis();
        try {
            url = url+"?name="+ URLEncoder.encode("测试","utf-8") +"&status=IN_PROCESS"+"&pageNum=1"+"&pageSize=20";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }
    /**
     * 获取某个任务信息
     * @return
     */
    private static void getTaskById() {
        String url = URL+"/apiOpen/v1/task/getTaskDetail";
        Long timestamp = System.currentTimeMillis();
        url = url+"?robotCallJobId=121";
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }
    /**
     * 获取已呼电话列表
     * @return
     */
    private static void getCallRecordInfoList() {
        String url = URL+"/apiOpen/v1/task/getCallRecordInfoList";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotCallJobId", 28);
        jsonObject.put("searchWords", "测试");
//        jsonObject.put("customerGroupId", 1);
        Set<String> dialStatusEnumSet = new HashSet<>();
        dialStatusEnumSet.add("ANSWERED");
        jsonObject.put("resultStatuses", dialStatusEnumSet);
        Set<String> intentLevelsEnumSet = new HashSet<>();
        intentLevelsEnumSet.add("A");
        jsonObject.put("intentLevels", intentLevelsEnumSet);
        jsonObject.put("followStatus", "AI_INITIAL_VISIT");
        jsonObject.put("dialogFlowId", 2);
        jsonObject.put("earliestCreationTime", "2018-07-25");
        jsonObject.put("latestCreationTime", "2018-07-25");
        jsonObject.put("getTrainTaskList", true);
        jsonObject.put("pageNum", 1);
        jsonObject.put("pageSize", 20);
        System.out.println(jsonObject.toJSONString());
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }
    /**
     * 获取通话记录详情
     * @return
     */
    private static void callDetail() {
        String url = URL+"/apiOpen/v1/task/callDetail";
        Long timestamp = System.currentTimeMillis();
        url = url+"?callRecordId=1";
        String result = HttpUrlConnectionUtils.doGet(url, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }
    /**
     * 创建任务
     * @return
     */
    private static void createTask()  {
        String url = URL+"/apiOpen/v1/task/create";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        RobotCallJobPO robotCallJobPO = new RobotCallJobPO();
        robotCallJobPO.setTenantId(1L);
        robotCallJobPO.setDialogFlowId(316L);
        robotCallJobPO.setName("测试名称1011-03");
        robotCallJobPO.setMode("MANUAL");
        robotCallJobPO.setRobotCount(1);
        robotCallJobPO.setDailyStartTime(LocalTime.of(9, 0));
        robotCallJobPO.setDailyEndTime(LocalTime.of(22, 0));
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
        robotCallJobPO.setStartTime(LocalDateTime.of(2017, 11, 21, 4,32));
        robotCallJobPO.setWechatSendMethod("SENDTOALL");
        jsonObject.put("robotCallJob", robotCallJobPO);
        List<LongStringBO> longStringBOS = new ArrayList<>();
        LongStringBO longStringBO = new LongStringBO();
        longStringBO.setKey(355L);
        longStringBO.setValue("test");
        longStringBOS.add(longStringBO);
        jsonObject.put("jobPhoneNumberList",longStringBOS);
        System.out.println(jsonObject.toJSONString());
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }
    /**
     * 删除任务
     * @return
     */
    private static void deleteTask()  {
        String url = "https://robot.yiwise.com/apiOpen/v1/task/delete";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotCallJobId", 30);
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }
//    /**
//     * 修改任务
//     * @return
//     */
//    private static String updateTask()  {
//        String url = "http://localhost:8060/apiOpen/v1/task/modify";
//        Long timestamp = System.currentTimeMillis();
//        JSONObject jsonObject = new JSONObject();
//        RobotCallJobPO robotCallJobPO = new RobotCallJobPO();
//        robotCallJobPO.setRobotCallJobId(31L);
//        robotCallJobPO.setTenantId(1L);
//        robotCallJobPO.setDialogFlowId(2L);
//        robotCallJobPO.setName("测试名称3333");
//        robotCallJobPO.setMode("AUTO");
//        robotCallJobPO.setRobotCount(10);
//        robotCallJobPO.setDailyStartTime(LocalTime.of(9, 0));
//        robotCallJobPO.setDailyEndTime(LocalTime.of(21, 0));
//        robotCallJobPO.setInactiveStartTime(LocalTime.of(12, 0));
//        robotCallJobPO.setInactiveEndTime(LocalTime.of(13, 0));
//        robotCallJobPO.setDescription("gthjoitjdjfdk");
//        robotCallJobPO.setSmsTemplateId(1L);
//        robotCallJobPO.setPhoneType("LANDLINE");
//        Set<String> wechatAlertLevel = new HashSet<>();
//        robotCallJobPO.setWechatAlertLevel(wechatAlertLevel);
//        Set<String> smsAlertLevel = new HashSet<>();
//        smsAlertLevel.add("A");
//        robotCallJobPO.setSmsAlertLevel(smsAlertLevel);
//        Set<Long> alertUsers = new HashSet<>();
//        robotCallJobPO.setAlertUsers(alertUsers);
//        Set<Long> earlyWarning = new HashSet<>();
//        robotCallJobPO.setEarlyWarningAlertUsers(earlyWarning);
//        robotCallJobPO.setStartTime(LocalDateTime.of(2017, 11, 21, 4,32));
//        robotCallJobPO.setWechatSendMethod("SENDTOALL");
//        jsonObject.put("robotCallJob", robotCallJobPO);
//        List<LongStringBO> longStringBOS = new ArrayList<>();
//        LongStringBO longStringBO = new LongStringBO();
//        longStringBO.setKey(348L);
//        longStringBO.setValue("test");
//        longStringBOS.add(longStringBO);
//        jsonObject.put("jobPhoneNumberList",longStringBOS);
//        System.out.println(jsonObject.toJSONString());
//        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
//        return result;
//    }
    /**
     * 开启任务
     * @return
     */
    private static void startTask()  {
        String url = URL+"/apiOpen/v1/task/start";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotCallJobId", 46);
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }

    /**
     * 开启任务
     * @return
     */
    private static void pauseTask()  {
        String url = URL+"/apiOpen/v1/task/pause";
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
        String url = URL+"/apiOpen/v1/task/stop";
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
        String url = URL+"/apiOpen/v1/task/importTaskCustomer";
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
        jsonObject.put("robotCallJobId", 121);
        jsonObject.put("customerPersons", customerPersons);
        System.out.println(jsonObject.toJSONString());
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }

    /**
     * 修改任务并发数
     * @return
     */
    private static void updateTaskAiCount()  {
        String url = URL+"/apiOpen/v1/task/updateTaskAiCount";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotCallJobId", 28);
        jsonObject.put("robotCount", 1);
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        System.out.println(result);
    }

}
