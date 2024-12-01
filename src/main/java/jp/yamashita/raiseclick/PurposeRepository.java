package jp.yamashita.raiseclick;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PurposeRepository {
    @Insert("insert into purpose(purpose_name)values(#{purposeName})")
    void insertPurpose(String purpose);
    @Select("select * from purpose where purpose_name=#{purposeName}")
    Purpose findByPurposeName(String purposeName);
}
