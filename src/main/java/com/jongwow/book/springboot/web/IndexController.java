package com.jongwow.book.springboot.web;

import com.jongwow.book.springboot.config.auth.LoginUser;
import com.jongwow.book.springboot.service.posts.PostsService;
import com.jongwow.book.springboot.web.dto.PostsResponseDto;
import com.jongwow.book.springboot.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
/*
 * View Resolver는 URL요청의 결과를 전달할 타입과 값을 지정하는 관리자격.
 * src/main/resources/templates/index.mustaches로 전환된 것을 view Resolver가 처리함*/
