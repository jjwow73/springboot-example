package com.jongwow.book.springboot.web;

import com.jongwow.book.springboot.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsRepository postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

}
/*
 * View Resolver는 URL요청의 결과를 전달할 타입과 값을 지정하는 관리자격.
 * src/main/resources/templates/index.mustaches로 전환된 것을 view Resolver가 처리함*/
