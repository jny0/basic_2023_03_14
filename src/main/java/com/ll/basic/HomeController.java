package com.ll.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

// @Controller 의 의미
// 개발자가 스프링부트에게 말한다.
// 아래 있는 HomeController 는 컨트롤러이다.
@Controller
public class HomeController {

    private int count;
    private List<Person> people;
    public HomeController() {
        count = -1;
        people = new ArrayList<>();
    }

    // @GetMapping("/home/main") 의 의미
    // 개발자가 스프링부트에게 말한다.
    // 만약에 /home/main 이런 요청이 오면 아래 메서드를 실행해줘
    @GetMapping("/home/main")
    // @ResponseBody 의 의미
    // 아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    @ResponseBody
    public String showMain() {
        return "안녕하세요.";
    }

    @GetMapping("/home/main2")
    @ResponseBody
    public String showMain2() {
        return "반갑습니다.";
    }

    @GetMapping("/home/main3")
    @ResponseBody
    public String showMain3() {
        return "즐거웠습니다.";
    }

    @GetMapping("/home/increase")
    @ResponseBody
    public int showIncrease() { // 리턴되는 int 값은 String 화 되어서 고객(브라우저)에게 전달된다.
        count++;
        return count;
    }

    @GetMapping("/home/plus")
    @ResponseBody
    public int showPlus(@RequestParam(defaultValue ="0") int a, @RequestParam int b){
        return a+b;
    }



    @GetMapping("/home/addPerson")
    @ResponseBody
    public String addPerson(String name, int age){
        Person person = new Person(name, age);
        people.add(person);
        return "%d번 사람이 추가되었습니다.".formatted(person.getId());
    }

    @GetMapping("/home/people")
    @ResponseBody
    public List<Person> showPeople() {
        return people;
    }
}
@AllArgsConstructor
@Getter
@ToString
class Person{
    private static int lastId;
    private final int id;
    private final String name;
    private final int age;

    static {
        lastId = 1;
    }

    public Person(String name, int age) {
        this(lastId++,name,age);
    }
}