package com.ll.basic.article.controller;

import com.ll.basic.article.entity.Article;
import com.ll.basic.article.repository.ArticleRepository;
import com.ll.basic.article.service.ArticleService;
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
    private final ArticleService articleService;
    @GetMapping("/write")
    @ResponseBody
    public RsData write(String title, String body){
       if(title == null || title.trim().length() ==0 ){
           return RsData.of("F-1", "title을(를) 입력해주세요.");
       }
        if(body == null || body.trim().length() ==0 ){
            return RsData.of("F-1", "body을(를) 입력해주세요.");
        }

        Article createdArticle = articleService.write(title, body);

        return RsData.of("S-1","1번 글이 생성되었습니다");
    }
}
