package example.day02._3과제;

import example.day02._2과제.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardDao {
    private ArrayList<BoardDto> boardList = new ArrayList<>();
    private int auto_bno = 1;

    public boolean method1 ( BoardDto boardDto) {
        boardDto.setBno(auto_bno);
        boardList.add(boardDto);
        auto_bno++;
        return true;
    }

    public ArrayList<BoardDto> method2 () {
        return boardList;
    }

    public BoardDto method3 ( int bno) {
        for (int index = 0; index < boardList.size(); index++) {
            BoardDto boardDto = boardList.get(index);
            if (boardDto.getBno() == bno) {return boardDto;}
        }// for e
        return null;
    }

    public boolean method4 ( BoardDto boardDto) {
        for(int index = 0; index < boardList.size(); index++) {
            BoardDto boardDto2 = boardList.get(index);
            if(boardDto2.getBno() == boardDto.getBno()) {
                boardList.set(index, boardDto);
                return true;
            }// if e
        }// for e
        return false;

    }

    public boolean method5 ( int bno) {
        for (int index = 0; index < boardList.size(); index++) {
            BoardDto boardDto2 = boardList.get(index);
            if (boardDto2.getBno() == bno) {
                boardList.remove(index);
                return true;
            }// if e
        }// for e
        return false;
    }
}
