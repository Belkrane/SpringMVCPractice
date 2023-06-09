package me.belk.demobootweb;

import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {
    //preHandle -> 전처리
    //preHandle2 -> 여러개 있을 경우(순서는 오더라는 속성으로 줄 수 있음)
    //hello
    //요청처리
    //postHandle2 -> 포스트와 애프터는 역순으로 호출 됨
    //postHandle -> 후처리
    //뷰 랜더링
    //afterCompletion2 -> 역순으로 호출 됨
    //afterCompletion -> 뷰 랜더링 후처리

    @GetMapping("/hello")
    public String hello(@RequestParam("id") Person person){
        return "hello " + person.getName();
    }

    @GetMapping("/message")
    public @ResponseBody String message (@RequestBody String body) {
        return body;
    }

    @GetMapping("/jsonMessage")
    public Person jsonMessage(@RequestBody Person person){
        return person;
    }
}
