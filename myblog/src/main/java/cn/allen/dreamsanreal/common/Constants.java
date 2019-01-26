package cn.allen.dreamsanreal.common;

public class Constants {
    public static final String DATA_PATH = "E:/我是Java程序猿/MyBlog/myblog/src/main/resources/data/";
    public static final String ARTICLE_DIR = "article/";
    public static final String IMAGE_DIR = "article/";
    public static final String USER = "user";
    public enum RequestMethod {
        GET("GET"), POST("POST");

        private String name;

        private RequestMethod(String name) {
            this.name = name;
        }
    }
}
