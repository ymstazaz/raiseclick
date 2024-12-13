package jp.yamashita.raiseclick.until;


import jp.yamashita.raiseclick.User;

public class TestDataFactory {
    public static User createUser(){
        return new User(1L, "太郎", "000@000","123456a","北海道","旭川市","秘密","10代","ROLE_USER");
    }
}
