package jp.yamashita.raiseclick.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ReviewForm {
    private String spotName;
    private String situation;
    private String reviewAge;
    private String reviewGender;
    private String freeComment;
    private String purposeName;
    private Integer nthPurpose;
    private Integer satisfaction;
}
