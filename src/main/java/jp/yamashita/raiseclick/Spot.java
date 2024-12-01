package jp.yamashita.raiseclick;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "spot")
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "spot_name", nullable = false,unique = true)
    private String spotName;
//    spot_nameはspotNameとして判断がされない場合があるため、ここで揃えておく。
    public Spot() {}
    public Spot(String spotName){
        this.spotName = spotName;
    }
    //    クチコミテーブル連動（id接続がこっちにない場合）
    @OneToMany(mappedBy = "spot", cascade = CascadeType.ALL)
    private List<Review> review;

    @Override
    public  String toString(){
        return "Spot{"+
                "id="+id+
                ",spotName='"+spotName+ '\''+
                '}';
    }

}
