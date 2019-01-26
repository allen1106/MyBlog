package cn.allen.dreamsanreal.util;

import cn.allen.dreamsanreal.common.Constants;
import org.springframework.util.ResourceUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import java.io.*;
import java.net.URLDecoder;

public class HtmlUtil {
    public static void generateHtmlByTemplate(String blog_num, String title, String summary, String content) {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        String filePath = "/static/templates/blog/";
        resolver.setPrefix(filePath);
        resolver.setSuffix(".html");
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        Context context = new Context();
        context.setVariable("title", title);
        context.setVariable("summary", summary);
        context.setVariable("content", content);

        String articlePath = Constants.DATA_PATH + Constants.ARTICLE_DIR;
        String articleFileName = articlePath + blog_num + ".html";
        System.out.println(articleFileName);
        File article_html = new File(articleFileName);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(article_html);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Write blog file failed!");
        }
        System.out.println(filePath);
        templateEngine.process("template_content", context, fileWriter);
    }

    public static void main(String[] args) throws Exception {
        HtmlUtil htmlUtil = new HtmlUtil();
//        htmlUtil.generateHtmlByTemplate("1", "title 1", "summary 1", "content 1");
        File file = new File(ResourceUtils.getURL("classpath:").getPath());
        System.out.println(file.getAbsolutePath());
        String html_path = file.getAbsolutePath() + "/static/templates/article/1.html";
//        String html_path = "1.html";
        System.out.println(html_path);
        html_path = URLDecoder.decode(html_path, "UTF-8");
        System.out.println(html_path);
        File article_html = new File(html_path);
        System.out.println(article_html.getAbsolutePath());
        FileWriter fileWriter = new FileWriter(article_html);

    }
}
