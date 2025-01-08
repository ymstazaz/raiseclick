package jp.yamashita.raiseclick.form;

import lombok.Data;

@Data
public class DiaryForm {
    private String spotName;
    private String situation;
    private String reviewAge;
    private String reviewGender;
    private String freeComment;
    private String purposeName;
    private Integer nthPurpose;
    private Integer satisfaction;
    private String transportation;
    private Integer cost;
    private Integer fullCost;
    private Integer frequency;
}
