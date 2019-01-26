package cn.allen.dreamsanreal.controller;

import cn.allen.dreamsanreal.model.User;
import cn.allen.dreamsanreal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/admin")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public String login() {
        return "admin/login";
    }

    @PostMapping(value = "/login")
    public String login(
            @RequestParam(name = "username", required = true)
                String userName,
            @RequestParam(name = "password", required = true)
                String password,
            Model model) {
        HttpSession session = request.getSession();

        User user = new User(userName, password);

        user = userService.getUserByName(user);

        if (user == null) {
            return "admin/login";
        } else {
            session.setAttribute("user", user);
            model.addAttribute("user", user);
            return "redirect:/blog/edit/";
        }
    }
}
