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
    @Autowired
    public  ReviewController(SpotService spotService){
        this.spotService = spotService;
    }
    @GetMapping("/reviewForm")
    public String showReviewForm(Model model){
        model.addAttribute("reviewForm",new ReviewForm());
        return "reviewForm";
    }

    @PostMapping("reviewForm")
    public String createSpot(@ModelAttribute("reviewForm")ReviewForm reviewForm, Model model){
        try {
            Long spotId = spotService.findOrCreateSpot(reviewForm.getSpotName());
        } catch (Exception e) {
            model.addAttribute("errorMessage", "スポット登録に失敗しました。詳細: " + e.getMessage());
            return "error";
        }
        return  "redirect:/";
    }
}
