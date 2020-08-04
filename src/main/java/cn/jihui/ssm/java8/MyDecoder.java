package cn.jihui.ssm.java8;

import java.util.Base64;

public class MyDecoder {
    public static void main(String[] args) throws Exception{
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();
        String content = "编码测试";
        String encodeString = encoder.encodeToString(content.getBytes("UTF-8"));
        System.out.println(encodeString);
        String decodeString = new String(decoder.decode(encodeString), "UTF-8");
        System.out.println(decodeString);
    }
}
