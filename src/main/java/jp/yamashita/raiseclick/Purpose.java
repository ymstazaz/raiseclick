package jp.yamashita.raiseclick;

import lombok.Data;

import java.util.List;

@Data
public class Purpose {
    private Long id;
    private String purposeName;
    public Purpose(){}
    public Purpose(String purposeName){this.purposeName = purposeName;}
    private List<ReviewPurpose>reviewPurposes;
}
