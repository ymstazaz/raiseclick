package jp.yamashita.raiseclick;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "review")
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String situation;
    @Column(nullable = false)
    private String reviewAge;
    @Column(nullable = false)
    private String reviewGender;
    @Lob
    private String freeComment;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    //    スポット連動
    @ManyToOne
    @JoinColumn(name = "spot_id", nullable = false) // スポットID（必須）
    private Spot spot;
//    ユーザー連動（任意）
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true) // ユーザーID（任意）
    private User user;

}
