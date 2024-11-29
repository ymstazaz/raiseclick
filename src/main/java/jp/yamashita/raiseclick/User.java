package jp.yamashita.raiseclick;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String address;
    @Column(nullable = false)
    private String password;
    private String prefecture;
    private String city;
    private String gender;
    private String age;
    @Column(nullable = false,columnDefinition = "VARCHAR(255) DEFAULT 'ROLE_USER'")
    private String role = "ROLE_USER";
}
