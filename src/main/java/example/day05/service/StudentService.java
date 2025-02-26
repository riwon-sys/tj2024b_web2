package example.day05.service;

import example.day05.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service // [IOC] 싱글톤처럼 쓰기 위해서, (스프링 컨테이너)에서 빈(인스턴스/객체) 등록
// 서비스에서 매핑하지 않는  이유 : 매핑은 컨트롤러의 역할이기 때문
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    // [1] 등록
    public int save( HashMap<String, Object> map){
        System.out.println("StudentController.save");
        System.out.println("map = " + map);
        // return studentMapper.save(map);
        System.out.println("=========== SQL 처리 전 ===========");
        System.out.println("map = " + map);

        int result = studentMapper.save(map);

        System.out.println("=========== SQL 처리 후 ===========");
        System.out.println("result = " + result); // soutv : 가장 가까운 변수 출력
        // result = 1 (SQL실행 결과 처리된 레코드 수)
        System.out.println("map = " + map); // soutm : 가까운 매개변수 출력
        // map = {sno=4, name=유재석, math=90, kor=100}
        // SQL 처리하기 전 sno는 없었지만 SQL처리된 후 sno가 존재한다
        // @Options

        return result;
    }

    // [2] 조회
    public List< Map<String, Object>> findAll(){
        System.out.println("StudentController.findAll");
        return studentMapper.findAll();
    }

    // [3] 수정
    public int update(Map<String, Object> map){
        System.out.println("StudentController.update");
        System.out.println("map = " + map);
        return studentMapper.update(map);

    }

    // [4] 삭제
    public boolean delete ( int sno){
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);
        return studentMapper.delete(sno);
    }


    // [5] 특정 점수 이상 학생 조회
    public List<Map<String, Object>> findStudentScores(int minKor, int minMath){
        return studentMapper.findStudentScores(minKor, minMath);
    }
}
