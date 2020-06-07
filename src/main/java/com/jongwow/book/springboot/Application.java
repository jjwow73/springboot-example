package com.jongwow.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 어노테이션들을 모두 활성화할 수 있게.
@SpringBootApplication // 이것으로 스프링부트의 자동 설정, 스프링 Bean 읽기와 생성이 모두 자동 설정
public class Application { // 앞으로 만들 프로젝트의 메인 클래스
    // @SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야만 한다.
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS를 실행
    }
}