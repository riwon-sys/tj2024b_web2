package example.day05.controller;

import example.day05.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/day05/students")
public class StudentController {
    // dto 대신 map을 사용하는 이유 : 일회성(재활용 별로임)
    // map 인터페이스 ( 구현체 : HashMap, TreeMap ...)
    // List 인터페이스 (구현체 : ArrayList, Vector)
    // map.push(key, value)
    // json(js객체) or dto(클래스) or map

    // (스프링 컨테이너)에서 빈(인스턴스) 주입받기
    @Autowired
    private StudentService studentService;

    // [1] 등록
    @PostMapping
    public int save(@RequestBody HashMap<String, Object> map){
        System.out.println("StudentController.save");
        System.out.println("map = " + map);
        return studentService.save(map);
    }

    // [2] 전체조회
    @GetMapping
    public List< Map<String, Object>> findAll(){
        System.out.println("StudentController.findAll");
        return studentService.findAll();
    }

    // [3] 수정
    @PutMapping
    public int update(@RequestBody Map<String, Object> map){
        System.out.println("StudentController.update");
        System.out.println("map = " + map);
        return studentService.update(map);

    }

    // [4] 삭제
    @DeleteMapping
    public boolean delete (@RequestParam int sno){
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);
        return studentService.delete(sno);
    }


    // [5] 특정 점수 이상 학생 조회
    @GetMapping("/find/scores")
    public List<Map<String, Object>> findStudentScores(@RequestParam int minKor, @RequestParam int minMath){
        return studentService.findStudentScores(minKor, minMath);
    }


    // [6] 여러명의 학생 등록하기
    @PostMapping("/save/all")
    public boolean saveAll(@RequestBody List<Map<String, Object>> list){
        System.out.println("StudentController.saveAll");
        System.out.println("list = " + list);
        return studentService.saveAll(list);
    }
    /*
        [JS(fetch/axios) / TalendAPI] -----> HTTP -----> [JAVA]
            JSON 알고 있음                    JSON 알아       JSON 몰라
            body : { }
            body : [ ]
    */




} // class end
