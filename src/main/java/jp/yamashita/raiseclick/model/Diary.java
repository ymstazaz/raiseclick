package jp.yamashita.raiseclick.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public class Diary {
    @Insert("INSERT INTO diary (transportation,cost,full_cost,frequency)VALUES(#{transportation},#{cost},#{fullCost},#{frequency})")
    void insert(String transportation,Integer cost,Integer fullCost,Integer frequency);
}
