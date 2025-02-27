package example.day06._aop과제.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface TaskMapper {
    @Insert("insert into student (name, kor, math) values (#{name}, #{kor}, #{math})")
    public int save( HashMap<String, Object> map);

    // [2] 조회
    @Select("select * from student")
    public List<Map<String, Object>> findAll();
}
