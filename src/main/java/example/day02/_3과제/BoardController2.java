package example.day02._3과제;

import example.day02._2과제.BoardController;
import example.day02._2과제.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/day02/task2")

public class BoardController2 {
    private final BoardDao boardDao;

    @Autowired
    public BoardController2(BoardDao boardDao) {
        this.boardDao = boardDao;
    }


    //DB 역할
    //private int auto_bno = 1; // bno 자동번호

    // POST 매핑으로 주소의 body값을 dto로 매핑하여 함수 매개변수로 받는다
    @PostMapping("/board")
    public boolean method1(@RequestBody BoardDto boardDto) { // body값을 함수 매개변수로 매핑한
        boolean result = boardDao.method1(boardDto); // db insert
        return result;
    }

    @GetMapping("/board")
    public List<BoardDto> method2() {
        List<BoardDto> boardList = boardDao.method2();
        return boardList;
    }


    @GetMapping("/board/view")
    public BoardDto method3(@RequestParam("bno") int bno) {
        BoardDto boardDto = boardDao.method3(bno);// for e
        return boardDto;
    }

    @PutMapping("/board")
    public boolean method4(@RequestBody BoardDto boardDto) {
        boolean result = boardDao.method4(boardDto);
        return result;

    }

    @DeleteMapping("/board")
    public boolean method5(@RequestParam(name = "bno") int bno) {
        boolean result = boardDao.method5(bno);
        return result;
    }//f e
}