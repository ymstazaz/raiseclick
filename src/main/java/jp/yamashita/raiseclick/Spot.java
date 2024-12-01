package jp.yamashita.raiseclick;

import jakarta.persistence.*;

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
    public Long getId(){
        return  id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getSpotName(){
        return  spotName;
    }
    public void setSpotName(String spotName){
        this.spotName = spotName;
    }

    @Override
    public  String toString(){
        return "Spot{"+
                "id="+id+
                ",spotName='"+spotName+ '\''+
                '}';
    }

}
