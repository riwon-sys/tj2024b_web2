package example.day02._3의존성;

/*
    [고전적인 방법2 : 싱글톤 생성]
    스프링 없이 싱글톤(인스턴스)를 직접 생성하여 메소드를 사용한다
    프로그램내 인스턴스 하나만 필요로 할 때
 */
// [1] 서비스 클래스
class SampleService2{
    // 싱글톤 만들기
    private static SampleService2 instance = new SampleService2();
    private SampleService2(){}
    public static SampleService2 getInstance(){return instance;}

    void method(){
        System.out.println("SampleService2.method");
    }
}

// [2] 컨트롤러 클래스
class SampleController2{
    SampleService2 sampleService2 = SampleService2.getInstance();
    public void method(){
        sampleService2.method();
    }

}



public class Example2 {

}
