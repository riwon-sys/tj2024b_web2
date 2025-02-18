package example.day02._2과제;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // [1] 해당 컨트롤러가 HTTP URL 매핑할 수 있도록 어노테이션 주입
@RequestMapping("/day02/task1/board")
public class BoardController {

    // [2] 현재 과제에서는 DB가 없으므로 리스트가 DB 역할을 한다
    private final List<BoardDto> boardList = new ArrayList<>();

    private int auto_increment = 1; // bno 자동번호 역할

    // [3] POST 글 쓰기
    @PostMapping // 1. post 매핑 주소를 만든다
    public boolean postBoard(@RequestBody BoardDto boardDto) { // 2. body 값을 매개변수로 매핑한다
        boardDto.setBno(auto_increment);// 3. boardDto에 bno를 넣어준다
        boardList.add(boardDto); // 4. 리스트에 boardDto를 넣어준다
        auto_increment++; // 5. auto_increment (bno)는 1씩 증가한다
        return true; // 6. 리턴한다
    }

    // [4] GET 전체 조회
    @GetMapping
    public List<BoardDto> getBoard() {
//        List<Map<String, String>> list = new ArrayList<>();
//        Map<String, String> map1 = new HashMap<>();
//        map1.put("bno", "1");
//        map1.put("title", "제목1");
//        map1.put("content", "내용1");
//        list.add(map1);
//        return list;
        return boardList;
    }


    // [5] GET (bno) 개별 조회
    @GetMapping("/view")
    public BoardDto getBoard(@RequestParam(name = "bno") int bno) {
        for(int index = 0; index <= boardList.size()-1; index++) {
            BoardDto boardDto = boardList.get(index);
            if( boardDto.getBno() == bno ){
                return boardDto; // 찾았으면 찾은 DTO 반환
            }
        }
        return null; // 없으면
    }



    // [6] PUT 수정
    @PutMapping
    public boolean putBoard(@RequestBody BoardDto boardDto) {
        for(int index = 0; index <= boardList.size()-1; index++){
            BoardDto boardDto2 = boardList.get( index );
            if( boardDto2.getBno() == boardDto.getBno() ){
                boardList.set( index , boardDto );
                return true;
            }
        }
        return false;
    } // f end

    // [6] DELETE 삭제
    @DeleteMapping
    public boolean mehtod5( @RequestParam( name = "bno") int bno ){
        for( int index = 0 ; index <= boardList.size()-1 ; index++  ){
            BoardDto boardDto2 = boardList.get(index);
            if( boardDto2.getBno() == bno ){
                boardList.remove( index );
                return true;
            }
        }
        return false;
    } // f end

} // class end
