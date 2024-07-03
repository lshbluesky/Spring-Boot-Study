package hello.hello_spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("name", "shl");
        return "hello";
    }

    @GetMapping("hello-static")
    public String helloStatic() {
        return "hello-static";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name_value, Model model) {
        model.addAttribute("name", name_value);
        return "hello-mvc";
    }
}
