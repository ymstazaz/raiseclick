package jp.yamashita.raiseclick.controller;

import jp.yamashita.raiseclick.form.DiaryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiaryController {
    private final DiaryRepository diaryRepository;

    @Autowired
    public DiaryController(DiaryController diaryController){
        this.diaryRepository = diaryRepository;
    }

    @GetMapping("/diaryForm")
    public String showDiaryForm(Model model){
        model.addAttribute("diaryForm",new DiaryForm());
        return "diaryForm";
    }

    @PostMapping("/diaryForm")
    public String createDiary(@ModelAttribute("diaryForm")DiaryForm diaryForm,Model model){
        try{
//            口コミidを自動保存・ユーザーIDをカレントから探して落とし込む
//            旅行記のフォームを保存かける
        }catch (Exception e){
            model.addAttribute("errorMessage","登録に失敗しました。詳細: " + e.getMessage());
            return "error";
        }
        return "redirect:/main";
    }
    public Long insertDiary(DiaryForm diaryForm,Long reviewId) throws Exception{
        try{
            diaryRepository.insert(
                diaryForm.getTransportation(),
                diaryForm.getCost(),
                diaryForm.getFullCost(),
                diaryForm.getFrequency(),
                reviewId
            );
            return diaryRepository.findLatestId();
        }catch (Exception e){
            throw new Exception("レビュー登録に失敗しました: " + e.getMessage(), e);
        }
    }
}
