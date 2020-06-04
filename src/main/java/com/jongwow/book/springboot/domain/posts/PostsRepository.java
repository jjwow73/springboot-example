package com.jongwow.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
/*
* 일종의 Dao라 불리는 DB layer 접근자
* JPA에선 Repository라 하며 Interface
* JpaRepository<Entity, PK>하면 기본 CRUD 생성
* @Repository 필요없음.
*
* ** 주의할 점
* Entity 클래스와 기본 Entity Repository는 함께 위치해야함.*/
