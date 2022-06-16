package com.yiwise;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;


import static com.yiwise.util.HttpClientUtils.*;

public class TestDemo {
    public static final String APP_KEY = "xiEYGLE2XQmuhAK9";
    public static final String APP_SECRET = "ZbLEetmNE82utniLEJuawc6biOL1mTy6";
    public static final String TENANT_SIGN = "helloworld";
    public static final String VERSION = "v1";
    public static final String URL = "https://aicc-daily.yiwise.com";

    public static void main(String[] args) throws Exception {
        // 测试Get
        Long timestamp = System.currentTimeMillis();
        System.out.println(doGet("https://aicc-daily.yiwise.com/apiOpen/v1/tenant/getTenant", APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString()));

        //测试Post
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tenantPhoneNumberId", 1010);
        jsonObject.put("areaCode", "010");
        jsonObject.put("province", "北京市");
        jsonObject.put("city", "朝阳区");
        JSONArray jsonArray = new JSONArray();
        JSONObject deadArea = new JSONObject();
        deadArea.put("prov", "xx省");
        deadArea.put("city", "xx市");
        jsonArray.add(deadArea);
        jsonObject.put("deadArea", jsonArray);
        jsonObject.put("callOutIndustry", "FINANCE");
        System.out.println(doPost("https://aicc-daily.yiwise.com/apiOpen/v1/phone/updatePhoneInfoByTenantPhoneNumberId", jsonObject.toJSONString(), APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString()));


        //测试Patch
        JSONObject obj = new JSONObject();
        JSONObject obj3 = new JSONObject();
        obj.put("concurrencyQuota", 3);
        obj.put("enableConcurrency", true);
        obj.put("robotCallJobId", 33);
        obj.put("name", "测试2");
        obj.put("mode", "AUTO");
        obj.put("dailyStartTime", "09:00");
        obj.put("dailyEndTime", "21:00");
        JSONObject obj1 = new JSONObject();
        obj1.put("startTime", "10:00");
        obj1.put("endTime", "11:00");
        JSONObject obj2 = new JSONObject();
        obj2.put("startTime", "12:00");
        obj2.put("endTime", "13:00");
        obj.put("inactiveTimeList", new JSONObject[]{obj1, obj2});
        obj.put("description", "任务描述信息");
        obj.put("smsTemplateId", 1L);
        obj.put("robotCount", 2);
        obj.put("wechatAlertLevelCode", new String[]{"0", "1"});
        obj.put("wechatConditionAlertLevel", new int[]{2});
        obj.put("wechatAlertChatDurationThreshold", 10);
        obj.put("smsAlertLevel", new int[]{});
        obj.put("alertUsers", new Long[]{1L, 5L});
        obj.put("startTime", "2019-11-21 04:32:56");
        obj3.put("concurrencyQuota", 2);
        obj.put("redialCondition", new String[]{"CALL_LOSS"});
        obj.put("redialInterval", 6);
        obj.put("redialTimes", 6);
        obj3.put("jobPhoneNumberIdList", new Long[]{2788L});
        obj.put("transferPhoneNumber", new String[]{"1523654789", "1758426896"});
        obj3.put("robotCallJob", obj);

        System.out.println(doPatch("https://aicc-daily.yiwise.com/apiOpen/v1/job/modify", obj3, APP_KEY, APP_SECRET, TENANT_SIGN, VERSION, timestamp.toString()));
    }
}
