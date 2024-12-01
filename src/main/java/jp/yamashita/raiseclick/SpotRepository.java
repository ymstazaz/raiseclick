package jp.yamashita.raiseclick;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SpotRepository {
    @Insert("insert into spot(spot_name) value (#{spotName})")
    void insertSpot(Spot spot);

    @Select("select * from spot where spot_name = #{spotName}")
    Spot findBySpotName(String spotName);
    @Select("SELECT * FROM spot")
    List<Spot> findAllSpot();
    @Select("SELECT * FROM spot WHERE id = #{id}")
    Spot findById(Long id);
}
