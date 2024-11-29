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
    private String password;
    @Column(nullable = false)
    private String prefecture;
    private String city;
    private String gender;
    private String age;
    @Column(nullable = false)
    private String role;
}
