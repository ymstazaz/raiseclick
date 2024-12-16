package jp.yamashita.raiseclick.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReviewPurposeRepository {
//    新規保存
    @Insert("INSERT INTO review_purpose(review_id,purpose_id,nth_purpose,satisfaction) VALUES (#{reviewId},#{purposeId},#{nthPurpose},#{satisfaction})")
    void insertReviewPurpose(Long reviewId,Long purposeId,Integer nthPurpose,Integer satisfaction);
}
