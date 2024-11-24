package jp.yamashita.raiseclick;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper
public interface SpotRepository {
    @Insert("insert into spot(spot_name) value (#{spotName})")
    void insertSpot(Spot spot);

    @Select("select * from spot where spot_name = #{spotName}")
    Spot findBySpotName(String spotName);
}
