package jp.yamashita.raiseclick;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurposeRepository {
    @Insert("insert into purpose(purpose_name)value(#{purposeName})")
    void insertPurpose(Purpose purpose);
}
