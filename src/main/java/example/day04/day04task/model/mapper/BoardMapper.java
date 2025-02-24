package example.day04.day04task.model.mapper;

import example.day04.day04task.model.dto.BoardDto;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert("insert into day04board (title, content) values (#{title}, #{content})")
    boolean write(BoardDto boardDto);

    @Select("select * from day04board")
    public List<BoardDto> findAll();

    @Select("select * from day04board where bno = #{bno}")
    public BoardDto view(int bno);

    @Update("update day04board set title = #{title}, content = #{content} where bno = #{bno}")
    public boolean update(BoardDto boardDto);

    @Delete("delete from day04board where bno = #{bno}")
    public boolean delete(int bno);

}
