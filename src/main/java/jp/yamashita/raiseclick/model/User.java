package jp.yamashita.raiseclick;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String address;
    private String password;
    private String prefecture;
    private String city;
    private String gender;
    private String age;
    private String role = "ROLE_USER";
}
