package example.day04.day04task.service;

import example.day04.day04task.model.dto.BoardDto;
import example.day04.day04task.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    public boolean write(BoardDto boardDto){
        return boardMapper.write(boardDto);
    }

    public List<BoardDto> findAll (){
        return boardMapper.findAll();
    }

    public BoardDto view(int bno){
        return boardMapper.view(bno);
    }

    public boolean update(BoardDto boardDto){
        return boardMapper.update(boardDto);
    }

    public boolean delete(int bno){
        return boardMapper.delete(bno);
    }
}
