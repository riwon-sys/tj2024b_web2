package example.day04._실습.controller;

import example.day04._실습.model.dto.StudentDto;
import example.day04._실습.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day04/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public int point (@RequestBody StudentDto studentDto){
        return studentService.point(studentDto);
    }

    @GetMapping
    public List<StudentDto> findAll(){
        return studentService.findAll();
    }

    @PutMapping
    public int update(@RequestParam int sno){
        return studentService.update(sno);
    }

    @DeleteMapping
    public int delete(@RequestParam int sno){
        return studentService.delete(sno);
    }
}
