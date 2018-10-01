package com.yiwise.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 签名
 * @author : yangdehong
 * @date : 2018/9/30 10:33
 */
public class SignUtils {


    public static String sign(TreeMap<String, Object> treeMap, String tenantSign) throws UnsupportedEncodingException {
        Iterator it = treeMap.entrySet().iterator();
        StringBuilder params = new StringBuilder();
        while (it.hasNext()) {
            Map.Entry ent = (Map.Entry) it.next();
            String key=ent.getKey().toString();
            if (!"signature".equals(key)) {
                String value=ent.getValue().toString();
                params.append(key).append("=").append(value).append("&");
            }
        }
        MessageDigest md = DigestUtils.getSha256Digest();
        byte[] result = md.digest((tenantSign+params.toString()+tenantSign).getBytes("UTF-8"));
        return Hex.encodeHexString(result);
    }

}
