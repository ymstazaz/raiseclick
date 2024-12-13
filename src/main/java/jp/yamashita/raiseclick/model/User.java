package jp.yamashita.raiseclick;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
