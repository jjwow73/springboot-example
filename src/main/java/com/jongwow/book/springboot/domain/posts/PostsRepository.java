package com.jongwow.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
/*
 * 일종의 Dao라 불리는 DB layer 접근자
 * JPA에선 Repository라 하며 Interface
 * JpaRepository<Entity, PK>하면 기본 CRUD 생성
 * @Repository 필요없음.
 *
 * ** 주의할 점
 * Entity 클래스와 기본 Entity Repository는 함께 위치해야함.*/

/*
 * findAllDesc()를 할 때 SpringDataJpa를 사용하지 않고 Query를 사용한 이유.
 * 만약 SpringDataJpa에서 제공하는 메소드면 그것을 사용하면 되는데 그렇지 않을 경우 쿼리를 이용해 구현한다.
 * 만약 가독성 측면에서 SpringDataJpa에서 제공하는 메소드보다 쿼리의 가독성이 더 좋다면 쿼리를 이용해도 된다.
 * */