package jp.yamashita.raiseclick.repository;

import jp.yamashita.raiseclick.model.Spot;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SpotRepository {
//    新規保存
    @Insert("insert into spot(spot_name) value (#{spotName})")
    void insertSpot(Spot spot);
//新規作成時のID重複確認↓
    @Select("select * from spot where spot_name = #{spotName}")
    Spot findBySpotName(String spotName);
    @Select("SELECT * FROM spot WHERE id = #{id}")
    Spot findById(Long id);
}
