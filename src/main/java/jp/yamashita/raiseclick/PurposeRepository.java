package jp.yamashita.raiseclick;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PurposeRepository {
    @Insert("insert into purpose(purpose_name)values(#{purposeName})")
    void insertPurpose(String purpose);
    @Select("select * from purpose where purpose_name=#{purposeName}")
    Purpose findByPurposeName(String purposeName);
    @Select("select * from purpose")
    List<Purpose>findAllPurpose();
}
