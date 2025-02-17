package example.day01._3과제;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day01/task/board")
public class BoardRestController {
    @PostMapping
    public boolean getWrite() {
        return true;
    }

    @GetMapping
    public List<Map<String, String>> getBoardList(){
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("bno", "1");
        map1.put("btitle", "제목입니다11");
        list.add(map1);

        Map<String, String> map2 = new HashMap<>();
        map2.put("bno", "2");
        map2.put("btitle", "제목입니다22");
        list.add(map2);

        Map<String, String> map3 = new HashMap<>();
        map3.put("bno", "3");
        map3.put("btitle", "제목입니다33");
        list.add(map3);

        return list;
    }



    @GetMapping("/view")
    public Map<String, String> getBoardView() {
        Map<String, String> map = new HashMap<>();
        map.put("bno", "1");
        map.put("btitle", "개별");
        return map;
    }

    @PutMapping
    public boolean putBoard() {
        return true;
    }

    @DeleteMapping
    public int deleteBoard() {
        return 3;
    }



}
