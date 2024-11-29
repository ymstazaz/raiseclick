package jp.yamashita.raiseclick;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Struct;
import java.util.Optional;

@Mapper
public interface UserRepository{
    @Insert("insert into user (name,address,password,prefecture,city,gender,age) values (#{name},#{address},#{password},#{prefecture},#{city},#{gender},#{age})")
    void insert(User user);

    @Select("SELECT name,address FROM users where id = #{address}")
    User findByAddress(String address);
    @Select("SELECT name,address FROM users where id = #{id}")
    User findById(Long Id);
}
