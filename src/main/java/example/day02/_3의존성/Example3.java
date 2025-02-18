package example.day02._3의존성;

/*
    [스프링 방법1,2 : IOC, DI]
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// [1] 서비스 클래스
//  bean : 스프링 컨테이너(메모리)에서 관리하는 인스턴스(객체) => IOC
//  IOC(제어역전) : 개발자가 인스턴스(new) 생성하지 않고 스프링이 대신 인스턴스를 생성해줌

@Component // 1. 스프링 컨테이너(메모리)에 bean(인스턴스) 등록
class SampleService3{
    void method(){
        System.out.println("SampleService3.method");
    }
}


// [2] 컨트롤러 클래스
// DI: Dependency Injection
class SampleController3{
    @Autowired // 2. 스프링 컨테이너(메모리)에 등록된 bean(인스턴스) 주입 => DI
    private SampleService3 sampleService3;
    public void method(){
        sampleService3.method();
    }
}


public class Example3 {
}
