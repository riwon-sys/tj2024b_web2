package example.day02._3의존성;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
    [스프링 방법 : IOC, DI] **권장

 */
@Service // @Service 에는 @Component 포함
class SampleService4{
    void method() {
        System.out.println("SampleService4.method");
    }
}


class SampleController4{
    // static : 전역 키워드 , final : 수정불가 키워드
    private final SampleService4 sampleService4;

    @Autowired // 생성자를 이용하여 bean 등록하는 방법
    public SampleController4(SampleService4 sampleService4) {
        this.sampleService4 = sampleService4;
    }

    public void method() {
        sampleService4.method();
    }



}





public class Example4 {

}


