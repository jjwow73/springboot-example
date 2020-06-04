package com.jongwow.book.springboot.web;

import com.jongwow.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        // @RequestParam: 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션. 여기선 name (@Req~) 이란 이름으로 넘긴 파라미터를
        // 메소드 파라미터 name(String name)에 저장함.
        return new HelloResponseDto(name, amount);
    }
}
