package hello.hello_spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name_value) {
        return "안녕하세요. " + name_value + "님.";
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name_value) {
        Hello hello = new Hello();
        hello.setName(name_value);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
