package jp.yamashita.raiseclick.model;

import jp.yamashita.raiseclick.model.ReviewPurpose;
import jp.yamashita.raiseclick.model.Spot;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Review {
//    Listに適用した全データ
    private Long id;
    private String situation;
    private String reviewAge;
    private String reviewGender;
    private String freeComment;
    private LocalDateTime createdAt = LocalDateTime.now();
    private Spot spot;
    private String spotName; // デバッグ用のフィールド
    private User user;
    private List<ReviewPurpose> reviewPurposes;
}
