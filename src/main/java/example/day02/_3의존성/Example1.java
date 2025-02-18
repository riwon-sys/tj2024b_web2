package example.day02._3의존성;


/*
    [고전적인 방법2 : 인스턴스 생성]
 */
// [1] 서비스 클래스
class SampleService1 {
    void method(){
        System.out.println("SampleService1.method"); // soutm
    }
}
// [2] 컨트롤러 클래스
class SampleController {
    // 다른 클래스의 메소드를 호출하는 방법 / 고전적인 방법1 : 인스턴스 생성
    SampleService1 sampleService1 = new SampleService1();

    public void method(){
        sampleService1.method(); // 서비스클래스의 메소드 호출
    }

}

public class Example1 {
    /*

    */
}

