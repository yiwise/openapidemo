package com.yiwise.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * 签名
 * @author : yangdehong
 * @date : 2018/9/30 10:33
 */
public class SignUtils {


    public static String sign(String appKey, String appSecret, String tenantSign, String version, String timestamp) throws UnsupportedEncodingException {
        String params = "appKey="+appKey+"&appSecret="+appSecret+"&tenantSign="+tenantSign+"&version="+version+"&timestamp="+timestamp;
        MessageDigest md = DigestUtils.getSha256Digest();
        md.update(tenantSign.getBytes("UTF-8"));
        byte[] result = md.digest(params.getBytes("UTF-8"));
        return Hex.encodeHexString(result);
    }

}
