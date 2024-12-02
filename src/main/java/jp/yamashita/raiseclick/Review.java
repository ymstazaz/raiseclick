package jp.yamashita.raiseclick;

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
    private User user;
    private List<ReviewPurpose> reviewPurposes;
}
