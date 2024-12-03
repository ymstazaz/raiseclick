package jp.yamashita.raiseclick;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewPurposeRepository {
//    新規保存
    @Insert("INSERT INTO review_purpose(review_id,purpose_id,nth_purpose,satisfaction) VALUES (#{reviewId},#{purposeId},#{nthPurpose},#{satisfaction})")
    void insertReviewPurpose(Long reviewId,Long purposeId,Integer nthPurpose,Integer satisfaction);
}
