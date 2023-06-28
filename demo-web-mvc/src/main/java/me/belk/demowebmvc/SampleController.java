package me.belk.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    @RequestMapping(value = "/hello",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
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
         - Content type이 맞지 않을 경우에는 415 Not Supported Media Type
        2. 어떠한 응답을 원한다를 맵핑할 수 있음
          - accpet header에 해당 타입을 정의하면 된다.
          - Accept Header가 맞지 않는 경우에는 406 Not Supported
          - 보내는쪽에서 Accept Header를 정의하지 않는다면 아무 응답이나 받기 때문에 정상처리 됨
          
          * 둘 다 클래스 단위로도 설정할 수 있음
     */
}
