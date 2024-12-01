package jp.yamashita.raiseclick;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository{
    @Insert("insert into users (name,address,password,prefecture,city,gender,age) values (#{name},#{address},#{password},#{prefecture},#{city},#{gender},#{age})")
    void insert(User user);

    @Select("SELECT name,address,password,role FROM users where address = #{address}")
    User findByAddress(String address);
    @Select("SELECT name,address FROM users where id = #{id}")
    User findById(Long Id);
}
