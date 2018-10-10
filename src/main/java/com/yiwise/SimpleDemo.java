package com.yiwise;

import com.alibaba.fastjson.JSONObject;
import com.yiwise.model.CustomerPersonImportVO;
import com.yiwise.model.LongStringBO;
import com.yiwise.model.RobotCallJobPO;
import com.yiwise.util.HttpUrlConnectionUtils;

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

    public static String APP_KEY = "yangdehong";
    public static String APP_SECRET = "123456";

    public static final String TENANT_SIGN = "yiwise";

    public static final String VERSION = "v1";

    public static void main(String[] args) throws Exception {
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
//        String result = stopTask();
        String result = importTaskCustomer();
//        String result = updateTaskAiCount();
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
    private static String getTasks() throws Exception {
        String url = "http://localhost:8060/openApi/v1/task/getTasks";
        Long timestamp = System.currentTimeMillis();
        url = url+"?name="+ URLEncoder.encode("测试","utf-8") +"&status=IN_PROCESS"+"&pageNum=1"+"&pageSize=20";
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
        url = url+"?robotCallJobId=28";
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
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotCallJobId", 28);
        jsonObject.put("searchWords", "测试");
        jsonObject.put("customerGroupId", 1);
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
        JSONObject jsonObject = new JSONObject();
        RobotCallJobPO robotCallJobPO = new RobotCallJobPO();
        robotCallJobPO.setTenantId(1L);
        robotCallJobPO.setDialogFlowId(2L);
        robotCallJobPO.setName("测试名称");
        robotCallJobPO.setMode("AUTO");
        robotCallJobPO.setRobotCount(10);
        robotCallJobPO.setDailyStartTime(LocalTime.of(9, 0));
        robotCallJobPO.setDailyEndTime(LocalTime.of(21, 0));
        robotCallJobPO.setInactiveStartTime(LocalTime.of(12, 0));
        robotCallJobPO.setInactiveEndTime(LocalTime.of(13, 0));
        robotCallJobPO.setDescription("gthjoitjdjfdk");
        robotCallJobPO.setSmsTemplateId(1L);
        robotCallJobPO.setPhoneType("LANDLINE");
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
        longStringBO.setKey(348L);
        longStringBO.setValue("test");
        longStringBOS.add(longStringBO);
        jsonObject.put("jobPhoneNumberList",longStringBOS);
        System.out.println(jsonObject.toJSONString());
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
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
        jsonObject.put("robotCallJobId", 30);
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }
//    /**
//     * 修改任务
//     * @return
//     */
//    private static String updateTask()  {
//        String url = "http://localhost:8060/openApi/v1/task/modify";
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
    private static String startTask()  {
        String url = "http://localhost:8060/openApi/v1/task/start";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotCallJobId", 31);
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

    /**
     * 向任务中导入客户
     * @return
     */
    private static String importTaskCustomer()  {
        String url = "http://localhost:8060/openApi/v1/task/importTaskCustomer";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        List<CustomerPersonImportVO> customerPersons = new ArrayList<>();
        CustomerPersonImportVO customerPersonImportVO = new CustomerPersonImportVO();
        customerPersonImportVO.setName("test");
        customerPersonImportVO.setPhoneNumber("11111111111");
        Map<String, String> properties = new HashMap<>();
        properties.put("ss", "jjj");
        customerPersonImportVO.setProperties(properties);
        customerPersons.add(customerPersonImportVO);
        jsonObject.put("robotCallJobId", 28);
        jsonObject.put("customerPersons", customerPersons);
        System.out.println(jsonObject.toJSONString());
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }

    /**
     * 修改任务并发数
     * @return
     */
    private static String updateTaskAiCount()  {
        String url = "http://localhost:8060/openApi/v1/task/updateTaskAiCount";
        Long timestamp = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotCallJobId", 28);
        jsonObject.put("robotCount", 2);
        System.out.println(jsonObject.toJSONString());
        String result = HttpUrlConnectionUtils.doPost(url, jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString());
        return result;
    }

}
