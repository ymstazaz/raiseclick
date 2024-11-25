package jp.yamashita.raiseclick;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class UserForm {
    private String name;
    private String address;
    private String password;
    private String prefecture;
    private String city;
    private String gender;
    private String age;

}
