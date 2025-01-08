package jp.yamashita.raiseclick.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DiaryRepository {
//    　保存機能
    @Insert("INSERT INTO diary (transportation,cost,full_cost,frequency,review_id)VALUES(#{transportation},#{cost},#{fullCost},#{frequency},#{reviewId})")
    void insert(String transportation,Integer cost,Integer fullCost,Integer frequency,Long reviewId);
    @Select("select LAST_INSERT_ID()")
    Long findLatestId();
}
