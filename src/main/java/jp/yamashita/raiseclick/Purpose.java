package jp.yamashita.raiseclick;

//import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

//@Entity
//@Table(name = "purpose")
@Data
public class Purpose {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "purpose_name",nullable = false,unique = true)
    private String purposeName;

    public Purpose(){}
    public Purpose(String purposeName){this.purposeName = purposeName;}

//    @OneToMany(mappedBy = "purpose",cascade = CascadeType.ALL)
    private List<ReviewPurpose>reviewPurposes;
}
