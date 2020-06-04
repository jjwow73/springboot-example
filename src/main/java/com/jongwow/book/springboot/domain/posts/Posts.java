package com.jongwow.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
/*
* Entity
*   테이블과 링크될 클래스임을 나타냄
*   기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭.
*   HelloWorld.java = hello_world.table
* Id
*   PK
* GerenatedValue
*   PK 생성ㄱ ㅠ칙.
*   스프링 부트 2.0에선 GerenationTYPE.INDENTITY 옵션이 있어야 auto_incre
* Column
*   테이블의 컬럼. 굳이 선언안해도 해당 클래스의 모든 필드는 컬럼
*   사용하는 이뉴는 기본 값 외 추가 변경옵션이 있으면
*   예) varchar size를 기본(255)에서 500으로 변경하고 싶을 때 등
*
* 중요한 것: Entity 클래스에선 Setter 메소드를 만들지 않는다.
* Setter가 없다면 DB에 값을 어떻게 INSERT?
*   기본적인 구조는 생성자를 통해 최종값을 채운 후 DB 삽입.
*   값 변경이 필요한 경우 해당 이벤트에 맞는 public 메소드를 호출하여 변경
*   이 책에선 생성자 대신 @Builder를 통해 제공되는 빌더 클래스 사용
*       생성자나 빌더나 생성 시점에 채워야할 필드가 무엇인지 명확히 지정 X
*       **Builder 패턴**
* */