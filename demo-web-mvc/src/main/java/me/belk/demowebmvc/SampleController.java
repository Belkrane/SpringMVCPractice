package me.belk.demowebmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    @GetMapping(value = "/hello", headers = HttpHeaders.AUTHORIZATION + "=" + "111", params = "name=belk")
    @ResponseBody
    public String hello(){
        return "hello belk";
    }


    @PostMapping("/hello")
    @ResponseBody
    public String helloPost(){
        return "hello";
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
          - produces option에 accpet header에 해당 타입을 정의하면 된다.
          - Accept Header가 맞지 않는 경우에는 406 Not Supported
          - 보내는쪽에서 Accept Header를 정의하지 않는다면 아무 응답이나 받기 때문에 정상처리 됨
          
          * 둘 다 클래스 단위로도 설정할 수 있음
     */

    /*
        임의의 HTTP 요청 헤더 값이 있는지, 특정한 헤더 값이 있는지
        headers option 을 사용해서, 특정 헤더값이 있는 경우에만 동작하도록 설정
        ! 이라는 기호를 통해서 특정 헤더가 없어야되는 경우도 체크할 수 있음
        "=" + "111" 등 특정 헤더값이 들어오는 경우에도 처리 할 수 있음
        헤더 뿐만이 아니라 param도 같은 방식으로 처리할 수 있음
     */

    /*
        HTTP method HEAD, OPTIONS
        HEAD 요청이 오면 응답 BODY를 빼고 HEAD 정보만(BODY를 주면 안됨) 준다. -> Spring 프레임웍이 자동으로 그렇게 처리해주기 때문에
        따로 핸들러를 그렇게 만들 필요는 없다.
        OPTIONS 는 서버 또는 리소스가 제공하는 기능을 확인 Allow라는 응답 헤더에 제공하는 METHOD를 응답한다.
     */
}
