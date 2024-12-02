package jp.yamashita.raiseclick;

import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface ReviewRepository {
//レビューリスト（一覧表示）
    @Select("""
            select
              r.id,
              r.situation,
              r.review_age,
              r.review_gender,
              r.free_comment,
              r.created_at,
              s.id as spot_id,
              s.spot_name,
              rp.id as review_purpose_id,
              rp.nth_purpose,
              rp.satisfaction,
              p.id as purpose_id,
              p.purpose_name
            from
              review r
            left join
              spot s on s.id = r.spot_id
            left join
              review_purpose rp on rp.review_id = r.id
            left join
              purpose p on p.id = rp.purpose_id
            """)
    @Results({
            @Result(property = "id", column = "review_id"),
            @Result(property = "situation", column = "situation"),
            @Result(property = "reviewAge", column = "review_age"),
            @Result(property = "reviewGender", column = "review_gender"),
            @Result(property = "freeComment", column = "free_comment"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "spot", one = @One(resultMap = "spotResultMap")),
            @Result(property = "reviewPurposes", many = @Many(resultMap = "reviewPurposeResultMap")),
            @Result(property = "spotName", column = "spot_name"),
            @Result(property = "nthPurpose", column = "nth_purpose"),
            @Result(property = "satisfaction", column = "satisfaction"),
            @Result(property = "purpose", one = @One(resultMap = "purposeResultMap")),
    })
    List<Review> findAllWithDetails();

    @Select("SELECT '1'")  // このクエリは実行されない。@ResultMap を定義するためのダミークエリ
    @Results(id = "spotResultMap",value = {})

    //保存機能
    @Insert("INSERT INTO review (situation, review_age, review_gender, free_comment, spot_id) VALUES (#{situation}, #{reviewAge}, #{reviewGender}, #{freeComment}, #{spotId})")
    void insert(String situation, String reviewAge, String reviewGender, String freeComment, Long spotId);
    @Select("select LAST_INSERT_ID()")
    Long findLatestId(); // 最後に挿入されたレビューIDを取得

}
