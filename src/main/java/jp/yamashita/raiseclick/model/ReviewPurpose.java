package jp.yamashita.raiseclick.model;

import jp.yamashita.raiseclick.model.Purpose;
import lombok.Data;

@Data
public class ReviewPurpose {
    private Long id;
    private Purpose purpose;
    private String nthPurpose;
    private String satisfaction;
}
