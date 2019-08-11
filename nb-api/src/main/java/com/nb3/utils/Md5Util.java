package com.nb3.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Md5Util {
	
	public static String md5(String plainText) {
        //定义一个字节数组
        byte[] secretBytes = null;
        try {
              // 生成一个MD5加密计算摘要  
            MessageDigest md = MessageDigest.getInstance("MD5");
            //对字符串进行加密
            md.update(plainText.getBytes());
            //获得加密后的数据
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        //将加密后的数据转换为16进制数字
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
    //主函数调用测试
    public static void main(String[] args) {


        //secret+method+param+token+timestamp+secret
        String secret = "af521f54-8bc0-4837-b1f4-3948f899d35f";
        String method = "10130103";
        String token = "9007c19e-da96-4ddd-84d0-93c6eba22e68";
        String timestamp = "1565500145022";
        //secret+method+param+token+timestamp+secret
        String signStr = secret+method+"{\"userId\":\"10\",\"hospitalId\":\"5\"}"+token+timestamp+secret;


        System.err.println("signStr ："+signStr);
        String sign = Md5Util.md5(signStr);
        System.err.println(sign);


        System.err.println("当前时间戳："+System.currentTimeMillis());
         //           af521f54-8bc0-4837-b1f4-3948f899d35f10130103{"userId":"10","hospitalId":"5"}9007c19e-da96-4ddd-84d0-93c6eba22e681565443844429af521f54-8bc0-4837-b1f4-3948f899d35f
	    //待签名字符串:af521f54-8bc0-4837-b1f4-3948f899d35f10130103{"userId":"10","hospitalId":"5"}9007c19e-da96-4ddd-84d0-93c6eba22e681565499798179af521f54-8bc0-4837-b1f4-3948f899d35f
        //md5签名：5db0677bb19c7be7458737d513b80670
	}



}
