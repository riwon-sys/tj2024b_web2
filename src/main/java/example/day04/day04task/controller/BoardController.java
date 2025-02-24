package example.day04.day04task.controller;

import example.day04.day04task.model.dto.BoardDto;
import example.day04.day04task.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day04/task/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @PostMapping
    public boolean write(@RequestBody BoardDto boardDto) {
        return boardService.write(boardDto);
    }

    @GetMapping
    public List<BoardDto> findAll(){
        return boardService.findAll();
    }

    @GetMapping("/view")
    public BoardDto view(@RequestParam int bno) {
        return boardService.view(bno);
    }

    @PutMapping
    public boolean update(@RequestBody BoardDto boardDto) {
        return boardService.update(boardDto);
    }

    @DeleteMapping
    public boolean delete(@RequestParam int bno) {
        return boardService.delete(bno);
    }

}
