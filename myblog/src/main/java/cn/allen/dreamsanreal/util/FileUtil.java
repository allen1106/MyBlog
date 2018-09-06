package cn.allen.dreamsanreal.util;

import java.io.*;

public class FileUtil {
    public static String getContentFromFile(String filePath) {
        int is_len = 0;
        byte[] strBuffer = null;
        try {
            File file = new File(filePath);
            InputStream is = new FileInputStream(file);
            is_len = (int)file.length();
            strBuffer = new byte[is_len];
            try {
                is.read(strBuffer, 0, is_len);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new String(strBuffer);
    }

//    public static void main(String[] args) {
//        String s = "你好";
//        System.out.println("你好");
//        String s1 = null;
//        try {
//            s1 = new String(s.getBytes(), "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(s1);
//    }
}
