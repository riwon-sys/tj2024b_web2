package example.day04._실습.model.mapper;

import example.day04._실습.model.dto.StudentDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Insert("insert into students (name, kor, math) values (#{name}, #{kor}, #{math})")
    int point(StudentDto studentDto);

    @Select("select * from students")
    public List<StudentDto> findAll();

    @Update("update students set kor = #{kor}, math = #{math} where sno = #{sno}")
    int update(int sno);

    @Delete("delete from students where sno = #{sno}")
    int delete(int sno);
}
