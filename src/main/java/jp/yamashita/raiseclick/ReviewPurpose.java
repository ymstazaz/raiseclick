package jp.yamashita.raiseclick;

import lombok.Data;

@Data
public class ReviewPurpose {
    private Long id;
    private Purpose purpose;
    private String nthPurpose;
    private String satisfaction;
}
