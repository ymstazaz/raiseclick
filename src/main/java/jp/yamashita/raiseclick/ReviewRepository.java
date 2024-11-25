package jp.yamashita.raiseclick;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface ReviewRepository {
    @Insert("INSERT INTO review (situation, review_age, review_gender, free_comment, spot_id) VALUES (#{situation}, #{reviewAge}, #{reviewGender}, #{freeComment}, #{spotId})")
    void insert(String situation, String reviewAge, String reviewGender, String freeComment, Long spotId);
}
