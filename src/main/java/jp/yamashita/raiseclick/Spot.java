package jp.yamashita.raiseclick;

import lombok.Data;

import java.util.List;

@Data
public class Spot {
    private Long id;
    private String spotName;
    public Spot() {}
    public Spot(String spotName){
        this.spotName = spotName;
    }
    private List<Review> review;

    @Override
    public  String toString(){
        return "Spot{"+
                "id="+id+
                ",spotName='"+spotName+ '\''+
                '}';
    }

}
