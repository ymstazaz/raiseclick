package jp.yamashita.raiseclick;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PurposeRepository {
//    新規保存
    @Insert("insert into purpose(purpose_name)values(#{purposeName})")
    void insertPurpose(String purpose);
//    重複確認
    @Select("select * from purpose where purpose_name=#{purposeName}")
    Purpose findByPurposeName(String purposeName);

}
