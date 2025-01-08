package jp.yamashita.raiseclick.controller;

import jp.yamashita.raiseclick.form.DiaryForm;
import jp.yamashita.raiseclick.model.User;
import jp.yamashita.raiseclick.repository.DiaryRepository;
import jp.yamashita.raiseclick.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class DiaryController {
    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;
    @Autowired
    public DiaryController(DiaryRepository diaryRepository, UserRepository userRepository) {
        this.diaryRepository = diaryRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/diaryForm")
    public String showDiaryForm(Model model){
        model.addAttribute("diaryForm",new DiaryForm());
        return "diaryForm";
    }

    @PostMapping("/diaryForm")
    public String createDiary(@ModelAttribute("diaryForm")DiaryForm diaryForm, Model model, Principal principal){
        try{
            // principal.getName()にログイン中のユーザーのメールアドレスが取得できるので、それを使ってユーザー情報をDBから探索しIDを取得する。
            User user = this.userRepository.findByAddress(principal.getName());
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
            throw new Exception("旅行記登録に失敗しました: " + e.getMessage(), e);
        }
    }
}
