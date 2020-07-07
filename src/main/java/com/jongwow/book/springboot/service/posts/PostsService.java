package com.jongwow.book.springboot.service.posts;

import com.jongwow.book.springboot.domain.posts.Posts;
import com.jongwow.book.springboot.domain.posts.PostsRepository;
import com.jongwow.book.springboot.web.dto.PostsListResponseDto;
import com.jongwow.book.springboot.web.dto.PostsResponseDto;
import com.jongwow.book.springboot.web.dto.PostsSaveRequestDto;
import com.jongwow.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteById(Long id) {
        Posts post = postsRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id)
        );
        postsRepository.delete(post);
        // entity를 parameter로 삭제할 수도 있고, deleteById 메소드를 이용해 id로 삭제할 수도 있음.
        // 존재하는 Posts인지 확인 후 엔티티 조회 후 그대로 삭제.
    }
    // 트랜잭션 범위는 유지하되 조회기능만 남겨 조회 속도 개선
}
