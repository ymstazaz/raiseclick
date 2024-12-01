package jp.yamashita.raiseclick;

import lombok.Data;

@Data
public class ReviewPurpose {
    private Long id;
    private Review review;
    private Purpose purpose;
    private String nth_purpose;
    private String satisfaction;
}
