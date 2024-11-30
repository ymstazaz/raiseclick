package jp.yamashita.raiseclick;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "review_purpose")
@Data
public class ReviewPurpose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "review_id",nullable = false)
    private Review review;
    @ManyToOne
    @JoinColumn(name = "purpose_id",nullable = false)
    private Purpose purpose;
    @Column(nullable = true)
    private String nth_purpose;
    @Column(nullable = true)
    private String satisfaction;
}
