package me.belk.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    @RequestMapping(value = "/hello", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String hello(){
        return "hello belk";
    }

    /*
      URI 패턴으로 연결하는 방법
      1.일치하는 문자열로 맵핑
      2.여러개의 문자열로 맵핑
      3.특정 패턴으로 맵핑(정규식으로 받을 수 있음), 패턴이 중복되는 경우 가장 구체적으로 맵핑되는것
      - Spring에서는 URI Pattern + ".*" 를 기본적으로 제공함, Boot에서는 제공 안함
     */

    /*
        1. 특정한 Type의 요청만 받고자 할때
         - consumes option에 해당 타입을 정의하면 된다.
     */
}
