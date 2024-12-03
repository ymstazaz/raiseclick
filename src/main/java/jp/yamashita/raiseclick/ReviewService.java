import jp.yamashita.raiseclick.Review;
import jp.yamashita.raiseclick.ReviewRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> searchReviews(String situation, String spotName, String purposeName, String reviewAge) {
        return reviewRepository.searchReviews(situation, spotName, purposeName, reviewAge);
    }
}