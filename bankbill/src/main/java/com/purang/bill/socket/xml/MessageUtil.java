package com.purang.bill.socket.xml;

import com.purang.bill.socket.pojo.AbstrMessage;
import com.purang.bill.socket.pojo.BaseMessage;
import com.purang.bill.socket.pojo.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Company :普兰科技
 * Create User:周明
 * Create Date:12-8-16
 * Create Time:下午5:01
 */
public class MessageUtil {

    public static Logger logger = LoggerFactory.getLogger(MessageUtil.class);

    public static String pattern = "yyyy-MM-dd";

    public static String object2Xml(Object obj) {
        StringBuffer sb = new StringBuffer();
        Class cs = obj.getClass().getSuperclass();
        Field[] parentFields = cs.getDeclaredFields();
        Field[] fields = obj.getClass().getDeclaredFields();
        List<Field> allFields = new ArrayList<Field>();
        for (Field f : parentFields) {
            allFields.add(f);
        }
        for (Field f : fields) {
            allFields.add(f);
        }
        for (Field field : allFields) {
            field.setAccessible(true);
            if (field.getName().equalsIgnoreCase("serialVersionUID")) {
                continue;
            }
            try {
                Object retObj = field.get(obj);
                Type type = field.getType();
                if (retObj != null && !"".equals(retObj.toString())) {
                    sb.append("<");
                    sb.append(field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
                    sb.append(">");
                    String value = convert(field, obj);
                    sb.append(value);
                    sb.append("</>");
                }
            } catch (IllegalAccessException e) {
                logger.error("生成XML出错......" + e);
            }
        }
        return sb.toString();
    }

    public static Map xml2Object(String xml) {
        Map map = new HashMap();
        String split = "</>";
        String regex = "<(\\w+)>(.+)";
        Pattern pattern = Pattern.compile(regex);
        String[] group = xml.split(split);
        for (String s : group) {
            Matcher matcher = pattern.matcher(s);
            boolean b = matcher.matches();
            if (b) {
                String key = matcher.group(1);
                String value = matcher.group(2);
                map.put(key, value);
            }
        }
        return map;
    }

    private static String convert(Field field, Object o) throws IllegalAccessException {
        String retValue = "";
        Type type = field.getType();
        Object value = field.get(o);
        if (type.equals(Date.class)) {
            Date date = (Date) value;
            DateFormat df = new SimpleDateFormat(pattern);
            retValue = df.format(date);
        } else {
            retValue = value.toString();
        }
        return retValue;
    }

    public static String numberToStr(int num, int len) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumIntegerDigits(len);
        nf.setMinimumIntegerDigits(len);
        String str = nf.format(num);
        return str;
    }

    public static String generateSendMessageBody(BaseMessage message) {
        String body = object2Xml(message);
        return body;
    }

    public static String generateSendMessageHeader(BaseMessage message) {
        String body = object2Xml(message);
        int bodyLen = body.length();
        int header1_num = bodyLen + AbstrMessage.HEADER_SIZE - 8;
        int header2_num = bodyLen;

        String header1 = numberToStr(header1_num, 8);
        String header2 = numberToStr(header2_num, 8);
        String header3 = message.getTradeCode();
        String header4 = "RQ";
        String header5 = "17";    //代表渠道(17 网上银行,18 手机银行,20呼叫中心)
        String header6 = "0000001"; //7位，固定
        String header7 = MD5.encode(body);
        String header8 = "3";    //固定(3 TCP方式,1 CICS)
        String header = header1 + header2 + header3 + header4 + header5 + header6 + header7 + header8;
        return header;
    }

    public static void main(String[] args) {
        Transfer t = new Transfer();
        t.setTradeCode("21B040");
        t.setSendSeqNo(12345678);
        t.setFlag('1');
        t.setPrimTranDate(new Date());
        t.setAmount(888.8);
        t.setaTeller("zhouming");
        t.setTermIP("127.0.0.1");
        t.setChannelId("tttttt");
        String str = MessageUtil.generateSendMessageHeader(t) + MessageUtil.generateSendMessageBody(t);
        logger.info("--------message-----\n\t" + str);
    }

/*    public static void main(String[] args) {
        String xml = "<TellerType0>03</><Teller>2601</><Brc>88</><TermId>ttyp6</>";
        Object ss = Object2Xml.xml2Object(xml);
        System.out.println("-----" + ss);
    }*/

}