package com.nb3.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils extends org.apache.commons.lang3.StringUtils  {

    /**
     * 检查字符串str是否匹配正则表达式regex
     *
     * @param regex
     *            正则表达式
     * @param str
     *            要检查的字符串
     * @return boolean
     */
    public static boolean matcherRegex(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * 检查电子邮件是否正确
     *
     * @param email
     *            电子邮件
     * @return boolean 邮箱正确返回true，否则返回false
     */
    public static boolean checkEmail(String email) {
        String regex = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        return matcherRegex(regex, email);
    }


    /**
     * 检查是否sql注入
     *
     * @param message
     *
     * @return boolean 正确返回true，否则返回false
     */
    public static boolean ifSqlInjection(String message) {
        String inj_str = "insert|select|delete|update|truncate|declare";
        String transMessage = message.toLowerCase();
        String[] inj_stra = inj_str.split("\\|");
        for (int i = 0; i < inj_stra.length; i++) {
            if (transMessage.trim().indexOf("" + inj_stra[i] + "") >= 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 转换编码到GBK
     *
     * @param ContentStr
     * @return
     */
    public static String convertToGBK(String ContentStr, String charsetName) throws UnsupportedEncodingException {
        return new String(ContentStr.getBytes(charsetName), "GBK");
    }

    /**
     * 判断字符串是否是数字（不为null，""或" "）
     *
     * @param str
     * @return
     */
    public static boolean isNotBlankNumeric(String str) {
        if (isNotBlank(str) && isNumeric(str)) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符类型
     *
     * @param ch
     *            传入的字符
     * @return int 隔断字符（空格、制表）返回0，数字返回1，字母返回2，其他返回3
     */
    public static int tokenCharType(char ch) {
        if ((ch == ' ') || (ch == '\t')) {
            return 0;
        }
        if ((ch >= '0') && (ch <= '9')) {
            return 1;
        }
        if ((ch >= 'A') && (ch <= 'Z')) {
            return 2;
        }
        return 3;
    }

    public static String removeEnter(String str) {
        if (isNotEmpty(str)) {
            str = remove(str, "\r");
            str = remove(str, "\n");
        }
        return str;
    }


    public static String removeNull(String str) {
        if (isNotEmpty(str)) {
            str = remove(str, " ");
        }
        return str;
    }
    public static String removeNullDot(String str) {
        if (isNotEmpty(str)) {
            str = remove(str, " ");
        }
        if (isNotEmpty(str)) {
            str = remove(str, ".");
        }
        if (isNotEmpty(str)) {
            str = remove(str, "\r\n");
        }
        return str;
    }


    /**
     * 去掉终端号码的86前缀
     *
     * @param termid
     *            String
     * @return String
     */
    public static String trim86(String termid) {
        return termid.startsWith("86") ? termid.substring(2) : termid;
    }

    /**
     * 将InputStream转成字符串
     *
     * @param is
     * @return
     */
    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "/n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();

    }

    /**
     * 将InputStream转成字符串
     *
     * @param is
     * @return
     */
    public static String inputStream2String(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i = -1;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        return baos.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String cardId = "110223198207121895";
        System.out.println(substring(cardId, cardId.length() - 6));

    }
    /**
     * 判断obj是否是null或者”“
     * @param obj
     * @return
     */
    public static boolean isNullForObj(Object obj) {
        if (obj == null ||  "".equals(obj) || "null".equals(obj)||"".equals(obj.toString().trim())) {
            return true;
        }
        return false;
    }

    /**
     * int 型数字转换成字符串
     * @param i
     * @return
     */
    public static String intToString(int i){
        return new Integer(i).toString();
    }
    public static int Str2Int(String s){

        int ii=0;

        if(s ==null || s.equals(""))
            return 0;
        else{

            try{
                ii=Integer.parseInt(s);
            }catch (Exception e) {

            }
        }
        return ii;

    }



    /**
     * 获取随机串
     *
     * @param length
     *            随机串长度
     * @param type
     *            类型 ：1. 数字 ；2.字母 ；3.数字+字母；
     * @return
     * @author 张广彬
     * @date 2013-7-10
     */
    public static String getRandomString(int length, int type) { // length表示生成字符串的长度
        String string = "";
        switch (type) {
            case 1:// 数字
                string = getRandomString(length, "0123456789");
                break;
            case 2:// 字母
                string = getRandomString(length, "abcdefghijklmnopqrstuvwxyz");
                break;
            case 3:// 数字+字母
                string = getRandomString(length, "abcdefghijklmnopqrstuvwxyz0123456789");
                break;
            default:
                break;
        }
        return string;
    }

    /**
     * 获取随机字符串
     *
     * @param length
     * @return
     * @author 张广彬
     * @date 2013-7-10
     */
    public static String getRandomString(int length, String baseString) { // length表示生成字符串的长度
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(baseString.length());
            sb.append(baseString.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 拷贝文件到新目录
     * @param oldFile 源文件
     * @param newFile 新文件
     */
    public static void copyFile(File oldFile,File newFile) throws Exception{
        try {
            //读取源文件
            BufferedReader read = new BufferedReader(new FileReader(oldFile));
            //准备写入文件
            BufferedWriter write = new BufferedWriter(new FileWriter(newFile));
            String temp = ""; //临时存储字符串
            while (( temp = read.readLine())!= null) {
                write.write(temp);
                write.newLine();
            }
            //关闭读入源
            read.close();
            //关闭写入源
            write.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }
    }



    public static  String dateFormat (Date date){
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);

    }
}
