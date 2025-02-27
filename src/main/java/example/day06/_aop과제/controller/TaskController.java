package example.day06._aop과제.controller;

import example.day06._aop과제.service.TaskService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/day06/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    // [1] 학생 점수 등록
    @PostMapping
    public int save(@RequestBody HashMap<String, Object> map){
        System.out.println("StudentController.save");
        System.out.println("map = " + map);
        return taskService.save(map);
    }

    // [2] 학생 전체 조회
    @GetMapping
    public List< Map<String, Object>> findAll(){
        System.out.println("StudentController.findAll");
        return taskService.findAll();
    }

} // class end
