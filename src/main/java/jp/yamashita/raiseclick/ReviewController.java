package jp.yamashita.raiseclick;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping
    public String showReviews(Model model){
        var reviewList =reviewRepository.findAll();
        model.addAttribute("reviewList",reviewList);
        return "main";
    }

    @GetMapping("/main")
    public String showMainPage(Model model){
//       ↓ reviewから全てのデータを取得
        var reviewList = reviewRepository.findAll();
//       ↓ Spot・目的・中間テーブルにて個別にfindをすることで↑でとったIdと連動させていく
        for (Review review : reviewList){
//            ↓レビューのスポット情報が不足していてスポットIdが取得できる場合、
            if(review.getSpot() ==null && review.getSpotId() !=null){
//                ↓spotリポジトリを使ってID検索して、
                var spot = spotRepository.findById(review.getSpotId());
//                ↓レビューにスポットを設置する
                review.setSpot(spot);
            }
//            ↓レビューの中間テーブル情報が不足している場合、
            if(review.getReviewPurpose() == null){
//                ↓中間テーブルのリポジトリを使ってレビューIdから目的Idを取得して、
                var purpose = reviewPurposeRepository.findByReviewId(review.getId());
//                ↓レビューに中間テーブルの情報を設置する
                review.setReviewPurpose(purpose);
            }
        }
        System.out.println("レビューリスト: " + reviewList);
        model.addAttribute("reviewList", reviewList);
        return "main";
    }

    @GetMapping("/reviewForm")
    public String showReviewForm(Model model){
        model.addAttribute("reviewForm",new ReviewForm());
        return "reviewForm";
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
