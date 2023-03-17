package com.ll.basic.article.service;

import com.ll.basic.article.entity.Article;
import com.ll.basic.article.repository.ArticleRepository;
import com.ll.basic.base.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Article write(String title, String body){
        Article article = Article
                .builder()
                .createDate(LocalDateTime.now())
                .modifyDate(LocalDateTime.now())
                .title(title)
                .body(body)
                .build();

        articleRepository.save(article);

        return article;
    }

}
