package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String Hello(Model model)
    {
        model.addAttribute("data","hello");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String Hello_mvc(@RequestParam("name") String name, Model model)//@RequestParam("name") String name 주소에서 파라미터로 값을 받는다.
    {
        model.addAttribute("name",name);
        return "hello-mvc";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String Hello_String(@RequestParam("name") String name)//@RequestParam("name") String name 주소에서 파라미터로 값을 받는다.
    {
        return "hello "+name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello Hello_Api(@RequestParam("name") String name)//@RequestParam("name") String name 주소에서 파라미터로 값을 받는다.
    {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
