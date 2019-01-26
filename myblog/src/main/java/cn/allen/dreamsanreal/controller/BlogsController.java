package cn.allen.dreamsanreal.controller;

import cn.allen.dreamsanreal.common.Constants;
import cn.allen.dreamsanreal.model.User;
import cn.allen.dreamsanreal.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cn.allen.dreamsanreal.util.FileUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@Controller
@RequestMapping(value = "/blog")
public class BlogsController {

    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/management")
    public String getMyBlog(Model model) {
        Object myblog = "blogs";
        return "blog/blog-management";
    }

    @GetMapping(value = "/edit")
    public String getEditBlogTemplate(Model model) {
        String title = "欢迎使用DREAMSANREAL-markdown编辑器";
        String mdFilePath = "src/main/resources/static/templates/demo-md-file.txt";
        FileUtil fu = new FileUtil();
        model.addAttribute("title", title);
        model.addAttribute("mdStr", fu.getContentFromFile(mdFilePath));
        return "blog/blog-edit";
    }

    @PostMapping(value = "/edit")
    public String editBlog(
            @RequestParam(name = "title", required = true)
                    String title,
            @RequestParam(name = "summary", required = true)
                    String summary,
            @RequestParam(name = "content", required = true)
                    String content,
                    Model model,
                    HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.USER);
        blogService.createBlog(user, title, summary, content);
        return "redirect:/blog/management/";
    }
}
