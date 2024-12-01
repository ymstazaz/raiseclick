package jp.yamashita.raiseclick;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ReviewPurposeRepository {
    @Insert("INSERT INTO review_purpose(review_id,purpose_id,nth_purpose,satisfaction) VALUES (#{reviewId},#{purposeId},#{nthPurpose},#{satisfaction})")
    void insertReviewPurpose(Long reviewId,Long purposeId,Integer nthPurpose,Integer satisfaction);
}
