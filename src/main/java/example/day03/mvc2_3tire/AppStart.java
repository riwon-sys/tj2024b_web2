package example.day03.mvc2_3tire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // ** 현재 클래스와 동일패키지와 하위패키지들의 컴포넌트(?)들을 스캔함
// 컴포넌트란? 모듈.레고조각 / MVC패턴의 계층 클래스들

// @Component에 포함된 것들 : @RestController @Controller @Service @Repository @Configuration @Mapper ...
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}
