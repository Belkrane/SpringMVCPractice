package me.belk.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class SampleController {

    @RequestMapping("/{name:[a-z]+}")
    @ResponseBody
    public String hello(@PathVariable String name){
        return "hello " + name;
    }

    //URI 패턴으로 연결하는 방법
    //1. 일치하는 문자열로 맵핑
    //2. 여러개의 문자열로 맵핑
    //3. 특정 패턴으로 맵핑(정규식으로 받을 수 있음)
}
