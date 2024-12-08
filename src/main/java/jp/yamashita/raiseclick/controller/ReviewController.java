package jp.yamashita.raiseclick;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReviewController {
    private final SpotService spotService;
    private final PurposeService purposeService;
    private final SpotRepository spotRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewPurposeRepository reviewPurposeRepository;

    @Autowired
    public ReviewController(SpotService spotService, PurposeService purposeService, SpotRepository spotRepository,
                            ReviewRepository reviewRepository, ReviewPurposeRepository reviewPurposeRepository) {
        this.spotService = spotService;
        this.purposeService = purposeService;
        this.spotRepository = spotRepository;
        this.reviewRepository = reviewRepository;
        this.reviewPurposeRepository = reviewPurposeRepository;
    }


    @GetMapping("/")
    public String redirectToMain() {
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String showMainPage(Model model){
        // リポジトリで全データを取得
        List<Review> reviewList = reviewRepository.findAllWithDetails();
        // 取得したデータをモデルに渡す
        System.out.println("レビューリスト: " + reviewList);
        model.addAttribute("reviewList", reviewList);
        return "main";
    }

    @GetMapping("/reviewForm")
    public String showReviewForm(Model model){
        model.addAttribute("reviewForm",new ReviewForm());
        return "reviewForm";
    }

    @GetMapping("/search")
    public String searchReviews(
            @RequestParam(required = false) String situation,
            @RequestParam(required = false) String reviewAge,
            @RequestParam(required = false) String purposeName,
            Model model
    ) {
        // 検索実行
        List<Review> reviews = reviewRepository.searchReviews(situation, reviewAge, purposeName);
        System.out.println("シチュエーション: " + situation);
        System.out.println("年代: " + reviewAge);
        System.out.println("目的: " + purposeName);

        // 結果をビューに渡す
        model.addAttribute("reviewList", reviews);
        return "search"; // ビュー名
    }



    @PostMapping("/reviewForm")
    public String createReview(@ModelAttribute("reviewForm")ReviewForm reviewForm, Model model){
        try {
            Long spotId = spotService.findOrCreateSpot(reviewForm.getSpotName());
            Long reviewId = insertReview(reviewForm, spotId);
            Long purposeId = purposeService.findOrCreatePurpose(reviewForm.getPurposeName());
            insertReviewPurpose(reviewId, purposeId, reviewForm.getNthPurpose(), reviewForm.getSatisfaction());
        } catch (Exception e) {
            model.addAttribute("errorMessage", "登録に失敗しました。詳細: " + e.getMessage());
            return "error";
        }
        return  "redirect:/main";
    }
    public Long insertReview(ReviewForm reviewForm, Long spotId)throws Exception {
        try {
            reviewRepository.insert(
                    reviewForm.getSituation(),
                    reviewForm.getReviewAge(),
                    reviewForm.getReviewGender(),
                    reviewForm.getFreeComment(),
                    spotId
            );
            return reviewRepository.findLatestId();
        } catch (Exception e) {
            throw new Exception("レビュー登録に失敗しました: " + e.getMessage(), e);
        }
    }
    private void insertReviewPurpose(Long reviewId, Long purposeId, Integer nthPurpose, Integer satisfaction) throws Exception {
        try {
            reviewPurposeRepository.insertReviewPurpose(reviewId, purposeId, nthPurpose, satisfaction);
        } catch (Exception e) {
            throw new Exception("中間テーブル登録に失敗しました: " + e.getMessage(), e);

        }
    }
}
