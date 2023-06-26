package me.belk.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class SampleController {

    @RequestMapping("/hello/**")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    //URI 패턴으로 연결하는 방법
    //1. 일치하는 문자열로 맵핑
    //2. 여러개의 문자열로 맵핑
    //3. 특정 패턴으로 맵핑
}
