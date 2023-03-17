package com.ll.basic.article.controller;

import com.ll.basic.article.entity.Article;
import com.ll.basic.article.repository.ArticleRepository;
import com.ll.basic.base.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor // 필드 중에서 final 붙은것만 인자로 입력받는 생성자 생성
public class ArticleController {
    private final ArticleRepository articleRepository;
    @GetMapping("/write")
    @ResponseBody
    public RsData write(String title, String body){
        Article article = Article
                .builder()
                .createDate(LocalDateTime.now())
                .modifyDate(LocalDateTime.now())
                .title(title)
                .body(body)
                .build();

        articleRepository.save(article); // INSERT, or UPDATE

        return RsData.of("S-1","1번 글이 생성되었습니다");
    }

}
