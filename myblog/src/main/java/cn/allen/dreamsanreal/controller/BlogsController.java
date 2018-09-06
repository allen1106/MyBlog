package cn.allen.dreamsanreal.controller;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cn.allen.dreamsanreal.util.FileUtil;

@Controller
public class BlogsController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/blog", method = RequestMethod.GET)
    public String index(Model model) {
        String mdFilePath = "src/main/resources/static/templates/demo-md-file.txt";
        FileUtil fu = new FileUtil();
        String s1 = fu.getContentFromFile(mdFilePath);
        String s = "你好";
        try {
            System.out.println(new String(s1.getBytes(), "UTF8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        model.addAttribute("str", "你好");
        model.addAttribute("mdStr", fu.getContentFromFile(mdFilePath));
        return "blogs";
    }
}
