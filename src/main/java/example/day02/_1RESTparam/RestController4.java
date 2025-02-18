package example.day02._1RESTparam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/day02")

public class RestController4 {

    @PostMapping("/dopost1") // http://localhost:8080/day02/dopost1 {"name" : "전은서", "age" : "100"}
    // [1] HTTP request(요청) body(본문) 매핑하는 방법 POST/PUT 사용
    // * @RequestBody : HTTP 요청 body의 'application/json' 타입 자료를 자바 타입으로 변환/매핑 해주는 어노테이션
    // -> @RequestBody 생략시 @ModelAttribute 가 적용되기 때문에 꼭 작성해야 한다
    // -> @RequestParam 도 생략시 @ModelAttribute 적용되지만, @ModelAttribute 는 queryString 매핑 가능하기 때문에 생략 가능
    public boolean method1(@RequestBody MemberDto memberDto) {
        System.out.println("RestController4.method1"); // soutm
        System.out.println("memberDto = " + memberDto); // soutp
        return true;
    }
}
