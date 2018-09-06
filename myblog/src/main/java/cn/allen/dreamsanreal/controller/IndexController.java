package cn.allen.dreamsanreal.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String index(@RequestParam(value="name", defaultValue="World") String name) {
        // map.put("counter", counter.incrementAndGet());
        // map.put("template", String.format(template, name));
        return "index";
    }
}
