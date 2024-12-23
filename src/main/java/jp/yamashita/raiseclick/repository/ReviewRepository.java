package jp.yamashita.raiseclick.repository;

import jp.yamashita.raiseclick.model.Review;
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
    @Results(
            id = "reviewResultMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "situation", column = "situation"),
            @Result(property = "reviewAge", column = "review_age"),
            @Result(property = "reviewGender", column = "review_gender"),
            @Result(property = "freeComment", column = "free_comment"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "spot", one = @One(resultMap = "spotResultMap")),
            @Result(property = "reviewPurposes", many = @Many(resultMap = "reviewPurposeResultMap")),
    })
    List<Review> findAllWithDetails();

    @Select("SELECT '1'") // このクエリは実行されない。@ResultMap を定義するためのダミークエリ
    @Results(id = "spotResultMap", value = {
            @Result(id = true, property = "id", column = "spot_id"),
            @Result(property = "spotName", column = "spot_name", javaType = String.class),
    })
    jp.yamashita.raiseclick.model.Spot __spotResultMap();

    @Select("SELECT '1'") // このクエリは実行されない。@ResultMap を定義するためのダミークエリ
    @Results(id = "reviewPurposeResultMap", value = {
            @Result(id = true, property = "id", column = "review_purpose_id"),
            @Result(property = "nthPurpose", column = "nth_purpose"),
            @Result(property = "satisfaction", column = "satisfaction"),
            @Result(property = "purpose", one = @One(resultMap = "purposeResultMap")),
    })
    jp.yamashita.raiseclick.model.ReviewPurpose __reviewPurposeResultMap();

    @Select("SELECT '1'") // このクエリは実行されない。@ResultMap を定義するためのダミークエリ
    @Results(id = "purposeResultMap", value = {
            @Result(id = true, property = "id", column = "purpose_id"),
            @Result(property = "purposeName", column = "purpose_name"),
    })
    jp.yamashita.raiseclick.model.Purpose __purposeResultMap();

    //検索機能
    @Select("""
           SELECT
              r.id,
              r.situation,
              r.review_age,
              r.review_gender,
              r.free_comment,
              r.created_at,
              s.id AS spot_id,
              s.spot_name,
              rp.id AS review_purpose_id,
              rp.nth_purpose,
              rp.satisfaction,
              p.id AS purpose_id,
              p.purpose_name
           FROM
              review r
           LEFT JOIN
              spot s ON s.id = r.spot_id
           LEFT JOIN
              review_purpose rp ON rp.review_id = r.id
           LEFT JOIN
              purpose p ON p.id = rp.purpose_id
           WHERE
              1 = 1
              AND (#{situation} IS NULL OR r.situation LIKE CONCAT('%', #{situation}, '%'))
              AND (#{reviewAge} IS NULL OR r.review_age LIKE CONCAT('%', #{reviewAge}, '%'))
              AND (#{purposeName} IS NULL OR p.purpose_name LIKE CONCAT('%', #{purposeName}, '%'))
            """)
    @ResultMap("reviewResultMap")
    List<Review> searchReviews(
            @Param("situation") String situation,
            @Param("reviewAge") String reviewAge,
            @Param("purposeName") String purposeName
    );

    //保存機能
    @Insert("INSERT INTO review (situation, review_age, review_gender, free_comment, spot_id) VALUES (#{situation}, #{reviewAge}, #{reviewGender}, #{freeComment}, #{spotId})")
    void insert(String situation, String reviewAge, String reviewGender, String freeComment, Long spotId);
    @Select("select LAST_INSERT_ID()")
    Long findLatestId(); // 最後に挿入されたレビューIDを取得

}
