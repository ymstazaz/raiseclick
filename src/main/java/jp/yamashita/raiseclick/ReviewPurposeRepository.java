package jp.yamashita.raiseclick;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewPurposeRepository {
    @Insert("INSERT INTO reviewPurpose(review_id,purpose_id,nth_purpose,satisfaction) VALUES (#{reviewId},#{purposeId},#{nthPurpose},#{satisfaction}")
    void insert(Long reviewId,Long purposeId,Integer nthPurpose,Integer satisfaction);
}
