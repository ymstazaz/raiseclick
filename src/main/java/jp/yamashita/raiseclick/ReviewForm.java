package jp.yamashita.raiseclick;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ReviewForm {
    private String spotName;
    private String situation;
    private String reviewAge;
    private String reviewGender;
    private String freeComment;
}
