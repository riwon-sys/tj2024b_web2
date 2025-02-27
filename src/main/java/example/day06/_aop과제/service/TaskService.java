package example.day06._aop과제.service;

import example.day06._aop과제.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    // [1] 등록
    public int save( HashMap<String, Object> map){
        return taskMapper.save(map);

    }

    // [2] 조회
    public List<Map<String, Object>> findAll(){
        return taskMapper.findAll();
    }
}
