package com.jongwow.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
/*
 * View Resolver는 URL요청의 결과를 전달할 타입과 값을 지정하는 관리자격.
 * src/main/resources/templates/index.mustaches로 전환된 것을 view Resolver가 처리함*/
