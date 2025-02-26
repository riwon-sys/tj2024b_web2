package example.day05.model.mapper;

import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    // 인터페이스란? 공통된 메소드들을 추상화해서 각 사용할 클래스에서 구체화(재정의)한다
    // -> 리모콘/키보드 같은 존재이다.
    // 추상메소드란? 메소드의{구현부}를 빼고 선언부만 존재하는 메소드
    // -> 여러 곳에서 사용할 메소드를 반환타입, 매개변수, 함수명만 정의하고 각 사용처에서 구현한다

    // [1] 등록
    // 선택하기 = .xml vs @어노테이션
    // @Insert("insert into student (name, kor, math) values (#{매개변수}, #{매개변수}, #{매개변수})")
    @Insert("insert into student (name, kor, math) values (#{name}, #{kor}, #{math})")
    @Options(useGeneratedKeys = true, keyProperty = "sno")
    public int save( HashMap<String, Object> map);

    // [2] 조회
    // @Serlect("select * from student") : native 쿼리 : 순수한 SQL 작성
    @Select("<script> select * from student </script>")    // 동적 쿼리 제공(SQL을 JAVA처럼 사용) : 순수한 SQL에 mybatis의 추가적인 쿼리 제공 // XML형식
    public List< Map<String, Object>> findAll();

    //[*] 특정한 점수 이상의 학생 조회(동적 쿼리 표현 = <script>, <if>, <foreach>)
    // @Select("select * from student kor >= 80 and math >= 80")
    @Select("""
            <script>
                select * from student
                where 1=1
                <if test = "minKor != null">
                    and kor >= #{minKor}
                </if>
                <if test = "minMath != null">
                    and math >= #{minMath}
                </if>
            </script>
            """) // 마이바티스에서 java15 이상부터 (강의는 17) """, """ 템플릿 지원 = 여러줄 일 때 + 없어도 가능
        List<Map<String, Object>> findStudentScores(int minKor, int minMath);
            // SQL에서 1=1(true를 뜻함, 강제로 true가 필요할 때 쓰는 방법) = 주로 다음 조건을 동적으로 처리할 때 사용함
            // minKor 가 null일 때 실제 SQL 표현 : select * from student  where 1=1
            // minKor 가 80일 때 실제 SQL 표현 : select * from student  where 1=1 and kor >= 80
            // minKor 가 80이고 , minMath 90일 때 : select * from student  where 1=1 and kor >= 80 and minMath >= 80
            // minKor 가 null이고 minMath 70일 때 : select * from student  where 1=1 and minMath >= 90

    /*
        [기본]
        String text = "안녕하세요"
                        + "유재석입니다";

        [java15이상]
        String text = """
                          안녕하세요
                          유재석입니다
                      """;
    */

    // [3] 수정
    @Update("update student set kor = #{kor}, math = #{math} where sno = #{sno}")
    public int update(Map<String, Object> map);

    // [4] 삭제
    @Delete("delete from student where sno = #{sno}")
    public boolean delete ( int sno);
}
