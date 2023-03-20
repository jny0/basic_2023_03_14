package com.ll.basic.base.initData;

import com.ll.basic.article.service.ArticleService;
import com.ll.basic.boundedContext.member.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev","test"})
// NotProd : 개발환경이고, 테스트환경일때만 실행
public class NotProd {
    // CommandLineRunner 객체를 Ioc 컨테이너에 넣으면 자동으로 알아서 실행된다.(그렇게 작동하도록 만들어진 클래스)
    @Bean // @Component 와 비슷한 의미, 이 함수의 리턴값(리모콘)이 Ioc 컨테이너에 등록된다는 뜻, 이걸 사용하려면 클래스에 @Configuration 필수
    CommandLineRunner initData(MemberService memberService, ArticleService articleService){
        // 이 부분은 스프링부트 앱이 실행되고, 본격적으로 작동되기 전에 실행된다. (CommandLineRunner 클래스가 원래 그렇게 작동되도록 설계됨)
        return args -> {
            memberService.join("user1", "1234");
            memberService.join("abc", "12345");
            memberService.join("test", "12346");
            memberService.join("love", "12347");
            memberService.join("like", "12348");
            memberService.join("giving", "12349");
            memberService.join("thanks", "123410");
            memberService.join("hello", "123411");
            memberService.join("good", "123412");
            memberService.join("peace", "123413");

            articleService.write("제목1", "내용1");
            articleService.write("제목2", "내용2");
        };
    }

}
